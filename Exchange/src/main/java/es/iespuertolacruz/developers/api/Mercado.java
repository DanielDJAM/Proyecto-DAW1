package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Mercado {
   
    Moneda moneda;
    Wallet wallet;
    Double cantidad;

    
    /**
     * Constructor vacio
     */
    public Mercado() {
    }

    /**
     * Constructor con todos los parametros de Mercado
     * @param moneda
     * @param wallet
     * @param cantidad
     */
    public Mercado(Moneda moneda, Wallet wallet, Double cantidad) {
        this.moneda = moneda;
        this.wallet = wallet;
        this.cantidad = cantidad;
    }
    
    /**
     * Getters y Setters
     */

    public Moneda getMoneda() {
        return this.moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Double getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Mercado [cantidad=" + cantidad + ", moneda=" + moneda + ", wallet=" + wallet + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mercado)) {
            return false;
        }
        Mercado mercado = (Mercado) o;
        return Objects.equals(moneda, mercado.moneda) && Objects.equals(wallet, mercado.wallet) && Objects.equals(cantidad, mercado.cantidad);
    }

}
