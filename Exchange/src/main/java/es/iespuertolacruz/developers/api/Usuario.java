package es.iespuertolacruz.developers.api;


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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (apellidos == null) {
            if (other.apellidos != null)
                return false;
        } else if (!apellidos.equals(other.apellidos))
            return false;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        if (edad != other.edad)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (uid == null) {
            if (other.uid != null)
                return false;
        } else if (!uid.equals(other.uid))
            return false;
        return true;
    }
    
}
