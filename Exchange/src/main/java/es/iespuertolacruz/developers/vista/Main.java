package es.iespuertolacruz.developers.vista;

import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.vista.menu.MenuLogin;

public class Main {

    public static void main(String[] args) throws BbddException {
        MenuLogin menu = new MenuLogin();

        menu.menuPrincipal();
    }
    
}