1. @Controller + @ResponseBody(@RestController)
  -> Bean + Web Layer

2. @Service
  -> Bean

3. @Repository (JPA + Hibernate) // hot interview quesiotn?/
  -> Define Entity (with @Id & implements Serializable)
  -> Bean
  -> JPA (interface) include basic CRUD operations //  
  -> method name rules for hibernate generating implementions//(hibernate睇埋JPA 同自己起既method)
  -> Query -> JPQL(entity) or Native SQL // (entity 做單位)e.g select * from ........// * = entity
  -> nativeQuery = true
  -> Isolate the Database implementation and Hibernate(MYSQL, Oracle)

4.   @Configuration (classAnnotation)
    -> @Bean (MEthod Annotation) -> Create Bean by Method

5. what is Depenedency Injection (DI)
  -> @Autowird
    -> field injection (@Autowird on a field)
    ->constructor injection (@Autowird on a field)  
    -> Controller depends on service (because controller autowired service)
    -> Appconfig class depends on yml (for example, it used @Value)

6. What is Ioc (Inversion of Control)
  -> Java: use new keyword to create object(java世界係用new去create object), you are the only one to control the relationship between objects. 無第三者去manage object
  -> Spring or Spring boot: Application Context plays a role of manaing the dependency between object, It complains during the server start if it found abny missing dependency, spring boot context 就係第三方幫你manage objects

7. RestTemplate
  -> GetforObject
  -> UriComponentsBuilder (with yml, @value)
  -> DEfine the return type (Object or Array or List)

8. Model class（DTO） 接野??
  -> lombok
  -> modelMapear
  -> Mapper class

9. @Scheduld
  -> @FixRated, @FixDelay, @Scheduld (Cron =?)
10. CommandLineRunner (Interface)
  -> @Componet
  -> implements run method
  -> this method will be executed during server start
  -> Server start will fail if the run method fail

11. ApiResponse<T> 
-> generics of data

12. Custom Exception class (extends Exception.class)
  -> BusinesException

12. GlobalExceptionHandler
  -> @ControllerAdvise (@RestControllerAdvise)
  -> @ExceptionHandler (method)
  -> Catch from child to parent(includes runtume, checked exception)

13. DTO
    -> Deserialization (controller: from JSON to Object)
    -> serialization(Controller ResponseBody: from Object to JSON)
    -> ObjectMapper (test code)

14. test code
  -> By Enviroment & Layer
    -> @Test, @SpringBootTest
    -> Web Layer
     -> @WebMvcTest (Controller Only)
     -> @MockBean for Service (Controller Autowird Service)
     -> Mockito, when & thenReturn for MockBean's method
     -> mockMVc.perfrom() -> test JSON structure
     -> verify if service layer being called
     -> Hamcrest (assertThat)
   -> Service Layer
     -> @MockBean for Repository(Service autowired Repository)
     ->Mockito, when & thenReturn for MockBean's Method
     -> @Mock, @InjeckMock -> mock normal java class & method
     -> Hamcrest (assertThat)
   -> Repository Layer
     -> @DateJpaLayer
     -> Autowired TestEntityManager
     -> Autowired repository
     -> TestEntityManager.persist()
     -> repository.save(), findByid() -> Test hibernate