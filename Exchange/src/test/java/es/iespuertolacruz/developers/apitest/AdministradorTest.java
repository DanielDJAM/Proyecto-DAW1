package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Administrador;
import es.iespuertolacruz.developers.api.DatosPersonales;
import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.api.Tarjeta;

public class AdministradorTest {

    Administrador administrador;
    Administrador administrador2;
    DatosPersonales datosPersonales;
    DatosPersonales datosPersonales2;
    Direccion direccion;
    Tarjeta tarjeta;

    @BeforeEach
    public void setUp(){
        datosPersonales = new DatosPersonales("456987A", "cristian", "apellidos2", 54);
        administrador = new Administrador("1002", datosPersonales, "administrador@gmail.com", "*********");
    }

    @Test
    public void validarTest(){
        datosPersonales2 = new DatosPersonales("6548a", "yoquese", "apellidos3", 96);
        administrador = new Administrador();
        administrador.setUid("1003");
        administrador.setDatosPersonales(datosPersonales);
        administrador.setEmail("admin@gmail.com");
        administrador.setContrasenia("123456");
        
        assertEquals(administrador.getUid(), "1003", "El campo no coincide");
        assertEquals(administrador.getDatosPersonales(), datosPersonales2, "El campo no coincide");
        assertEquals(administrador.getEmail(), "admin@gmail.com", "El campo no coincide");
        assertEquals(administrador.getContrasenia(), "123456", "El campo no coincide");
    }

    @Test
    public void listarTest(){
        assertTrue(administrador.toString().contains("AAA"), "No ha listado correctamente");
    }

    @Test
    public void equalTest(){
        administrador2 = administrador;
        assertTrue(administrador.equals(administrador2), "Los objetos no deben ser iguales");
    }

    @Test
    public void equalErrorTest(){
        administrador2 = administrador;
        administrador.setUid("1003");
        administrador.setDatosPersonales(datosPersonales);
        administrador.setEmail("admin@gmail.com");
        administrador.setContrasenia("123456");

        assertTrue(administrador.equals(administrador2), "Los objetos no deben ser iguales");
    }
    
}
