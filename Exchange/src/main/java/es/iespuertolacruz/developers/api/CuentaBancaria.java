package es.iespuertolacruz.developers.api;

public class CuentaBancaria extends MetodoPago {

    String iban;

    /**
     * Constructor con parametros
     * @param titular de la cuenta
     * @param numeroCuenta de la cuenta
     * @param iban de la cuenta
     */
    public CuentaBancaria(String titular, String numeroCuenta, String iban) {
        super(titular, numeroCuenta);
        this.iban = iban;
    }

    /**
     * Getters y Setters de la clase CuentaBancaria
     */

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    
    /**
     * Getters y Setters extendidos de la clase MetodoPago
     */

    @Override
    public String getTitular() {
        return titular;
    }

    @Override
    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    

    @Override
    public String toString() {
        return getTitular() + getNumeroCuenta() + getIban();
    }

}
