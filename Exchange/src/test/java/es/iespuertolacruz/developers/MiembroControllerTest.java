package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


import java.sql.SQLException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.DatosPersonales;
import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.api.Miembro;

import es.iespuertolacruz.developers.api.Tarjeta;
import es.iespuertolacruz.developers.controller.DatosPersonalesController;
import es.iespuertolacruz.developers.controller.DireccionController;
import es.iespuertolacruz.developers.controller.MiembroController;
import es.iespuertolacruz.developers.controller.MonedaController;
import es.iespuertolacruz.developers.controller.TarjetaController;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.DatosPersonalesException;
import es.iespuertolacruz.developers.excepcion.DireccionException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.MiembroException;
import es.iespuertolacruz.developers.excepcion.TarjetaException;

import es.iespuertolacruz.developers.modelo.MiembroModelo;

public class MiembroControllerTest {

    MiembroController miembroController;
    MiembroModelo miembroModelo;
    DireccionController direccionController;
    TarjetaController tarjetaController;
    DatosPersonalesController datosPersonalesController;
    MonedaController monedaController;

    Miembro miembro;
    Miembro miembro2;
    DatosPersonales datosPersonales;
    DatosPersonales datosPersonales2;
    Direccion direccion;
    Tarjeta tarjeta;
    Tarjeta tarjeta2;

    @BeforeEach
    public void setUp() {

        try {
            if (datosPersonalesController == null) {
                datosPersonalesController = new DatosPersonalesController();
            }
            if (direccionController == null) {
                direccionController = new DireccionController();
            }
            if (tarjetaController == null) {
                tarjetaController = new TarjetaController();
            }
            if (miembroController == null) {
                miembroController = new MiembroController();
            }
            if (monedaController == null) {
                monedaController = new MonedaController();
            }

        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (FicheroException e) {
            fail(e.getMessage());
        } catch (SQLException e) {
            fail(e.getMessage());
        }

        try {
           tarjeta =  new Tarjeta("1111e-aaaa", "Borja", "20/5/2090", 108);
            
           direccion =  new Direccion ("1111e", "38400", "La laja", "a45", "SC/ Tenerife", "Espania");
            
           datosPersonales = new DatosPersonales("11111111C", "Pepe", "Devora", 27);
           
            miembro = new Miembro("10000", "admin", datosPersonales, "es@email.com", "1234", direccion,
            tarjeta);

            tarjetaController.insertar(tarjeta);
            direccionController.insertar(direccion);
            datosPersonalesController.insertar(datosPersonales);
            miembroController.insertar(miembro);
            


        } catch (MiembroException e) {
            fail(e.getMessage());
        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (TarjetaException e) {
            fail(e.getMessage());
        } catch (DireccionException e) {
            fail(e.getMessage());
        } catch (DatosPersonalesException e) {
            fail(e.getMessage());
        }

    }

    @AfterEach
    public void after() {

        try {
            direccionController.eliminar(direccion);
            tarjetaController.eliminar(tarjeta);
            datosPersonalesController.eliminar(datosPersonales);
            miembroController.eliminar(miembro);
            

        } catch (DireccionException e) {
            fail(e.getMessage());
        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (TarjetaException e) {
            fail(e.getMessage());
        } catch (DatosPersonalesException e) {
            fail(e.getMessage());
        } catch (MiembroException e) {
            fail(e.getMessage());

        }

    }

    @Test 
    public void insertarErrorTest() {
        String mensaje = "existe";
        try {
            miembroController.insertar(miembro);
            fail("se ha insertado");
        } catch (BbddException e) {
            assertTrue(e.getMessage().contains(mensaje));
        } catch (MiembroException e) {
           
        }
    }


   

    @Test
    public void buscarPorIdTest() {
        Miembro Buscado;

        try {
            
            Buscado = miembroController.buscarUid("10000");
            assertEquals(miembro, Buscado, "Los usuario deberian ser iguales");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void modificarTest() {
        Miembro miembroModificar;
        miembro.setEmail("ee@gmail.com");
        try {
            miembroController.modificar(miembro);
            miembroModificar = miembroController.buscarUid("10000");
            assertEquals(miembro, miembroModificar, "Los miembros deberian ser iguales");
        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (MiembroException e) {
            fail();
        }
    }


    @Test
    public void validarErrorNullTest() {
        try {
            Miembro miembro2 = null;
            miembroController.validar(miembro2);
        } catch (MiembroException e) {
            assertTrue(e.getMessage().contains("nulo"));

        }
    }

    @Test
    public void validarErrorTest() {
        try {
            Miembro miembro2 = null;
            miembro2 = new Miembro();
            miembro2.setUid("");
            miembro2.setTipoUsuario("");
            miembro2.setContrasenia("");
            miembro2.setDireccion(null);
            miembro2.setTarjeta(null);
            miembroController.validar(miembro2);
        } catch (MiembroException e) {
            assertTrue(e.getMessage().contains("nulo o vacio"));

        }
    }

    @Test
    public void mostrarContenidoDBTest() {
        String contenido;
        try {
            contenido = miembroController.obtenerListado().toString();
            assertTrue(contenido.contains("1001"));
        } catch (BbddException e) {
            fail("Error al visualizar el contenido de la db");
        }
    }

   


}
