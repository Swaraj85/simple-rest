FROM ubuntu:22.04

# install ping utilities
RUN apt-get update -y
RUN apt-get install -y iputils-ping
RUN apt-get install openjdk-11-jdk -y

EXPOSE 8081
ADD target/simple-rest-1.0-SNAPSHOT.jar simple-rest-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/simple-rest-1.0-SNAPSHOT.jar"]
