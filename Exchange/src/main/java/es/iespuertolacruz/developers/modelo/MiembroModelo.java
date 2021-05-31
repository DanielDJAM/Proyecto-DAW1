package es.iespuertolacruz.developers.modelo;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;


import es.iespuertolacruz.developers.api.Miembro;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class MiembroModelo {
    private static final String TABLA = "Miembro";
    SqliteDb persistencia;
    DireccionModelo direccionModelo;
    TarjetaModelo tarjetaModelo;
    DatosPersonalesModelo datosPersonalesModelo;


    
    /**
     * Constructor por defecto de la clase MiembroModelo
     * 
     * @throws FicheroException
     * @throws SQLException
     */
    public MiembroModelo() throws BbddException, FicheroException, SQLException {
        persistencia = new SqliteDb(TABLA,null, null);
        direccionModelo = new DireccionModelo();
        tarjetaModelo = new TarjetaModelo();
        datosPersonalesModelo = new DatosPersonalesModelo();

    }

    /**
     * Metodo que permite insertar un miembro en la DB
     * 
     * @param miembro a insertar
     * @throws BbddException controlada
     */
    public void insertar(Miembro miembro) throws BbddException {
        String sql = "INSERT INTO Miembro (uid, dni,tipo, email, contrasenia,idDireccion,idTarjeta)"
                + " VALUES ('" + miembro.getUid()
                + "', '" + miembro.getDatosPersonales().getDni()
                + "', '" + miembro.getTipoUsuario()
                + "', '" + miembro.getEmail() 
                + "', '" + miembro.getContrasenia()
                + "', '" + miembro.getDireccion().getIdDireccion() 
                + "','" + miembro.getTarjeta().getidTarjeta() 
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
        return obtenerMiembro(uid);

    }

      /**
     * Funcion que obtiene el listado de todas las miembros
     * 
     * @return lista total
     * @throws BbddException Error controlado
     */
    public ArrayList<Miembro> obtenerListado() throws BbddException {
        String sql = "SELECT * FROM Miembro";
        return obtenerListadoMiembro(sql);
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
        listaMiembros = obtenerListadoMiembro(sql);
        if (!listaMiembros.isEmpty()) {
            miembro = listaMiembros.get(0);
        }

        return miembro;

    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Miembro
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     */
    private ArrayList<Miembro> obtenerListadoMiembro(String sql) throws BbddException {
        ArrayList<Miembro> listaMiembros = new ArrayList<>();
        ResultSet resultSet = null;
        Miembro miembro = null;
       
        try {
            
            resultSet = persistencia.buscarElemento(sql);
            while (resultSet.next()) {
                miembro = new Miembro();



                listaMiembros.add(miembro);
            }
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaMiembros;
    }



}
