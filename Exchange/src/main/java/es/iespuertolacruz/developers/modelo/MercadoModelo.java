package es.iespuertolacruz.developers.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.Mercado;
import es.iespuertolacruz.developers.api.Moneda;
import es.iespuertolacruz.developers.api.Wallet;
import es.iespuertolacruz.developers.excepcion.*;

public class MercadoModelo {

    SqliteDb persistencia;
    WalletModelo walletModelo;
    MonedaModelo monedaModelo;
    Mercado mercado;
    private static final String TABLA = "Mercado";
    
    /**
     * Constructor por defecto de la clase MercadoModelo
     * 
     * @throws FicheroException
     * @throws SQLException
     */
    public MercadoModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(TABLA,null, null);
    }

    /**
     * Metodo que permite insertar un mercado en la DB
     * 
     * @param mercado a insertar
     * @throws BbddException controlada
     */
    public void insertar(Mercado mercado) throws BbddException {
        String sql = "INSERT INTO Mercado (idMoneda, idWallet, cantidad)"
                + " VALUES ('" + mercado.getMoneda().getTicket()
                + "', '" + mercado.getWallet().getIdWallet()
                + "', '" + mercado.getCantidad()
                + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que permite modificar un mercado de la DB
     * 
     * @param mercado a modificar
     * @throws BbddException controlada
     */
    public void modificar(Mercado mercado) throws BbddException {
        String sql = "UPDATE Mercado SET WHERE idWallet = '" + mercado.getWallet().getIdWallet() + "' idMoneda = '" + mercado.getMoneda().getTicket() 
        + "', cantidad = '" + mercado.getCantidad()
        + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion encargada de realizar la busqueda de un mercado
     * 
     * @param uid del mercado
     * @return Mercado a buscar
     * @throws BbddException
     */
    public Mercado buscarMercado(String uid) throws BbddException {
        return obtenerMercado(uid);

    }

      /**
     * Funcion que obtiene el listado de todas las mercados
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Mercado> obtenerListado() throws BbddException {
        String sql = "SELECT * FROM Mercado";
        return obtenerListadoMercado(sql);
    }

    /**
     * Funcion que obtiene una mercado
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
     */
    public Mercado obtenerMercado(String idWallet) throws BbddException {
        Mercado mercado = null;
        ArrayList<Mercado> listaMercados = null;
        String sql = "SELECT * FROM Mercado where idWallet = '" + idWallet + "'";
        listaMercados = obtenerListadoMercado(sql);
        if (!listaMercados.isEmpty()) {
            mercado = listaMercados.get(0);
        }

        return mercado;

    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Mercado
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     */
    private ArrayList<Mercado> obtenerListadoMercado(String sql) throws BbddException {
        ArrayList<Mercado> listaMercados = new ArrayList<>();

        Mercado mercado = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = persistencia.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String idWallet = resultSet.getString("idWallet");
                String idMoneda = resultSet.getString("idMoneda");
                Double cantidad = resultSet.getDouble("cantidad");

                Wallet wallet = walletModelo.buscarWallet(idWallet);
                Moneda moneda = monedaModelo.obtenerMoneda(idMoneda);
                mercado = new Mercado(moneda, wallet, cantidad);
                listaMercados.add(mercado);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(connection, statement, resultSet);
        }
        return listaMercados;
    }
    
}
