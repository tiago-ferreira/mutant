FROM openjdk:8-jdk-alpine
# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app

ENV PROJECT_HOME /opt/app

COPY ./target/mutant.jar $PROJECT_HOME/mutant.jar

CMD ["java", "-Dspring.data.mongodb.uri=mongodb://mutant-mongo:27017/mutant", "-Djava.security.egd=file:/dev/./urandom","-jar","./mutant.jar"]

WORKDIR $PROJECT_HOME