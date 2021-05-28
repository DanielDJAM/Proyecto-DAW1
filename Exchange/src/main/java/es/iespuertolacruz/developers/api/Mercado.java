package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Mercado {
   
    String idMoneda;
    String idWallet;
    Double cantidad;

    

    public Mercado() {
    }

    public Mercado(String idMoneda, String idWallet, Double cantidad) {
        this.idMoneda = idMoneda;
        this.idWallet = idWallet;
        this.cantidad = cantidad;
    }

    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(String idWallet) {
        this.idWallet = idWallet;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Mercado [cantidad=" + cantidad + ", idMoneda=" + idMoneda + ", idWallet=" + idWallet + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mercado)) {
            return false;
        }
        Mercado mercado = (Mercado) o;
        return Objects.equals(idMoneda, mercado.idMoneda) && Objects.equals(idWallet, mercado.idWallet) && Objects.equals(cantidad, mercado.cantidad);
    }

   

    
}
