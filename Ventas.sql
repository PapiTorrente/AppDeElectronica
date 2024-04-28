SET NAMES 'latin1';
DROP DATABASE IF EXISTS ventas;
CREATE DATABASE IF NOT EXISTS ventas DEFAULT CHARACTER SET utf8;
USE ventas;

CREATE TABLE proveedores(
id_proveedor INTEGER NOT NULL AUTO_INCREMENT,
nombre VARCHAR(18) NOT NULL,
ap_paterno VARCHAR(9) NOT NULL,
ap_materno VARCHAR(9) NOT NULL,
telefono VARCHAR(12) NOT NULL,
correo VARCHAR(22) NOT NULL,

PRIMARY KEY(id_proveedor)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE productos(
id_producto INTEGER NOT NULL AUTO_INCREMENT,
nombre VARCHAR(20),
precio INTEGER,
modelo VARCHAR(10),
cant_disp INTEGER,
id_proveedor INTEGER,

PRIMARY KEY(id_producto),
FOREIGN KEY(id_proveedor) REFERENCES proveedores(id_proveedor)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE clientes(
id_cliente INTEGER NOT NULL AUTO_INCREMENT,
nombre VARCHAR(18) NOT NULL,
ap_paterno VARCHAR(9) NOT NULL,
ap_materno VARCHAR(9) NOT NULL,
domicilio VARCHAR(30) NOT NULL,
telefono VARCHAR(12) NOT NULL,
correo VARCHAR(22) NOT NULL,
es_miembro BOOLEAN,

PRIMARY KEY(id_cliente)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE ventas(
id_venta INTEGER NOT NULL AUTO_INCREMENT,
id_producto INTEGER,
nombre VARCHAR(20),
precio INTEGER,
cantidad INTEGER,
forma_pago VARCHAR(10),
id_cliente INTEGER,
fecha_venta DATE,

PRIMARY KEY(id_venta),
FOREIGN KEY(id_producto) REFERENCES productos(id_producto),
FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE devoluciones(
id_devol INTEGER NOT NULL AUTO_INCREMENT,
id_producto INTEGER,
precio INTEGER,
cantidad INTEGER,
forma_de_reembolso VARCHAR(10),
motivo VARCHAR(40),
id_cliente INTEGER,
fecha_devol DATE,

PRIMARY KEY(id_devol),
FOREIGN KEY(id_producto) REFERENCES productos(id_producto),
FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE envios(
id_envio INTEGER NOT NULL AUTO_INCREMENT,
id_venta INTEGER,
costo_envio INTEGER,
fecha_envio DATE,

PRIMARY KEY(id_envio),
FOREIGN KEY(id_venta) REFERENCES ventas(id_venta)
)DEFAULT CHARACTER SET utf8;