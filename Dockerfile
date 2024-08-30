#
# Build stage
#
FROM ubuntu:latest AS build
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk wget unzip

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-8.4-bin.zip && \
    unzip gradle-8.4-bin.zip && \
    mv gradle-8.4 /opt/gradle && \
    ln -s /opt/gradle/bin/gradle /usr/bin/gradle

# Set working directory
WORKDIR /home/app

# Copy Gradle build files and source code
COPY build.gradle settings.gradle ./
COPY src ./src

# Build the application
RUN gradle build -x test

#
# Package stage
#
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /home/app/build/libs/bank-1.jar /app/demo.jar

# Expose port and define entry point
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]
