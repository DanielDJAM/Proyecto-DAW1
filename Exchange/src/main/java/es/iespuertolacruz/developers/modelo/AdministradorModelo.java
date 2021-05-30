package es.iespuertolacruz.developers.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iespuertolacruz.developers.api.Administrador;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class AdministradorModelo {
    SqliteDb persistencia;

    /**
     * Constructor por defecto de la clase AdministradorModelo
     * 
     * @throws FicheroException
     * @throws SQLException
     */
    public AdministradorModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(null, null);
    }

 

 


    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla DatosPersonales
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     */
    private ArrayList<Administrador> obtenerListadoAdministrador(String sql) throws BbddException {
        ArrayList<Administrador> listaAdministradores = new ArrayList<>();

        Administrador administrador = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = persistencia.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                administrador = new Administrador();

                administrador.setUid(resultSet.getString("uid"));
                administrador.setEmail(resultSet.getString("email"));
                administrador.setContrasenia(resultSet.getString("contrasenia"));
               
               

                listaAdministradores.add(administrador);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(connection, statement, resultSet);
        }
        return listaAdministradores;
    }

}
