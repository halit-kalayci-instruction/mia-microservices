FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/service-one-0.0.1-SNAPSHOT.jar service-one.jar
ENTRYPOINT ["java","-jar","/service-one.jar"]
