package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Direccion {
    
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
     * @param codigoPostal del usuario
     * @param calle del domicilio
     * @param numero de la calle
     * @param puerta del domicilio
     * @param provincia del usuario
     * @param pais del usuario
     */
    public Direccion(String codigoPostal, String calle, int numero, String puerta, String provincia, String pais) {
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
    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPuerta() {
        return this.puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    

    @Override
    public String toString() {
        return "Direccion [calle=" + calle + ", codigoPostal=" + codigoPostal + ", numero=" + numero + ", pais=" + pais
                + ", provincia=" + provincia + ", puerta=" + puerta + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Direccion)) {
            return false;
        }
        Direccion direccion = (Direccion) o;
        return Objects.equals(codigoPostal, direccion.codigoPostal) && Objects.equals(calle, direccion.calle) && numero == direccion.numero && Objects.equals(puerta, direccion.puerta) && Objects.equals(provincia, direccion.provincia) && Objects.equals(pais, direccion.pais);
    }

}
