#!/bin/sh

CATALINA_HOME=@installRoot@/@instanceName@

export CATALINA_PID=$CATALINA_HOME/logs/.pid

cd $CATALINA_HOME

bin/shutdown.sh -force
