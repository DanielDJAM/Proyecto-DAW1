package es.iespuertolacruz.developers.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class DireccionModelo {

    SqliteDb persistencia;
    private static final String TABLA = "Direccion";
    
    /**
     * Constructor por defecto de la clase DireccionModelo
     * 
     * @throws FicheroException
     * @throws SQLException
     */
    public DireccionModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(TABLA,null, null);
    }

    /**
     * Metodo que permite insertar un direccion en la DB
     * 
     * @param direccion a insertar
     * @throws BbddException controlada
     */
    public void insertar(Direccion direccion) throws BbddException {
        String sql = "INSERT INTO Direccion (idDireccion, codigoPostal, calle, puerta,provincia, pais)"
                + " VALUES ('" + direccion.getIdDireccion()
                + "', '" + direccion.getCodigoPostal()
                + "', '" + direccion.getCalle()
                + "', '" + direccion.getPuerta()
                + "', '" + direccion.getProvincia() 
                + "', '" + direccion.getPais() 
                + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que permite eliminar un direccion de la DB
     * 
     * @param direccion a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Direccion direccion) throws BbddException {
        String sql = "DELETE from Direccion WHERE idDireccion ='" + direccion.getIdDireccion() + "'";
        persistencia.actualizar(sql);

    }

    /**
     * Metodo que permite modificar un direccion de la DB
     * 
     * @param direccion a modificar
     * @throws BbddException controlada
     */
    public void modificar(Direccion direccion) throws BbddException {
        String sql = "UPDATE Direccion SET codigoPostal = '" + direccion.getCodigoPostal() 
        + "', calle = '" + direccion.getCalle()
        + "', puerta = '" + direccion.getPuerta()
        + "', provincia = '" + direccion.getProvincia()
        + "', pais = '" + direccion.getPais() 
        + "' WHERE uid = '" + direccion.getIdDireccion() + "'";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion encargada de realizar la busqueda de un direccion
     * 
     * @param uid del direccion
     * @return Direccion a buscar
     * @throws BbddException
     */
    public Direccion buscarDireccion(String uid) throws BbddException {
        return obtenerDireccion(uid);

    }

      /**
     * Funcion que obtiene el listado de todas las direccions
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Direccion> obtenerListado() throws BbddException {
        String sql = "SELECT * FROM Direccion";
        return obtenerListadoDireccion(sql);
    }

    /**
     * Funcion que obtiene una direccion
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
     */
    public Direccion obtenerDireccion(String identificador) throws BbddException {
        Direccion direccion = null;
        ArrayList<Direccion> listaDirecciones = null;
        String sql = "SELECT * FROM Direccion where idDireccion = ";
        sql = sql + "'" + identificador + "'";
        listaDirecciones = obtenerListadoDireccion(sql);
        if (!listaDirecciones.isEmpty()) {
            direccion = listaDirecciones.get(0);
        }

        return direccion;

    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Direccion
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     */
    private ArrayList<Direccion> obtenerListadoDireccion(String sql) throws BbddException {
        ArrayList<Direccion> listaDirecciones = new ArrayList<>();

        Direccion direccion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = persistencia.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                direccion = new Direccion();
                direccion.setIdDireccion(resultSet.getString("idDireccion"));
                direccion.setCodigoPostal(resultSet.getString("codigoPostal"));
                direccion.setCalle(resultSet.getString("calle")); 
                direccion.setPuerta(resultSet.getString("puerta"));
                direccion.setProvincia(resultSet.getString("provincia"));
                direccion.setPais(resultSet.getString("pais"));

                listaDirecciones.add(direccion);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(connection, statement, resultSet);
        }
        return listaDirecciones;
    }
    
}
