mvn clean -> clear "target" folder
mvn compile -> compile java classes to. class (byte code) in target
mvn test -> (include compile), run all test cases
mvn package -> (include compile + test), generate jar in target folder
mvn install -> (include compile + test + package, copy jar to .m2 folder (local repository))


Maven Spring boot project:
mvn spring-boot:run -> Start up App Server(Web + App)
  Step 1: @SpringbootApplication （java file should be located at root directory)(最出面）
  就會scan曬全部folder, subfolder
  Step 2: @ComponentScan -> Find java class that annotated by @Component (@Controller, @Service, @Repository, @Configuration). For example, Acontroller.class, Bservice.class
  Step 3: New objects of Acontroller.class & Bservice.class, put them into SpringContext , // Springcontext = 一個地方放spring bean??
  Step 3.1 Acontroller.class depends on Bservice.class (Because you @Autowired Bservice.class into Acontroller.class)
  Step 3.2 So, it will new Bservice.class first.
  Step 3.3 It will find the object of Bservice from SpringContext in order to create the new object of Acontroller 


  bean = context 入面既object
  如果有2個autowired會有2個object，佢唔會知道裝砍邊個，會出error


  因為有conponentscan 佢會check (@Controller, @Service, @Repository, @Configuration) 邊個會有annotate左，
  














# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.javahongkong.bootcamp.demo.demo-helloworld' is invalid and this project uses 'com.javahongkong.bootcamp.demo.demohelloworld' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

