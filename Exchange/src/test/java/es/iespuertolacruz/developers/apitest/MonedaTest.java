package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Moneda;

public class MonedaTest {

    Moneda moneda;
    Moneda moneda2;

    @BeforeEach
    public void setUp(){
        moneda = new Moneda("AAA", "pilas", 1.5);
    }

    @Test
    public void validarTest(){
        moneda = new Moneda();
        moneda.setTicket("BBB");
        moneda.setNombreMoneda("Bebeboin");
        moneda.setValor(546);

        assertEquals(moneda.getTicket(), "BBB", "El ticket de la moneda no coincide");
        assertEquals(moneda.getNombreMoneda(), "Bebeboin", "El nombre de la moneda no coincide");
        assertEquals(moneda.getValor(), 546, "el precio no coincide");
    }

    @Test
    public void listarTest(){
        assertTrue(moneda.toString().contains("AAA"), "No ha listado correctamente");
    }

    @Test
    public void equalTest(){
        moneda2 = moneda;
        assertTrue(moneda.equals(moneda2), "Los objetos no deben ser iguales");
    }

    @Test
    public void equalErrorTest(){
        moneda2 = moneda;
        moneda.setTicket("BBB");
        moneda.setNombreMoneda("Bebeboin");
        moneda.setValor(546);

        assertTrue(moneda.equals(moneda2), "Los objetos no deben ser iguales");
    }
    
}
