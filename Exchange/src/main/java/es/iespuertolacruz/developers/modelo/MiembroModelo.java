package es.iespuertolacruz.developers.modelo;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Miembro;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class MiembroModelo {

    SqliteDb persistencia;

    /**
     * Constructor por defecto de la clase MiembroModelo
     * 
     * @throws FicheroException
     * @throws SQLException
     */
    public MiembroModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(null, null);
    }

    /**
     * Metodo que permite insertar un miembro en la DB
     * 
     * @param miembro a insertar
     * @throws BbddException controlada
     */
    public void insertar(Miembro miembro) throws BbddException {
        String sql = "INSERT INTO Miembro (uid, dni, email, contrasenia,id_direccion, id_wallet, id_tarjeta)"
                + " VALUES ('" + miembro.getUid()
                + "', '" + miembro.getDatosPersonales().getDni()
                + "', '" + miembro.getEmail() 
                + "', '" + miembro.getContrasenia()
                + "', '" + miembro.getDireccion() 
                + "', '" + miembro.getWallet() 
                + "','" + miembro.getTarjeta() 
                + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que permite eliminar un miembro de la DB
     * 
     * @param miembro a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(Miembro miembro) throws BbddException {
        String sql = "DELETE from Miembro WHERE uid ='" + miembro.getUid() + "'";
        persistencia.actualizar(sql);

    }

    /**
     * Metodo que permite modificar un miembro de la DB
     * 
     * @param miembro a modificar
     * @throws BbddException controlada
     */
    public void modificar(Miembro miembro) throws BbddException {
        String sql = "UPDATE Miembro SET email = '" + miembro.getEmail() + "', contrasenia = '" + miembro.getContrasenia() 
                + "' WHERE uid = '" + miembro.getUid() + "'";
        persistencia.actualizar(sql);
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
