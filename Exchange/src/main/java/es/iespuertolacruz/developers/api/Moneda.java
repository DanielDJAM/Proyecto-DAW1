package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Moneda {

    String ticket;
    String nombreMoneda;
    double valor;
    


    public Moneda() {
    }

    /**
     * Constructor de la clase Moneda
     */
    public Moneda(String ticket, String nombreMoneda, double valor) {
        this.ticket = ticket;
        this.nombreMoneda = nombreMoneda;
        this.valor = valor;
    }


    /**
     * GETTERS y Setters de la clase Moneda
     */
    public String getNombreMoneda() {
        return nombreMoneda;
    }


    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }


    public String getTicket() {
        return ticket;
    }


    public void setTicket(String ticket) {
        this.ticket = ticket;
    }


    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Moneda"  + ", moneda=" + nombreMoneda + ", ticket=" + ticket + ", valor=" + valor + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Moneda)) {
            return false;
        }
        Moneda moneda = (Moneda) o;
        return Objects.equals(moneda, moneda.nombreMoneda) && Objects.equals(ticket, moneda.ticket) && valor == moneda.valor;
    }

}
