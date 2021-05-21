package es.iespuertolacruz.developers.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.api.Moneda;
import es.iespuertolacruz.developers.api.Miembro;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class Bbdd {
    
    private static final String TABLE = "TABLE";
    Direccion direccion;
    
    private static final String NOMBRE_TABLAS = "Miembro,Direccion,Moneda,Wallet,Mercado";
    private String driver;
    private String url;
    private String miembro;
    private String password;
    ArrayList<String> listaTablas;

    public Bbdd(String driver, String url, String miembro, String password) throws FicheroException, BbddException, SQLException {
        this.driver = driver;
        this.url = url;
        this.miembro = miembro;
        this.password = password;
        if(listaTablas == null) {
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
    private Connection getConnection() throws BbddException {
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

   
    private void init() throws FicheroException, BbddException, SQLException  {
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

    // CRUD Miembro

    /**
     * Metodo que permite insertar un miembro en la DB
     * 
     * @param miembro a insertar
     * @throws BbddException controlada
     */
    public void insertar(Miembro miembro) throws BbddException {
        String sql = "INSERT INTO Miembro (uid, dni, nombre, apellidos, edad, email, contrasenia,id_direccion)" + " VALUES ('" + miembro.getUid()
                + "', '" + miembro.getDni() + "', '" + miembro.getNombre() + "', '" + miembro.getApellidos() + "', "
                + miembro.getEdad() +"','" + miembro.getEmail() +"','"+ 
                miembro.getContrasenia()+"','"+ miembro.getDireccion() +"')";
        actualizar(sql);
    }

    /**
     * Metodo que permite eliminar un miembro de la DB
     * 
     * @param miembro a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Miembro miembro) throws BbddException {
        String sql = "DELETE from Miembro WHERE uid ='" + miembro.getUid() + "'";
        actualizar(sql);

    }

    /**
     * Metodo que permite modificar un miembro de la DB
     * 
     * @param miembro a modificar
     * @throws BbddException controlada
     */
    public void modificar(Miembro miembro) throws BbddException {
        String sql = "UPDATE Miembro SET uid = '" + miembro.getUid() + "', dni = '" + miembro.getDni() + "', nombre = '"
                + miembro.getNombre() + "', apellidos = '" + miembro.getApellidos() + "' , edad = '" + miembro.getEdad()
                + "' WHERE uid = '" + miembro.getUid() + "'";
        actualizar(sql);
    }

    // CRUD Moneda

    /**
     * Metodo que permiter insertar una moneda en la DB
     * 
     * @param moneda a insertar
     * @throws BbddException controlada
     */
    public void insertar(Moneda moneda) throws BbddException {
        String sql = "INSERT INTO Moneda (nombreMoneda, ticket, valor)" + " VALUES ('" + moneda.getNombreMoneda()
                + "', '" + moneda.getTicket() + "'," + "'" + moneda.getValor() + "')";
        actualizar(sql);
    }

    /**
     * Metodo que permite elimnar una moneda de la DB
     * 
     * @param moneda a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Moneda moneda) throws BbddException {
        String sql = "DELETE from Moneda WHERE ticket ='" + moneda.getTicket() + "'";
        actualizar(sql);

    }

    /**
     * Metodo que permite modificar una moneda e la DB
     * 
     * @param moneda a modificar
     * @throws BbddException controlada
     */
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
            closeConnection(connection, statement, null);
        }

    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Miembro
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     */
    private ArrayList<Miembro> obtenerListado(String sql) throws BbddException {
        ArrayList<Miembro> listaMiembros = new ArrayList<>();

        Miembro miembro = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String uid = resultSet.getString("uid");
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                int edad = resultSet.getInt("edad");

                // miembro = new Miembro(uid, nombre, apellidos, edad, dni, direccion );
                // MODIFICAR!!!!!!
                listaMiembros.add(miembro);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaMiembros;
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
            closeConnection(connection, statement, resultSet);
        }
        return listaMonedas;
    }

    /**
     * Funcion que obtiene el listado de todas las miembros
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Miembro> obtenerListado() throws BbddException {
        String sql = "SELECT * FROM Miembro";
        return obtenerListado(sql);
    }

    /**
     * Funcion que obtiene el listado de todas las monedas
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Miembro> obtenerListadoMonedas() throws BbddException {
        String sql = "SELECT * FROM Moneda";
        return obtenerListado(sql);
    }

    /**
     * Funcion que obtiene una miembro
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
     */
    public Miembro obtenerMiembro(String identificador) throws BbddException {
        Miembro miembro = null;
        ArrayList<Miembro> listaMiembros = null;
        String sql = "SELECT * FROM Miembro where uid = ";
        sql = sql + "'" + identificador + "'";
        listaMiembros = obtenerListado(sql);
        if (!listaMiembros.isEmpty()) {
            miembro = listaMiembros.get(0);
        }

        return miembro;

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
        String sql = "SELECT * FROM Moneda where ticket = ";
        sql = sql + "'" + ticket + "'";
        listaMonedas = obtenerListadoMoneda(sql);
        if (!listaMonedas.isEmpty()) {
            moneda = listaMonedas.get(0);
        }

        return moneda;

    }

    private void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws BbddException {
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
