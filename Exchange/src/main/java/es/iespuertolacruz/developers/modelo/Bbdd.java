package es.iespuertolacruz.developers.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.Moneda;
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

    // CRUD Usuario
    public void insertar(Usuario usuario) throws BbddException {
        String sql = "INSER INTO Usuario (uid, dni, nombre, apellidos, edad)" + " VALUES ('" + usuario.getUid() + "', '"
                + usuario.getDni() + "'," + "'" + usuario.getNombre() + "', '" + usuario.getApellidos() + "')";
        actualizar(sql);
    }

    public void eliminar(Usuario usuario) throws BbddException {
        String sql = "DELETE from Usuario WHERE uid ='" + usuario.getUid() + "'";
        actualizar(sql);

    }

    public void modificar(Usuario usuario) throws BbddException {
        String sql = "UPDATE Usuario SET nombre ='" + usuario.getNombre();
        actualizar(sql);
    }

    // CRUD Moneda
    public void insertar(Moneda moneda) throws BbddException {
        String sql = "INSER INTO Moneda (nombreMoneda, ticket, valor)" + " VALUES ('" + moneda.getNombreMoneda()
                + "', '" + moneda.getTicket() + "'," + "'" + moneda.getValor() + "')";
        actualizar(sql);
    }

    public void eliminar(Moneda moneda) throws BbddException {
        String sql = "DELETE from Moneda WHERE ticket ='" + moneda.getTicket() + "'";
        actualizar(sql);

    }

    public void modificar(Moneda moneda) throws BbddException {
        String sql = "UPDATE Moneda SET valor ='" + moneda.getValor();
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la actualizacion de la BBDD
     * 
     * @param sql a ejecutar
     * @throws ExceptionException Error controlado
     */
    private void actualizar(String sql) throws BbddException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql); // actualiza la base de datos con la sentencia sql
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConecction(connection, statement, null);
        }

    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Usuario
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
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
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nombreMoneda = resultSet.getString("nombreMoneda");
                String ticket = resultSet.getString("ticket");
                double valor = resultSet.getDouble("valor");
                moneda = new Moneda(nombreMoneda, ticket, valor);
                listaMonedas.add(moneda);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConecction(connection, statement, resultSet);
        }
        return listaMonedas;
    }

    /**
     * Funcion que obtiene el listado de todas las usuarios
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Usuario> obtenerListado() throws BbddException {
        String sql = "SELECT * FROM Usuario";
        return obtenerListado(sql);
    }

    /**
     * Funcion que obtiene el listado de todas las monedas
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Usuario> obtenerListadoMonedas() throws BbddException {
        String sql = "SELECT * FROM Moneda";
        return obtenerListado(sql);
    }

    /**
     * Funcion que obtiene una usuario
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
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
        String sql = "SELECT * FROM Moneda where identificador = ";
        sql = sql + "'" + ticket + "'";
        listaMonedas = obtenerListadoMoneda(sql);
        if (!listaMonedas.isEmpty()) {
            moneda = listaMonedas.get(0);
        }

        return moneda;

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
