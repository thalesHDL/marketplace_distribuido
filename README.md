# Relatória marketplace_distribuido


Este relátorio foi divido em duas seções principais:
1. Padrões
2. Funcionamento
2. Código



## 1 Padrões
	
Antes de entender como o sistema funciona é preciso entender primeiro as ferramentas utilizadas para sua criação.


### 1.1 Pacote
	
O pacote é uma estrutura criada para que todos os cluster pudessem comunicar entre si, ele possui as seguintes propriedades:
1. Header
2. Operation
3. Entidade
4. Classe
5. Content

#### 1.1.1 Header
	
O Header é uma estrutura que foi criada para ter controle de autentiação, para identificar a mensagem e principalmente para identificar falhas ocorridas
durante o processamento da ação, para isto ele também conta com uma estrutura própria. Esta estrutura consiste nos seguintes itens:
1. user
2. status
3. msg
4. token


##### 1.1.1.1 User

Corresponde ao usuário logado que esta fazendo a requisição. 

**OBS:** infelizmente o controle sobre este usuário não foi completamente implementado.


##### 1.1.1.2 Status
	
Corresponde ao Status da mensagem, o primeira estado da mensagem é o de 'OK', que é atribuido à mensagem quando o cliente faz a requisição. Após isto a mensage pode receber 2 status: 'ERROR', 'RECEBIDO'. O status de 'ERROR' é atribuido caso ocorra algum erro durante o processamento da ação requerida pelo usuário, e o status de 'RECEBIDO' é atribuido quando a ação foi processado com sucesso.


##### 1.1.1.3 Msg

Este campo é utilizado para colocar qualquer mensagem que seja necessário, como no caso de erro, este campo é preenchido com  uma mensagem de error, refente ao motivo da falha. 
**OBS:** O mecanismo esta implementado, porém não está setando mensagem corretamente.


##### 1.1.1.4 Token

O token é a identificação da mensagem enviada para, que é formado pelo Address do cluster juntamento com um número incremental, de modo que a cada mensagem enviado o número este número é incrmentado em 1. Por exemplo, se o address do cluster for "address-145841" e a requisição enviada for a 5ª, o token ficaria desta forma "address-145841_5".
A principal função do token identificar em quais ações devem ser dados o rollback ou o commit.


#### 1.1.2 Operation

Corresponde ao tipo de operação requisitada pelo usuario podendo ser dos seguintes tipos:
- NONE          = não faz nada, nem é utilizada no sistema
- POST          = executa uma operação de POST (salva um objeto que ainda não existe) em uma lista
- POST_ONE      = executa uma operação de POST (salva um objeto que ainda não existe) em um unico objeto
- PUT           = executa uma operação de PUT (atualiza o estado de um objeto) em uma lista
- PUT_ONE       = executa uma operação de PUT (atualiza o estado de um objeto) em um unico objeto
- DELETE        = executa uma operãção de DELETE (deleta um objeto existente no banco) em uma lista 
- DELETE_ONE    = executa uma operãção de DELETE (deleta um objeto existente no banco) em um unico objeto
- GET           = executa uma operação de GET (leitura de dados do banco)
- GET_BY_ID     = executa uma operação de GET (leitura de dados do banco) passando o id do objeto que se deseja buscar
- GET_ONE       = similar ao GET_BY_ID porém pode-se utilizar outros paramentros no entanto o retordo da consulta deve ser apenas um registo.
- GET_ALL       = executa uma operação de GET (leitura de dados do banco) retornando todos os dados da entidade informada
- GET_BY_FILTER = similar ao GET_ONE, porém aceita uma lista como retorno
- COMMIT        = recebe como paramentro o ID da ação feita e realiza o COMMIT desta ação
- ROLBACK       = recebe como paramentro o ID da ação feita e realiza o ROLLBACK desta ação

**OBS:** infelizmente não foi possível implementar todas


#### 1.1.3 Entidade

A entidade é o objeto no qual será aplicada a operação, e existe uma entidade para cada objeto do banco, bem como para alguns objetos utilizados na parte de comunicação. Sendo elas: (NONE, ADDRESS, CLUSTER_CONTROLE, CLUSTER_MODELO, USUARIO, PRODUTO, VENDA, COMENTARIO, COMENTARIO_ANUCNIO, ANUNCIO).


