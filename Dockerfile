FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp

RUN "./mvnw" install -f "pom.xml"

COPY target/*.jar app.jar

EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]
