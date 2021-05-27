package es.iespuertolacruz.developers.modelo;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Moneda;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class MonedaModelo {
    SqliteDb persistencia;

    /**
     * Constructor por defecto de la clase MonedaModelo
     * @throws BbddException
     * @throws FicheroException
     * @throws SQLException
     */
    public MonedaModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(null, null);
    }

      /**
     * Metodo que permiter insertar una moneda en la DB
     * 
     * @param moneda a insertar
     * @throws BbddException controlada
     */
    public void insertar(Moneda moneda) throws BbddException {
        String sql = "INSERT INTO Moneda (nombreMoneda, ticket, valor)" + " VALUES ('" + moneda.getNombreMoneda()
                + "', '" + moneda.getTicket() + "'," + "'" + moneda.getValor() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que permite elimnar una moneda de la DB
     * 
     * @param moneda a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Moneda moneda) throws BbddException {
        String sql = "DELETE from Moneda WHERE ticket ='" + moneda.getTicket() + "'";
        persistencia.actualizar(sql);

    }

    /**
     * Metodo que permite modificar una moneda e la DB
     * 
     * @param moneda a modificar
     * @throws BbddException controlada
     */
    public void modificar(Moneda moneda) throws BbddException {
        String sql = "UPDATE Moneda SET valor ='" + moneda.getValor();
        persistencia.actualizar(sql);
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
