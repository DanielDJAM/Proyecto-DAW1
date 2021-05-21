package es.iespuertolacruz.developers.modelo;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class UsuarioModelo {

    
    SqliteDb persistencia;

    /**
     * Constructor por defecto de la clase UsuarioModelo
     * @throws FicheroException
     * @throws SQLException
     */
    public UsuarioModelo() throws BbddException, FicheroException, SQLException{
        persistencia = new SqliteDb(null, null);
    }

    /**
     * Metodo encargado de realizar la insercion de un usuario
     * 
     * @param usuario a insertar
     * @throws BbddException controlada
     */
    public void insertar(Usuario usuario) throws BbddException {
        persistencia.insertar(usuario);
    }

    /**
     * Metodo encargado de realizar la eleminacion de un usuario
     * 
     * @param usuario a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Usuario usuario) throws BbddException {
        persistencia.eliminar(usuario);
    }

    /**
     * Metodo encargado de realizar la modificacion de un usuario
     * 
     * @param usuario a modificar
     */
    public void modificar(Usuario usuario) throws BbddException {
        persistencia.modificar(usuario);
    }

    /**
     * Funcion encargada de realizar la busqueda de un usuario
     * 
     * @param uid del usuario
     * @return Usuario a buscar
     * @throws BbddException
     */
    public Usuario buscarUsuario(String uid) throws BbddException {
       return persistencia.obtenerUsuario(uid);
       
    }

}
