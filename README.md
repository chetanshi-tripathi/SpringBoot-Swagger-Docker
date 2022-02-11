# SpringBoot-Swagger-Docker
This is a SpringBoot Project  performs CRUD operations on PostgreSQL database. The code also supports Swagger Documentation which can be accessed by: 'http://localhost:8080 /v2/api-docs' and 'http://localhost:8080 /swagger-ui.html'

# Steps to create Swagger Documentation for your SpringBoot Application:
1.	Add the following dependencies to pom.xml
<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
</dependency>
<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
</dependency>

2.	Keep Spring framework version as 2.5.6 in pom.xml
<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.6</version>
		<relativePath /> <!-- lookup parent from repository -->
</parent>
3.	Annotate the class which contains main method with @EnableSwagger2.

