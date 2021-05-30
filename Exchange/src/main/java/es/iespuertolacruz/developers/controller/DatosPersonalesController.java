package es.iespuertolacruz.developers.controller;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.DatosPersonales;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.DatosPersonalesException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.modelo.DatosPersonalesModelo;

public class DatosPersonalesController {
    
    DatosPersonalesModelo datosPersonalesModelo;
    private static final int EDAD_MINIMA = 18;
     /**
     * Constructor por defecto de la clase datosPersonalesController
     * @throws BbddException
     * @throws FicheroException
     * @throws SQLException
     */
    public DatosPersonalesController() throws BbddException, FicheroException, SQLException{
        datosPersonalesModelo = new DatosPersonalesModelo();
    }

    /**
     * Metodo para validar datosPersonaless
     * @param datosPersonales a validar
     * @throws datosPersonalesException
     */
    public void validar(DatosPersonales datosPersonales) throws DatosPersonalesException{
        String mensaje = "";

        if (datosPersonales == null){
            mensaje = "Los datosPersonales son nulos";
            throw new DatosPersonalesException(mensaje);
        }
        if(datosPersonales.getDni() == null || datosPersonales.getDni().isEmpty()) {
            mensaje = "El Dni es nulo o vacio,";
        }
        if (datosPersonales.getNombre() == null || datosPersonales.getNombre().isEmpty()) {
            mensaje += "El nombre es nulo o vacio,";
        }
        if (datosPersonales.getApellidos() == null || datosPersonales.getApellidos().isEmpty()) {
            mensaje += "Los apellidos son nulos o vacios,";
        }
        if (datosPersonales.getEdad() < EDAD_MINIMA ) {
            mensaje += "La edad es menor de 18";
        }
       
        if(!mensaje.isEmpty()) {
            throw new DatosPersonalesException(mensaje);
        }
    }

    /**
     * Metodo para insertar un datosPersonales
     * @param datosPersonales a insertar
     * @throws datosPersonalesException
     * @throws FicheroException
     * @throws BbddException
     */
    public void insertar(DatosPersonales datosPersonales) throws DatosPersonalesException, BbddException {
        validar(datosPersonales);
        if(existe(datosPersonales)) {
            throw new DatosPersonalesException("Los datosPersonales ya existe");
        }
        datosPersonalesModelo.insertar(datosPersonales);
    }

      /**
     * Metodo para eliminar un datosPersonales
     * @param datosPersonales a eliminar
     * @throws FicheroException
     * @throws datosPersonalesException
     * @throws BbddException
     */
    public void eliminar(DatosPersonales datosPersonales) throws  DatosPersonalesException, BbddException{
        validar(datosPersonales);
        if (!existe(datosPersonales)) {
          throw new DatosPersonalesException("Los datosPersonales no existe");
        }
        datosPersonalesModelo.eliminar(datosPersonales);
    }

    /**
     * Metodo para modificar de la clase datosPersonalesController.
     * 
     * @param datosPersonales  a modificar.
     * @throws FicheroException
     * @throws BbddException
     * @throws datosPersonalesException
     */
    public void modificar(DatosPersonales datosPersonales) throws  BbddException, DatosPersonalesException{
        validar(datosPersonales);
        if(!existe(datosPersonales)){
            throw new DatosPersonalesException("El datosPersonales no existe");
        }
        datosPersonalesModelo.modificar(datosPersonales);
    }


    /**
     * Funcion que busca un datosPersonales por su Dni
     * @param uid del datosPersonales a buscar
     * @return un datosPersonales
     * @throws datosPersonalesException
     * @throws FicheroException
     * @throws BbddException
     */
    public DatosPersonales buscar(String dni) throws DatosPersonalesException, BbddException {
        DatosPersonales datosPersonales = null;
        if (dni == null || dni.isEmpty()) {
            throw new DatosPersonalesException("El dni está vacio");
        }
        datosPersonales = datosPersonalesModelo.buscarDatosPersonales(dni);
        return datosPersonales;
    }

      /**
     * Funcion que verifica si existe un datosPersonales
     * @param uid por el que se busca
     * @return True/false si se ha encontrado
     * @throws datosPersonalesException
     * @throws FicheroException
     * @throws BbddException
     */
    public boolean existe(DatosPersonales datosPersonales) throws DatosPersonalesException, BbddException {
        boolean encontrado = false;
        DatosPersonales datosPersonalesEncontrado;
        datosPersonalesEncontrado = buscar(datosPersonales.getDni());
        if (datosPersonalesEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }



}
