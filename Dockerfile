FROM openjdk:11
COPY ./target/customer.jar customer.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/customer.jar"]