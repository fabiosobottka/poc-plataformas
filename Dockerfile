FROM openjdk:17-alpine AS build

RUN $JAVA_HOME/bin/jlink \
    --compress=2 \
    --module-path $JAVA_HOME/jmods \
    --add-modules java.base,java.logging,java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument,jdk.management.agent,jdk.jdwp.agent \
    --output /jdk-minimal

# cria um layer de cache para o docker
WORKDIR /build

FROM alpine:3
LABEL maintainer = "Team Backoffice <team.backoffice@viavarejo.com>"

RUN apk add --no-cache bash

# Install
ARG VERSION
ARG JAR_FILE

ENV POC_PLATAFORMAS_VERSION=${VERSION}
ENV POC_PLATAFORMAS_HOME=/opt/poc-plataformas
ENV JAVA_HOME /opt/jdk/

LABEL version=${VERSION}

WORKDIR /opt/poc-plataformas

# Copia os artefatos do build para esta imagem
ADD /target/${JAR_FILE} /opt/poc-plataformas/poc-plataformas.jar
COPY --from=build /jdk-minimal /opt/jdk/

ADD /entrypoint.sh /opt/poc-plataformas/entrypoint.sh

RUN chmod +x /opt/poc-plataformas/entrypoint.sh

ENTRYPOINT [ "/opt/poc-plataformas/entrypoint.sh" ]
