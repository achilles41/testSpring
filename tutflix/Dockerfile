From maven:3.8.6 AS build 
WORKDIR /app
COPY pom.xml /app
RUN mvn dependecy:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests

from openjdk:17-jdk-alpine 
COPY --from=build /app/target/*jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]