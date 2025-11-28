# **Sistema de Inventario – Módulo Web (Spring Boot + Hibernate)**

**Autor:** Daniel Felipe Perdomo Hernández
**Evidencia:** GA7-220501096-AA3-EV01
**Programa:** Análisis y Desarrollo de Software
**Frameworks:** Spring Boot – Spring Web – Hibernate (JPA) – H2 (dev) – MySQL (prod)

---

## **Descripción del Proyecto**

Este módulo corresponde a la codificación del sistema de inventario definido en el proyecto formativo.
Implementa un backend web construido con **Spring Boot** y **Hibernate**, siguiendo el diseño previo: casos de uso, historias de usuario, diagrama de clases y artefactos del ciclo de vida del software.

El módulo desarrollado incluye:

* Gestión de productos.
* Control de existencias: entradas y salidas.
* Persistencia con Hibernate.
* API REST con Spring Web.
* Perfiles de ejecución: H2 para desarrollo y MySQL para despliegue.
* Código comentado siguiendo estándares de la evidencia.

---

## **Arquitectura**

El proyecto sigue una arquitectura en capas:

```
/controller      → Exposición API REST
/service         → Lógica de negocio
/repository      → Persistencia con Hibernate/JPA
/model           → Entidades del dominio
```

Se aplica el patrón **Service – Repository** y el ciclo de vida definido en el proyecto formativo.

---

## **Tecnologías**

* **Java 17**
* **Spring Boot 3.x**
* **Spring Web**
* **Spring Data JPA (Hibernate)**
* **H2 Database (dev)**
* **MySQL (prod)**
* Maven
* Git + GitHub

---

## **Características del Módulo**

### **1. CRUD completo de productos**

Permite registrar, consultar, actualizar y eliminar productos del inventario.

### **2. Control de stock**

Movimiento de inventario por medio de un endpoint dedicado:

* **Entradas:** `quantity > 0`
* **Salidas:** `quantity < 0`

Incluye validación de stock insuficiente.

### **3. Estándares de codificación**

* Nombrado en inglés.
* Paquetización por capas.
* Comentarios Javadoc en servicios y controladores.
* DTOs limpios y validados con Jakarta Validation.

### **4. Persistencia**

* Base de datos H2 en desarrollo.
* Conexión lista a MySQL en producción (archivo `application-prod.properties`).

---

## **Endpoints Principales**

### **Productos**

| Método | Ruta                 | Descripción        |
| ------ | -------------------- | ------------------ |
| GET    | `/api/products`      | Lista productos    |
| GET    | `/api/products/{id}` | Consulta por ID    |
| POST   | `/api/products`      | Crea producto      |
| PUT    | `/api/products/{id}` | Actualiza producto |
| DELETE | `/api/products/{id}` | Elimina producto   |

### **Movimiento de stock**

| Método | Ruta                                  | Descripción        |
| ------ | ------------------------------------- | ------------------ |
| PATCH  | `/api/products/{id}/stock?quantity=x` | Ajusta existencias |

Ejemplo:
`PATCH /api/products/5/stock?quantity=-3` → salida de inventario.

---

## **Perfiles de ejecución**

### **Desarrollo (H2 – default)**

```bash
mvn spring-boot:run
```

Acceso a consola H2:
`http://localhost:8080/h2-console`

### **Producción (MySQL)**

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

---

## **Estructura del Repositorio**

```
/src/main/java/com/inventory
    /controller
    /service
    /repository
    /model
    /dto
/src/main/resources
    application.properties
    application-prod.properties
README.md
pom.xml
```

---

## **Cómo Probar el Módulo**

1. Clonar repositorio
2. Importar como proyecto Maven
3. Ejecutar con el perfil por defecto
4. Consumir los endpoints vía Postman, Thunder Client o navegador (para GET)

---

## **Estado de la Evidencia**

Este módulo cumple los criterios del instrumento:

✔ Framework aplicado (Spring + Hibernate)
✔ Persistencia configurada
✔ Estándares de codificación
✔ Código comentado
✔ Uso de repositorio para control de versiones
✔ Módulo codificado según diseño establecido

---

## **Licencia**

Proyecto académico – uso formativo.