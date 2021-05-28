package es.iespuertolacruz.developers.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class Bbdd {

    private static final String TABLE = "TABLE";
    Direccion direccion;

    private static final String NOMBRE_TABLAS = "Direccion,DatosPersonales,Tarjeta,Miembro,Wallet,Moneda,Mercado,";
    private String driver;
    private String url;
    private String miembro;
    private String password;
    ArrayList<String> listaTablas;

    public Bbdd(String driver, String url, String miembro, String password)
            throws FicheroException, BbddException, SQLException {
        this.driver = driver;
        this.url = url;
        this.miembro = miembro;
        this.password = password;
        if (listaTablas == null) {
            listaTablas = new ArrayList<>();
            String[] nombresTablas = NOMBRE_TABLAS.split(",");
            Collections.addAll(listaTablas, nombresTablas);
        }
        init();
    }

    /**
     * Funcion encargada de realizar la conexion con la BBDD
     * 
     * @return la conexion
     * @throws BbddException error controlado
     */
    protected Connection getConnection() throws BbddException {
        Connection connection = null;

        try {
            Class.forName(driver);
            if (miembro == null || password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                DriverManager.getConnection(url, miembro, password);
            }
        } catch (Exception exception) {
            throw new BbddException("No se ha podido establecer la coneccion con la BBDD", exception);
        }

        return connection;
    }

    private void init() throws FicheroException, BbddException, SQLException {
        DatabaseMetaData databaseMetaData;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> listaTablas = new ArrayList<>();

        String[] convertir = NOMBRE_TABLAS.split(",");
        List<String> nombreTablas = Arrays.asList(convertir);

        try {
            connection = getConnection();
            databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getTables(null, null, null, new String[] { TABLE });
            while (resultSet.next()) {
                listaTablas.add(resultSet.getString("TABLE_NAME"));
            }
            for (String tabla : nombreTablas) {
                if (!listaTablas.contains(tabla)) {
                    String sqlCrearTabla = new Fichero().leer("resources/sqlite/" + tabla + "Crear.sql");
                    actualizar(sqlCrearTabla);
                    String sqlInsertarDatos = new Fichero().leer("resources/sqlite/" + tabla + "-insertar.sql");
                    actualizar(sqlInsertarDatos);
                }
            }
        } catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la inicializacion de la BBDD", e);
        } finally {
            closeConnection(connection, null, resultSet);
        }

    }

    public ResultSet buscarElemento(String sql) throws BbddException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new BbddException("Se ha producido un error al buscar elemento Bbdd", e);
        } 
         
         
         return resultSet;
     }

    /**
     * Metodo encargado de realizar la actualizacion de la BBDD
     * 
     * @param sql a ejecutar
     * @throws ExceptionException Error controlado
     */
    protected void actualizar(String sql) throws BbddException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql); // actualiza la base de datos con la sentencia sql
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConnection(connection, statement, null);
        }

    }

   

    protected void closeConnection(Connection connection, Statement statement, ResultSet resultSet)
            throws BbddException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error cerrando la coneccion", exception);
        }

    }

}
