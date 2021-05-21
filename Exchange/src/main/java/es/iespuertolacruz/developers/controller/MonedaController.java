package es.iespuertolacruz.developers.controller;
import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Moneda;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.MonedaException;
import es.iespuertolacruz.developers.modelo.MonedaModelo;

public class MonedaController {
    MonedaModelo monedaModelo;

    public MonedaController() throws BbddException, FicheroException, SQLException {
        monedaModelo = new MonedaModelo();
    }

      /**
     * Metodo para validar monedas
     * @param moneda a validar
     * @throws MonedaException
     */
    public void validar(Moneda moneda) throws MonedaException{
        String mensaje = "";

        if (moneda == null){
            mensaje = "El moneda es nulo";
            throw new MonedaException(mensaje);
        }
        if(moneda.getNombreMoneda() == null || moneda.getNombreMoneda().isEmpty()) {
            mensaje = "El nomrbe de la moneda es nulo o vacio,";
        }
        if (moneda.getTicket() == null || moneda.getTicket().isEmpty()) {
            mensaje += "El ticket es nulo o vacio,";
        }
        if (moneda.getValor() < 0 ) {
            mensaje += "El valor de la moneda es menor que 0";
        }
        
        if(!mensaje.isEmpty()) {
            throw new MonedaException(mensaje);
        }
    }

       /**
     * Metodo para insertar una moneda
     * @param moneda a insertar
     * @throws MonedaException
     * @throws BbddException
     */
    public void insertar(Moneda moneda) throws MonedaException, BbddException {
        validar(moneda);
        if(existe(moneda)) {
            throw new MonedaException("La moneda ya existe");
        }
        monedaModelo.insertar(moneda);
    }

    /**
     * Metodo para eliminar una moneda
     * @param moneda a eliminar
     * @throws MonedaException
     * @throws BbddException
     */
    public void eliminar(Moneda moneda) throws  MonedaException, BbddException{
        validar(moneda);
        if (!existe(moneda)) {
          throw new MonedaException("La moneda no existe");
        }
        monedaModelo.eliminar(moneda);
    }
     /**
     * Metodo para modificar de la clase MonedaController.
     * @param moneda  a modificar
     * @throws BbddException
     * @throws MonedaException
     */
    public void modificar(Moneda moneda) throws  BbddException, MonedaException{
        validar(moneda);
        if(!existe(moneda)){
            throw new MonedaException("La moneda no existe");
        }
        monedaModelo.modificar(moneda);
    }
      /**
     * Funcion que busca una moneda por su ticket
     * @param ticket del moneda a buscar
     * @return un moneda
     * @throws MonedaException
     * @throws BbddException
     */
    public Moneda buscar(String ticket) throws MonedaException, BbddException {
        Moneda moneda = null;
        if (ticket == null || ticket.isEmpty()) {
            throw new MonedaException("El ticket no corresponde");
        }
        moneda = monedaModelo.buscarMoneda(ticket);
        return moneda;
    }

      /**
     * Funcion que verifica si una moneda existe
     * @param ticket por el que se busca
     * @return True/false si se ha encontrado
     * @throws MonedaException
     * @throws BbddException
     */
    public boolean existe(Moneda moneda) throws MonedaException, BbddException {
        boolean encontrado = false;
        Moneda monedaEncontrada;
        monedaEncontrada = buscar(moneda.getTicket());
        if (monedaEncontrada != null) {
            encontrado = true;
        }
        return encontrado;
    }


    
}
