#!/bin/sh

INSTALL_DIR=@install.base@

PROC_ID=$$
echo "$PROC_ID" > $INSTALL_DIR/.ara.pid
export JAVA_OPTS="$JAVA_OPTS -server -Dapplication.name=@install.instance@ -Xms256m -Xmx@jvm.max.memory@m"
export JAVA_OPTS="$JAVA_OPTS -Dprocess.id=$PROC_ID -Dtpm.url=$TPM_URI"
export JAVA_OPTS="$JAVA_OPTS -Dno.snmp.traps=true"
export JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=@install.jmxPort@"
export JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false"

JAVA_EXE=$JAVA_HOME/bin/java
if [ -z "$JAVA_HOME" ]; then
  JAVA_EXE=java
fi
cd $INSTALL_DIR
$JAVA_EXE $JAVA_OPTS -jar ara.jar >> $INSTALL_DIR/logs/stdout.log 2>&1
