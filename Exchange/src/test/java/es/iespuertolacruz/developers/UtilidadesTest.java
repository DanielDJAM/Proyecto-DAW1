package es.iespuertolacruz.developers;

import es.iespuertolacruz.developers.api.Usuario;

public class UtilidadesTest {


    private static final String DNI = "12345678A";
    private static final String UID = "1004";
    private static final int EDAD = 25;
    private static final String APELLIDOS = "algo";
    private static final String NOMBRE = "algo";
    

    protected Usuario crearUsuario(String uid,String dni, String nombre, String apellidos, int edad){
        Usuario usuario = null;
        if (uid != null &&dni != null && nombre != null && apellidos != null && edad != 0 ){
            usuario = new Usuario(uid, nombre, apellidos, edad, dni);
        } else {
            usuario = new Usuario();
            usuario.setUid(UID);
            usuario.setDni(DNI);
            usuario.setNombre(NOMBRE);
            usuario.setApellidos(APELLIDOS);
            usuario.setEdad(EDAD);
            
        }
        return usuario;

    }
    
}
