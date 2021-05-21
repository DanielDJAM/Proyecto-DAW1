CREATE TABLE tarjeta (
  id_tarjeta VARCHAR(16) NOT NULL PRIMARY Key,
  titular VARCHAR(50) NOT NULL,
  fechaCaducidad VARCHAR(50) NOT NULL,
  cvv INT(6)
  );