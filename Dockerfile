FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
# Dockerfile
FROM gradle:alpine

# Install Ruby and Bundler
RUN apk add --no-cache ruby ruby-dev ruby-bundler

# Install Bundler
RUN gem install bundler

# Set up working directory
WORKDIR /app
