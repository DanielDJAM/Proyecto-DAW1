package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Visitante;
/**
 * 
 
public class VisitanteTest {

    Visitante visitante;
    Visitante visitante2;

    @BeforeEach
    public void setUp(){
        visitante = new Visitante("132ADS");
    }

    @Test
    public void validarTest(){
        visitante = new Visitante();
        visitante.setUid("123asd");

        assertEquals(visitante.getUid(), "123asd", "El campo no coincide");
    }

    @Test
    public void listarTest(){
        assertTrue(visitante.toString().contains("132ADS"), "El campo no coincide");
    }

    @Test
    public void equalErrorTest(){
        visitante2 = visitante;
        visitante.setUid("123asd");

        assertTrue(visitante.equals(visitante2), "Los objetos no deben ser iguales");
    }

}
*/