# 📌 Vol.Med-App-API-Rest

Este proyecto es una API REST desarrollada en **Java 17** usando el framework **Spring Boot**. Implementa autenticación basada en **JWT** con política **STATELESS**, control de acceso mediante **Spring Security**, validación con **Spring Validation**, persistencia con **JPA/Hibernate** y base de datos **MySQL**. Además, se utiliza **Lombok** para simplificar el código.

---

## 🚀 Tecnologías utilizadas
- **Java 17 (JDK 17)**
- **Spring Boot**
  - Spring Security (con política STATELESS y filtros personalizados)
  - Spring Validation
  - Spring Data JPA (Hibernate)
- **MySQL**
- **JWT** (Biblioteca `com.auth0:java-jwt:4.5.0`)
- **Lombok**

---

## 🔐 Configuración de Seguridad
La clase `SecurityConfiguration` define un **SecurityFilterChain** donde:
- Solo se permite el acceso a `/login` mediante el método **POST** sin autenticación.
- Todas las demás solicitudes requieren autenticación JWT.
- La política de sesión es **STATELESS**.
- Los filtros se encuentran ordenados para procesar correctamente las peticiones y validar el token JWT antes de acceder a los endpoints protegidos.

```java
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http.csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            .build();
    }
}
```
## 📝 Endpoints del Controller TopicoController
La API expone los siguientes endpoints para manejar recursos de tópicos:

Método	Endpoint	Descripción
GET	/topicos	Listar todos los tópicos
GET	/topicos/{id}	Ver detalles de un tópico
POST	/topicos	Registrar un nuevo tópico
PUT	/topicos/{id}	Modificar un tópico existente
DELETE	/topicos/{id}	Eliminar un tópico

Ejemplo de TopicoController:

```java
...
public class TopicoController {

    private final TopicoService topicoService;

   @Transactional
    @PostMapping
    public ResponseEntity register(//Esta Request es para registrar un nuevo topico
            @RequestBody @Valid  DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topico(datos);
        if(!topicosReponsitory.existsByTitulo(datos.titulo()) &&
                !topicosReponsitory.existsByMensaje(datos.mensaje())){
            topicosReponsitory.save(topico);
            var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
        }
        return ResponseEntity.badRequest().body("Ya existe un topico con ese titulo ó mensaje");
...
}
```
## ⚡ Autenticación JWT
El endpoint /login permite obtener un token JWT enviando credenciales válidas.

El token debe ser incluido en el header Authorization con el formato:

```makefile
Authorization: Bearer <TU_TOKEN>
```

## 📦 Instalación y ejecución
✅ Requisitos previos:
Java JDK 17

Maven

MySQL configurado

##🔧 Configuración:
Clonar el repositorio:

```bash
git clone https://github.com/Narugh14/Vol.Med-App-API-Rest-.git
```
Configurar las credenciales de MySQL en application.properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tu_baseDeDatos
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
```
Ejecutar la aplicación:

```bash
mvn spring-boot:run
```
---

## 🧪 Testing con Insomnia (JWT Bearer Token)

Puedes probar la API usando **Insomnia** o **Postman**.  
El flujo básico es:

1. **Obtener un token JWT** mediante el endpoint `/login`.
2. **Usar el token recibido** en el header `Authorization: Bearer <TOKEN>` para todas las demás solicitudes.

---

### 🔹 1. Login (Obtener Token)
**Request:**
```http
POST /login
Content-Type: application/json

{
  "login": "usuario",
  "password": "contraseña"
}
```
Response:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
Guarda el valor del token para usarlo en los demás endpoints.

🔹 2. Listar Tópicos
```http
GET /topicos
Authorization: Bearer <TOKEN>
```

🔹 3. Ver Detalles de un Tópico
```http
GET /topicos/{id_topico}
Authorization: Bearer <TOKEN>
```
🔹 4. Registrar un Nuevo Tópico
Existen tres estados de status: PUBLICADO, PENDIENTE y CERRADO
```http
POST /topicos
Content-Type: application/json
Authorization: Bearer <TOKEN>

{	
	"titulo":	"Sexto Topico",
	"mensaje":"Este es el sexto topico",
	"fecha":	"2025-06-20T15:30:00",
	"autor":	"Abigail Mosqueda",
	"status": "PUBLICADO"
}
```
🔹 5. Modificar un Tópico
```http
PUT /topicos/1
Content-Type: application/json
Authorization: Bearer <TOKEN>

{
			"id": 1,
			"titulo": "Cuarto Topico",
			"mensaje": "Este es el cuarto topico",
			"fecha": "2020-12-20T15:30:00",
			"autor": "Luis Montelongo",
			"status": "PUBLICADO"
}
```
🔹 6. Eliminar un Tópico
```http
DELETE /topicos/{id_topico}
Authorization: Bearer <TOKEN>
```

✅ Configuración de Insomnia
Crear una colección en Insomnia llamada API REST - TEST.

Añadir una variable de entorno TOKEN para guardar el JWT.

Configurar el header de autorización en cada request:

```http
Authorization: Bearer {{TOKEN}}
```

---

## ✅ Licencia
Este proyecto se distribuye bajo la licencia MIT.


