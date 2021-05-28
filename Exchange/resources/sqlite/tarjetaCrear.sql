CREATE TABLE Tarjeta (
  idTarjeta VARCHAR(16) NOT NULL PRIMARY Key,
  titular VARCHAR(50) NOT NULL,
  fechaCaducidad VARCHAR(50) NOT NULL,
  cvv INT(6)
  );