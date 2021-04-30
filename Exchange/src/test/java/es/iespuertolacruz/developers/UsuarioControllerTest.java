package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.controller.UsuarioController;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.UsuarioException;

public class UsuarioControllerTest extends UtilidadesTest {

    UsuarioController usuarioController;
    Usuario usuario;

    @BeforeEach
    public void setUp(){
        if (usuarioController == null){
            usuarioController = new UsuarioController();
        }

        usuario = crearUsuario(null, null, null, 0, null);
        try {
            usuarioController.insertar(usuario);
        } catch (UsuarioException e) {
            fail("Error de Usuario");
        } catch (FicheroException e) {
            fail("Error de Fichero");
        }

        
    }

    @AfterEach
    public void after(){

    }

    @Test
    public void existeTest(){
        try {
            assertTrue(usuarioController.existe(usuario.getUid()), "No existe el UID del usuario.");
        } catch (UsuarioException e) {
            fail("Error de Usuario");
        } catch (FicheroException e) {
            fail("Error de Fichero");
        }
    }

    @Test
    public void buscarTest(){
        try {
            assertTrue(usuarioController.buscar("1000").equals(usuario.getUid()), "No se ha encontrado al usuario");
        } catch (UsuarioException e) {
            fail("Error de Usuario");
        } catch (FicheroException e) {
            fail("Error de Fichero");
        }
    }
    
}
