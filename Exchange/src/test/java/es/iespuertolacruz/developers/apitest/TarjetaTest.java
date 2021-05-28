package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Tarjeta;

public class TarjetaTest {

    Tarjeta tarjeta;
    Tarjeta tarjeta2;

    @BeforeEach
    public void setUp(){
        tarjeta = new Tarjeta("1111A", "daniel", "20/20/20", 874);
    }

    @Test
    public void validarTest(){
        tarjeta = new Tarjeta();
        tarjeta.setidTarjeta("2222B");
        tarjeta.setTitular("juan");
        tarjeta.setFechaCaducidad("10/10/10");
        tarjeta.setCvv(234);

        assertEquals(tarjeta.getidTarjeta(), "2222B", "Los campos no coinciden");
        assertEquals(tarjeta.getTitular(), "juan", "Los campos no coinciden");
        assertEquals(tarjeta.getFechaCaducidad(), "10/10/10", "Los campos no coinciden");
        assertEquals(tarjeta.getCvv(), 234, "Los campos no coinciden");
    }

    @Test
    public void listarTest(){
        assertTrue(tarjeta.toString().contains("1111A"), "No ha listado correctamente");
    }

    @Test
    public void equalTest(){
        tarjeta2 = tarjeta;
        assertTrue(tarjeta.equals(tarjeta2), "Los objetos no deben ser iguales");
    }

    @Test
    public void equalErrorTest(){
        tarjeta2 = tarjeta;
        tarjeta.setidTarjeta("2222B");
        tarjeta.setTitular("juan");
        tarjeta.setFechaCaducidad("10/10/10");
        tarjeta.setCvv(234);

        assertTrue(tarjeta.equals(tarjeta2), "Los objetos no deben ser iguales");
    }
    
}
