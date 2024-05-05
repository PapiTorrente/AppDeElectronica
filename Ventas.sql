SET NAMES 'latin1';
DROP DATABASE IF EXISTS ventas;
CREATE DATABASE IF NOT EXISTS ventas DEFAULT CHARACTER SET utf8;
USE ventas;

CREATE TABLE proveedores(
id_proveedor INTEGER NOT NULL AUTO_INCREMENT,
nombre_empresa VARCHAR(70) NOT NULL,
nombre VARCHAR(18) NOT NULL,
ap_paterno VARCHAR(20) NOT NULL,
ap_materno VARCHAR(20) NOT NULL,
telefono VARCHAR(12) NOT NULL,
correo VARCHAR(50) NOT NULL,

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

/*Cliente*/
insert into clientes values (1,"Jaime", "Lara", "Hernandez", "Valle de México", "5512345678","j1@hotmail.com", 1);
insert into clientes values (2,"Melanie", "Clara", "Lopéz", "Valle de Aragon", "5587654321","m1@hotmail.com", 1);
insert into clientes values (3,"Elizabeth", "Yang", "Garcia", "Valle de Europa", "5585746321","e1@hotmail.com", 0);
insert into clientes values (4,"Erick", "Lara", "Hernandez", "Valle de Asia", "5598637452","e2@hotmail.com", 0);
insert into clientes values (5,"Adrian", "Sanchez", "VillaReal", "Valle de Geras", "5523874651","a1@hotmail.com", 1);
/*Proveedores*/
INSERT INTO proveedores VALUES (1,'Electrónica Innovadora', 'Juan', 'González', 'Martínez', '551234567890', 'juan.gonzalez@hotmail.com');
INSERT INTO proveedores VALUES (2,'Tecnología Avanzada', 'María', 'López', 'Hernández', '552345678901', 'maria.lopez@gmail.com');
INSERT INTO proveedores VALUES (3,'Electrónica Moderna', 'Carlos', 'Martínez', 'Sánchez', '553456789012', 'carlos.martinez@icloud.com');
INSERT INTO proveedores VALUES (4,'ElectroTech', 'Ana', 'Hernández', 'Gómez', '554567890123', 'ana.hernandez@yahoo.com');
INSERT INTO proveedores VALUES (5,'ElectroWorld', 'Pedro', 'García', 'Pérez', '555678901234', 'pedro.garcia@outlook.com');
/*Productos*/
INSERT INTO productos VALUES (1, 'Resistor', 50, 'R1234AB567', 100,1);
INSERT INTO productos VALUES (2, 'Capacitor', 80, 'C5678CD901', 150,2);
INSERT INTO productos VALUES (3, 'Transistor', 120, 'T2345EF678', 80,3);
INSERT INTO productos VALUES (4, 'Diodo', 30, 'D8901GH234', 200,4);
INSERT INTO productos VALUES (5, 'Inductor', 70, 'I5678IJ345', 120,5);