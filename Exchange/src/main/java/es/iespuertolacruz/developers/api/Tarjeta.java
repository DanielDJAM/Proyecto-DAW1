package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Tarjeta  {

    String idTarjeta;
    String titular;
    String fechaCaducidad;
    int cvv;


    
    public Tarjeta() {
    }

    /**
     * Constructor de la clase Tarjeta
     * @param titular de la tarjeta
     * @param numeroCuenta de la tarjeta
     * @param fechaCaducidad de la tarjeta
     * @param cvv de la tarjeta
     */

    public Tarjeta(String idTarjeta, String titular, String fechaCaducidad, int cvv) {
        this.idTarjeta = idTarjeta;
        this.titular = titular;
        this.fechaCaducidad = fechaCaducidad;
        this.cvv = cvv;
    }

    public String getidTarjeta() {
        return idTarjeta;
    }

    public void setidTarjeta(String idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

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



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tarjeta)) {
            return false;
        }
        Tarjeta tarjeta = (Tarjeta) o;
        return Objects.equals(idTarjeta, tarjeta.idTarjeta) && Objects.equals(titular, tarjeta.titular) && Objects.equals(fechaCaducidad, tarjeta.fechaCaducidad) && cvv == tarjeta.cvv;
    }

    @Override
    public String toString() {
        return "Tarjeta [cvv=" + cvv + ", fechaCaducidad=" + fechaCaducidad + ", idTarjeta=" + idTarjeta
                + ", titular=" + titular + "]";
    }


   
}
