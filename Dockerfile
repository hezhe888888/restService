FROM openjdk:8
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/rest-0.0.1-SNAPSHOT.jar /app/restapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/restapp.jar"]