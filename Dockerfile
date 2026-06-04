FROM eclipse-temurin:21-jdk

COPY target/weather-service.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]