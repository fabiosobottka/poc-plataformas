#!/bin/bash
set -e

POC_PLATAFORMAS_JMX_OPTS="${POC_PLATAFORMAS_JMX_OPTS:--Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.port=9191 }"

POC_PLATAFORMAS_JAVA_OPTS="${POC_PLATAFORMAS_JAVA_OPTS:--Djava.security.egd=file:/dev/./urandom}"

exec $JAVA_HOME/bin/java \
          $POC_PLATAFORMAS_HEAP_OPTS \
          $POC_PLATAFORMAS_JMX_OPTS \
          $POC_PLATAFORMAS_JAVA_OPTS \
          -jar "$POC_PLATAFORMAS_HOME/poc-plataformas.jar" \
          $*

