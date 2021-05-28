package es.iespuertolacruz.developers.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.Tarjeta;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class TarjetaModelo {
    SqliteDb persistencia;

    /**
     * Constructor por defecto de la clase TarjetaModelo
     * 
     * @throws BbddException
     * @throws FicheroException
     * @throws SQLException
     */
    public TarjetaModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(null, null);
    }

    /**
     * Metodo que permiter insertar una moneda en la DB
     * 
     * @param moneda a insertar
     * @throws BbddException controlada
     */
    public void insertar(Tarjeta tarjeta) throws BbddException {
        String sql = "INSERT INTO Tarjeta (id_tarjeta, titular, fechaCaducidad, cvv)" + " VALUES ('"
                + tarjeta.getidTarjeta() + "', '" + tarjeta.getTitular() + "', '" + tarjeta.getFechaCaducidad() + "', '"
                + tarjeta.getCvv() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que permite eliminar una tarjeta de la DB
     * 
     * @param tarjeta a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Tarjeta tarjeta) throws BbddException {
        String sql = "DELETE from Tarjeta WHERE id_tarjeta ='" + tarjeta.getidTarjeta() + "'";
        persistencia.actualizar(sql);

    }

    /**
     * Funcion encargada de realizar la busqueda de una tarjeta
     * 
     * @param uid del moneda
     * @return Moneda a buscar
     * @throws BbddException
     */
    public Tarjeta buscartTarjeta(String idTarjeta) throws BbddException {

        return obtenerTarjeta(idTarjeta);

    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Moneda
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     */
    private ArrayList<Tarjeta> obtenerListadoTarjeta(String sql) throws BbddException {
        ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();

        Tarjeta tarjeta = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = persistencia.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tarjeta = new Tarjeta();
                tarjeta.setidTarjeta(resultSet.getString("id_tarjeta"));
                tarjeta.setTitular(resultSet.getString("titular"));
                tarjeta.setFechaCaducidad(resultSet.getString("fechaCaducidad"));
                tarjeta.setCvv(resultSet.getInt("cvv"));

                listaTarjetas.add(tarjeta);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(connection, statement, resultSet);
        }
        return listaTarjetas;
    }

     /**
     * Funcion que obtiene el listado de todas las tarjetas
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Tarjeta> obtenerListadoTarjetas() throws BbddException {
        String sql = "SELECT * FROM Tarjeta";
        return obtenerListadoTarjeta(sql);
    }

    /**
     * Funcion que obtiene una tarjeta
     * 
     * @param idTarjeta de la tarjeta
     * @return lista total
     * @throws BbddException Error controlado
     */
    public Tarjeta obtenerTarjeta(String idTarjeta) throws BbddException {
        Tarjeta tarjeta = null;
        ArrayList<Tarjeta> listaTarjetas = null;
        String sql = "SELECT * FROM Tarjeta where id_tarjeta = ";
        sql = sql + "'" + idTarjeta + "'";
        listaTarjetas = obtenerListadoTarjeta(sql);
        if (!listaTarjetas.isEmpty()) {
            tarjeta = listaTarjetas.get(0);
        }

        return tarjeta;

    }

}
