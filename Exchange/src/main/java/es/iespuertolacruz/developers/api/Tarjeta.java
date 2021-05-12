package es.iespuertolacruz.developers.api;

public class Tarjeta extends MetodoPago {

    String fechaCaducidad;
    int cvv;

    /**
     * Constructor de la clase Tarjeta
     * @param titular de la tarjeta
     * @param numeroCuenta de la tarjeta
     * @param fechaCaducidad de la tarjeta
     * @param cvv de la tarjeta
     */
    public Tarjeta(String titular, String numeroCuenta, String fechaCaducidad,int cvv) {
        super(titular, numeroCuenta);
        this.fechaCaducidad = fechaCaducidad;
        this.cvv = cvv;
    }

    /**
     * Getters y Setters de la clase Tarjeta
     */
     
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
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
        return getTitular() + getNumeroCuenta() + getFechaCaducidad() + getCvv();
    }

   
}
