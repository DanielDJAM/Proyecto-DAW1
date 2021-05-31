package es.iespuertolacruz.developers;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.DatosPersonalesException;
import es.iespuertolacruz.developers.excepcion.DireccionException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.MiembroException;
import es.iespuertolacruz.developers.excepcion.MonedaException;
import es.iespuertolacruz.developers.excepcion.TarjetaException;
import es.iespuertolacruz.developers.excepcion.WalletException;

public class ExceptionsTest {
    

    @Test
    public void generarExcepcionTest() {
        Exception bbException = new BbddException("mensaje de error", new Exception());
        Exception ficheroException = new FicheroException("mensaje de error", new Exception());
        Exception datosPersonalesException = new DatosPersonalesException("mensaje de error", new Exception());
        Exception direccionException = new DireccionException("mensaje de error", new Exception());
        Exception miembroException = new MiembroException("mensaje de error", new Exception());
        Exception monedaException = new MonedaException("mensaje de error", new Exception());
        Exception tarjetaException = new TarjetaException("mensaje de error", new Exception());
        Exception walletException = new WalletException("mensaje de error", new Exception());
        assertTrue(bbException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(ficheroException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(datosPersonalesException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(direccionException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(miembroException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(monedaException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(tarjetaException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(walletException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");


    }

    @Test
    public void generarExcepcionMensajeTest() {
        Exception bbddException = new BbddException("mensaje de error");
        Exception ficheroException = new FicheroException("mensaje de error");
        Exception datosPersonalesException = new DatosPersonalesException("mensaje de error");
        Exception direccionException = new DireccionException("mensaje de error");
        Exception miembroException = new MiembroException("mensaje de error");
        Exception monedaException = new MonedaException("mensaje de error");
        Exception tarjetaException = new TarjetaException("mensaje de error");
        Exception walletException = new WalletException("mensaje de error");
        assertTrue(bbddException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(ficheroException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(datosPersonalesException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(direccionException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(miembroException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(monedaException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(tarjetaException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");
        assertTrue(walletException.getMessage().contains("mensaje de error"), "No genera el mensaje esperado");

    }



}
