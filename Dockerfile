# Maven build container 
FROM openjdk:8-jre-alpine

COPY target/user-details.jar app.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "/app.jar"]