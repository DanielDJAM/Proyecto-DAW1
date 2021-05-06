package es.iespuertolacruz.developers.controller;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.UsuarioException;
import es.iespuertolacruz.developers.modelo.UsuarioModelo;

public class UsuarioController {

    private static final String EL_UID_ESTA_VACIO = "El UID esta vacio";
    private static final int EDAD_MINIMA = 18;
    UsuarioModelo usuarioModelo;

    /**
     * Constructor por defecto de la clase UsuarioController
     */
    public UsuarioController(){
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
     */
    public void insertar(Usuario usuario) throws UsuarioException, FicheroException {
        validar(usuario);
        if(!existe(usuario.getUid())) {
            usuarioModelo.insertar(usuario);
        }
    }

    /**
     * Metodo para eliminar un usuario
     * @param usuario a eliminar
     * @throws FicheroException
     * @throws UsuarioException
     */
    public void eliminar(Usuario usuario) throws FicheroException, UsuarioException{
        validar(usuario);
        if (existe(usuario.getUid())) {
            usuarioModelo.eliminar(usuario);
        }
    }

    /**
     * Metodo para modificar de la clase UsuarioController.
     * 
     * @param usuario  a modificar.
     * @param usuario2 usuario con modificaciones.
     * @throws FicheroException
     */
    public void modificar(Usuario usuario, Usuario usuario2) throws FicheroException {
        usuarioModelo.modificar(usuario, usuario2);
    }

    /**
     * Funcion que busca un usuario por su UID
     * @param uid del usuario a buscar
     * @return un usuario
     * @throws UsuarioException
     * @throws FicheroException
     */
    public Usuario buscar(String uid) throws UsuarioException, FicheroException {
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
     */
    public boolean existe(String uid) throws UsuarioException, FicheroException {
        boolean encontrado = false;
        Usuario usuario = null;

        usuario = buscar(uid);
        if (usuario != null) {
            encontrado = true;
        }
        return encontrado;
    }
    
}
