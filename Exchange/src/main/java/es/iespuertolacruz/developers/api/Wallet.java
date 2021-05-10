package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Wallet {

    String ticket;
    String nombreMoneda;
    double cantidad;
    double total;
    int uid;

    public Wallet(String ticket, String nombreMoneda, double cantidad, double total, int uid) {
        this.ticket = ticket;
        this.nombreMoneda = nombreMoneda;
        this.cantidad = cantidad;
        this.total = total;
        this.uid = uid;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Wallet [cantidad=" + cantidad + ", nombreMoneda=" + nombreMoneda + 
        ", ticket=" + ticket + ", total="+ total + ", uid=" + uid + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Wallet)) {
            return false;
        }
        Wallet wallet = (Wallet) o;
        return Objects.equals(ticket, wallet.ticket) && Objects.equals(nombreMoneda, wallet.nombreMoneda) && cantidad == wallet.cantidad && total == wallet.total && uid == wallet.uid;
    }

}
