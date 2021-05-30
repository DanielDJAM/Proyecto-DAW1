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

    protected DatosPersonales crearDatosPersonales(String dni, String nombre, String apellidos, int edad) {
        DatosPersonales datosPersonales = null;
        if (dni != null && nombre != null && apellidos != null && edad == 0) {
            datosPersonales = new DatosPersonales(dni, nombre, apellidos, edad);
        } else {
            datosPersonales = new DatosPersonales();
            datosPersonales.setDni("11111111A");
            datosPersonales.setNombre("Borja");
            datosPersonales.setApellidos("Devora");
            datosPersonales.setEdad(25);
        }

        return datosPersonales;
    }

    protected Tarjeta crearTarjeta(String idTarjeta, String titular, String fechaCaducidad, int cvv) {
        Tarjeta tarjeta = null;
        if (idTarjeta != null && titular != null && fechaCaducidad != null && cvv == 0) {
            tarjeta = new Tarjeta(idTarjeta, titular, fechaCaducidad, cvv);
        } else {
            tarjeta = new Tarjeta();
            tarjeta.setidTarjeta("1111e-aaaa");
            tarjeta.setTitular("Borja");
            tarjeta.setFechaCaducidad("20/5/2090");
            tarjeta.setCvv(108);
        }

        return tarjeta;
    }

    protected Direccion crearDireccion(String idDireccion, String codigoPostal, String calle, String puerta,
            String provincia, String pais) {
        Direccion direccion = null;
        if (idDireccion != null && codigoPostal != null && calle != null && puerta != null && provincia != null
                && pais != null) {
            direccion = new Direccion(idDireccion, codigoPostal, calle, puerta, provincia, pais);
        } else {
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

    protected Miembro crearMiembro(String uid, String tipoUsuario, DatosPersonales datosPersonales, String email,
            String contrasenia, Direccion direccion, Tarjeta tarjeta) {
        Miembro miembro = null;
        if (uid != null && tipoUsuario != null && datosPersonales != null && email != null && contrasenia != null
                && direccion != null && tarjeta != null) {
            miembro = new Miembro(uid, tipoUsuario, datosPersonales, email, contrasenia, direccion, tarjeta);

        } else {
            miembro = new Miembro();

            direccion = crearDireccion(null, null, null, null, null, null);
            datosPersonales = crearDatosPersonales(null, null, null, 0);
            tarjeta = crearTarjeta(null, null, null, 0);

            miembro.setUid(UID);
            miembro.setTipoUsuario("admin");
            miembro.setDatosPersonales(datosPersonales);
            miembro.setContrasenia("admin");
            miembro.setDireccion(direccion);
            miembro.setTarjeta(tarjeta);

        }
        return miembro;

    }

   
  

}
