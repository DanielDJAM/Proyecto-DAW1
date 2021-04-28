package es.iespuertolacruz.developers.api;

public class Usuario  {
    String uid;
    String nombre;
    String apellidos;
    int edad;
    String dni;

    public Usuario(String uid){
        this.uid = uid;
    }

    public Usuario(String uid, String nombre, String apellidos, int edad, String dni) {
        this.uid = uid;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
    }

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

    




    
}
