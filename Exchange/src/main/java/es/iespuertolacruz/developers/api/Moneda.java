package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Moneda {

    String moneda;
    String ticket;
    double cantidad;
    double valor;
    

    /**
     * Constructor de la clase Moneda
     */
    public Moneda(String moneda, String ticket, double cantidad, double valor) {
        this.moneda = moneda;
        this.ticket = ticket;
        this.cantidad = cantidad;
        this.valor = valor;
    }


    /**
     * GETTERS y Setters de la clase Moneda
     */
    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "Moneda [cantidad=" + cantidad + ", moneda=" + moneda + ", ticket=" + ticket + ", valor=" + valor + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Moneda)) {
            return false;
        }
        Moneda moneda = (Moneda) o;
        return Objects.equals(moneda, moneda.moneda) && Objects.equals(ticket, moneda.ticket) && cantidad == moneda.cantidad && valor == moneda.valor;
    }

}
