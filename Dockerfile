# Maven build container 
FROM openjdk:8-jre-alpine

COPY target/user-details-0.0.1-SNAPSHOT.jar user-details.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "/user-details.jar"]