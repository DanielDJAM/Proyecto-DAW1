package es.iespuertolacruz.developers.api;

public class CuentaBancaria extends MetodoPago {

    String iban;
    String dni;

    public CuentaBancaria(String dni, String titular, String numeroCuenta, String iban) {
        super(titular, numeroCuenta);
        this.dni = dni;
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return getDni() + getTitular() + getNumeroCuenta() + getIban();
    }

}
