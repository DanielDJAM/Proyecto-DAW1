package es.iespuertolacruz.developers.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class Fichero {

    private static final String SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO = "Se ha producido un error en el volcado del fichero";
    private static final String RETORNO_CARRO = "\n";
    private static final String NOMBRE_FICHERO = "Fichero-Usarios.txt";

    /**
     * Metodo encargado de almacenar una usuario en el fichero
     * 
     * @param usuario a insertar
     * @throws FicheroException controlado
     */
    public void insertar(Usuario usuario) throws FicheroException {
        ArrayList<Usuario> listado;
        listado = obtenerListado();
        listado.add(usuario);
        try {
            crear(NOMBRE_FICHERO, obtenerLista(listado));
        } catch (FicheroException exception) {
            throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, exception);
        }
    }

    /**
     * Funcion para obtener una lista de usuarios
     * @param listado array
     * @return un string.
     */
    private String obtenerLista(ArrayList<Usuario> listado) {
        String lista = "";
        int i = 0;
        while (i<listado.size()) {
            lista += listado.get(i).toString() +RETORNO_CARRO;
            ++i;
        }
        return lista;
    }

    /**
     * Metodo encargado de eliminar una Usuario del fichero
     * 
     * @param Usuario a eliminar
     * @throws FicheroException error controlado
     */
    public void eliminar(Usuario usuario) throws FicheroException {
        ArrayList<Usuario> listado;
        listado = obtenerListado();
        listado.remove(usuario);
        try {
            crear(NOMBRE_FICHERO, obtenerLista(listado));
        } catch (FicheroException exception) {
            throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, exception);
        }
    }

    /**
     * Metodo encargado de modificar un elemento del fichero
     * 
     * @param UsuarioAlamcenada elemento a actualizar
     * @param Usuario elemento con la informacion actualizada
     * @throws FicheroException
     */
    public void modificar(Usuario usuarioAlmacenada, Usuario usuario) throws FicheroException {
        ArrayList<Usuario> listado = obtenerListado();
        int posicion = -1;
        posicion = listado.indexOf(usuarioAlmacenada);
        listado.remove(posicion);
        listado.add(posicion, usuario);
        try {
            crear(NOMBRE_FICHERO, obtenerLista(listado));
        } catch (FicheroException exception) {
            throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, exception);
        }

    }

    /**
     * Funcion encargada de obtener el listado de Usuarios del fichero
     * 
     * @return listado de Usuarios
     * @throws FicheroException
     */
    public ArrayList<Usuario> obtenerListado() throws FicheroException {
        ArrayList<Usuario> lista = new ArrayList<>();
        File fichero = null;
        Scanner scanner = null;

        try {
            fichero = new File(NOMBRE_FICHERO);
            if (!validarFichero(fichero)) {
                throw new FicheroException("El fichero a leer no existe");
            }
            scanner = new Scanner(fichero);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine(); // Guardamos la linea en un String
                if (!linea.isEmpty()) {
                    Usuario usuario = new Usuario(linea);
                    lista.add(usuario);
                }
            }
        } catch (FicheroException e) {
            throw e;
        } catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return lista;
    }

    /**
     * Metodo encargado de crear un fichero
     * 
     * @param nombre del fichero a crear
     * @throws FicheroException
     */
    public void crear(String nombre, String cadenaTexto) throws FicheroException {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(nombre);
            fichero.write(cadenaTexto + RETORNO_CARRO);
        } catch (Exception ex) {
            throw new FicheroException("Se ha producido un error en la escritura del fichero", ex);
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    throw new FicheroException("No ha sido podible cerrar el fichero", e);
                }
            }
        }

    }

    /**
     * Funcion que verifica si el fichero existo
     * 
     * @param fichero
     * @return
     */
    public boolean validarFichero(File fichero) {
        return fichero.exists();
    }

    /**
     * Metodo encargado de elimianr un fichero/directorio
     * 
     * @param nombre del fichero/directorio a elimina
     * @throws FicheroException error controlado
     */
    public void eliminar(String nombre) throws FicheroException {
        File fichero = new File(nombre);
        if (validarFichero(fichero)) {
            fichero.delete();
        } else {
            throw new FicheroException("No se puede eliminar un fichero que no existe");
        }

    }

    /**
     * Funcion que verifica si se trata de un directorio noFichero-Usarios
     * 
     * @param path de la ruta a validad
     * @return boolean Si/No se trata de un directorio
     */
    public boolean esDirectorio(String path) {
        File fichero = new File(path);
        return fichero.isDirectory();
    }

    /**
     * Funcion encargada de obtener un usuario
     * 
     * @param uid del usuario
     * @return Objeto usuario
     * @throws FicheroException
     */
    public Usuario buscar(String uid) throws FicheroException {
        Usuario usuario = null;
        ArrayList<Usuario> listado = obtenerListado();
        int i = 0;

        while (i < listado.size() && usuario == null) {
            if (uid.equals(listado.get(i).getUid())) {
                usuario = listado.get(i);
            }
            i++;
        }
        return usuario;
    }

}
