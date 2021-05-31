package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.controller.DireccionController;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.DireccionException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class DireccionControllerTest {

    DireccionController direccionController;
    Direccion direccion;
    Direccion direccion2;

    @BeforeEach
    public void setUp() {

        if (direccionController == null) {
            try {
                direccionController = new DireccionController();
            } catch (BbddException e) {
                fail(e.getMessage());
            } catch (FicheroException e) {
                fail(e.getMessage());
            } catch (SQLException e) {
                fail(e.getMessage());
            }
        }

        direccion = new Direccion("222e", "38400", "La Toja", "a454", "SC/ Tenerife", "Espania");
        direccion2 = new Direccion("4444r","4454","direccion","dds","algo","algo");
        try {
            direccionController.insertar(direccion);
        } catch (DireccionException e) {
            fail(e.getMessage());
        } catch (BbddException e) {
            fail(e.getMessage());
        }

    }

    @AfterEach
    public void after() {
        try {
            direccionController.eliminar(direccion);
        } catch (DireccionException e) {

            fail(e.getMessage());
        } catch (BbddException e) {

            fail(e.getMessage());
        }
    }

    @Test
    public void existeTest() {
        try {
            direccionController.validar(direccion);
        } catch (DireccionException e) {
            fail("Se ha producido un error validando la direecion no controlado");
        }
    }

    @Test
    public void buscarPorIdDireccionTest() {
        Direccion Buscado;

        try {

            Buscado = direccionController.buscar("222e");
            assertEquals(direccion, Buscado, "Las direcciones deberian ser iguales");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


    @Test
    public void modificarTest() {
        Direccion direccionModificar;
        direccion.setCalle("Martina 2");;
        try {
            direccionController.modificar(direccion);
            direccionModificar = direccionController.buscar("222e");
            assertEquals(direccion, direccionModificar, "Los productos deberian ser iguales");
        } catch (BbddException e) {
            fail(e.getMessage());
        } catch (DireccionException e) {
            fail();
        }
    }

    @Test 
    public void insertarErrorTest() {
        String mensaje = "existe";
        try {
            direccionController.insertar(direccion);
            fail("se ha insertado");
        } catch (BbddException e) {
            assertTrue(e.getMessage().contains(mensaje));
        } catch (DireccionException e) {
           
        }
    }

 
    @Test
    public void validarErrorNullTest() {
        try {
            Direccion direccion4 = null;
            direccionController.validar(direccion4);
        } catch (DireccionException e) {
            assertTrue(e.getMessage().contains("nula"));

        }
    }

    @Test
    public void validarErrorTest() {
        try {
            Direccion direccion4 = null;
            direccion4 = new Direccion();
            direccion4.setIdDireccion("");
            direccion4.setCodigoPostal("");
            direccion4.setCalle("");
            direccion4.getPuerta();
            direccion4.getProvincia();
            direccion4.getPais();
            direccionController.validar(direccion4);
        } catch (DireccionException e) {
            assertTrue(e.getMessage().contains("nulo o vacio"));

        }
    }


   

}
