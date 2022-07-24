# Reto-3_4-5
Query BD: 

https://github.com/davidmintic/elecciones-g8

1. CREACION DE BD
CREATE DATABASE bd_elecciones;
===============================
2. CREACION DE  TABLAS 
A).TABLA ELECCIONES:

CREATE TABLE tbl_elecciones (
   PRIMARY KEY(id_eleccion),
   id_eleccion VARCHAR(10),
   description vARCHAR(400),
   categoria VARCHAR(20),
   fecha_inicio DATE,
   fecha_fin DATE,
   fecha_ins DATE
);

----------------------------------
B) TABLA VOTANTES


CREATE TABLE tbl_votantes (
   PRIMARY KEY(id_votante),
   id_votante VARCHAR(25),
   nombre vARCHAR(150),
   correo VARCHAR(20),
   telefono VARCHAR(150),
   direccion VARCHAR(100)
);
---------------------------------------
C)  TABLA CANDIDATOS

CREATE TABLE tbl_candidatos (
   PRIMARY KEY(id_candidato),
   id_candidato VARCHAR(25),
   nombre VARCHAR(150),
   correo VARCHAR(20),
   telefono VARCHAR(150),
   direccion VARCHAR(100),
   partido_politico VARCHAR(150),
   mensaje_campania VARCHAR(150),
   descripcion VARCHAR(400),
   ciudad_origen VARCHAR(250)
);
---------------------------------------------------
D) TABLA PROPUESTAS

CREATE TABLE tbl_propuestas (
   id_propuesta VARCHAR(10),
   sector VARCHAR(50),
   descripcion VARCHAR(400),
   id_candidato VARCHAR(25),
   PRIMARY KEY(id_propuesta),
   FOREIGN KEY(id_candidato) REFERENCES tbl_candidatos(id_candidato)
);
---------------------------------------------------------
E) TABLA 

CREATE TABLE tbl_votos (
   id_voto INT(10),
   id_eleccion VARCHAR(10),
   id_candidato VARCHAR(25),
   id_votante VARCHAR(25),
   PRIMARY KEY(id_voto),
   FOREIGN KEY(id_eleccion) REFERENCES tbl_elecciones(id_eleccion),
   FOREIGN KEY(id_candidato) REFERENCES tbl_candidatos(id_candidato),
   FOREIGN KEY(id_votante) REFERENCES tbl_votantes(id_votante)
);

=============================================================================
INSERTAR DATOS EN LAS  TABLAS

INSERT INTO tbl_elecciones (id_eleccion, description, categoria,
fecha_inicio, fecha_fin, fecha_ins) VALUES ('EP-V12022', 
'Elecciones Presidenciales Primera Vuelta','Presidencial', '2022-08-06', '2022-08-07', NOW());   

INSERT INTO tbl_elecciones (id_eleccion, description, categoria,
fecha_inicio, fecha_fin, fecha_ins) VALUES ('EP-V22022', 
'Elecciones Presidenciales Segunda Vuelta','Presidencial', '2022-09-24', '2022-09-25', NOW());   

INSERT INTO tbl_candidatos(id_candidato, nombre, correo, telefono, direccion, partido_politico, mensaje_campania, description, ciudad_origen)
VALUES ('01', 'Ernesto Mandela', 'candidato1@gmail.com','8903132','Cra 5 No 89B-23', 
'Partido Verde', 'Paz para Colombia', 'Politico con trayectoria', 'Bogota');



================================================================================
OTRAS CONSULTAS :
SELECT *
FROM tbl_elecciones
WHERE id_eleccion = 'EP-V22022';

ACTUALIZAR INFORMACION:
UPDATE tbl_elecciones
SET categoria = 'Presidencial', fecha_inicio = '2022-08-05'
WHERE id_eleccion = 'EP-V12022';
==========================================
  

                             '
