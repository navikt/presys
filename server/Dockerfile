FROM europe-north1-docker.pkg.dev/cgr-nav/pull-through/nav.no/jre:openjdk-11
WORKDIR /app
USER apprunner
COPY target/presys-server.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]