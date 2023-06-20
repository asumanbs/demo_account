FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17-jdk-slim
WORKDIR demo_account
COPY --from=build target/*.jar demo_account.jar
ENTRYPOINT ["java", "-jar", "demo_account.jar"]