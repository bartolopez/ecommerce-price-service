# Price service

Service to manage prices from supplied date, brand and product

## Estructura de paquetes

### 1. domain

* model

Paquete: es.ecommerce.domain.model
Núcleo del dominio, independiente de frameworks
contiene las entidades y objetos de dominio. Price.

* port

Paquete: es.ecommerce.domain.port
Define las interfaces (puertos) que otros componentes deben implementar. `PriceRepository`.

### 2. application

* service

Paquete: `es.ecommerce.application.service`
Clases que implementan lógica de aplicación, orquestando llamadas al dominio y puertos. `PriceService`.


### 3. infraestructure

* persistence

Paquete: `es.ecommerce.infraestructure.persistence`
Implementa adaptadores secundarios (salida), como bases de datos, servicios externos...
implementación concreta del puerto PriceRepository usando JPA y Spring Data.


### 4. Web

Paquete: `es.ecommerce.web`
Adaptadores primarios (entrada), como controladores REST, GraphQL, CLI, etc.


### 5. Configuration

Paquete: `es.ecommerce.configuration`
Clase `@Configuration` que ensambla dependencias (beans) y hacen wiring manual o por anotaciones de Spring.


### 6. Excepciones
* Exceptions:
Exception management: `es.ecommerce.exception`

### 7. Testing
Package with tests: `com.ecommerce.price.test`

5 tests to check rest controller: `PriceControllerTest`
5 unit tests for services: `PriceServiceTest`

### 8. Recursos

* Resources: `src/main/resources`
`application.yaml`: Configuration of application
`data-h2.sql`: script to load initial data



## Ejecutar la aplicación

* Executing desde el propio source code

```
mvn spring-boot:run
```

* Ejecutar la aplicación

```
java -jar ecommerce-price-service-1.0.0-SNAPSHOT.jar
```

* Swagger
http://localhost:8080/swagger-ui/index.html

## Test application

* Testing application
http://localhost:8080/prices/?suppliedDate=[yyyy-MM-ddTHH:mm:ss.000Z]&productId=[productId]&brandId=[brandId]

* Testing application for example
http://localhost:8080/prices/?suppliedDate=2020-06-14T15:00:00.000Z&productId=35455&brandId=1


## Exceptions

* In case there are no prices: `404` NOT_FOUND is raised with the following message body:

```json
{
    "code": "NOT_FOUND",
    "message": "prices have not been found"
}
```

## Actuators

* Test actuator health
http://localhost:8080/actuator/health

* Test actuator health
http://localhost:8080/actuator/info


