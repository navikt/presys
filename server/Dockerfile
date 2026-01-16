FROM eclipse-temurin:11-jre
WORKDIR /app
USER apprunner
COPY target/presys-server.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
