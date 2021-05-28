package es.iespuertolacruz.developers;

import es.iespuertolacruz.developers.api.DatosPersonales;
import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.api.Miembro;
import es.iespuertolacruz.developers.api.Tarjeta;

public class UtilidadesTest {

    private static final String DNI = "12345678D";
    private static final String UID = "0001";
    private static final int EDAD = 35;
    private static final String APELLIDOS = "Exposito";
    private static final String NOMBRE = "Joatham";;

    protected Direccion crearDireccion(String idDireccion, String codigoPostal, String calle, String puerta,
            String provincia, String pais) {
                Direccion direccion = null;
                if (idDireccion != null && codigoPostal !=null && calle !=null && puerta !=null && provincia !=null && pais !=null) {
                    direccion = new Direccion(idDireccion,codigoPostal,calle,puerta,provincia, pais);
                } else{
                    direccion = new Direccion();
                    direccion.setIdDireccion("1111e");
                    direccion.setCodigoPostal("38400");
                    direccion.setCalle("La laja");
                    direccion.setPuerta("a45");
                    direccion.setProvincia("SC/ Tenerife");
                    direccion.setPais("Espania");
                }
        return direccion;

    }

    protected Miembro crearMiembro(String uid, String dni, DatosPersonales datosPersonales, Direccion direccion,Tarjeta tarjeta) {
        Miembro miembro = null;
        if (uid != null && dni != null) {
            // miembro = new Miembro(uid, nombre, apellidos, edad, dni);
            // MODIFICAR!!!!!!!!!!!
        } else {
            miembro = new Miembro();
            miembro.setUid(UID);
            miembro.setDatosPersonales(datosPersonales);
            miembro.setDireccion(direccion);

        }
        return miembro;

    }

}
