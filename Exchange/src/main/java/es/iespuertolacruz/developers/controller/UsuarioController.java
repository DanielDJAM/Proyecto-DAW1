package es.iespuertolacruz.developers.controller;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.UsuarioException;
import es.iespuertolacruz.developers.modelo.UsuarioModelo;

public class UsuarioController {

    private static final String EL_UID_ESTA_VACIO = "El UID esta vacio";
    private static final int EDAD_MINIMA = 18;
    UsuarioModelo usuarioModelo;

    public UsuarioController(){
        usuarioModelo = new UsuarioModelo();
    }

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

    public void insertar(Usuario usuario) throws UsuarioException, FicheroException {
        validar(usuario);
        if(existe(usuario.getUid())) {
            throw new UsuarioException("El usuario se encuentra almacenado");
        }
        usuarioModelo.insertar(usuario);
    }

    public Usuario buscar(String uid) throws UsuarioException, FicheroException {
        Usuario usuario = null;
        if (uid == null || uid.isEmpty()) {
            throw new UsuarioException(EL_UID_ESTA_VACIO);
        }
        usuario = usuarioModelo.buscarUsuario(uid);
        return usuario;
    }

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
