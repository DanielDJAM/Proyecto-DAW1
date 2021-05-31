package es.iespuertolacruz.developers.controller;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.DireccionException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.modelo.DireccionModelo;

public class DireccionController {

    DireccionModelo  direccionModelo;

       /**
     * Constructor por defecto de la clase DireccionController
     * @throws BbddException
     * @throws FicheroException
     * @throws SQLException
     */
    public DireccionController() throws BbddException, FicheroException, SQLException{
        direccionModelo = new DireccionModelo();
    }


    /**
     * Metodo para validar direcciones
     * @param direccion a validar
     * @throws direccionException
     */
    public void validar(Direccion direccion) throws DireccionException{
        String mensaje = "";

        if (direccion == null){
            mensaje = "La direccion es nula";
            throw new DireccionException(mensaje);
        }
        if(direccion.getIdDireccion() == null || direccion.getIdDireccion().isEmpty()) {
            mensaje = "El IdDireccion es nulo o vacio,";
        }
        if (direccion.getCodigoPostal() == null || direccion.getCodigoPostal().isEmpty()) {
            mensaje += "El Codigo postal es nulo o vacio,";
        }
        if (direccion.getCalle() == null || direccion.getCalle().isEmpty()) {
            mensaje += "La calle es nula o vacia,";
        }
        if (direccion.getPuerta() == null || direccion.getPuerta().isEmpty() ) {
            mensaje += "Los datos de la puerta estan vacios o son nulos";
        }
       
        if (direccion.getProvincia() == null || direccion.getPuerta().isEmpty()) {
            mensaje += "Los datos de la provincia estan vacios o son nulos";
        }
        if (direccion.getPais() == null || direccion.getPais().isEmpty()) {
            mensaje += "Los datos del pais estan vacios o son nulos";
        }
        if(!mensaje.isEmpty()) {
            throw new DireccionException(mensaje);
        }
    }


        /**
     * Metodo para insertar un direccion
     * @param direccion a insertar
     * @throws DireccionException
     * @throws FicheroException
     * @throws BbddException
     */
    public void insertar(Direccion direccion) throws DireccionException, BbddException {
        validar(direccion);
        if(existe(direccion)) {
            throw new DireccionException("La direccion ya existe");
        }
        direccionModelo.insertar(direccion);
    }


     /**
     * Metodo para eliminar un miembro
     * @param miembro a eliminar
     * @throws FicheroException
     * @throws MiembroException
     * @throws BbddException
     */
    public void eliminar(Direccion direccion) throws  DireccionException, BbddException{
        validar(direccion);
        if (!existe(direccion)) {
          throw new DireccionException("La direccion no existe");
        }
        direccionModelo.eliminar(direccion);
    }

     /**
     * Metodo para modificar de la clase MiembroController.
     * 
     * @param direccion  a modificar.
     * @throws FicheroException
     * @throws BbddException
     * @throws MiembroException
     */
    public void modificar(Direccion direccion) throws  BbddException, DireccionException{
        validar(direccion);
        if(!existe(direccion)){
            throw new DireccionException("El direccion no existe");
        }
        direccionModelo.modificar(direccion);
    }

    /**
     * Funcion que busca un direccion por su idDireccion
     * @param idDireccion de la direccion a buscar
     * @return un direccion
     * @throws DireccionException
     * @throws FicheroException
     * @throws BbddException
     */
    public Direccion buscar(String idDireccion) throws DireccionException, BbddException {
        Direccion direccion = null;
        if (idDireccion == null || idDireccion.isEmpty()) {
            throw new DireccionException("El id de la direccion esta vacio o es nulo");
        }
        direccion = direccionModelo.buscarDireccion(idDireccion);
        return direccion;
    }

     /**
     * Funcion que verifica si existe un direccion
     * @param uid por el que se busca
     * @return True/false si se ha encontrado
     * @throws DireccionException
     * @throws FicheroException
     * @throws BbddException
     */
    public boolean existe(Direccion direccion) throws DireccionException, BbddException {
        boolean encontrado = false;
        Direccion direccionEncontrado;
        direccionEncontrado = buscar(direccion.getIdDireccion());
        if (direccionEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }
    



}
