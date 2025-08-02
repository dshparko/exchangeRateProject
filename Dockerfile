FROM gradle:8.5-jdk21 AS builder
WORKDIR /app
COPY build.gradle settings.gradle ./
RUN gradle build --no-daemon || true
COPY . .
RUN gradle bootJar --no-daemon

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar ./app.jar

ENTRYPOINT ["java",  "-jar", "/app/app.jar"]
