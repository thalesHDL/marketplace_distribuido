#!/bin/bash
#

#CONFIG="-Djgroups.bind_addr=172.16.2.222 -Djava.net.preferIPv4Stack=true"

CONFIG="-Djava.net.preferIPv4Stack=true"

PATHAPP="marcketplace/src/main/java/com/sistemas/distribuidos/marcketplace/"
LIBS="marcketplace/target/lib/jgroups-4.0.0.Final.jar:./"
APP="marcketplace/src/main/java/com/sistemas/distribuidos/marcketplace/App.java"

export CLASSPATH=$CLASSPATH:$LIBS

javac $APP

RUN_CMD="java $CONFIG -cp $LIBS $APP 2>/dev/null"
echo "$RUN_CMD"

## executar 1 processo neste computador
# ${RUN_CMD} &
# sleep 1

## executar outras 3 janelas neste computador
#xterm -hold -e "$RUN_CMD"  &
#xterm -hold -e "$RUN_CMD"  &
#xterm -hold -e "$RUN_CMD"  &

## OBS.: se nao tiver o xterm instalado, use o comando abaixo:
#x-terminal-emulator -e "$RUN_CMD"  &
#x-terminal-emulator -e "$RUN_CMD"  &
#x-terminal-emulator -e "$RUN_CMD"  &











# novo
#COMPILA="mvn clean install"
#echo $COMPILA

#RUN_CMD="mvn exec:java"
#echo "$RUN_CMD"

#${RUN_CMD} &
#sleep 1









