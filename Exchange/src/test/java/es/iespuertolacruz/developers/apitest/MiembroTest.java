package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Miembro;

public class MiembroTest {

    Miembro miembro;
    Miembro miembro2;

    @BeforeEach
    public void setUp(){
        miembro = new Miembro(uid, datosPersonales, email, contrasenia, direccion, tarjeta);
    }

    @Test
    public void validarTest(){
        miembro = new Miembro();
        miembro.setUid(uid);
        miembro.setDatosPersonales(datosPersonales);
        miembro.setEmail(email);
        miembro.setContrasenia(contrasenia);
        miembro.setDireccion(direccion);
        miembro.setTarjeta(tarjeta);

        assertEquals(miembro.getUid(), actual, "El campo no coincide");
        assertEquals(miembro.getDatosPersonales(), actual, "El campo no coincide");
        assertEquals(miembro.getEmail(), actual, "El campo no coincide");
        assertEquals(miembro.getContrasenia(), actual, "El campo no coincide");
        assertEquals(miembro.getDireccion(), actual, "El campo no coincide");
        assertEquals(miembro.getTarjeta(), actual, "El campo no coincide");
    }

    @Test
    public void listarTest(){
        assertTrue(miembro.toString().contains("AAA"), "No ha listado correctamente");
    }

    @Test
    public void equalTest(){
        miembro2 = miembro;
        assertTrue(miembro.equals(miembro2), "Los objetos no deben ser iguales");
    }

    @Test
    public void equalErrorTest(){
        miembro2 = miembro;
        miembro.setUid(uid);
        miembro.setDatosPersonales(datosPersonales);
        miembro.setEmail(email);
        miembro.setContrasenia(contrasenia);
        miembro.setDireccion(direccion);
        miembro.setTarjeta(tarjeta);

        assertTrue(miembro.equals(miembro2), "Los objetos no deben ser iguales");
    }
    
}
