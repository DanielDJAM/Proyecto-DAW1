package es.iespuertolacruz.developers.controller;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Tarjeta;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.TarjetaException;
import es.iespuertolacruz.developers.modelo.TarjetaModelo;

public class TarjetaController {

    TarjetaModelo tarjetaModelo;

     /**
     * Constructor por defecto de la clase TarjetaController
     * 
     * @throws BbddException
     * @throws FicheroException
     * @throws SQLException
     */
    public TarjetaController() throws BbddException, FicheroException, SQLException {
        tarjetaModelo = new TarjetaModelo();
    }

    /**
     * Metodo para validar tarjetas
     * 
     * @param tarjeta a validar
     * @throws tarjetaException
     */
    public void validar(Tarjeta tarjeta) throws TarjetaException {
        String mensaje = "";

        if (tarjeta == null) {
            mensaje = "Los tarjeta  son nulos";
            throw new TarjetaException(mensaje);
        }
        if (tarjeta.getidTarjeta() == null || tarjeta.getidTarjeta().isEmpty()) {
            mensaje = "El ID es nulo o vacio,";
        }
        if (tarjeta.getTitular() == null || tarjeta.getTitular().isEmpty()) {
            mensaje += "El Titular es nulo o vacio,";
        }
        if (tarjeta.getFechaCaducidad() == null || tarjeta.getFechaCaducidad().isEmpty()) {
            mensaje += "La fecha es nula o  está vacio,";
        }
        if (tarjeta.getCvv() < 0) {
            mensaje += "El cvv no tiene que tener numeros negativos";
        }

        if (!mensaje.isEmpty()) {
            throw new TarjetaException(mensaje);
        }
    }

    /**
     * Metodo para insertar una tarjeta
     * 
     * @param tarjeta a insertar
     * @throws tarjetaException
     * @throws FicheroException
     * @throws BbddException
     */
    public void insertar(Tarjeta tarjeta) throws TarjetaException, BbddException {
        validar(tarjeta);
        if (existe(tarjeta)) {
            throw new TarjetaException("Los tarjeta ya existe");
        }
        tarjetaModelo.insertar(tarjeta);
    }

     /**
     * Metodo para eliminar una tarjeta
     * 
     * @param tarjeta a eliminar
     * @throws FicheroException
     * @throws tarjetaException
     * @throws BbddException
     */
    public void eliminar(Tarjeta tarjeta) throws TarjetaException, BbddException {
        validar(tarjeta);
        if (!existe(tarjeta)) {
            throw new TarjetaException("Los tarjeta no existe");
        }
        tarjetaModelo.eliminar(tarjeta);
    }

  

    /**
     * Funcion que busca un tarjeta por su id
     * 
     * @param id del tarjeta a buscar
     * @return un tarjeta
     * @throws tarjetaException
     * @throws FicheroException
     * @throws BbddException
     */
    public Tarjeta buscar(String idTarjeta) throws TarjetaException, BbddException {
        Tarjeta tarjeta = null;
        if (idTarjeta == null || idTarjeta.isEmpty()) {
            throw new TarjetaException("El id de la tarjeta está vacio o es nulo");
        }
        tarjeta = tarjetaModelo.obtenerTarjeta(idTarjeta);
        return tarjeta;
    }

     /**
     * Funcion que verifica si existe un tarjeta
     * 
     * @param dni por el que se busca
     * @return True/false si se ha encontrado
     * @throws tarjetaException
     * @throws FicheroException
     * @throws BbddException
     */
    public boolean existe(Tarjeta tarjeta) throws TarjetaException, BbddException {
        boolean encontrado = false;
        Tarjeta tarjetaEncontrado;
        tarjetaEncontrado = buscar(tarjeta.getidTarjeta());
        if (tarjetaEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }


}
