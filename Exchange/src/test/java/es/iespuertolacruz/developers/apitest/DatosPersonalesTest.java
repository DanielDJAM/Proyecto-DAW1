package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.DatosPersonales;

public class DatosPersonalesTest {

    DatosPersonales datosPersonales;
    DatosPersonales datosPersonales2;

    @BeforeEach
    public void setUp(){
        datosPersonales = new DatosPersonales("12345678A", "daniel", "apellidos", 56);
    }

    @Test
    public void validarTest(){
        datosPersonales = new DatosPersonales();
        datosPersonales.setDni("98787978U");
        datosPersonales.setNombre("Yisus");
        datosPersonales.setApellidos("ramos");
        datosPersonales.setEdad(98);

        assertEquals(datosPersonales.getDni(), "98787978U", "El campo no coincide");
        assertEquals(datosPersonales.getNombre(), "Yisus", "El campo no coincide");
        assertEquals(datosPersonales.getApellidos(), "ramos", "El campo no coincide");
        assertEquals(datosPersonales.getEdad(), 98, "El campo no coincide");
    }

    @Test
    public void listarTest(){
        assertTrue(datosPersonales.toString().contains("12345678A"), "No ha listado correctamente");
    }

    @Test
    public void equalTest(){
        datosPersonales2 = datosPersonales;
        assertTrue(datosPersonales.equals(datosPersonales2), "Los objetos no deben ser iguales");
    }

    @Test
    public void equalErrorTest(){
        datosPersonales2 = datosPersonales;
        datosPersonales.setDni("98787978U");
        datosPersonales.setNombre("Yisus");
        datosPersonales.setApellidos("ramos");
        datosPersonales.setEdad(98);

        assertTrue(datosPersonales.equals(datosPersonales2), "Los objetos no deben ser iguales");
    }
    
}
