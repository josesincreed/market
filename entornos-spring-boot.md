
# 🌱 Gestión de Entornos en Spring Boot con `application.properties`

Spring Boot permite definir múltiples entornos (profiles) como `dev`, `test`, `prod`, etc., y cargar configuraciones específicas para cada uno usando archivos `application-{profile}.properties`.

---

## 🛠️ 1. Crear archivos de configuración por entorno

En la carpeta `src/main/resources/`, crea archivos de propiedades por cada entorno deseado:

```
src/main/resources/
├── application.properties
├── application-dev.properties
├── application-test.properties
└── application-prod.properties
```

---

## 📋 2. Configurar cada entorno

Ejemplo:  
**`application-dev.properties`**
```properties
server.port=8090
spring.datasource.url=jdbc:mysql://localhost:3306/dev_db
spring.datasource.username=dev_user
spring.datasource.password=dev_pass
spring.jpa.hibernate.ddl-auto=update
```

**`application-prod.properties`**
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/prod_db
spring.datasource.username=prod_user
spring.datasource.password=prod_pass
spring.jpa.hibernate.ddl-auto=validate
```

---

## 🚦 3. Activar el entorno deseado en Spring Boot

Spring Boot permite seleccionar el entorno (o **profile**) que quieres activar para que cargue sus propiedades específicas.

---

### ✅ Opción A: Desde `application.properties`

Esta es la opción más sencilla y común durante el desarrollo local.

```properties
# archivo: application.properties
spring.application.name=demo
spring.profiles.active=dev


```

🔎 Esto le dice a Spring Boot que debe usar el archivo `application-dev.properties`.

---

### ✅ Opción B: Usando parámetros en la línea de comandos

Puedes activar el perfil al ejecutar tu app:

#### ▶️ Si usas Maven:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

#### ▶️ Si ejecutas el `.jar`:
```bash
java -jar nombre-del-archivo.jar --spring.profiles.active=prod
```

---

### ✅ Opción C: Usando variables de entorno (recomendado en producción)

Esto permite externalizar la configuración, ideal para contenedores, servidores o CI/CD:

```bash
export SPRING_PROFILES_ACTIVE=test
```

En Windows CMD:

```cmd
set SPRING_PROFILES_ACTIVE=test
```

En PowerShell:

```powershell
$env:SPRING_PROFILES_ACTIVE = "test"
```

---

### 🧪 Verifica que funciona

Cuando inicias la app, deberías ver en la consola algo como:

```
The following profiles are active: dev
```

---

## 📌 Recomendaciones

- Nunca subas a Git tus archivos `application-*.properties` con contraseñas reales.
- Usa `@Profile("dev")` o similares para cargar Beans específicos según el entorno.
- En producción, puedes usar `application.yml` con múltiples perfiles anidados si prefieres.
- Si usas Docker, puedes definir la variable `SPRING_PROFILES_ACTIVE` directamente en el contenedor.

---

## 📚 Recursos útiles

- [Documentación oficial de Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)
- [Guía sobre perfiles en Baeldung](https://www.baeldung.com/spring-profiles)
