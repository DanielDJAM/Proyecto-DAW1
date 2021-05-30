package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Driver;
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

public class MiembroControllerTest extends UtilidadesTest {

    MiembroController miembroController;
    MiembroModelo miembroModelo;
    DireccionController direccionController;
    TarjetaController tarjetaController;
    DatosPersonalesController datosPersonalesController;
    MonedaController monedaController;

    Miembro miembro;
    DatosPersonales datosPersonales;
    Direccion direccion;
    Tarjeta tarjeta;

    @BeforeEach
    public void setUp() throws BbddException, FicheroException, SQLException {
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
    public void insertarTest() {
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
            fail("tarjeta");
        } catch (DireccionException e) {
            fail("direccion");
        }

    }


    @Test
    public void insertarMonedaTest() {
        moneda = crearMoneda();
       monedaController.insertar(moneda);

    }




    private Object crearMoneda() {
        return null;
    }

    private Direccion crearDireccion() {
        return new Direccion("1111e", "38400", "La laja", "a45", "SC/ Tenerife", "Espania");
    }

    private DatosPersonales crearDatosPersonales() {
        return new DatosPersonales("11111111B", "Borja", "Devora", 25);

    }

    private Tarjeta crearTarjeta() {
        return new Tarjeta("1111e-aaaa", "Borja", "20/5/2090", 108);
    }

    private Miembro crearMiembro() {
        return new Miembro("10000", "admin", crearDatosPersonales(), "es@email.com", "1234", crearDireccion(),
                crearTarjeta());
    }

}
