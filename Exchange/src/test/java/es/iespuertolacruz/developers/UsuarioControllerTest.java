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

    String nombreFichero = "Fichero-Usuarios.txt";
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
            usuario = crearUsuario("aaa123", "dakota", "perra", 50, "11111111A");
        }
        if (usuario2 == null) {
            usuario2 = crearUsuario(null, null, null, 0, null);
        }
        if (usuario3 == null) {
            usuario3 = crearUsuario("3333CCC", "jonay", "exposito", 26, "33333333c");
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
            usuarioController.eliminar(usuario3);
            assertTrue(usuarioController.buscar(usuario3.getUid()) == null,
                    "El usuario no se ha borrado correctamente");

        } catch (UsuarioException | BbddException e) {
            fail("Fallo en usuarioException");
        }
    }

    @Test
    public void modificarUsuarioTest() {
        try {
            usuarioController.modificar(usuario);
            assertTrue(usuarioController.existe(usuario2), "Los objetos no son iguales.");

        } catch (UsuarioException | BbddException e) {
            fail("Error UsuarioException");
        }
    }

}
