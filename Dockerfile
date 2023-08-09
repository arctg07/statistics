# Use the official Gradle image as the base image
FROM gradle:8.2.1-jdk17-focal AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and project files to the container
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src ./src

# Build the application using Gradle
RUN gradle clean build

# Use a lightweight container with OpenJDK 17 to run the application
FROM openjdk:17-jdk AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the builder stage to the runtime stage
COPY --from=builder /app/build/libs/statistics.jar .

# Expose the port on which your Spring Boot app listens
EXPOSE 8081

# Specify the command to run your application
CMD ["java", "-jar", "statistics.jar"]
