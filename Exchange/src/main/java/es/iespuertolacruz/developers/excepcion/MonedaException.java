package es.iespuertolacruz.developers.excepcion;

public class MonedaException extends Exception {

    /**
     * Constructor con el mensaje personalizado
     * 
     * @param message descriptivo con el error
     */
    public MonedaException(String message) {
        super(message);
    }

    /**
     * Constructor con el mensaje y la exception que se produce
     * 
     * @param mensaje   de la excepcion
     * @param exception que produce el error
     */
    public MonedaException(String mensaje, Exception exception) {
        super(mensaje, exception);
    }

}
