package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Direccion {
    
    String idDireccion;
    String codigoPostal;
    String calle;
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
     * @param puerta       del domicilio
     * @param provincia    del miembro
     * @param pais         del miembro
     */
    public Direccion(String idDireccion, String codigoPostal, String calle, String puerta,String provincia, String pais) {
        this.idDireccion = idDireccion;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.puerta = puerta;
        this.provincia = provincia;
        this.pais = pais;
    }

    /**
     * GETTERS y SETTERS de la clase Direccion
     */

    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
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
        return "Direccion"  + idDireccion + "Calle ="
        + calle + ", codigoPostal=" + codigoPostal +  ", pais=" + pais + ", provincia=" + provincia + ", puerta=" + puerta + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Direccion)) {
            return false;
        }
        Direccion direccion = (Direccion) o;
        return Objects.equals(idDireccion, direccion.idDireccion) && Objects.equals(codigoPostal, direccion.codigoPostal) && Objects.equals(calle, direccion.calle) && Objects.equals(puerta, direccion.puerta) && Objects.equals(provincia, direccion.provincia) && Objects.equals(pais, direccion.pais);
    }


    


}
