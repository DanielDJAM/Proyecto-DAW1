package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.modelo.Fichero;
/* 
public class FicheroTest extends UtilidadesTest {

    Fichero fichero = null;
    String nombreFichero = "Fichero-Usarios.txt";
    Usuario usuario;
    Usuario usuario2;
    Usuario usuario3;

    @BeforeEach
    public void setUp() {
        if (fichero == null) {
            fichero = new Fichero();
        }
        if (usuario == null) {
            usuario = crearUsuario("aaa111", "dani", "alvarez", 30, "11111111a");
        }
        if (usuario2 == null) {
            usuario2 = crearUsuario("bbb222", "borja", "rodriguez", 20, "22222222b");
        }
        if (usuario3 == null) {
            usuario3 = crearUsuario("3333CCC", "jonay", "exposito", 26, "33333333c");
        }
        crearFichero();
        try {
            fichero.insertar(usuario);
            fichero.insertar(usuario2);
            fichero.insertar(usuario3);

        } catch (FicheroException e) {
            //fail("ERROR en insertar de BeforeEach");
            fail(e.getMessage());
        }
    }

    @Test
    public void insertarTest(){
        try {
            assertEquals(usuario, fichero.buscar(usuario.getUid()), "Ha ocurrido un error al insertar");
        } catch (FicheroException e) {
            fail("ERROR en insertarTest");
        }
    }

    @Test
    public void eliminarUsuarioTest(){
        try {
            fichero.eliminar(usuario);
            assertTrue(fichero.buscar(usuario.getUid()) == null, "Deberia ser True/nulo");
        } catch (FicheroException e) {
            fail("Error al eliminar el usuario del fichero.");
        }
    }

    @Test
    public void modificarUsuarioTest(){
        try {
            fichero.modificar(usuario3, usuario2);
            assertTrue(fichero.obtenerListado().contains(usuario2), "Los objetos no son iguales.");
        } catch (FicheroException e) {
            fail("Error al modificar el usuario.");
        }
    }

    @Test
    public void buscarTest() {
        try {
            assertEquals(usuario , fichero.buscar(usuario.getUid()), "No se ha encontrado el usuario.");
        } catch (FicheroException e) {
            fail("Error en FicheroException");
        }
    }



    @Test
    public void eliminarNoExisteTest() {
        String nombreFichero = "ficheroNoExiste.txt";

        try {
            fichero.eliminar(nombreFichero);
        } catch (FicheroException e) {
            boolean validar = e.getMessage().contains("No se puede eliminar un fichero que no existe");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("El test (eliminarNoExisteTest) ha generado un error no controlado");
        }
    }

    

    private void crearFichero() {
        try {
            fichero.crear(nombreFichero, "");
        } catch (FicheroException e) {
            fail("Se ha producido un error en la escritura del fichero");
        }
    }

    private void eliminar() {
        try {
            fichero.eliminar(nombreFichero);
        } catch (FicheroException e) {
            fail("Se ha producido un error en la escritura del fichero");
        }
    }
    
}
*/