CREATE TABLE Mercado (
  id_moneda VARCHAR(6) NOT NULL,
  id_wallet VARCHAR(12) NOT NULL,
  cantidad DOUBLE(50),
  FOREIGN Key (id_moneda) REFERENCES Moneda(ticket),
  FOREIGN key(id_wallet) REFERENCES Wallet(id_wallet)
  );