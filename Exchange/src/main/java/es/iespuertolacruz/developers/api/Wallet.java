package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Wallet {

    String idWallet;
    String uid;

    /**
     * Constructor de la clase Wallet
     * @param idWallet de la moneda
     * @param uid del propietario de la cartera.
     */

    public Wallet(String idWallet, String uid) {
        this.idWallet = idWallet;
        this.uid = uid;
    }

    /**
     * GETTERS y SETTERS de la clase Wallet.
     */

    public String getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(String idWallet) {
        this.idWallet = idWallet;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    


    @Override
    public String toString() {
        return "Wallet [idWallet=" + idWallet + ", uid=" + uid + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Wallet)) {
            return false;
        }
        Wallet wallet = (Wallet) o;
        return Objects.equals(idWallet, wallet.idWallet) && Objects.equals(uid, wallet.uid);
    }
}
