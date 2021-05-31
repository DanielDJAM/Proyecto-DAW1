package es.iespuertolacruz.developers.controller;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Miembro;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.MiembroException;
import es.iespuertolacruz.developers.modelo.MiembroModelo;

public class MiembroController {

    private static final String EL_UID_ESTA_VACIO = "El UID esta vacio";
  
    MiembroModelo miembroModelo;

    /**
     * Constructor por defecto de la clase MiembroController
     * @throws BbddException
     * @throws FicheroException
     * @throws SQLException
     */
    public MiembroController() throws BbddException, FicheroException, SQLException{
        miembroModelo = new MiembroModelo();
    }

    /**
     * Metodo para validar miembros
     * @param miembro a validar
     * @throws MiembroException
     */
    public void validar(Miembro miembro) throws MiembroException{
        String mensaje = "";

        if (miembro == null){
            mensaje = "El miembro es nulo";
            throw new MiembroException(mensaje);
        }
        if(miembro.getUid() == null || miembro.getUid().isEmpty()) {
            mensaje = "El UID es nulo o vacio,";
        }

        if(miembro.getTipoUsuario() == null || miembro.getTipoUsuario().isEmpty()) {
            mensaje = "El tipo usuario es nulo o vacio,";
        }
        if (miembro.getEmail() == null || miembro.getEmail().isEmpty()) {
            mensaje += "El nombre es nulo o vacio,";
        }
        if (miembro.getContrasenia() == null || miembro.getContrasenia().isEmpty()) {
            mensaje += "Los apellidos son nulos o vacios,";
        }
        if (miembro.getDireccion() == null ) {
            mensaje += "Los datos de direccion estan vacios";
        }
       
        if (miembro.getTarjeta() == null) {
            mensaje += "Los datos de la tarjeta estan vacios";
        }
        if(!mensaje.isEmpty()) {
            throw new MiembroException(mensaje);
        }
    }

    /**
     * Metodo para insertar un miembro
     * @param miembro a insertar
     * @throws MiembroException
     * @throws FicheroException
     * @throws BbddException
     */
    public void insertar(Miembro miembro) throws MiembroException, BbddException {
        validar(miembro);
        if(existe(miembro)) {
            throw new MiembroException("El miembro ya existe");
        }
        miembroModelo.insertar(miembro);
    }

    /**
     * Metodo para eliminar un miembro
     * @param miembro a eliminar
     * @throws FicheroException
     * @throws MiembroException
     * @throws BbddException
     */
    public void eliminar(Miembro miembro) throws  MiembroException, BbddException{
        validar(miembro);
        if (!existe(miembro)) {
          throw new MiembroException("El miembro no existe");
        }
        miembroModelo.eliminar(miembro);
    }

    /**
     * Metodo para modificar de la clase MiembroController.
     * 
     * @param miembro  a modificar.
     * @throws FicheroException
     * @throws BbddException
     * @throws MiembroException
     */
    public void modificar(Miembro miembro) throws  BbddException, MiembroException{
        validar(miembro);
        if(!existe(miembro)){
            throw new MiembroException("El miembro no existe");
        }
        miembroModelo.modificar(miembro);
    }

    /**
     * Funcion que busca un miembro por su UID
     * @param uid del miembro a buscar
     * @return un miembro
     * @throws MiembroException
     * @throws FicheroException
     * @throws BbddException
     */
    public Miembro buscar(String uid) throws MiembroException, BbddException {
        Miembro miembro = null;
        if (uid == null || uid.isEmpty()) {
            throw new MiembroException(EL_UID_ESTA_VACIO);
        }
        miembro = miembroModelo.obtenerMiembroUid(uid);
        return miembro;
    }

    /**
     * Funcion que busca un miembro por su dni
     * @param uid del miembro a buscar
     * @return un miembro
     * @throws MiembroException
     * @throws FicheroException
     * @throws BbddException
     */
    public Miembro buscarDni(String dni) throws MiembroException, BbddException {
        Miembro miembro = null;
        if (dni == null || dni.isEmpty()) {
            throw new MiembroException(EL_UID_ESTA_VACIO);
        }
        miembro = miembroModelo.obtenerMiembroUid(dni);
        return miembro;
    }


    /**
     * Funcion que verifica si existe un miembro
     * @param uid por el que se busca
     * @return True/false si se ha encontrado
     * @throws MiembroException
     * @throws FicheroException
     * @throws BbddException
     */
    public boolean existe(Miembro miembro) throws MiembroException, BbddException {
        boolean encontrado = false;
        Miembro miembroEncontrado;
        miembroEncontrado = buscar(miembro.getUid());
        if (miembroEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }
    
}
