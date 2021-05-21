package es.iespuertolacruz.developers.vista;

import java.sql.SQLException;

import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.vista.menu.MenuLogin;

public class Main {

    public static void main(String[] args) throws BbddException, FicheroException, SQLException {
        MenuLogin menu = new MenuLogin();

        menu.menuPrincipal();
    }
    
}