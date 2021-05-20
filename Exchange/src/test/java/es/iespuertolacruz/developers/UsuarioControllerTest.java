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
    public void setUp() throws BbddException {
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
            usuario3 = crearUsuario("0002", "12345678C","jonay", "exposito", 26);
        }

        
            try {
                usuarioController.insertar(usuario);
                usuarioController.insertar(usuario2);
       
            } catch (UsuarioException e) {
               fail("Fallo al insertar usuario");
            } catch (BbddException e) {
                fail("fallo al insertar en la DB");
            }
            

    }

    @AfterEach
    public void after() {
        try {
            usuarioController.eliminar(usuario);
            usuarioController.eliminar(usuario2);
        } catch (UsuarioException e) {
            fail("Error al eliminar usuario");
        } catch (BbddException e) {
            fail("Error al elimanr usuario en la DB");
        }
    }

    @Test
    public void insertartest(){
        try {
            usuarioController.insertar(usuario3);
            assertEquals(usuario3, usuarioController.buscar(usuario3.getUid()), "No se ha encontrado al usuario");
        } catch (UsuarioException | BbddException e) {
            fail("Error al insertar usuario");
        }
    }



    @Test
    public void existeTest() {
        try {
            usuarioController.validar(usuario3);
        } catch (UsuarioException e) {
            fail("Se ha producido un error validando el usuario no controlado");
        }
    }

   
   
    @Test
    public void insertarFailTest() {
        try {
            try {
                usuarioController.insertar(usuario);
            } catch (BbddException e) {
                fail("Error al insertar en la db");
            }
        } catch (UsuarioException e) {
           assertTrue(e.getMessage().contains("ya existe"));

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

        } catch (UsuarioException  e) {
            fail("Fallo al eliminar usuario");
        } catch (BbddException e){
            fail("Fallo al eliminar usuario de la db");
        }
    }
 
    @Test
    public void modificarUsuarioTest() {
        usuario.setNombre("pepe");
        try {
            usuarioController.modificar(usuario);
            

        } catch (UsuarioException | BbddException e) {
            fail(e.getMessage());
        }
    }
   
     


}
