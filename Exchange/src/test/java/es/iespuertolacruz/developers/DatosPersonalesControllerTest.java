package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.DatosPersonales;
import es.iespuertolacruz.developers.controller.DatosPersonalesController;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.DatosPersonalesException;

public class DatosPersonalesControllerTest {

    DatosPersonalesController datosPersonalesController;
    DatosPersonales datosPersonales;
    DatosPersonales datosPersonales2;

    @BeforeEach
    public void setUp() {

        if (datosPersonalesController == null) {
            try {
                datosPersonalesController = new DatosPersonalesController();
            } catch (BbddException e) {
                fail(e.getMessage());
            } catch (FicheroException e) {
                fail(e.getMessage());
            } catch (SQLException e) {
                fail(e.getMessage());
            }
        }

        datosPersonales = new DatosPersonales("aaaa45","Juan Pedro","Benitez",30);
        datosPersonales2 = new DatosPersonales("BB7843","Pedro","Garcia",390);
        try {
            datosPersonalesController.insertar(datosPersonales);
        } catch (DatosPersonalesException e) {
            fail(e.getMessage());
        } catch (BbddException e) {
            fail(e.getMessage());
        }

    }

    @AfterEach
    public void after() {
        try {
            datosPersonalesController.eliminar(datosPersonales);
        } catch (DatosPersonalesException e) {

            fail(e.getMessage());
        } catch (BbddException e) {

            fail(e.getMessage());
        }
    }

    @Test
    public void existeTest() {
        try {
            datosPersonalesController.validar(datosPersonales);
        } catch (DatosPersonalesException e) {
            fail("Se ha producido un error validando la direecion no controlado");
        }
    }

    @Test
    public void modificarTest() {
        DatosPersonales datosModificar;
        datosPersonales.setNombre("Berna");
        try {
            datosPersonalesController.modificar(datosPersonales);
            datosModificar = datosPersonalesController.buscar("aaaa45");
            assertEquals(datosPersonales, datosModificar, "Los datos deberian ser iguales");
        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (DatosPersonalesException e) {
            fail();
        }
    }

    @Test
    public void buscarPorIdDatosPersonalesTest() {
        DatosPersonales Buscado;

        try {

            Buscado = datosPersonalesController.buscar("aaaa45");
            assertEquals(datosPersonales, Buscado, "Las datosPersonaleses deberian ser iguales");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }



    @Test 
    public void insertarErrorTest() {
        String mensaje = "existe";
        try {
            datosPersonalesController.insertar(datosPersonales);
            fail("se ha insertado");
        } catch (BbddException e) {
            assertTrue(e.getMessage().contains(mensaje));
        } catch (DatosPersonalesException e) {
           
        }
    }

 
    @Test
    public void validarErrorNullTest() {
        try {
            DatosPersonales datosPersonales4 = null;
            datosPersonalesController.validar(datosPersonales4);
        } catch (DatosPersonalesException e) {
            assertTrue(e.getMessage().contains("nulo"));

        }
    }

    @Test
    public void validarErrorTest() {
        try {
            
            DatosPersonales datosPersonales4 = null;
            datosPersonales4 = new DatosPersonales();
            datosPersonales4.setDni("");
            datosPersonales4.setNombre("");
            datosPersonales4.setApellidos("");
            datosPersonales4.getEdad();
            datosPersonalesController.validar(datosPersonales4);
        } catch (DatosPersonalesException e) {
            assertTrue(e.getMessage().contains("nulo o vacio"));

        }
    }
}
