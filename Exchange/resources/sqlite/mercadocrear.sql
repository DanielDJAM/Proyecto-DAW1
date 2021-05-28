CREATE TABLE Mercado (
  idMoneda VARCHAR(6) NOT NULL,
  idWallet VARCHAR(12) NOT NULL,
  cantidad DOUBLE(50),
  FOREIGN Key (idMoneda) REFERENCES Moneda(ticket),
  FOREIGN key(idWallet) REFERENCES Wallet(idWallet)
  );