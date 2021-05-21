package es.iespuertolacruz.developers.modelo;

import java.sql.SQLException;

import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class SqliteDb extends Bbdd{

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL  = "jdbc:sqlite:Exchange.db";

    public SqliteDb(String driver, String url, String miembro, String password) throws BbddException, FicheroException, SQLException {
        super(driver, url, miembro, password);
    }

    public SqliteDb(String miembro, String password) throws BbddException, FicheroException, SQLException  {
        super(DRIVER, URL, miembro, password);
     }
    
}
