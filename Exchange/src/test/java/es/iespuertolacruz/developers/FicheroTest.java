package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.modelo.Fichero;

public class FicheroTest {

    Fichero fichero = null;
    String nombreFichero = "fichero.txt";
    String mensaFichero = "CREATE";

    @BeforeEach
    public void sepUp() {
        if (fichero == null) {
            fichero = new Fichero();
        }

    }

    @Test
    public void leerFicheroTest() {
        String texto = null;
        try {
            texto = new Fichero().leer("resources/sqlite/mercadoCrear.sql");
            boolean validar = texto.contains(mensaFichero);
            assertTrue(validar, "El programa no lee correctamente el fichero");
        } catch (Exception e) {
            fail("Se ha producido un error en el test leer fichero");
        }
    }

    @Test
    public void validarErrorFicheroExisteTest() {
        try {
            fichero.leer("fichero");
        } catch (FicheroException e) {
            assertTrue(e.getMessage().contains("no existe"));

        }
    }

}
