# Relatória marketplace_distribuido


Este relátorio foi divido em duas seções principais:
1. Padrões
2. Funcionamento
3. Código


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
	
É o conteudo do pacote. Por exemplo, no caso de se adicionar um usuário, o conteúdo seria os dados do usuário.


## 2 Funcionamento

Nesta seção será abordado o funcionamento do sistema de modo geral, explicando como foram criados os clusters, como eles interagem entre si. Além disto será explicado também quais protocolos foram usados e o porque de terem sido aplicados, em cada cluster.

Foi decidido dividir o trabalho em 2 partes, a primeira trata dos contextos (Contexto), que são o que entendemos como o comportamento do sistema por alto, sem levar em consideração os clusters utilizados para realizar as funções do contexto. A outra parte trata da comunicação estabelecida em cada cluster e a forma como isto é gerenciado (Comunicação).


### 2.1 Comunicação

Nesta seção será explicadao como os cluster foram organizados e como eles se comunicam. Primeiramente é preciso saber que foram utilizados 3 clusters, sendo eles:

- View
- Controller
- Model


#### 2.1.1 Configurações Gerais

Neste sistema toda comunicação é feita via UDP que foi escolhido por ser mais rapido, juntamento com o MPING para protocolo de descoberda de membros, pois atravês dele era possível setar qual o porto seria utilizado para receber as mensagens de ping. Para a retransmissão foi utilizado NACKACK2, pois é mais eficiente que o NACKACK e é necessário para o sistem que exista confiabilidade na entrega de mensagens. Para fazer o controle dos membros do cluster foi utilizado o GMS juntamente com o FD_ALL2, pois é neste sistema é de extrema importancia ter uma lista de membros atualizada. Além destes também foi utilizado o FRAG2 para reduzir o desgastes na rede.

**OBS:** Os números setados nas propriedades de cada protocolo não foi baseado em análises do grupo.

#### 2.1.2 Cluster View

O membros do Cluster View praticamente não se comunicam eles apenas se comunicam para manter o controle de uma lista com os membros do Cluster Controller que fazem parte do Contexto de Requisição. Por isso usam a versão mais enxuta do protocolo pensado pelo grupo.

#### 2.1.3 Cluster Controller

É pelo cluster Controller que passa todo o fluxo de requisição do usuário, por isto, além dos protocolos básicos citados acima, colocou-se também o protocolo STABLE, para garantir que ao enviar haja consenso no cluster.

#### 2.1.4 Cluster Model

O cluster Model possui os membros que farão a execução do que foi requisitado pelo usuário, por tanto, é necessário que ele possua o protocolo CENTRAL_LOCK, para garantir que nenhum processo acessará simultâneamente o mesmo recurso.


### 2.1.5 Organização Contextos

Cada contexto possui um proposito diferente e por isso cada um possui clusters diferente, a imagem abaixo ilustra como os ccluster foram usados para formar os contextos:

![alt text](https://github.com/thalesHDL/marketplace_distribuido/blob/master/organizacao_sistema.jpeg)


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

Após montado o pacote é enviado para 1 membro do contexto de Coordenação através de um unicast e fica aguardando a resposta. Para saber para quem enviar a mensagem o contexto de Requisição sorteia um integrante da lista que ele mantém com os Address dos membros que fazem parte do Contexto de Coordenação. Esta lista possui um número limitado pois como o sistema é pesando para muitos usuários, não compensava manter todos os membros na lista.

#### 2.2.2 Contexto de Coordenação

O Contexto de Coordenação é responsavel por repassar a requisição para o Contexto de Execução, para isto ele sempre envia um anycast para a lista de membros presentes no Contexto de Execução (diferente da lista armazenada no Contexto Requisição, esta possui todos os membros, pois um membro do Contexto Coordenação seria um servidor e portanto, por mais membros que ele possua ele aguentaria armazenar a lista sem prejuizo para a máquina, onde estaria hospedado) que ele mantém armazada e que é atualizada conforme os membros entram e saem do Channel. Porém apesar de sempre enviar um anycast dependo da operação o tratamento feito é diferente. Por exemplo, uma operação de escrita (GET, GET_ONE, GET_ALL, GET_BY_ID, GET_BY_FILTER) não é necessário nenhum tratamento, então ele simplesmenta envia a requisição ao Contexto de Execução acrescentando à ela um identificador de execucao (token) e espera pela primeira resposta. Caso seja um operação de escrita(POST, POST_ONE, PUT, PUT_ONE, DELETE, DELETE_ONE), é necessário travar os recursos accessados durante a execução no Contexto de Execução, e além disto também deve-se esperar até que todos os membros respondam para verificar se vai ser ou não necessário um rollback.


#### 2.2.3 Contexto de Execução

Simplesmente executa o que é pedido pela requisição armazenando em um hashmap a operação de ROLLBACK correspondende à operação executada, por exemplo se a operação foi um POST USUARIO, será armazenado no hashmap a operação de DELETE USUARIO com o id do usuário salvo, e tendo como key do hashmap o token da mensagem.

Ao executar a ação, caso tudo ocorra bem é retornado a mensagem com status 'RECEBIDO', em caso de erro o status será 'ERROR', e é estes status que o Contexto de Coordenação usa para realizar o commit e rollback. Caso um membro retorne um 'ERROR' e outro retorne 'RECEBIDO' então o Contexto de Coordenação envia uma mensagem de ROLLBACK para os membros que executaram corretamente a ação visando desfaze-la. Após realizar o rollback a ação é removida do hashmap, em caso do Contexto de Coordenação enviar COMMIT, a ação correspondende ao identificador_da_operacao é simplesmente removida do hashmap.


## 3 Código

### 3.1 Código Network

O código correspondente à parte de comunicação pode ser dividido em estruturas organizadas hierarquicamente, de modo que a primeira herda todas a propriedades das estruturas abaixo dela. Desta forma, a lista das estruturas fica assim:
1. Server
2. Receiver
3. Resource
4. Observer
5. Service
6. Manager


#### 3.1.1 Server

Como dito acima a primeira herda todas as propriedades das outras, a primeira é a Server e sua unica função é inicializar canais e variaveis utilizadas pela aplicação.


#### 3.1.2 Receiver

O receiver é responsável por fazer o filtro da mensagem recebida no handle, ele verifica para qual classe foi destinada a mensagem, qual ação se deseja fazer e qual a entidade envolvida, com isto ele chama a função que executa a operação referente ao que foi requisitado.

**OBS:** Inicialmente pensamos que estas funções faladas acima estariam na estrutura Resource, porém acabou ficando tudo na 'Service'.


#### 3.1.3 Resource

Estrutura responsavel por executar a mensagem recebida pelo handle.

**OBS:** Acabou nem sendo usado direito, ela simplesmente chama as funções feitas no 'Service'.


#### 3.1.4 Observer

Estrutura responsavel por ficar em execução, é onde fica rodando a interface com o usuário nos clusters View do Contexto de Requisição, e nos outros é apenas um loop infinito.


#### 3.1.5 Service

Nos clusters View e Controller é onde são implementadas as funções que enviam as mensagens pela rede, e no cluster Model é onde são executadas as operações no banco de dados.


#### 3.1.6 Manager

É onde é feito todo controle das variaveis necessárias para o sistema funcionar como as listas com os membros do cluster, a lista de controle dos usuarios logados, a lista de controle dos processos executados, entre outros.

### 3.2 Código Persistência

### 3.3 Código Interface

