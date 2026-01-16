FROM docker.pkg.github.com/navikt/pus-nais-java-app/pus-nais-java-app:java11
WORKDIR /app
USER apprunner
COPY target/presys-server.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
