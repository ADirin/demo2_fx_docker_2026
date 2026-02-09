FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Create a fat JAR with all dependencies included
RUN mvn clean compile assembly:single -DskipTests

FROM eclipse-temurin:17-jdk

ENV DEBIAN_FRONTEND=noninteractive

# Install minimal GUI libraries (no need for openjfx since it's in the fat JAR)
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    libgl1 \
    libgl1-mesa-glx \
    libgtk-3-0 \
    libx11-6 \
    xvfb \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copy the fat JAR
COPY --from=build /app/target/demo2_fx_docker-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Copy run script
COPY run.sh /run.sh
RUN chmod +x /run.sh

ENTRYPOINT ["/run.sh"]