package es.iespuertolacruz.developers.api;

public class MetodoPago {

    String titular;
    String numeroCuenta;

    /**
     * Constructor de la clase MetodoPago
     * @param titular 
     * @param numeroCuenta
     */
    public MetodoPago(String titular, String numeroCuenta) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

}
