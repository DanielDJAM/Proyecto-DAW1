package es.iespuertolacruz.developers.apitest;

import org.junit.jupiter.api.BeforeEach;

import es.iespuertolacruz.developers.api.DatosPersonales;

public class DatosPersonalesTest {

    DatosPersonales datosPersonales;
    DatosPersonales datosPersonales2;

    @BeforeEach
    public void setUp(){
        datosPersonales = new DatosPersonales("daniel", "apellidos", 56, "12345678A");
    }

    @Test
    public void validarTest(){
        datosPersonales = new DatosPersonales();
        datosPersonales.setTicket("BBB");
        datosPersonales.setNombreDatosPersonales("Bebeboin");
        datosPersonales.setValor(546);

        assertEquals(datosPersonales.getTicket(), "BBB", "El ticket de la datosPersonales no coincide");
        assertEquals(datosPersonales.getNombreDatosPersonales(), "Bebeboin", "El nombre de la datosPersonales no coincide");
        assertEquals(datosPersonales.getValor(), 546, "el precio no coincide");
    }

    @Test
    public void listarTest(){
        assertTrue(datosPersonales.toString().contains("AAA"), "No ha listado correctamente");
    }

    @Test
    public void equalTest(){
        datosPersonales2 = datosPersonales;
        assertTrue(datosPersonales.equals(datosPersonales2), "Los objetos no deben ser iguales");
    }

    @Test
    public void equalErrorTest(){
        datosPersonales2 = datosPersonales;
        datosPersonales.setTicket("BBB");
        datosPersonales.setNombreDatosPersonales("Bebeboin");
        datosPersonales.setValor(546);

        assertTrue(datosPersonales.equals(datosPersonales2), "Los objetos no deben ser iguales");
    }
    
}
