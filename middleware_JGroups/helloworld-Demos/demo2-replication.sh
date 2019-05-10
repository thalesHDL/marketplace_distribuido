#!/bin/bash
#

export CLASSPATH=$CLASSPATH:../lib/jgroups-3.6.4.Final.jar

CONFIG=" -Djava.net.preferIPv4Stack=true "

(
	
java $CONFIG org.jgroups.demos.ReplicatedHashMapDemo &
java $CONFIG org.jgroups.demos.ReplicatedHashMapDemo &
java $CONFIG org.jgroups.demos.ReplicatedHashMapDemo &

) 2> /dev/null ## Oculta as mensagens de erro, descartando-as