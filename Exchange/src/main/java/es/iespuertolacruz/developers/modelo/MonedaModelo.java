package es.iespuertolacruz.developers.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.Moneda;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class MonedaModelo {
    SqliteDb persistencia;
    private static final String TABLA = "Moneda";

    /**
     * Constructor por defecto de la clase MonedaModelo
     * 
     * @throws BbddException
     * @throws FicheroException
     * @throws SQLException
     */
    public MonedaModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(TABLA, null, null);
    }

    /**
     * Metodo que permiter insertar una moneda en la DB
     * 
     * @param moneda a insertar
     * @throws BbddException controlada
     */
    public void insertar(Moneda moneda) throws BbddException {
        String sql = "INSERT INTO Moneda (ticket, nombreMoneda, valor) VALUES ('" + moneda.getTicket() 
        + "', '" + moneda.getNombreMoneda() 
        + "', '" + moneda.getValor() 
        + "')";
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
        String sql = "UPDATE Moneda SET valor ='" + moneda.getValor()+
        "' where ticket = '" +moneda.getTicket() + "'";
        persistencia.actualizar(sql);
    }

   
    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Moneda
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     */
    private ArrayList<Moneda> obtenerListadoMoneda(String sql) throws BbddException {
        ArrayList<Moneda> listaMonedas = new ArrayList<>();

        Moneda moneda = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = persistencia.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                moneda = new Moneda();
                moneda.setTicket(resultSet.getString("ticket"));
                moneda.setNombreMoneda(resultSet.getString("nombreMoneda"));
                moneda.setValor(resultSet.getDouble("valor"));
                listaMonedas.add(moneda);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(connection, statement, resultSet);
        }
        return listaMonedas;
    }

    /**
     * Funcion que obtiene el listado de todas las monedas
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Moneda> obtenerListadoMonedas() throws BbddException {
        String sql = "SELECT * FROM Moneda";
        return obtenerListadoMoneda(sql);
    }

    /**
     * Funcion que obtiene una moneda
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
     */
    public Moneda obtenerMoneda(String ticket) throws BbddException {
        Moneda moneda = null;
        ArrayList<Moneda> listaMonedas = null;
        String sql = "SELECT * FROM Moneda where ticket = '" + ticket + "'";
        listaMonedas = obtenerListadoMoneda(sql);
        if (!listaMonedas.isEmpty()) {
            moneda = listaMonedas.get(0);
        }
        return moneda;
    }

<<<<<<< HEAD
    /**
     * Funcion que lista Top 10 monedas
     * @return las monedas listadas
     * @throws BbddException error
     */
    public Moneda listarTop10() throws BbddException {
        Moneda moneda = null;
        ArrayList<Moneda> listaMonedas = null;
        String sql = "SELECT * FROM Moneda order by valor DESC limit 10";
        listaMonedas = obtenerListadoMoneda(sql);
        if (!listaMonedas.isEmpty()) {
            moneda = listaMonedas.get(0);
        }
        return moneda;
    }

    /**
     * Funcion que lista por un numero determinado de monedas
     * @param limite numero de monedas a listar
     * @return lista de monedas 
     * @throws BbddException error
     */
    public ArrayList<Moneda> listarMonedas(int limite) throws BbddException {
        ArrayList<Moneda> listaMonedas = null;
        String sql = "SELECT * FROM Moneda order by valor DESC limit '" + limite + "'";
        listaMonedas = obtenerListadoMoneda(sql);
        return listaMonedas;
    }

    public int contarTodo() throws BbddException {
        Integer cuenta = 0;
        String sql = "SELECT count(*) FROM Moneda";
        cuenta = obtenerListadoMoneda(sql).indexOf(0);
        return cuenta;

    }
=======

     
>>>>>>> 03d3faf504214d760971231a48e1187bb8f24b09

}
