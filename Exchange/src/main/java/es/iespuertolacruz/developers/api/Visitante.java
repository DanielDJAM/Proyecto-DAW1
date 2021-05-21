package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Visitante {

    String uid;

    /**
     * Constructor de la clase Visitante
     * @param uid del visitante
     */

    public Visitante() {
    }
    
    public Visitante(String uid) {
        this.uid = uid;
    }

    /**
     * Getters y Setters de la clase Visitante
     * @return
     */
    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    @Override
    public String toString() {
        return "Visitante [uid=" + uid + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Visitante)) {
            return false;
        }
        Visitante visitante = (Visitante) o;
        return Objects.equals(uid, visitante.uid);
    }
    
}

