# Inventario

Aplicación fullstack de gestión de inventario y reportes, desarrollada con React (frontend), Spring Boot (backend), MySQL (base de datos) y un microservicio extra en FastAPI (Python) para analítica avanzada.

Este proyecto está pensado como un ejercicio de portfolio para demostrar conocimientos en desarrollo web, arquitectura de software y despliegue con Docker.

## 🎯 Objetivos del proyecto

- Construir una aplicación realista que gestione productos, usuarios y pedidos.

- Incluir autenticación con roles (admin / usuario).

- Mostrar reportes y estadísticas en un dashboard con gráficas.

- Exportar datos en Excel y PDF.

- Aprender a orquestar servicios con Docker Compose.

- Añadir un microservicio en FastAPI para analítica predictiva.

## 🛠️ Tecnologías

- Frontend: React + TypeScript + Tailwind + Recharts.

- Backend: Spring Boot (Java) + JUnit tests.

- Microservicio: FastAPI (Python) + pandas/scikit-learn (opcional).

- Base de datos: MySQL / PostgreSQL.

- Infraestructura: Docker Compose + GitHub Actions (CI/CD).

## 📑 Modelo de datos inicial

- Usuarios: id, nombre, email, contraseña (hash), rol.

- Productos: id, nombre, precio, stock, categoría.

- Pedidos: id, usuario_id, fecha, total.

- DetallePedido: id, pedido_id, producto_id, cantidad, precio.

## 🚀 Roadmap
- Fase 1 – MVP (mínimo producto viable)

    - [ ] Crear backend en Spring Boot con CRUD de usuarios y productos.

    - [ ] Conectar base de datos MySQL/Postgres.

    - [ ] Frontend React con login y listado de productos.

    - [ ] Docker Compose para levantar backend + base de datos.

- Fase 2 – Funcionalidades avanzadas

    - [ ] Autenticación JWT con roles (admin / usuario).

    - [ ] Dashboard en frontend con gráficas de stock/ventas.

    - [ ] Exportar reportes en Excel y PDF.

    - [ ] Semillas (datos de prueba).

- Fase 3 – Extras pro

    - [ ] Microservicio de analítica con FastAPI (ejemplo: predicción de stock bajo).

    - [ ] Tests automáticos en backend y microservicio.

    - [ ] CI/CD con GitHub Actions.

    - [ ] Despliegue en la nube (Railway, Render o similar).

## 📸 Preview

(Se irán añadiendo capturas y GIFs de la app conforme avance el desarrollo).


## 🗂 Modelo de datos

### Usuarios
| Campo      | Tipo      | Detalle                 |
|------------|-----------|-------------------------|
| id         | UUID      | PK                      |
| nombre     | string    |                         |
| email      | string    | único                   |
| contraseña | string    |                         |
| rol        | RolEnum   | ADMIN / EMPLEADO        |
| created_at | timestamp |                         |
| updated_at | timestamp |                         |

### Productos
| Campo        | Tipo      | Detalle             |
|--------------|-----------|---------------------|
| id           | UUID      | PK                  |
| nombre       | string    |                     |
| categoria    | string    | opcional            |
| descripcion  | string    | opcional            |
| stock        | int       | cantidad disponible |
| precio_venta | double    |                     |
| created_at   | timestamp |                     |
| updated_at   | timestamp |                     |

### Entradas (compras/proveedores)
| Campo         | Tipo      | Detalle                              |
|---------------|-----------|--------------------------------------|
| id            | UUID      | PK                                   |
| id_producto   | UUID      | FK → productos.id                    |
| cantidad      | int       | cantidad comprada                    |
| precio_compra | double    | precio de compra por unidad          |
| fecha_compra  | date      | fecha de la compra                   |


### Pedidos
| Campo        | Tipo      | Detalle                              |
|--------------|-----------|--------------------------------------|
| id           | UUID      | PK                                   |
| id_usuario   | UUID      | FK → usuarios.id                     |
| fecha_pedido | date      | fecha en que se realiza el pedido    |
| total        | double    | suma de los precios de los productos |


### DetallePedidos
| Campo        | Tipo      | Detalle                              |
|--------------|-----------|--------------------------------------|
| id           | UUID      | PK                                   |
| id_pedido    | UUID      | FK → pedidos.id                      |
| id_producto  | UUID      | FK → productos.id                    |
| cantidad     | int       | cantidad pedida                      |
| precio_venta | double    | precio del producto en ese pedido    |





## 👥 Roles de usuario

La aplicación distingue entre **administradores** y **empleados**, cada uno con diferentes permisos:

| Acción                           | Empleado | Administrador |
|----------------------------------|:--------:|:-------------:|
| Iniciar sesión                   | ✅       | ✅             |
| Consultar productos y stock      | ✅       | ✅             |
| Registrar pedidos                | ✅       | ✅             |
| Crear/editar/eliminar productos  | ❌       | ✅             |
| Gestionar usuarios               | ❌       | ✅             |
| Consultar reportes de ventas     | ❌       | ✅             |
| Exportar datos (Excel/PDF)       | ❌       | ✅             |
| Alertas de stock bajo            | ❌       | ✅             |
| Gráficas                         | ❌       | ✅             |




## Autor
Proyecto personal de **Alejandro Casado Arribas** ppara portfolio