package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.controller.UsuarioController;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.UsuarioException;
import es.iespuertolacruz.developers.modelo.UsuarioModelo;

public class UsuarioControllerTest extends UtilidadesTest {

    
    UsuarioController usuarioController;
    UsuarioModelo usuarioModelo;

    Usuario usuario;
    Usuario usuario2;
    Usuario usuario3;

    @BeforeEach
    public void setUp() {
        if (usuarioController == null) {
            usuarioController = new UsuarioController();
        }
        if (usuarioModelo == null) {
            usuarioModelo = new UsuarioModelo();
        }

        if (usuario == null) {
            usuario = crearUsuario("1000","12345678A","daniel","exposito",25);
        }
        if (usuario2 == null) {
            usuario2 = crearUsuario(null, null, null, null, 0);
        }
        if (usuario3 == null) {
            usuario3 = crearUsuario("3333CCC", "33333333c","jonay", "exposito", 26);
        }

        try {
            usuarioController.insertar(usuario);
            usuarioController.insertar(usuario2);
        } catch (UsuarioException | BbddException e) {

        }

    }

    @AfterEach
    public void after() {

    }



    @Test
    public void existeTest() {
        try {
            usuarioController.validar(usuario);
        } catch (UsuarioException e) {
            fail("Se ha producido un error validando el usuario no controlado");
        }
    }

    /**
     * 
   
    @Test
    public void insertarFailTest() {
        try {
            usuarioController.insertar(usuario);
            assertEquals(usuario, usuarioController.buscar(usuario.getUid()), "No se ha encontrado al usuario");
        } catch (UsuarioException | BbddException e) {
           // fail("Error de Usuario buscarTest");
           fail(e.getMessage());

        }
    }
      */
      
    @Test
    public void buscarTest() {
        try {
            assertEquals(usuario, usuarioController.buscar(usuario.getUid()), "No se ha encontrado al usuario");
        } catch (UsuarioException | BbddException e) {
            fail("Error de Usuario buscarTest");

        }
    }
    
    @Test
    public void eliminarTest() {
        try {
            usuarioController.eliminar(usuario);
            assertTrue(usuarioController.buscar(usuario.getUid()) == null,
                    "El usuario no se ha borrado correctamente");

        } catch (UsuarioException | BbddException e) {
            fail("Fallo en usuarioException");
        }
    }
 /**
    @Test
    public void modificarUsuarioTest() {
        try {
            usuarioController.modificar(usuario);
            assertTrue(usuarioController.existe(usuario2), "Los objetos no son iguales.");

        } catch (UsuarioException | BbddException e) {
            fail(e.getMessage());
        }
    }
   
     * 
     */


}
