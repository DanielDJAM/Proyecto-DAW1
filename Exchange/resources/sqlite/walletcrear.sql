CREATE TABLE Wallet (
  id_wallet VARCHAR(12) NOT NULL PRIMARY KEY,
  id_usuario VARCHAR(6) NOT NULL,
  FOREIGN KEY (id_usuario) REFERENCES Miembro(uid)
  );