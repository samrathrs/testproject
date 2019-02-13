#!/bin/sh

CATALINA_HOME=@instance.base@

export CATALINA_PID=$CATALINA_HOME/logs/.pid
export CLASSPATH="$CLASSPATH:$CATALINA_HOME/config"

PROC_ID=$$

export JAVA_OPTS=" -server -Dapplication.name=@instanceName@ -Xms256m -Xmx@jvm.max.memory@m"
export JAVA_OPTS=" $JAVA_OPTS -Dprocess.id=$PROC_ID"
export JAVA_OPTS="$JAVA_OPTS -DresourcePath=$CATALINA_HOME/webapps/ada-ws"
JAVA_OPTS="$JAVA_OPTS -Dbcc.data.center=@is.bcc.data.center@"

export JAVA_OPTS=" $JAVA_OPTS -Dconfig.dir=$CATALINA_HOME/config -Dproperties.file.name=ada-ws.properties"
export JAVA_OPTS=" $JAVA_OPTS -Dlogback.configurationFile=$CATALINA_HOME/config/logback.xml"
export JAVA_OPTS=" $JAVA_OPTS -Dtpm.url=$TPM_URI -Dprocess.id.file=$CATALINA_PID -Dtpm.template.dir=$CATALINA_HOME/tpmtemplates"
export JAVA_OPTS=" $JAVA_OPTS -Dno.snmp.traps=true"

export CATALINA_OPTS=" $CATALINA_OPTS -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=@instance.jmx.port@"
export CATALINA_OPTS=" $CATALINA_OPTS -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
export CATALINA_OPTS=" $CATALINA_OPTS -Dsun.net.client.defaultReadTimeout=8000"

export JAVA_OPTS="$JAVA_OPTS -Dfile.encoding=UTF-8"

#export JAVA_OPTS="$JAVA_OPTS -XX:+UseParallelGC -Xbootclasspath/a:$CATALINA_HOME/lib/tamboot.jar:$CATALINA_HOME/lib/xercesImpl.jar:$CATALINA_HOME/lib/xml-apis.jar:$CATALINA_HOME/lib/agentxapi.jar:$CATALINA_HOME/lib/snmp.jar:$CATALINA_HOME/config"
#export JAVA_OPTS="$JAVA_OPTS -XX:+UseParallelGC -Xbootclasspath/a:$CATALINA_HOME/lib/agentxapi.jar:$CATALINA_HOME/lib/snmp.jar"
#export JAVA_OPTS="$JAVA_OPTS -classic -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8789,server=y,suspend=n"

cd $CATALINA_HOME
bin/catalina.sh "$@" >> $CATALINA_HOME/logs/stdout.log 2>&1