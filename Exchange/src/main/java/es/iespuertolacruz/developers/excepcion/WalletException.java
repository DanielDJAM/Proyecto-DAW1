package es.iespuertolacruz.developers.excepcion;

public class WalletException extends Exception {
    

    
     /**
     * Constructor de la exception con el parametro mensaje
     * 
     * @param mensaje descriptivo del error
     */
    public WalletException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con el mensaje y la exception que se produce
     * 
     * @param mensaje   de la excepcion
     * @param exception que produce el error
     */
    public WalletException(String mensaje, Exception exception) {
        super(mensaje, exception);
    }
}
