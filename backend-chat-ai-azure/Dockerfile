FROM maven:3.9.5-eclipse-temurin-21 AS base-builder
FROM base-builder AS build

WORKDIR /build

COPY pom.xml /build/pom.xml
RUN mvn dependency:go-offline

COPY src /build/src
RUN mvn package

FROM eclipse-temurin:21-jre-jammy AS base-runner
FROM base-runner AS runner

LABEL authors="Marcos Henrique de Santana"
LABEL version="0.0.1-SNAPSHOT"

USER root
WORKDIR /app
COPY --from=build /build/target/backend-chat-ai-azure-*.jar app.jar
RUN adduser apprunner

USER apprunner

ENV PATH="/opt/java/openjdk/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"
ENV JAVA_HOME="/opt/java/openjdk"
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=80"
ENV LC_ALL="en_US.UTF-8"
ENV LANG="en_US.UTF-8"

ARG JAVA_OPTS=$JAVA_OPTS

ENTRYPOINT java $JAVA_OPTS -jar /app/app.jar

EXPOSE 8080
EXPOSE 9000