package es.iespuertolacruz.developers.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.excepcion.BbddException;

public class Bbdd {

    private String driver;
    private String url;
    private String usuario;
    private String password;

    public Bbdd(String driver, String url, String usuario, String password) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    private Connection getConnection() throws BbddException {
        Connection connection = null;

        try {
            Class.forName(driver);
            if (usuario == null || password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                DriverManager.getConnection(url, usuario, password);
            }
        } catch (Exception exception) {
            throw new BbddException("No se ha podido establecer la coneccion con la BBDD", exception);
        }

        return connection;
    }

    // CRUD
    public void insertar(Usuario usuario) {

    }

    public void eliminar(Usuario usuario) {

    }

    public void modificar(Usuario usuario) {

    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Usuario
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException controlado
     */
    private ArrayList<Usuario> obtenerListado(String sql) throws BbddException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        Usuario usuario = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String uid = resultSet.getString("uid");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                int edad = resultSet.getInt("edad");
                String dni = resultSet.getString("dni");
                usuario = new Usuario(uid, nombre, apellidos, edad, dni);
                listaUsuarios.add(usuario);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConecction(connection, statement, resultSet);
        }
        return listaUsuarios;
    }

    /**
     * Funcion que obtiene el listado de todas las usuarios
     * 
     * @return lisa todal
     * @throws BbddException controlado
     */
    public ArrayList<Usuario> obtenerListado() throws BbddException {
        String sql = "SELECT * FROM Usuario";
        return obtenerListado(sql);
    }

    /**
     * Funcion que obtiene una usuario
     * 
     * @param
     * @return lisa todal
     * @throws BbddException controlado
     */
    public Usuario obtenerUsuario(String identificador) throws BbddException {
        Usuario usuario = null;
        ArrayList<Usuario> listaUsuarios = null;
        String sql = "SELECT * FROM Usuario where identificador = ";
        sql = sql + "'" + identificador + "'";
        listaUsuarios = obtenerListado(sql);
        if (!listaUsuarios.isEmpty()) {
            usuario = listaUsuarios.get(0);
        }

        return usuario;

    }

    private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws BbddException {
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
