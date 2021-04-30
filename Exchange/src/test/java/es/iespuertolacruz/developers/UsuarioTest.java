package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Usuario;

public class UsuarioTest extends UtilidadesTest {
    
    Usuario usuario;

    @BeforeEach
    public void setUp(){
        usuario = crearUsuario(null, null, null, 0, null);
    }


    @Test
    public void existeTest(){
        assertEquals("1000", usuario.getUid(), "Error al obtener el UID del usuario.");
        assertEquals("daniel", usuario.getNombre(), "Error al obtener el nombre del usuario.");
        assertEquals("exposito", usuario.getApellidos(), "Error al obtener el apellido del usuario.");
        assertEquals(25, usuario.getEdad(), "Error al obtener la edad del usuario.");
        assertEquals("12345678A", usuario.getDni(), "Error al obtener el DNI del usuario.");
    }

    @Test
    public void constructor2Test(){
        Usuario usuario = new Usuario("2000");
        assertEquals("2000", usuario.getUid(), "Error al obtener el UID del usuario");
    }

    @Test
    public void constructor3Test(){
        Usuario usuario = crearUsuario("3000", "borja", "nose", 24, "11111111B");
        assertEquals("3000", usuario.getUid(), "Error al obtener el UID del usuario.");
        assertEquals("borja", usuario.getNombre(), "Error al obtener el nombre del usuario.");
        assertEquals("nose", usuario.getApellidos(), "Error al obtener el apellido del usuario.");
        assertEquals(24, usuario.getEdad(), "Error al obtener la edad del usuario.");
        assertEquals("11111111B", usuario.getDni(), "Error al obtener el DNI del usuario.");

    }
    
}
