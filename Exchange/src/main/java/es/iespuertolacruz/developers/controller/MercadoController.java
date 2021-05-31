package es.iespuertolacruz.developers.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.Mercado;
import es.iespuertolacruz.developers.api.Wallet;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.modelo.MercadoModelo;
import es.iespuertolacruz.developers.modelo.MonedaModelo;
import es.iespuertolacruz.developers.modelo.WalletModelo;

public class MercadoController {

    MercadoModelo mercadoModelo;
    WalletModelo walletModelo;
    MonedaModelo monedaModelo;


    public MercadoController() throws BbddException, FicheroException, SQLException {
        mercadoModelo = new MercadoModelo();
        walletModelo = new WalletModelo();
        monedaModelo = new MonedaModelo();
    }


    public String listarMercadoWallet(Wallet wallet) throws BbddException{
        Mercado mercado = null;
        ArrayList<Mercado> listaMercado = null;
        mercado = mercadoModelo.obtenerMercado(wallet.getIdWallet());
        listaMercado.add(mercado);
        return listaMercado.toString();
    }

    
}
