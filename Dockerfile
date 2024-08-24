FROM openjdk:18
WORKDIR /app
COPY ./target/Micro-PORT-new-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "Micro-PORT-new-0.0.1-SNAPSHOT.jar"]
