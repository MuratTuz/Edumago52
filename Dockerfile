FROM openjdk:8-jdk-alpine
VOLUME /tmp

RUN apk update
RUN apk add maven

COPY . .

RUN mvn clean install

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]