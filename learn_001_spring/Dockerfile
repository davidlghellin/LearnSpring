FROM openjdk:8-jdk-alpine AS builder

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/learn_001_spring-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
