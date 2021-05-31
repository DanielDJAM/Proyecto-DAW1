package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    Direccion direccion2;
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
            tarjeta = crearTarjeta();
            tarjetaController.insertar(tarjeta);
            direccion = crearDireccion();
            direccionController.insertar(direccion);
            datosPersonales = crearDatosPersonales();
            datosPersonalesController.insertar(datosPersonales);
            miembro = crearMiembro();

            miembroController.insertar(miembro);

        } catch (MiembroException e) {
            fail(e.getMessage());
        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (DatosPersonalesException e) {
            fail("datospersonales");
        } catch (TarjetaException e) {
            fail(e.getMessage());
        } catch (DireccionException e) {
            fail("direccion");
        }

    }

    @AfterEach
    public void after() {

        try {
            direccionController.eliminar(direccion);
            direccionController.eliminar(direccion2);
            tarjetaController.eliminar(tarjeta2);
            tarjetaController.eliminar(tarjeta);
            datosPersonalesController.eliminar(datosPersonales);
            datosPersonalesController.eliminar(datosPersonales2);
            miembroController.eliminar(miembro);
            miembroController.eliminar(miembro2);

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
    public void modificarMiembroTest() {
        try {
            tarjeta2 = crearTarjeta2();
            tarjetaController.insertar(tarjeta2);
            direccion2 = crearDireccion2();
            direccionController.insertar(direccion2);
            datosPersonales2 = crearDatosPersonales2();
            datosPersonalesController.insertar(datosPersonales2);
            miembro2 = crearMiembro2();
            miembroController.insertar(miembro2);
            miembro2.setTipoUsuario("admin");
            miembroController.modificar(miembro2);

        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (MiembroException e) {
            fail(e.getMessage());
        } catch (TarjetaException e) {
            fail(e.getMessage());
        } catch (DireccionException e) {
            fail(e.getMessage());
        } catch (DatosPersonalesException e) {
            fail(e.getMessage());
        }
    }

  


    

    private Direccion crearDireccion() {
        return new Direccion("1111e", "38400", "La laja", "a45", "SC/ Tenerife", "Espania");
    }

    private Direccion crearDireccion2() {
        return new Direccion("1111h", "38400", "Tamaimo", "a556", "SC/ Tenerife", "Espania");
    }

    private DatosPersonales crearDatosPersonales() {
        return new DatosPersonales("11111111B", "Borja", "Devora", 25);
    }

    private DatosPersonales crearDatosPersonales2() {
        return new DatosPersonales("11111111C", "Pepe", "Devora", 27);
    }

    private Tarjeta crearTarjeta() {
        return new Tarjeta("1111e-aaaa", "Borja", "20/5/2090", 108);
    }

    private Tarjeta crearTarjeta2() {
        return new Tarjeta("1111e-bbb", "Pepe", "20/5/2090", 107);
    }

    private Miembro crearMiembro() {
        return new Miembro("10000", "admin", crearDatosPersonales(), "es@email.com", "1234", crearDireccion(),
                crearTarjeta());
    }

    private Miembro crearMiembro2() {
        return new Miembro("10003", "miembro", crearDatosPersonales2(), "er@email.com", "1234", crearDireccion2(),
                crearTarjeta2());
    }

}
