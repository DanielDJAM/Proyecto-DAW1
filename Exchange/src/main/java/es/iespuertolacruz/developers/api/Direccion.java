package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Direccion {
    String id_direccion;
    String codigoPostal;
    String calle;
    int numero;
    String puerta;
    String provincia;
    String pais;

    public Direccion() {
    }

    /**
     * Constructor de la clase Direccion
     * 
     * @param codigoPostal del miembro
     * @param calle        del domicilio
     * @param numero       de la calle
     * @param puerta       del domicilio
     * @param provincia    del miembro
     * @param pais         del miembro
     */
    public Direccion(String id_direccion, String codigoPostal, String calle, int numero, String puerta,
            String provincia, String pais) {
        this.id_direccion = id_direccion;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.numero = numero;
        this.puerta = puerta;
        this.provincia = provincia;
        this.pais = pais;
    }

    /**
     * GETTERS y SETTERS de la clase Direccion
     */

    public String getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(String id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion"  + id_direccion + "Calle ="
        + calle + ", codigoPostal=" + codigoPostal + ", numero=" + numero + ", pais=" + pais + ", provincia=" + provincia + ", puerta=" + puerta + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Direccion)) {
            return false;
        }
        Direccion direccion = (Direccion) o;
        return Objects.equals(id_direccion, direccion.id_direccion) && Objects.equals(codigoPostal, direccion.codigoPostal) && Objects.equals(calle, direccion.calle) && numero == direccion.numero && Objects.equals(puerta, direccion.puerta) && Objects.equals(provincia, direccion.provincia) && Objects.equals(pais, direccion.pais);
    }


    


}
