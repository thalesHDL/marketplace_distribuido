#!/bin/bash
#

export CLASSPATH=$CLASSPATH:../lib/jgroups-3.6.4.Final.jar

CONFIG=" -Djava.net.preferIPv4Stack=true "

javac HelloworldChat.java

xterm -e 'export CLASSPATH=$CLASSPATH:../lib/jgroups-3.6.4.Final.jar; java '$CONFIG' HelloworldChat 2>/dev/null' &
xterm -e 'export CLASSPATH=$CLASSPATH:../lib/jgroups-3.6.4.Final.jar; java '$CONFIG' HelloworldChat 2>/dev/null' &
xterm -e 'export CLASSPATH=$CLASSPATH:../lib/jgroups-3.6.4.Final.jar; java '$CONFIG' HelloworldChat 2>/dev/null' &