CREATE TABLE Miembro(
uid VARCHAR(6) NOT NULL,
dni VARCHAR(9) NOT NULL,
tipo VARCHAR(50),
email VARCHAR(20) NOT NULL,
contrasenia VARCHAR(256) NOT NULL,
idDireccion VARCHAR(12) NOT NULL,
idTarjeta VARCHAR(16) NOT NULL,
PRIMARY KEY(uid),
FOREIGN KEY (idDireccion) REFERENCES Direccion(idDireccion),
FOREIGN KEY (dni) REFERENCES DatosPersonales(dni),
FOREIGN KEY (idTarjeta) REFERENCES Tarjeta(idTarjeta)
);