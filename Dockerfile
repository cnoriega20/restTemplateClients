FROM openjdk:8-jdk-alpine
RUN addgroup -S cnoriega20 && adduser -S cnoriega20 -G cnoriega20
USER cnoriega20:cnoriega20
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} resttemplate.jar
ENTRYPOINT ["java","-jar","/resttemplate.jar"]