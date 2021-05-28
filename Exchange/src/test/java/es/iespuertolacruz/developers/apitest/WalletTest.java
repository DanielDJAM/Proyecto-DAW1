package es.iespuertolacruz.developers.apitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.Wallet;

public class WalletTest {

    Wallet wallet;
    Wallet wallet2;

    @BeforeEach
    public void setUp(){
        wallet = new Wallet("312546", "asd987");
    }

    @Test
    public void validarTest(){
        wallet = new Wallet();
        wallet.setIdWallet("fgdhgdfs");
        wallet.setUid("987654");

        assertEquals(wallet.getIdWallet(), "fgdhgdfs", "El ticket de la wallet no coincide");
        assertEquals(wallet.getUid(), "987654", "El nombre de la wallet no coincide");
    }

    @Test
    public void listarTest(){
        assertTrue(wallet.toString().contains("asd987"), "No ha listado correctamente");
    }

    @Test
    public void equalTest(){
        wallet2 = wallet;
        assertTrue(wallet.equals(wallet2), "Los objetos no deben ser iguales");
    }

    @Test
    public void equalErrorTest(){
        wallet2 = wallet;
        wallet.setIdWallet("312546");
        wallet.setUid("asd987");

        assertTrue(wallet.equals(wallet2), "Los objetos no deben ser iguales");
    }
    
}
