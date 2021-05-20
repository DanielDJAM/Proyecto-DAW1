package es.iespuertolacruz.developers.modelo;

import es.iespuertolacruz.developers.excepcion.BbddException;

public class SqliteDb extends Bbdd{

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL  = "jdbc:sqlite:test.db";

    public SqliteDb(String driver, String url, String usuario, String password) throws BbddException {
        super(driver, url, usuario, password);
    }

    public SqliteDb(String usuario, String password) throws BbddException  {
        super(DRIVER, URL, usuario, password);
     }
    
}
