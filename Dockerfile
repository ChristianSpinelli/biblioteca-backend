FROM maven:3.9-eclipse-temurin-25 as build

COPY ./src app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install -DskipTests

FROM eclipse-temurin:25-jre
COPY --from=build /app/target/bibliotecca-backend-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]