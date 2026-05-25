CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombre_usuario VARCHAR(100) NOT NULL,
    email_usuario VARCHAR(100) NOT NULL,
    contraseña_usuario VARCHAR(200) NOT NULL,
    rol_usuario VARCHAR(20) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE
);

-- Tabla para ver los productos que hay en el almacén
CREATE TABLE IF NOT EXISTS productos (
    id_producto UUID PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    categoria_producto VARCHAR(100),
    descripcion_producto VARCHAR(200),
    stock_producto INT NOT NULL,
    precio_venta DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE
);

-- Tabla para ver las entradas de productos (Compras a proveeddores)
CREATE TABLE IF NOT EXISTS entradas (
    id_entrada UUID PRIMARY KEY,
    id_producto UUID REFERENCES productos(id_producto),
    cantidad INT NOT NULL,
    precio_compra DECIMAL(10,2) NOT NULL,
    fecha_compra DATE NOT NULL
);