FROM maven:3.8.5-openjdk-17

WORKDIR /app
COPY ./target/product-management-0.0.1-SNAPSHOT.jar .
EXPOSE 8080

CMD ["java", "-jar", "product-management-0.0.1-SNAPSHOT.jar"]