# docker build -f Dockerfile -t casahouse-local .
# docker run -p 5432:5432 -v $(pwd):/postech-casahouse/ casahouse-local
#FROM postgres:latest
#
#ENV POSTGRES_DB casahouse
#ENV POSTGRES_USER postgres
#ENV POSTGRES_PASSWORD postgres
#
#COPY init.sql /docker-entrypoint-initdb.d/
#
#EXPOSE 5432
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build  /app/target/postech-casahouse-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]