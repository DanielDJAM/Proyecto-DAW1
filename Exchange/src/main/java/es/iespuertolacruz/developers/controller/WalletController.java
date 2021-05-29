package es.iespuertolacruz.developers.controller;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Wallet;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.WalletException;
import es.iespuertolacruz.developers.modelo.WalletModelo;

public class WalletController {
    WalletModelo walletModelo;

    public WalletController() throws BbddException, FicheroException, SQLException {
        walletModelo = new WalletModelo();
    }

    /**
     * Metodo para validar wallets
     * 
     * @param wallet a validar
     * @throws walletException
     */
    public void validar(Wallet wallet) throws WalletException {
        String mensaje = "";

        if (wallet == null) {
            mensaje = "Los wallet  son nulos";
            throw new WalletException(mensaje);
        }
        if (wallet.getIdWallet() == null || wallet.getIdWallet().isEmpty()) {
            mensaje = "El id es nulo o vacio,";
        }
        if (wallet.getUid() == null || wallet.getUid().isEmpty()) {
            mensaje += "El nombre es nulo o vacio,";
        }

        if (!mensaje.isEmpty()) {
            throw new WalletException(mensaje);
        }
    }

    /**
     * Metodo para insertar un wallet
     * 
     * @param wallet a insertar
     * @throws walletException
     * @throws FicheroException
     * @throws BbddException
     */
    public void insertar(Wallet wallet) throws WalletException, BbddException {
        validar(wallet);
        if (existe(wallet)) {
            throw new WalletException("Los wallet ya existe");
        }
        walletModelo.insertar(wallet);
    }

    /**
     * Metodo para eliminar un wallet
     * 
     * @param wallet a eliminar
     * @throws FicheroException
     * @throws walletException
     * @throws BbddException
     */
    public void eliminar(Wallet wallet) throws WalletException, BbddException {
        validar(wallet);
        if (!existe(wallet)) {
            throw new WalletException("Los wallet no existe");
        }
        walletModelo.eliminar(wallet);
    }

    /**
     * Funcion que busca un wallet por su id
     * 
     * @param idWallet del wallet a buscar
     * @return un wallet
     * @throws walletException
     * @throws FicheroException
     * @throws BbddException
     */
    public Wallet buscar(String idWallet) throws WalletException, BbddException {
        Wallet wallet = null;
        if (idWallet == null || idWallet.isEmpty()) {
            throw new WalletException("El idWallet está vacio");
        }
        wallet = walletModelo.buscarWallet(idWallet);
        return wallet;
    }

    /**
     * Funcion que verifica si existe un wallet
     * 
     * @param dni por el que se busca
     * @return True/false si se ha encontrado
     * @throws walletException
     * @throws FicheroException
     * @throws BbddException
     */
    public boolean existe(Wallet wallet) throws WalletException, BbddException {
        boolean encontrado = false;
        Wallet walletEncontrado;
        walletEncontrado = buscar(wallet.getIdWallet());
        if (walletEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }

}
