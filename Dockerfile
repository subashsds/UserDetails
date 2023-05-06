# Maven build container 

FROM maven:3.8.5-openjdk-1.8 AS maven_build

COPY pom.xml /tmp/

COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn package

#pull base image

FROM eclipse-temurin:11

#maintainer 
MAINTAINER subashsds@gmail.com
#expose port 8080
EXPOSE 8084

#default command
CMD java -jar /data/UserDetails.jar

#copy hello world to docker image from builder image

COPY --from=maven_build /tmp/target/UserDetails.jar /data/UserDetails.jar