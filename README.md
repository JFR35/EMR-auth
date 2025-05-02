# Proyecto de Pruebas: Implementación de Spring Security  
## Aplicación de Gestión de Pacientes con Hipertensión

Este proyecto es una **implementación de prueba** centrada en integrar **Spring Security** dentro de una aplicación que gestiona pacientes con hipertensión. Forma parte del desarrollo del **proyecto final del ciclo DAW**, con el objetivo de aprender y aplicar conceptos de autenticación y autorización en un entorno real.

---

## 🔐 Objetivo de esta prueba

- Asegurar los endpoints de la aplicación usando Spring Security.
- Implementar autenticación básica y/o con JWT.
- Controlar el acceso a recursos según el rol del usuario (por ejemplo: ADMIN, MÉDICO, PACIENTE).
- Comprobar el funcionamiento de filtros, configuración de seguridad y manejo de sesiones o tokens.

---

## ⚙️ Tecnologías utilizadas

- Java 17+
- Spring Boot 3+
- Spring Security
- Maven
- H2 / MySQL (según entorno de pruebas)
- Postman / Navegador para pruebas de endpoints
- (Opcional) JWT para autenticación basada en tokens

---

## 🏗️ Estructura del proyecto (parcial)

src/
├── main/
│ ├── java/
│ │ └── com/miapp/pacientes/
│ │ ├── controller/
│ │ ├── entity/
│ │ ├── security/ <-- Configuraciones de Spring Security
│ │ ├── service/
│ │ └── ...
│ └── resources/
│ └── application.properties
└── test/

yaml
Copiar
Editar

---

## 🔐 Spring Security - Funcionalidades Probadas

- Configuración de `SecurityFilterChain` (en lugar del método `configure()` deprecado).
- Filtro personalizado para autenticar peticiones con JWT (si aplica).
- Exclusión de rutas públicas (por ejemplo: `/login`, `/register`).
- Protección de rutas privadas (`/api/pacientes/**`, `/dashboard`, etc.).
- Manejo de sesiones o tokens.
- Redirección o respuesta 401 personalizada para accesos no autorizados.

---

## 📌 Endpoints de prueba

| Método | Ruta                  | Descripción                            | Seguridad |
|--------|-----------------------|----------------------------------------|-----------|
| POST   | /login                | Iniciar sesión                         | Pública   |
| POST   | /register             | Registrar nuevo usuario                | Pública   |
| GET    | /dashboard            | Vista protegida tras login             | Privada   |
| GET    | /api/pacientes        | Obtener lista de pacientes             | Privada   |
| POST   | /api/pacientes        | Crear paciente                         | Privada   |
| ...    | ...                   | ...                                    | ...       |

---

## 🧪 Cómo ejecutar las pruebas

1. Clona este repositorio.
2. Configura el archivo `application.properties` según tu entorno (base de datos, puertos, etc.).
3. Ejecuta la aplicación (`mvn spring-boot:run` o desde tu IDE).
4. Usa Postman o el navegador para probar las rutas protegidas y públicas.
5. Verifica que los accesos no autorizados respondan correctamente.

---

## ✅ Estado actual

✅ Login y registro funcionando  
✅ Rutas protegidas por roles  
✅ Seguridad con filtro JWT (si lo implementaste)  
⚠️ Pendiente conexión con frontend (si aplica)  
⚠️ Pendiente implementación de logout seguro (opcional)

---

## 📚 Aprendizajes

- Cómo configurar seguridad en Spring Boot 3+
- Diferencia entre autenticación y autorización
- Uso de `SecurityFilterChain` y filtros personalizados
- Pruebas de endpoints protegidos en Postman
- Validación de roles en endpoints REST

---

## 📌 Nota

Este proyecto **no es la versión final** de la aplicación, sino una **prueba aislada** para comprobar que la seguridad con Spring Security se integra correctamente antes de llevarla al proyecto principal de gestión de pacientes.

---
