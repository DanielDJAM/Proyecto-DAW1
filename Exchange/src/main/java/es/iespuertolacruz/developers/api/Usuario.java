package es.iespuertolacruz.developers.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Usuario  {

    private static final String DELIMITADOR = ",";
    String uid;
    String nombre;
    String apellidos;
    String contrasenia;
    int edad;
    String dni;
    Direccion direccion;
    String email;

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario(){

    }

    /**
    * Constructor que recibe una cadena de text
    * @param cadena con la informacion
    */
    public Usuario(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.uid = (String) elementos.get(0);
        this.nombre = (String) elementos.get(1);
        this.apellidos = (String) elementos.get(2);
        this.edad = Integer.parseInt((String) elementos.get(3));
        this.dni = (String) elementos.get(4);
    }

    /**
     * Constructor con todos los parametros del usuario.
     * @param uid del usuario
     * @param nombre del usuario
     * @param apellidos del usuario
     * @param edad del usuario
     * @param dni del usuario
     */
    protected Usuario(String uid, String nombre, String apellidos, int edad, String dni, Direccion direccion, String email, String contrasenia) {
        this.uid = uid;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.direccion = direccion;
        this.email = email;
        this.contrasenia = contrasenia;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getUid() + DELIMITADOR + getNombre() + DELIMITADOR + getApellidos() + DELIMITADOR + getEdad() + DELIMITADOR + getDni();
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
