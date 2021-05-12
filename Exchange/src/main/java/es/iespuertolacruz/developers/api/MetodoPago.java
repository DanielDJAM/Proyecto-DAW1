package es.iespuertolacruz.developers.api;

abstract class MetodoPago {

    String titular;
    String numeroCuenta;

    /**
     * Constructor de la clase MetodoPago
     * @param titular tarjeta/cuenta bancaria
     * @param numeroCuenta tarjeta/cuenta bancaria 
     */
    protected MetodoPago(String titular, String numeroCuenta) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
    }

    public abstract String getTitular();

    public abstract void setTitular(String titular);

    public abstract String getNumeroCuenta();

    public abstract void setNumeroCuenta(String numeroCuenta);

}
