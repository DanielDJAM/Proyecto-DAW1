package es.iespuertolacruz.developers.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.DatosPersonales;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class DatosPersonalesModelo {

    SqliteDb persistencia;
    private static final String TABLA = "DatosPersonales";

    /**
     * Constructor por defecto de la clase DatosPersonalesModelo
     * 
     * @throws FicheroException
     * @throws SQLException
     */
    public DatosPersonalesModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(TABLA, null, null);
    }

    /**
     * Metodo que permiter insertar los atributos que tiene la clase DatosPersonales
     * en la DB
     * 
     * @param datosPersonales a insertar
     * @throws BbddException controlada
     */
    public void insertar(DatosPersonales datosPersonales) throws BbddException {
        String sql = "INSERT INTO DatosPersonales (dni, nombre, apellidos, edad)" + " VALUES ('"
                + datosPersonales.getDni() + "', '" + datosPersonales.getNombre() + "'," + "'"
                + datosPersonales.getApellidos() + "','" + datosPersonales.getEdad() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que permite eliminar los datos personales de la DB
     * 
     * @param datosPersonales a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(DatosPersonales datosPersonales) throws BbddException {
        String sql = "DELETE from DatosPersonales WHERE dni ='" + datosPersonales.getDni() + "'";
        persistencia.actualizar(sql);

    }

    /**
     * Metodo que permite modificar los datos personales en la DB
     * 
     * @param datosPersonales a modificar
     * @throws BbddException controlada
     */
    public void modificar(DatosPersonales datosPersonales) throws BbddException {
        String sql = "UPDATE DatosPersonales SET nombre ='" + datosPersonales.getNombre() + "', apellidos = '"
                + datosPersonales.getApellidos() + "', edad = '" + datosPersonales.getEdad() + "' WHERE dni = '"
                + datosPersonales.getDni() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion encargada de realizar la busqueda de los datos personales
     * 
     * @param dni del miembro
     * @return datos personales del miembro
     * @throws BbddException
     */
    public DatosPersonales buscarDatosPersonales(String dni) throws BbddException {

        return obtenerDatosPersonales(dni);

    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla DatosPersonales
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     */
    private ArrayList<DatosPersonales> obtenerListadoDatosPersonales(String sql) throws BbddException {
        ArrayList<DatosPersonales> listaDatosPersonales = new ArrayList<>();

        DatosPersonales datosPersonales = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = persistencia.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                datosPersonales = new DatosPersonales();

                datosPersonales.setDni(resultSet.getString("dni"));
                datosPersonales.setNombre(resultSet.getString("nombre"));
                datosPersonales.setApellidos(resultSet.getString("apellidos"));
                datosPersonales.setEdad(resultSet.getInt("edad"));

                listaDatosPersonales.add(datosPersonales);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(connection, statement, resultSet);
        }
        return listaDatosPersonales;
    }

    /**
     * Funcion que obtiene el listado de todos los datos personales de la Db
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<DatosPersonales> obtenerListadoDatosPersonales() throws BbddException {
        String sql = "SELECT * FROM DatosPesonales";
        return obtenerListadoDatosPersonales(sql);
    }

    /**
     * Funcion que obtiene una miembro
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
     */
    public DatosPersonales obtenerDatosPersonales(String dni) throws BbddException {
        DatosPersonales datosPersonales = null;
        ArrayList<DatosPersonales> listaDatosPersonales = null;
        String sql = "SELECT * FROM DatosPersonales where dni = ";
        sql = sql + "'" + dni + "'";
        listaDatosPersonales = obtenerListadoDatosPersonales(sql);
        if (!listaDatosPersonales.isEmpty()) {
            datosPersonales = listaDatosPersonales.get(0);
        }

        return datosPersonales;

    }

}
