CREATE DATABASE levelup_arcade;
USE levelup_arcade;

-- =========================
-- CATEGORIA
-- =========================
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(255)
);

-- =========================
-- PROVEEDOR
-- =========================
CREATE TABLE proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(45),
    direccion VARCHAR(100)
);

-- =========================
-- PRODUCTO
-- =========================
CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    id_categoria INT,
    id_proveedor INT,

    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
        ON DELETE SET NULL ON UPDATE CASCADE,

    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
        ON DELETE SET NULL ON UPDATE CASCADE
);

-- =========================
-- CLIENTE
-- =========================
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    apellidos VARCHAR(45),
    email VARCHAR(45),
    telefono VARCHAR(20),
    direccion VARCHAR(100)
);

-- =========================
-- COMPRA
-- =========================
CREATE TABLE compra (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    id_cliente INT,

    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
        ON DELETE SET NULL ON UPDATE CASCADE
);

-- =========================
-- DETALLE_COMPRA
-- =========================
CREATE TABLE detalle_compra (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_compra INT,
    id_producto INT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (id_compra) REFERENCES compra(id_compra)
        ON DELETE CASCADE ON UPDATE CASCADE,

    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

-- =========================
-- USUARIO (SEGURIDAD)
-- =========================
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    rol ENUM('ADMIN', 'EMPLEADO')
);

INSERT INTO usuario (nombre, contrasena, rol)
VALUES ('admin', SHA2('admin', 256), 'ADMIN');

INSERT INTO usuario (nombre, contrasena, rol)
VALUES ('empleado', SHA2('empl123', 256), 'EMPLEADO');


