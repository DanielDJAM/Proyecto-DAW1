package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Wallet;
import es.iespuertolacruz.developers.controller.WalletController;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.WalletException;

public class WalletControllerTest {

    WalletController walletController;
    Wallet wallet;
    Wallet wallet2;

    @BeforeEach
    public void setUp() {

        if (walletController == null) {
            try {
                walletController = new WalletController();
            } catch (BbddException e) {
                fail(e.getMessage());
            } catch (FicheroException e) {
                fail(e.getMessage());
            } catch (SQLException e) {
                fail(e.getMessage());
            }
        }

        wallet = new Wallet("100-200","10002");
        wallet2 = new Wallet("200-100","10003");
        try {
            walletController.insertar(wallet);
        } catch (WalletException e) {
            fail(e.getMessage());
        } catch (BbddException e) {
            fail(e.getMessage());
        }

    }

    @AfterEach
    public void after() {
        try {
            walletController.eliminar(wallet);
        } catch (WalletException e) {

            fail(e.getMessage());
        } catch (BbddException e) {

            fail(e.getMessage());
        }
    }

    @Test
    public void existeTest() {
        try {
            walletController.validar(wallet);
        } catch (WalletException e) {
            fail("Se ha producido un error validando la direecion no controlado");
        }
    }

   

    @Test
    public void buscarPorIdWalletTest() {
        Wallet Buscado;

        try {

            Buscado = walletController.buscarId("100-200");
            assertEquals(wallet, Buscado, "Las walletes deberian ser iguales");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }




    @Test 
    public void insertarErrorTest() {
        String mensaje = "existe";
        try {
            walletController.insertar(wallet);
            fail("se ha insertado");
        } catch (BbddException e) {
            assertTrue(e.getMessage().contains(mensaje));
        } catch (WalletException e) {
           
        }
    }

 
    @Test
    public void validarErrorNullTest() {
        try {
            Wallet wallet4 = null;
            walletController.validar(wallet4);
        } catch (WalletException e) {
            assertTrue(e.getMessage().contains("nulo"));

        }
    }

    @Test
    public void validarbuscarNullTest() {
        try {
            Wallet wallet4 = new Wallet();
            wallet4.setUid("");
            walletController.buscarId("");
        } catch (WalletException e) {
            assertTrue(e.getMessage().contains("vacio"));

        } catch (BbddException e) {
            
        }
    }

    @Test
    public void eliminarErrorTest() {
        try {
            try {
                walletController.insertar(wallet2);
                walletController.eliminar(wallet2);
                walletController.eliminar(wallet2);
            } catch (WalletException e) {
                assertTrue(e.getMessage().contains("no existe"));
            }
        } catch (BbddException e) {
            assertTrue(e.getMessage().contains("no existe"));
        }
    }

    @Test
    public void validarErrorTest() {
        try {
            
            Wallet wallet4 = null;
            wallet4 = new Wallet();
            wallet4.setUid("");
            wallet4.setIdWallet("");
            
            walletController.validar(wallet4);
        } catch (WalletException e) {
            assertTrue(e.getMessage().contains("nulo o vacio"));

        }
    }
}

