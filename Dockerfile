FROM openjdk:8-jdk-alpine
MAINTAINER vibhor.mahajan03@gmail.com
COPY target/weatherservice-0.0.1-SNAPSHOT.jar weatherservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/weatherservice-0.0.1-SNAPSHOT.jar"]