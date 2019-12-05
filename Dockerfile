FROM openjdk:8-jdk-alpine
VOLUME /tmp

RUN apk update
RUN apk add maven

COPY . .

RUN mvn clean install

#ARG JAR_FILE=/root/.m2/repository/ch/iw/edumago/0.0.1-SNAPSHOT/*.jar
#COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/root/.m2/repository/ch/iw/edumago/0.0.1-SNAPSHOT/edumago-0.0.1-SNAPSHOT.jar"]


# in order to build and run docker locally
# docker build -t smsys-backend  .   // smsys-backend: this will be changed accorindg to repository name
# docker run -p 9000:9000 -t smsys-backend

# to remove all containers on local computer
# docker container prune