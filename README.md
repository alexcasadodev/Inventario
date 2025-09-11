### Inventario

Aplicación fullstack de gestión de inventario y reportes, desarrollada con React (frontend), Spring Boot (backend), MySQL (base de datos) y un microservicio extra en FastAPI (Python) para analítica avanzada.

Este proyecto está pensado como un ejercicio de portfolio para demostrar conocimientos en desarrollo web, arquitectura de software y despliegue con Docker.

## 🎯 Objetivos del proyecto

- Construir una aplicación realista que gestione productos, usuarios y pedidos.

 -Incluir autenticación con roles (admin / usuario).

- Mostrar reportes y estadísticas en un dashboard con gráficas.

- Exportar datos en Excel y PDF.

- Aprender a orquestar servicios con Docker Compose.

- (Opcional) Añadir un microservicio en FastAPI para analítica predictiva.

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

    - []Crear backend en Spring Boot con CRUD de usuarios y productos.

    - []Conectar base de datos MySQL/Postgres.

    - []Frontend React con login y listado de productos.

    - []Docker Compose para levantar backend + base de datos.

- Fase 2 – Funcionalidades avanzadas

    - []Autenticación JWT con roles (admin / usuario).

    - []Dashboard en frontend con gráficas de stock/ventas.

    - []Exportar reportes en Excel y PDF.

    - []Semillas (datos de prueba).

- Fase 3 – Extras pro

    - []Microservicio de analítica con FastAPI (ejemplo: predicción de stock bajo).

    - []Tests automáticos en backend y microservicio.

    - []CI/CD con GitHub Actions.

    - []Despliegue en la nube (Railway, Render o similar).

## 📸 Preview

(Se irán añadiendo capturas y GIFs de la app conforme avance el desarrollo).


## Autor
Proyecto personal de **Alejandro Casado Arribas** ppara portfolio