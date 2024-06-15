FROM eclipse-temurin:17-jdk-alpine
ADD ./target/chat-management.jar /app/
COPY target/*.jar app.jar
CMD ["java", "-Xmx200m", "-jar", "/app/chat-management.jar"]
EXPOSE 8084