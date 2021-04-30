package es.iespuertolacruz.developers.modelo;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class UsuarioModelo {

    Fichero fichero;

    /**
     * Constructor por defecto de la clase UsuarioModelo
     */
    public UsuarioModelo() {
        fichero = new Fichero();
    }

    /**
     * Metodo encargado de realizar la insercion de un usuario
     * 
     * @param usuario a insertar
     * @throws FicheroException controlada
     */
    public void insertar(Usuario usuario) throws FicheroException {
        fichero.insertar(usuario);
    }

    /**
     * Metodo encargado de realizar la eleminacion de un usuario
     * 
     * @param usuario a eliminar
     * @throws FicheroException controlada
     */
    public void eliminar(Usuario usuario) throws FicheroException {
        fichero.eliminar(usuario);
    }

    /**
     * Metodo encargado de realizar la modificacion de un usuario
     * 
     * @param usuario a modificar
     */
    public void modificar(Usuario usuario, Usuario userMod) throws FicheroException {
        fichero.modificar(usuario, userMod);
    }

    /**
     * Funcion encargada de realizar la busqueda de un usuario
     * 
     * @param identificador del usuario
     * @return Usuario a buscar
     * @throws FicheroException
     */
    public Usuario buscarUsuario(String elemento) throws FicheroException {
        Usuario usuario = null;
        usuario = fichero.buscar(elemento);
        return usuario;
    }

}
