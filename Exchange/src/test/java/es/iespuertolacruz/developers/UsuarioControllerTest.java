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
        if (usuario == null) {
            usuario = crearUsuario(null, null, null, 0, null);
        }
    }

    @AfterEach
    public void after(){

    }

    @Test
    public void existeTest(){
        try {
            usuarioController.validar(usuario);
         } catch (UsuarioException e) {
            fail("Se ha producido un error validando el usuario no controlado");
         }
    }

    @Test
    public void buscarTest(){
        try {
            assertTrue(usuarioController.buscar("1000").toString().contains(usuario.getUid()), "No se ha encontrado al usuario");
        } catch (UsuarioException e) {
            fail("Error de Usuario buscarTest");
        } catch (FicheroException e) {
            fail("Error de Fichero buscarTest");
        }
    }
    
}
