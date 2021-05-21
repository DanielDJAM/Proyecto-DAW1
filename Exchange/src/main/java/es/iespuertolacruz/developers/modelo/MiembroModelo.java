package es.iespuertolacruz.developers.modelo;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Miembro;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class MiembroModelo {

    
    SqliteDb persistencia;

    /**
     * Constructor por defecto de la clase MiembroModelo
     * @throws FicheroException
     * @throws SQLException
     */
    public MiembroModelo() throws BbddException, FicheroException, SQLException{
        persistencia = new SqliteDb(null, null);
    }

    /**
     * Metodo encargado de realizar la insercion de un miembro
     * 
     * @param miembro a insertar
     * @throws BbddException controlada
     */
    public void insertar(Miembro miembro) throws BbddException {
        persistencia.insertar(miembro);
    }

    /**
     * Metodo encargado de realizar la eleminacion de un miembro
     * 
     * @param miembro a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Miembro miembro) throws BbddException {
        persistencia.eliminar(miembro);
    }

    /**
     * Metodo encargado de realizar la modificacion de un miembro
     * 
     * @param miembro a modificar
     */
    public void modificar(Miembro miembro) throws BbddException {
        persistencia.modificar(miembro);
    }

    /**
     * Funcion encargada de realizar la busqueda de un miembro
     * 
     * @param uid del miembro
     * @return Miembro a buscar
     * @throws BbddException
     */
    public Miembro buscarMiembro(String uid) throws BbddException {
       return persistencia.obtenerMiembro(uid);
       
    }

}
