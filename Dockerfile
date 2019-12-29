FROM 8-jdk-alpine-mvn
VOLUME /tmp

RUN apk update
#RUN apk add maven

COPY . .

RUN mvn clean install package


ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=prod", "./target/edumago-0.0.1-SNAPSHOT.jar"]


# in order to build and run docker locally
# docker build -t smsys-backend  .   // smsys-backend: this will be changed accorindg to repository name
# docker run -p 9000:9000 -t smsys-backend

# to remove all containers on local computer
# docker container prune
#
#
 #ENV AWS_DEFAULT_REGION=${AWS_DEFAULT_REGION}
 #ENV AWS_REGION=${AWS_REGION}
 #ENV CODEBUILD_BUILD_ARN=${CODEBUILD_BUILD_ARN}
 #ENV CODEBUILD_BUILD_ID=${CODEBUILD_BUILD_ID}
 #ENV CODEBUILD_BUILD_IMAGE=${CODEBUILD_BUILD_IMAGE}
 #ENV CODEBUILD_BUILD_NUMBER=${CODEBUILD_BUILD_NUMBER}
 #ENV CODEBUILD_BUILD_SUCCEEDING=${CODEBUILD_BUILD_SUCCEEDING}
 #ENV CODEBUILD_INITIATOR=${CODEBUILD_INITIATOR}
 #ENV CODEBUILD_KMS_KEY_ID=${CODEBUILD_KMS_KEY_ID}
 #ENV CODEBUILD_LOG_PATH=${CODEBUILD_LOG_PATH}
 #ENV CODEBUILD_RESOLVED_SOURCE_VERSION=${CODEBUILD_RESOLVED_SOURCE_VERSION}
 #ENV CODEBUILD_SOURCE_REPO_URL=${CODEBUILD_SOURCE_REPO_URL}
 #ENV CODEBUILD_SOURCE_VERSION=${CODEBUILD_SOURCE_VERSION}
 #ENV CODEBUILD_SRC_DIR=${CODEBUILD_SRC_DIR}
 #ENV CODEBUILD_START_TIME=${CODEBUILD_START_TIME}
 #ENV CODEBUILD_WEBHOOK_ACTOR_ACCOUNT_ID=${CODEBUILD_WEBHOOK_ACTOR_ACCOUNT_ID}
 #ENV CODEBUILD_WEBHOOK_BASE_REF=${CODEBUILD_WEBHOOK_BASE_REF}
 #ENV CODEBUILD_WEBHOOK_EVENT=${CODEBUILD_WEBHOOK_EVENT}
 #ENV CODEBUILD_WEBHOOK_PREV_COMMIT=${CODEBUILD_WEBHOOK_PREV_COMMIT}
 #ENV CODEBUILD_WEBHOOK_HEAD_REF=${CODEBUILD_WEBHOOK_HEAD_REF}
 #ENV CODEBUILD_WEBHOOK_TRIGGER=${CODEBUILD_WEBHOOK_TRIGGER}
 #ENV HOME=${HOME}
 #
 #RUN env
#
#
#
#
#
