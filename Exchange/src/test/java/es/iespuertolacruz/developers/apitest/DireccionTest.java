package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Direccion;

public class DireccionTest {

    Direccion direccion;
    Direccion direccion2;

    @BeforeEach
    public void setUp(){
        direccion = new Direccion("dir123456", "CP38896", "Santa Maria", "5ºG", "Santa Cruz de Tenerife", "Espania");
    }

    @Test
    public void validarTest(){
        direccion = new Direccion();
        direccion.setIdDireccion("dir1111A");
        direccion.setCodigoPostal("CP333333");
        direccion.setCalle("Santo tomas");
        direccion.setPuerta("2ºA");
        direccion.setProvincia("Las palmas de Gran Canaria");
        direccion.setPais("England");

        assertEquals(direccion.getIdDireccion(), "dir1111A", "Los campos no coinciden");
        assertEquals(direccion.getCodigoPostal(), "CP333333", "Los campos no coinciden");
        assertEquals(direccion.getCalle(), "Santo tomas", "Los campos no coinciden");
        assertEquals(direccion.getPuerta(), "2ºA", "Los campos no coinciden");
        assertEquals(direccion.getProvincia(), "Las palmas de Gran Canaria", "Los campos no coinciden");
        assertEquals(direccion.getPais(), "England", "Los campos no coinciden");
    }

    @Test
    public void listarTest(){
        assertTrue(direccion.toString().contains("dir123456"), "No ha listado correctamente");
    }

    @Test
    public void equalTest(){
        direccion2 = direccion;
        assertTrue(direccion.equals(direccion2), "Los objetos no deben ser iguales");
    }

    @Test
    public void equalErrorTest(){
        direccion2 = direccion;
        direccion.setIdDireccion("dir1111A");
        direccion.setCodigoPostal("CP333333");
        direccion.setCalle("Santo tomas");
        direccion.setPuerta("2ºA");
        direccion.setProvincia("Las palmas de Gran Canaria");
        direccion.setPais("England");

        assertTrue(direccion.equals(direccion2), "Los objetos no deben ser iguales");
    }
    
}
