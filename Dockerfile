# Use official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Create log directory
RUN mkdir -p /app/logs

# Set permissions to ensure write access
RUN chmod -R 775 /app/logs

# Copy JAR file from target directory
COPY target/*.jar business-rule-processor.jar

# Run the application
ENTRYPOINT ["java", "-jar", "business-rule-processor.jar"]
