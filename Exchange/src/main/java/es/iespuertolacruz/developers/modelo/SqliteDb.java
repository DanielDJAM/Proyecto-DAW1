package es.iespuertolacruz.developers.modelo;

import java.sql.SQLException;

import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class SqliteDb extends Bbdd{

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL  = "jdbc:sqlite:Exchange.db";

    public SqliteDb(String driver, String url, String usuario, String password) throws BbddException, FicheroException, SQLException {
        super(driver, url, usuario, password);
    }

    public SqliteDb(String usuario, String password) throws BbddException, FicheroException, SQLException  {
        super(DRIVER, URL, usuario, password);
     }
    
}
