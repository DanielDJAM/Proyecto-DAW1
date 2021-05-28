package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Administrador;

public class AdministradorTest {

    Administrador administrador;
    Administrador administrador2;

    @BeforeEach
    public void setUp(){
        administrador = new Administrador(uid, datosPersonales, email, contrasenia, direccion, tarjeta);
    }

    @Test
    public void validarTest(){
        administrador = new Administrador();
        administrador.setUid(uid);
        administrador.setDatosPersonales(datosPersonales);
        administrador.setEmail(email);
        administrador.setContrasenia(contrasenia);
        

        assertEquals(administrador.getUid(), actual, "El campo no coincide");
        assertEquals(administrador.getDatosPersonales(), actual, "El campo no coincide");
        assertEquals(administrador.getEmail(), actual, "El campo no coincide");
        assertEquals(administrador.getContrasenia(), actual, "El campo no coincide");
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
        administrador.setUid(uid);
        administrador.setDatosPersonales(datosPersonales);
        administrador.setEmail(email);
        administrador.setContrasenia(contrasenia);

        assertTrue(administrador.equals(administrador2), "Los objetos no deben ser iguales");
    }
    
}
