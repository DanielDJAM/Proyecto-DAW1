package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Tarjeta;
import es.iespuertolacruz.developers.controller.TarjetaController;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.TarjetaException;

public class TarjetaControllerTest {

    TarjetaController tarjetaController;
    Tarjeta tarjeta;
    Tarjeta tarjeta2;

    @BeforeEach
    public void setUp() {

        if (tarjetaController == null) {
            try {
                tarjetaController = new TarjetaController();
            } catch (BbddException e) {
                fail(e.getMessage());
            } catch (FicheroException e) {
                fail(e.getMessage());
            } catch (SQLException e) {
                fail(e.getMessage());
            }
        }

        tarjeta = new Tarjeta("aaaa45","Juan Pedro","23/3/2021",300);
        tarjeta2 = new Tarjeta("BB7843","Pedro","23/3/2026",390);
        try {
            tarjetaController.insertar(tarjeta);
        } catch (TarjetaException e) {
            fail(e.getMessage());
        } catch (BbddException e) {
            fail(e.getMessage());
        }

    }

    @AfterEach
    public void after() {
        try {
            tarjetaController.eliminar(tarjeta);
        } catch (TarjetaException e) {

            fail(e.getMessage());
        } catch (BbddException e) {

            fail(e.getMessage());
        }
    }

    @Test
    public void existeTest() {
        try {
            tarjetaController.validar(tarjeta);
        } catch (TarjetaException e) {
            fail("Se ha producido un error validando la direecion no controlado");
        }
    }

    @Test
    public void buscarPorIdTarjetaTest() {
        Tarjeta Buscado;

        try {

            Buscado = tarjetaController.buscar("aaaa45");
            assertEquals(tarjeta, Buscado, "Las tarjetaes deberian ser iguales");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }



    @Test 
    public void insertarErrorTest() {
        String mensaje = "existe";
        try {
            tarjetaController.insertar(tarjeta);
            fail("se ha insertado");
        } catch (BbddException e) {
            assertTrue(e.getMessage().contains(mensaje));
        } catch (TarjetaException e) {
           
        }
    }

 
    @Test
    public void validarErrorNullTest() {
        try {
            Tarjeta tarjeta4 = null;
            tarjetaController.validar(tarjeta4);
        } catch (TarjetaException e) {
            assertTrue(e.getMessage().contains("nulo"));

        }
    }

    @Test
    public void validarErrorTest() {
        try {
            Tarjeta tarjeta4 = null;
            tarjeta4 = new Tarjeta();
            tarjeta4.setidTarjeta("");
            tarjeta4.setTitular("");
            tarjeta4.setFechaCaducidad("");
            tarjeta4.getCvv();
            tarjetaController.validar(tarjeta4);
        } catch (TarjetaException e) {
            assertTrue(e.getMessage().contains("nulo o vacio"));

        }
    }


   

}
