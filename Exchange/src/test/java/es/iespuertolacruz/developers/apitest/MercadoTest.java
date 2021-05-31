package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Mercado;
/** 
public class MercadoTest {

    Mercado mercado;
    Mercado mercado2;

    @BeforeEach
    public void setUp(){
        mercado = new Mercado("BBB", "123456", 789.5);
    }

    @Test
    public void validarTest(){
        mercado = new Mercado();
        mercado.setMoneda("aaaa");
        mercado.setIdWallet("987456");
        mercado.setCantidad(546.0);

        assertEquals(mercado.getIdMoneda(), "AAA", "El campo no coincide");
        assertEquals(mercado.getIdWallet(), "987456", "El campo no coincide");
        assertEquals(mercado.getCantidad(), 546.0, "El campo no coincide");
    }

    @Test
    public void listarTest(){
        assertTrue(mercado.toString().contains("BBB"), "No ha listado correctamente");
    }

    @Test
    public void equalTest(){
        mercado2 = mercado;
        assertTrue(mercado.equals(mercado2), "Los objetos no deben ser iguales");
    }

    @Test
    public void equalErrorTest(){
        mercado2 = mercado;
        mercado.setIdMoneda("BBB");
        mercado.setIdWallet("123456");
        mercado.setCantidad(789.5);

        assertTrue(mercado.equals(mercado2), "Los objetos no deben ser iguales");
    }
    
}
*/