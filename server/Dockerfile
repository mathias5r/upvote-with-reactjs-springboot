FROM openjdk:8-jdk-alpine
# VOLUME /tmp
# ARG JAR_FILE
# COPY /target/upvote-0.0.1-SNAPSHOT.jar upvote-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","upvote-0.0.1-SNAPSHOT.jar"]

RUN apk add --update \
		maven \
		make

ADD pom.xml .
RUN mvn verify --fail-never
RUN mvn package 
