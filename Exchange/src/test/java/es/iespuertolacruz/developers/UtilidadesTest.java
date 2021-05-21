package es.iespuertolacruz.developers;

import es.iespuertolacruz.developers.api.Miembro;

public class UtilidadesTest {


    private static final String DNI = "12345678D";
    private static final String UID = "0001";
    private static final int EDAD = 35;
    private static final String APELLIDOS = "Exposito";
    private static final String NOMBRE = "Joatham";
    

    protected Miembro crearMiembro(String uid,String dni, String nombre, String apellidos, int edad){
        Miembro miembro = null;
        if (uid != null &&dni != null && nombre != null && apellidos != null && edad != 0 ){
          //  miembro = new Miembro(uid, nombre, apellidos, edad, dni); MODIFICAR!!!!!!!!!!!
        } else {
            miembro = new Miembro();
            miembro.setUid(UID);
            miembro.setDni(DNI);
            miembro.setNombre(NOMBRE);
            miembro.setApellidos(APELLIDOS);
            miembro.setEdad(EDAD);
            
        }
        return miembro;

    }
    
}
