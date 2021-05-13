package es.iespuertolacruz.developers.modelo;

import es.iespuertolacruz.developers.api.Moneda;
import es.iespuertolacruz.developers.excepcion.BbddException;

public class MonedaModelo {
    SqliteDb persistencia;

    /**
     * Constructor por defecto de la clase MonedaModelo
     */
    public MonedaModelo() {
        persistencia = new SqliteDb("jdbc:sqlite:", "url", null, null);
    }

    /**
     * Metodo encargado de realizar la insercion de un moneda
     * 
     * @param moneda a insertar
     * @throws BbddException controlada
     */
    public void insertar(Moneda moneda) throws BbddException {
        persistencia.insertar(moneda);
    }

    /**
     * Metodo encargado de realizar la eleminacion de un moneda
     * 
     * @param moneda a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Moneda moneda) throws BbddException {
        persistencia.eliminar(moneda);
    }

    /**
     * Metodo encargado de realizar la modificacion de un moneda
     * 
     * @param moneda a modificar
     */
    public void modificar(Moneda moneda) throws BbddException {
        persistencia.modificar(moneda);
    }

    /**
     * Funcion encargada de realizar la busqueda de un moneda
     * 
     * @param uid del moneda
     * @return Moneda a buscar
     * @throws BbddException
     */
    public Moneda buscarMoneda(String ticket) throws BbddException {

     return persistencia.obtenerMoneda(ticket);
       
   }
}