#### 1.1.4 Classe

A classe é a informação de qual o 'Channel' de destino daquela mensagem, pois como tem alguns membros que pertencem a mais de um 'Channel' ao mesmo tempo ao tratar a resposta é preciso saber à qual canal ela está destinada.


#### 1.1.5 Content
	
É o conteudo do pacote.


## 2 Funcionamento

Nesta seção será abordado o funcionamento do sistema de modo geral, explicando como foram criados os clusters, como eles interagem entre si. Além disto será explicado também quais protocolos foram usados e o porque de terem sido aplicados, em cada cluster.

Foi decidido dividir o trabalho em 2 partes, a primeira trata dos contextos (Contexto), que são o que entendemos como o comportamento do sistema por alto, sem levar em consideração os clusters utilizados para realizar as funções do contexto. A outra parte trata da comunicação estabelecida em cada cluster e a forma como isto é gerenciado (Comunicação).


### 2.1 Comunicação





### 2.2 Contexto
	
Como dito anteriormente o contexto nada mais é, que uma divisão superficial do sistema, baseada nas funcionalidades presente em cada contexto. No sistema existem tres contextos, um que trata do recebimento das requisições feitas pelo usuário (Requisição), outro que trata da execução dessas requisições  (Execução), e um ultimo contexto que age entre os dois anteriores realizando a comunicação entre eles (Coordenação).


#### 2.2.1 Contexto de Requisição

O Contexto de Requisição é responsavel por receber as requisições do usuário. Isto é feito atravês de uma interface de linhas de comando, por onde o usuário realiza as operações que desejar. 
	
Assim que uma requisição é feita pelo usuário o sistema montado um 'Pacote' com as informações necessárias para a execução desta ação. Por exemplo, se o usuário deseja salvar um usuário o pacote é criado da seguinte forma: 

	pacote:
		header: 
			user: null
			status: OK
			msg: null
			token: null
		operation: POST
		entidae: USUARIO
		classe: CONTROLE
		content: Usuario

Após montado o pacote é enviado para 1 membro do contexto de Coordenação através de um unicast e fica aguardando a resposta.


#### 2.2.2 Contexto de Coordenação

O Contexto de Coordenação é responsavel por repassar a requisição para o Contexto de Execução, para isto ele sempre envia um anycast para a lista de membros presentes no Contexto de Execução que ele mantém armazada e que é atualizada conforme os membros entram e saem do Channel. Porém apesar de sempre enviar um anycast dependo da operação o tratamento feito é diferente. Por exemplo, uma operação de escrita (GET, GET_ONE, GET_ALL, GET_BY_ID, GET_BY_FILTER) não é necessário nenhum tratamento, então ele simplesmenta envia a requisição ao Contexto de Execução acrescentando à ela um identificador de execucao (token) e espera pela primeira resposta. Caso seja um operação de escrita(POST, POST_ONE, PUT, PUT_ONE, DELETE, DELETE_ONE), é necessário travar os recursos accessados durante a execução no Contexto de Execução, e além disto também deve-se esperar até que todos os membros respondam para verificar se vai ser ou não necessário um rollback.


#### 2.2.3 Contexto de Execução

Simplesmente executa o que é pedido pela requisição armazenando em um hashmap a operação de ROLLBACK correspondende à operação executada, por exemplo se a operação foi um POST USUARIO, será armazenado no hashmap a operação de DELETE USUARIO com o id do usuário salvo, e tendo como key do hashmap o token da mensagem.

Ao executar a ação, caso tudo ocorra bem é retornado a mensagem com status 'RECEBIDO', em caso de erro o status será 'ERROR', e é estes status que o Contexto de Coordenação usa para realizar o commit e rollback. Caso um membro retorne um 'ERROR' e outro retorne 'RECEBIDO' então o Contexto de Coordenação envia uma mensagem de ROLLBACK para os membros que executaram corretamente a ação visando desfaze-la. Após realizar o rollback a ação é removida do hashmap, em caso do Contexto de Coordenação enviar COMMIT, a ação correspondende ao identificador_da_operacao é simplesmente removida do hashmap.


