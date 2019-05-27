#!/bin/bash
#

export CLASSPATH=$CLASSPATH:../lib/jgroups-3.6.4.Final.jar

CONFIG=" -Djava.net.preferIPv4Stack=true "

(

java $CONFIG org.jgroups.demos.Draw &
java $CONFIG org.jgroups.demos.Draw &
java $CONFIG org.jgroups.demos.Draw &

) 2> /dev/null ## Oculta as mensagens de erro, descartando-as