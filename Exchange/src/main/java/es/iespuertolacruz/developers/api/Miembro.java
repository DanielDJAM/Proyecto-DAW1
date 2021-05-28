package es.iespuertolacruz.developers.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Miembro extends Visitante {

    public static final String DELIMITADOR = ",";

    DatosPersonales datosPersonales;
    String email;
    String contrasenia;
    Direccion direccion;
    Tarjeta tarjeta;

    public Miembro() {

    }

    /**
     * Constructor que recibe una cadena de text
     * 
     * @param cadena con la informacion
     */
    public Miembro(String cadena) {
        super();
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.uid = (String) elementos.get(0);
        this.datosPersonales = (DatosPersonales) elementos.get(1);
        this.email = (String) elementos.get(2);
        this.contrasenia = (String) elementos.get(3);
        this.direccion = (Direccion) elementos.get(4);
        this.tarjeta = (Tarjeta) elementos.get(5);
    }

    /**
     * Constructor con todos los parametros de la clase Miembro
     * 
     * @param uid             del miembro
     * @param datosPersonales del miembro
     * @param email del miembro
     * @param contrasenia del miembro
     * @param direccion del miembro
     * @param tarjeta del miembro
    */
    public Miembro(String uid, DatosPersonales datosPersonales, String email, String contrasenia, Direccion direccion, Tarjeta tarjeta) {
        super(uid);
        this.datosPersonales = datosPersonales;
        this.email = email;
        this.contrasenia = contrasenia;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
    }

    /**
     * Getters y Setters de la clase Miembro
     */

    @Override
    public String getUid() {
        return this.uid;
    }

    @Override
    public void setUid(String uid) {
        this.uid = uid;
    }

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

    public Direccion getDireccion() {
        return this.direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Tarjeta getTarjeta() {
        return this.tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "Miembro [contrasenia=" + contrasenia + ", datosPersonales=" + datosPersonales + ", direccion="
                + direccion + ", email=" + email + ", tarjeta=" + tarjeta + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Miembro)) {
            return false;
        }
        Miembro miembro = (Miembro) o;
        return Objects.equals(datosPersonales, miembro.datosPersonales) && Objects.equals(email, miembro.email)
                && Objects.equals(contrasenia, miembro.contrasenia) && Objects.equals(direccion, miembro.direccion)
                && Objects.equals(tarjeta, miembro.tarjeta);
    }

}
