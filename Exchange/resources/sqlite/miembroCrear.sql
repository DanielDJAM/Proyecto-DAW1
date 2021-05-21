CREATE TABLE IF NOT EXISTS Miembro(
uid VARCHAR(6) NOT NULL,
dni VARCHAR(9) NOT NULL,
email VARCHAR(20) NOT NULL,
contrasenia VARCHAR(256) NOT NULL,
id_direccion VARCHAR(12) NOT NULL,
id_wallet VARCHAR(12) NOT NULL,
id_tarjeta VARCHAR(16) NOT NULL,
PRIMARY KEY(uid),
FOREIGN KEY (id_direccion) REFERENCES Direccion(id_direccion),
FOREIGN KEY (dni) REFERENCES DatosPersonales(dni),
FOREIGN KEY (id_wallet) REFERENCES Wallet(id_wallet),
FOREIGN KEY (id_tarjeta) REFERENCES Tarjeta(id_tarjeta)
);