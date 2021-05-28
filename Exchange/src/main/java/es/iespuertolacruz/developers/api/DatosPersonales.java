package es.iespuertolacruz.developers.api;

import java.util.Objects;

public class DatosPersonales {

    String dni;
    String nombre;
    String apellidos;
    int edad;
  

    
    public DatosPersonales() {
    }

    /**
     * Constructor de la clase DatosPersonales
     * @param nombre de miembro
     * @param apellidos de miembro
     * @param edad de miembro
     * @param dni de miembro
     */

    public DatosPersonales(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        
    }

    /**
     * Getters y Setters de la clase DatosPersonales
     */

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    @Override
    public String toString() {
        return "DatosPersonales [apellidos=" + apellidos + ", dni=" + dni + ", edad=" + edad + ", nombre=" + nombre
                + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DatosPersonales)) {
            return false;
        }
        DatosPersonales datosPersonales = (DatosPersonales) o;
        return Objects.equals(nombre, datosPersonales.nombre) && Objects.equals(apellidos, datosPersonales.apellidos) && edad == datosPersonales.edad && Objects.equals(dni, datosPersonales.dni);
    }

   
}
