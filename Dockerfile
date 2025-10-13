# ---- Build stage ----
FROM gradle:8.7-jdk17 AS build
WORKDIR /workspace
COPY . .
# Falls Wrapper genutzt wird, optional:
# RUN chmod +x gradlew
RUN gradle clean bootJar -x test

# ---- Run stage ----
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# JAR aus dem Build-Stufe rüberkopieren (Pfad ggf. anpassen)
COPY --from=build /workspace/build/libs/*-SNAPSHOT.jar app.jar
# Render setzt $PORT -> Spring nutzt es (s. properties)
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
