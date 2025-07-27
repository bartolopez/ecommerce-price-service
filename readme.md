# Servicio de Precios

Este proyecto consiste en una aplicación Spring Boot que expone un endpoint REST para consultar precios aplicables a un producto en una fecha determinada y para una cadena concreta. Utiliza una base de datos en memoria H2 y cuenta con pruebas unitarias y de integración del endpoint.

---

## Descripción del Servicio

El servicio permite consultar la tarifa final que debe aplicarse a un producto, en función de:

**Parámetros de entrada del endpoint REST**:

- `suppliedDate` (fecha de aplicación): en formato `yyyy-MM-ddTHH:mm:ss.000Z`
- `productId` (identificador del producto)
- `brandId` (identificador de la cadena)

**Respuesta esperada**:

- Identificador del producto
- Identificador de la cadena
- Tarifa a aplicar (price list)
- Fechas de aplicación de dicha tarifa (inicio y fin)
- Precio final a aplicar (price)

---

## Estructura de Paquetes

### 1. Dominio (`es.ecommerce.domain`)

- **model**: contiene las entidades y objetos de dominio (`Price`)
- **port**: define las interfaces que deben implementar los adaptadores (`PriceRepository`)

### 2. Aplicación (`es.ecommerce.application`)

- **service**: contiene la lógica de negocio del servicio (`PriceService`)

### 3. Infraestructura (`es.ecommerce.infraestructure`)

- **persistence**: implementación del repositorio (`PriceRepository`) usando Spring Data JPA y base de datos H2

### 4. Web (`es.ecommerce.web`)

- Controlador REST que expone el endpoint de consulta de precios (`PriceController`)

### 5. Configuración (`es.ecommerce.configuration`)

- Configuración de beans de Spring, incluyendo ensamblado de dependencias

### 6. Excepciones (`es.ecommerce.exception`)

- Gestión de errores personalizados, por ejemplo cuando no se encuentran precios

### 7. Testing (`com.ecommerce.price.test`)

- Pruebas del controlador REST: `PriceControllerTest` (mínimo 5 casos)
- Pruebas unitarias del servicio: `PriceServiceTest` (mínimo 5 casos)

### 8. Recursos

- `application.yaml`: configuración de la aplicación
- `data-h2.sql`: script de carga de datos iniciales en H2

---

## Cómo ejecutar la aplicación

### Desde código fuente:

```bash
mvn spring-boot:run
```

### Desde el JAR:

```bash
java -jar ecommerce-price-service-1.0.0-SNAPSHOT.jar
```

---

## Endpoint REST

**URL**:  
`GET /prices`

**Parámetros**:
- `suppliedDate`: fecha de aplicación
- `productId`: identificador del producto
- `brandId`: identificador de la cadena

**Ejemplo**:

```
http://localhost:8080/prices/?suppliedDate=2020-06-14T15:00:00.000Z&productId=35455&brandId=1
```

**Respuesta exitosa** (HTTP 200):

```json
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 2,
  "startDate": "2020-06-14T15:00:00",
  "endDate": "2020-06-14T18:30:00",
  "price": 25.45
}
```

---

## Gestión de Errores

Si no se encuentra ningún precio que aplicar para los parámetros dados, se devuelve:

**HTTP 404 Not Found**:

```json
{
  "code": "NOT_FOUND",
  "message": "prices have not been found"
}
```

---

## Pruebas

### Ejecutar las pruebas:

```bash
mvn test
```

### Tipos de prueba:

- **`PriceControllerTest`**: pruebas del endpoint REST verificando diferentes combinaciones de parámetros de entrada y comportamiento del servicio
- **`PriceServiceTest`**: pruebas de la lógica del servicio, incluyendo selección correcta de la tarifa según prioridad y fechas

---

### Pruebas End-to-End (E2E) con RestAssured

Además de los tests unitarios y de integración, se ha añadido la clase `PriceE2ETest` con pruebas E2E usando la librería [RestAssured](https://rest-assured.io/).

Estas pruebas arrancan el servidor en un puerto aleatorio (`@SpringBootTest(webEnvironment = RANDOM_PORT)`) y validan las respuestas reales del endpoint `/prices`.

Casos cubiertos en `PriceE2ETest`:

- **Test 1**: 14/06 a las 10:00 → precio esperado `35.50`
- **Test 2**: 14/06 a las 16:00 → precio esperado `25.45`
- **Test 3**: 14/06 a las 21:00 → precio esperado `35.50`
- **Test 4**: 15/06 a las 10:00 → precio esperado `30.50`
- **Test 5**: 16/06 a las 21:00 → precio esperado `38.95`

Para ejecutar:

```bash
mvn test -Dtest=PriceE2ETest
```

Estas pruebas permiten validar el sistema de forma realista como un cliente externo y simulan casos de negocio reales.

## Consola de Base de Datos H2

Accesible desde:  
`http://localhost:8080/h2-console`  
Configuración por defecto:  
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: *(vacía)*

---

## Swagger (Documentación API)

`http://localhost:8080/swagger-ui/index.html`

---

## Actuadores de Spring Boot

- Health:  
  `http://localhost:8080/actuator/health`

- Info:  
  `http://localhost:8080/actuator/info`
