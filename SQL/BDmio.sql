/*

INTEGRANTES:

Jhonier Andrés Calero Rodas 	-   	1424599
Fabio Andrés Castañeda Duarte 	- 		1424386
Juan Pablo Moreno Muñoz 		-       1423437
Joan Manuel Tovar Guzmán 		-       1423124

*/

DROP TABLE IF EXISTS bus, estacion, ruta, empleado, pasajero, tarjeta, caso, recargas_tarjetas, ingresos_rutas, rutas_estaciones, asignaciones_conductores, medidas_casos CASCADE;
DROP SEQUENCE IF EXISTS pinT;

CREATE TABLE ruta(
	cod_ruta varchar(5), 
	nombre varchar(50) NOT NULL,
	descripcion varchar(100) NOT NULL,
	PRIMARY KEY(cod_ruta)
);

CREATE TABLE bus(
	placa char(7), 
	tipo varchar(20) NOT NULL,
	capacidad integer NOT NULL, 
	cod_ruta varchar(5) NOT NULL,
	PRIMARY KEY(placa),
	FOREIGN KEY(cod_ruta) REFERENCES ruta(cod_ruta)
	ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE empleado(
	id_empleado varchar(10), 
	nombre varchar(50) NOT NULL,
	direccion varchar(50) NOT NULL, 
	telefono varchar(10) NOT NULL,
	fecha_nac date NOT NULL,
	cargo varchar(30) NOT NULL,
	salario double precision NOT NULL, 	
	estado varchar(10) NOT NULL,
	password varchar(20) NOT NULL,
	PRIMARY KEY(id_empleado)	
);

CREATE TABLE estacion(
	cod_estacion serial, 
	nombre varchar(50) NOT NULL, 
	ubicacion varchar(50) NOT NULL, 
	telefono varchar(10) NOT NULL,
	id_director varchar(5) NOT NULL,
	PRIMARY KEY(cod_estacion),
	FOREIGN KEY(id_director) REFERENCES empleado(id_empleado)
	ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE SEQUENCE pinT START 10001;

CREATE TABLE tarjeta(
	pin varchar(5) DEFAULT nextval ('pinT'::regclass), 
	pasajes integer NOT NULL, 
	estado varchar(15) NOT NULL,
	eliminada boolean DEFAULT false, 
	fecha_adq date NOT NULL,
	cod_estacion integer NOT NULL,
	PRIMARY KEY(pin),
	FOREIGN KEY(cod_estacion) REFERENCES estacion(cod_estacion)
	ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE pasajero(
	id_pasajero varchar(10), 
	nombre varchar(50) NOT NULL,
	direccion varchar(50) NOT NULL, 
	telefono varchar(10) NOT NULL,
	fecha_nac date NOT NULL, 
	pin varchar(5) UNIQUE,
	PRIMARY KEY(id_pasajero), 
	FOREIGN KEY(pin) REFERENCES tarjeta(pin)
	ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE caso(
	cod_caso serial,
	descripcion varchar(500) NOT NULL,	
	motivo varchar(80) NOT NULL,
	fecha date,  
	estado varchar(15) NOT NULL,
	cod_estacion integer,
	id_pasajero varchar(10),
	id_empleado varchar(5), 
	PRIMARY KEY(cod_caso), 
	FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY(id_pasajero) REFERENCES pasajero(id_pasajero)
	ON DELETE NO ACTION ON UPDATE CASCADE, 
	FOREIGN KEY(cod_estacion) REFERENCES estacion(cod_estacion)
	ON DELETE NO ACTION ON UPDATE CASCADE	
);


CREATE TABLE recargas_tarjetas(
	pin varchar(5), 
	cod_estacion integer, 
	num_pasajes integer NOT NULL,
	fecha_hora timestamp,
	PRIMARY KEY(pin, cod_estacion, fecha_hora),
    FOREIGN KEY(pin) REFERENCES tarjeta(pin)
    ON DELETE NO ACTION ON UPDATE CASCADE,
    FOREIGN KEY(cod_estacion) REFERENCES estacion(cod_estacion)
    ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE ingresos_rutas(
	pin varchar(5), 
	cod_ruta char(5), 
	fecha_hora timestamp, 
	PRIMARY KEY(pin, cod_ruta, fecha_hora), 
	FOREIGN KEY(pin) REFERENCES tarjeta(pin)
	ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY(cod_ruta) REFERENCES ruta(cod_ruta)
	ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE rutas_estaciones(
	cod_estacion integer, 
	cod_ruta varchar(5), 
	PRIMARY KEY(cod_estacion, cod_ruta), 
	FOREIGN KEY(cod_estacion) REFERENCES estacion(cod_estacion)
	ON DELETE NO ACTION ON UPDATE CASCADE, 
	FOREIGN KEY(cod_ruta) REFERENCES ruta(cod_ruta)
	ON DELETE NO ACTION ON UPDATE CASCADE
);


CREATE TABLE asignaciones_conductores(
	id_empleado varchar(5), 
	placa varchar(7), 
	turno varchar(10),
	PRIMARY KEY(id_empleado, placa, turno),
	FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado),
	FOREIGN KEY(placa) REFERENCES bus(placa)
);

CREATE TABLE medidas_casos(
	medida varchar(100),
	cod_caso integer, 
	PRIMARY KEY(cod_caso, medida), 
	FOREIGN KEY(cod_caso) REFERENCES caso(cod_caso)
	ON DELETE NO ACTION ON UPDATE CASCADE
); 
