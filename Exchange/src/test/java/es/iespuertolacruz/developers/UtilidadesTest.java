package es.iespuertolacruz.developers;

import es.iespuertolacruz.developers.api.Usuario;

public class UtilidadesTest {


    private static final String DNI = "12345678A";
    private static final int EDAD = 25;
    private static final String APELLIDOS = "exposito";
    private static final String NOMBRE = "daniel";
    private static final String UID = "1000";

    protected Usuario crearUsuario(String uid, String nombre, String apellidos, int edad, String dni){
        Usuario usuario = null;
        if (uid != null && nombre != null && apellidos != null && edad != 0 &&dni != null){
            usuario = new Usuario(uid, nombre, apellidos, edad, dni);
        } else {
            usuario = new Usuario();
            usuario.setUid(UID);
            usuario.setNombre(NOMBRE);
            usuario.setApellidos(APELLIDOS);
            usuario.setEdad(EDAD);
            usuario.setDni(DNI);
        }
        return usuario;

    }
    
}
