FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/service-two-0.0.1-SNAPSHOT.jar service-two.jar
ENTRYPOINT ["java","-jar","/service-two.jar"]
