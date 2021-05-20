CREATE TABLE "MetodoPago" (
  id_pago VARCHAR(12) NOT NULL PRIMARY Key,
  titular VARCHAR(50) NOT NULL,
  numeroCuenta VARCHAR(50) NOT NULL,
  tipoPago INT (1) NOT NULL,
  iban VARCHAR(50),
  fechaCaducidad VARCHAR(50) NOT NULL,
  cvv INT(6)
  );