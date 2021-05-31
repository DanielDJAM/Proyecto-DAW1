package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Moneda;
import es.iespuertolacruz.developers.controller.MonedaController;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.MonedaException;

public class MonedaControllerTest {

    MonedaController monedaController;
    Moneda moneda;
    Moneda moneda2;

    @BeforeEach
    public void setUp() {

        try {

            if (monedaController == null) {
                monedaController = new MonedaController();
            }

            if (moneda == null) {
                moneda = new Moneda();
            }

            if (moneda2 == null) {
                moneda2 = new Moneda();
            }

            moneda = crearMoneda();
            monedaController.insertar(moneda);
        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (FicheroException e) {
            fail(e.getMessage());
        } catch (SQLException e) {
            fail(e.getMessage());
        } catch (MonedaException e) {
            fail(e.getMessage());
        }
    }

    @AfterEach
    public void after() {

        try {

            monedaController.eliminar(moneda);

        } catch (MonedaException e) {
            fail(e.getMessage());
        } catch (BbddException e) {
            
        }

    }

    @Test
    public void modificarMonedaTest() {
        moneda2 = crearMoneda2();
        try {
            monedaController.insertar(moneda2);
            moneda2.setValor(230);
            monedaController.modificar(moneda2);
            monedaController.eliminar(moneda2);
        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (MonedaException e) {
            fail(e.getMessage());
        }
    }


    @Test
    public void modificarCuentaTest() {
        try {
            Moneda monedaEncontrada;
            try {
                monedaEncontrada = monedaController.buscar(moneda.getTicket());
                assertNotNull(monedaEncontrada, "No se debe de obtener un elemento nulo");
                monedaEncontrada.setValor(1000);
                monedaController.modificar(monedaEncontrada);
                Moneda monedaActualziada = monedaController.buscar(monedaEncontrada.getTicket());
                assertEquals(monedaActualziada, monedaEncontrada, "No se ha encontrado lo esperado");
            } catch (MonedaException e) {
                fail("Error a la hora de modificar en censo de un habitante");
            }
        } catch (BbddException e) {
            fail("Se ha producido un error al consultar la tabla censo" + e.getMessage());
        }
    }

    private Moneda crearMoneda() {
        return new Moneda("PRTD", "PTD", 12);
    }

    private Moneda crearMoneda2() {
    return new Moneda("PRUEB", "PRB", 1200);
    }

}
