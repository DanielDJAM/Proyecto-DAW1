package es.iespuertolacruz.developers.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.Wallet;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class WalletModelo {

    SqliteDb persistencia;
    private static final String TABLA = "Wallet";

    /**
     * Constructor por defecto de la clase WalletModelo
     * 
     * @throws FicheroException
     * @throws SQLException
     */
    public WalletModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(TABLA, null, null);
    }

    /**
     * Metodo que permite insertar un wallet en la DB
     * 
     * @param wallet a insertar
     * @throws BbddException controlada
     */
    public void insertar(Wallet wallet) throws BbddException {
        String sql = "INSERT INTO Wallet (idWallet, uid)" + " VALUES ('" + wallet.getIdWallet() + "', '"
                + wallet.getUid() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que permite eliminar un wallet de la DB
     * 
     * @param wallet a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Wallet wallet) throws BbddException {
        String sql = "DELETE from Wallet WHERE idWallet ='" + wallet.getIdWallet() + "'";
        persistencia.actualizar(sql);

    }

    /**
     * Funcion encargada de realizar la busqueda de un wallet
     * 
     * @param uid del wallet
     * @return Wallet a buscar
     * @throws BbddException
     */
    public Wallet buscarWallet(String uid) throws BbddException {
        return obtenerWallet(uid);

    }

    /**
     * Funcion que obtiene el listado de todas las wallets
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Wallet> obtenerListado() throws BbddException {
        String sql = "SELECT * FROM Wallet";
        return obtenerListadoWallet(sql);
    }

    /**
     * Funcion que obtiene una wallet
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
     */
    public Wallet obtenerWallet(String identificador) throws BbddException {
        Wallet wallet = null;
        ArrayList<Wallet> listaWalletes = null;
        String sql = "SELECT * FROM Wallet where idWallet = ";
        sql = sql + "'" + identificador + "'";
        listaWalletes = obtenerListadoWallet(sql);
        if (!listaWalletes.isEmpty()) {
            wallet = listaWalletes.get(0);
        }

        return wallet;

    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Wallet
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     */
    private ArrayList<Wallet> obtenerListadoWallet(String sql) throws BbddException {
        ArrayList<Wallet> listaWalletes = new ArrayList<>();

        Wallet wallet = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = persistencia.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                wallet = new Wallet();

                wallet.setIdWallet(resultSet.getString("idWallet"));
                wallet.setUid(resultSet.getString("uid"));

                listaWalletes.add(wallet);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(connection, statement, resultSet);
        }
        return listaWalletes;
    }

}
