package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Administrador extends Visitante{

   
    DatosPersonales datosPersonales;
    String email;
    String contrasenia;


    /**
     * Constructor por defecto de la clase Administrador
     */
    public Administrador() {
    }

    /**
     * Constructor con todos los parametros de la clase Administrador
     * @param uid del admin
     * @param datosPersonales del admin
     * @param email del admin
     * @param contrasenia del admin
     */
    public Administrador(String uid, DatosPersonales datosPersonales, String email, String contrasenia) {
        super(uid);
        this.datosPersonales = datosPersonales;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    /**
     * Getters y setters de la clase Administrador
     */

    public DatosPersonales getDatosPersonales() {
        return this.datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


    @Override
    public String toString() {
        return "Administrador [contrasenia=" + contrasenia + ", datosPersonales=" + datosPersonales + ", email=" + email
                + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Administrador)) {
            return false;
        }
        Administrador administrador = (Administrador) o;
        return Objects.equals(datosPersonales, administrador.datosPersonales) && Objects.equals(email, administrador.email) && Objects.equals(contrasenia, administrador.contrasenia);
    }

}
