package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class Usuario  {
    String uid;
    String nombre;
    String apellidos;
    int edad;
    String dni;

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario(){

    }

    /**
     * Constructor con el parametro UID
     * @param uid del usuario.
     */
    public Usuario(String uid){
        this.uid = uid;
    }

    /**
     * Constructor con todos los parametros del usuario.
     * @param uid del usuario
     * @param nombre del usuario
     * @param apellidos del usuario
     * @param edad del usuario
     * @param dni del usuario
     */
    public Usuario(String uid, String nombre, String apellidos, int edad, String dni) {
        this.uid = uid;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
    }

    /**
     * Getters y Setters de la clase Usuario
     */

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(uid, usuario.uid) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos) && edad == usuario.edad && Objects.equals(dni, usuario.dni);
    }
    
}
