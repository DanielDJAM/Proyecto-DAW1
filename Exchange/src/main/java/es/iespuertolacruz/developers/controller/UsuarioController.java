package es.iespuertolacruz.developers.controller;

import java.sql.SQLException;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.UsuarioException;
import es.iespuertolacruz.developers.modelo.UsuarioModelo;

public class UsuarioController {

    private static final String EL_UID_ESTA_VACIO = "El UID esta vacio";
    private static final int EDAD_MINIMA = 18;
    UsuarioModelo usuarioModelo;

    /**
     * Constructor por defecto de la clase UsuarioController
     * @throws BbddException
     * @throws FicheroException
     * @throws SQLException
     */
    public UsuarioController() throws BbddException, FicheroException, SQLException{
        usuarioModelo = new UsuarioModelo();
    }

    /**
     * Metodo para validar usuarios
     * @param usuario a validar
     * @throws UsuarioException
     */
    public void validar(Usuario usuario) throws UsuarioException{
        String mensaje = "";

        if (usuario == null){
            mensaje = "El usuario es nulo";
            throw new UsuarioException(mensaje);
        }
        if(usuario.getUid() == null || usuario.getUid().isEmpty()) {
            mensaje = "El UID es nulo o vacio,";
        }
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            mensaje += "El nombre es nulo o vacio,";
        }
        if (usuario.getApellidos() == null || usuario.getApellidos().isEmpty()) {
            mensaje += "Los apellidos son nulos o vacios,";
        }
        if (usuario.getEdad() < EDAD_MINIMA) {
            mensaje += "La edad minima (" + EDAD_MINIMA + ") no se cumple,";
        }
        if (usuario.getDni() == null || usuario.getDni().isEmpty()) {
            mensaje += "El DNI es nulo o vacio";
        }
        if(!mensaje.isEmpty()) {
            throw new UsuarioException(mensaje);
        }
    }

    /**
     * Metodo para insertar un usuario
     * @param usuario a insertar
     * @throws UsuarioException
     * @throws FicheroException
     * @throws BbddException
     */
    public void insertar(Usuario usuario) throws UsuarioException, BbddException {
        validar(usuario);
        if(existe(usuario)) {
            throw new UsuarioException("El usuario ya existe");
        }
        usuarioModelo.insertar(usuario);
    }

    /**
     * Metodo para eliminar un usuario
     * @param usuario a eliminar
     * @throws FicheroException
     * @throws UsuarioException
     * @throws BbddException
     */
    public void eliminar(Usuario usuario) throws  UsuarioException, BbddException{
        validar(usuario);
        if (!existe(usuario)) {
          throw new UsuarioException("El usuario no existe");
        }
        usuarioModelo.eliminar(usuario);
    }

    /**
     * Metodo para modificar de la clase UsuarioController.
     * 
     * @param usuario  a modificar.
     * @param usuario2 usuario con modificaciones.
     * @throws FicheroException
     * @throws BbddException
     * @throws UsuarioException
     */
    public void modificar(Usuario usuario) throws  BbddException, UsuarioException{
        validar(usuario);
        if(!existe(usuario)){
            throw new UsuarioException("El usuario no existe");
        }
        usuarioModelo.modificar(usuario);
    }

    /**
     * Funcion que busca un usuario por su UID
     * @param uid del usuario a buscar
     * @return un usuario
     * @throws UsuarioException
     * @throws FicheroException
     * @throws BbddException
     */
    public Usuario buscar(String uid) throws UsuarioException, BbddException {
        Usuario usuario = null;
        if (uid == null || uid.isEmpty()) {
            throw new UsuarioException(EL_UID_ESTA_VACIO);
        }
        usuario = usuarioModelo.buscarUsuario(uid);
        return usuario;
    }

    /**
     * Funcion que verifica si existe un usuario
     * @param uid por el que se busca
     * @return True/false si se ha encontrado
     * @throws UsuarioException
     * @throws FicheroException
     * @throws BbddException
     */
    public boolean existe(Usuario usuario) throws UsuarioException, BbddException {
        boolean encontrado = false;
        Usuario usuarioEncontrado;
        usuarioEncontrado = buscar(usuario.getUid());
        if (usuarioEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }
    
}
