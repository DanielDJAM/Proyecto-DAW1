CREATE TABLE Usuario(
uid VARCHAR(6) NOT NULL,
dni VARCHAR(9),
nombre VARCHAR(20),
apellidos VARCHAR(20),
edad INTEGER,
email VARCHAR(20),
contrasenia VARCHAR(256),
id_direccion VARCHAR(12) NOT NULL,
PRIMARY KEY(uid ),
FOREIGN KEY (id_direccion) REFERENCES Direccion(id_direccion)
);
