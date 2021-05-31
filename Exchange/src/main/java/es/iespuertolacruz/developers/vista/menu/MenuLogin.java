package es.iespuertolacruz.developers.vista.menu;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertolacruz.developers.api.*;
import es.iespuertolacruz.developers.controller.*;
import es.iespuertolacruz.developers.excepcion.*;

public class MenuLogin {
    private static final String DEBES_INSERTAR_UN_NUMERO = "Debes insertar un numero";
    private static final String ESCRIBE_UNA_DE_LAS_OPCIONES = "Escribe una de las opciones";

    Miembro miembro;
    Miembro miembro2;
    Moneda moneda;
    Mercado mercado;
    Wallet wallet;
    MonedaController monedaController;
    DatosPersonalesController datosPersonalesController;
    DireccionController direccionController;
    TarjetaController tarjetaController;
    WalletController walletController;
    MercadoController mercadoController;
    Tarjeta tarjeta;
    Direccion direccion;
    MiembroController miembroController;
    DatosPersonales datosPersonales;
    Scanner scan = new Scanner(System.in);
    boolean salir = false;
    int opcion;
    String mensaje = "";
    String entrada = "";
    int numero;

    public void crearTodo() {
        try {
            datosPersonalesController = new DatosPersonalesController();
            direccionController = new DireccionController();
            tarjetaController = new TarjetaController();
            miembroController = new MiembroController();
            walletController = new WalletController();
            monedaController = new MonedaController();
            mercadoController = new MercadoController();
        } catch (BbddException e) {
            System.out.println("Ha ocurrido un error inesperado");
        } catch (FicheroException e) {
            System.out.println("Ha ocurrido un error inesperado");
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error inesperado");
        }
    }

    /**
     * Menu principal de la aplicacion
     */
    public void menuPrincipal() {
        while (!salir) {
            crearTodo();
            printMenuPrincipal();
            try {
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = Integer.parseInt(scan.nextLine());
                switch (opcion) {
                    case 1:
                        loginCase();
                        break;
                    case 2:
                        menuRegistro();
                        break;
                    case 3:
                        listar10Case();
                        break;
                    case 4:
                        listarMonedasCase();
                        break;
                    case 5:
                        salirCase();
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                scan.next();
            }
        }
    }

    /**
     * Metodo que lista por un determinado numero de monedas
     */
    public void listarMonedasCase() {
        System.out.println("Ingrese el numero de monedas que desea ver: ");
        numero = scan.nextInt();
        System.out.println("Listado de las monedas:  ");
        try {
            System.out.println(monedaController.listarMonedas(numero).toString());
        } catch (BbddException e) {
            System.out.println("Ha ocurrido un error inesperado al listar por las monedas.");
        }
    }

    /**
     * Metodo que lista las Top 10 monedas
     */
    public void listar10Case() {
        System.out.println("----------[TOP 10]---------- ");
        try {
            System.out.println(monedaController.listar10());
        } catch (BbddException e) {
            System.out.println("Ha ocurrido un error inesperado al listar Top 10 monedas.");
        }
    }

    /**
     * Metodo que imprime en pantalla las opciones del menu principal
     */
    public void printMenuPrincipal() {
        System.out.println("Bienvenido, querido trader, a nuestro Exchange.");
        System.out.println("¿Que deseas hacer?");
        System.out.println("1. Log in.");
        System.out.println("2. Registrarse.");
        System.out.println("3. Listar Top 10 criptomonedas.");
        System.out.println("4. Listar criptomonedas.");
        System.out.println("5. Salir.");
    }

    /**
     * Metodo para logear a un miembro
     */
    public void loginCase() {
        miembro = new Miembro();
        System.out.println("Ingrese su email: ");
        entrada = scan.next();
        miembro.setEmail(entrada);
        System.out.println("Ingrese su contrasenia: ");
        scan.nextLine();
        entrada = scan.nextLine();
        miembro.setContrasenia(entrada);
        System.out.println("Comprobando datos introducidos . . . ");

        try {
            miembroController = new MiembroController();
            // miembroController.buscar(uid);
        } catch (BbddException e) {
            System.out.println("Ha ocurrido un error inesperado al trabajar con la base de datos.");
        } catch (FicheroException e) {
            System.out.println("Ha ocurrido un error inesperado al trabajar con ficheros.");
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error inesperado de consultas SQL.");
        }

    }

    /**
     * Menu de registro de un miembro.
     */
    public void menuRegistro() {
        datosPersonales = new DatosPersonales();
        miembro = new Miembro();
        direccion = new Direccion();
        tarjeta = new Tarjeta();

        while (!salir) {
            printRegistro();
            try {
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        datosPersonales = datosPersonalesCase();
                        break;
                    case 2:
                        direccion = direccionCase();
                        break;
                    case 3:
                        tarjeta = tarjetaCase();
                        break;
                    case 4:
                        miembro = miembroCase();
                        break;
                    case 5:
                        listarCase();
                        break;
                    case 6:
                        finalizarCase();
                        break;
                    case 7:
                        salirCase();
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 7");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                scan.next();
            }
        }
    }

    /**
     * Metodo que imprime en pantalla las opciones del menu de registro.
     */
    public void printRegistro() {
        System.out.println("Comencemos con el registro.");
        System.out.println("¿Por donde deseas comenzar?");
        System.out.println("1. Datos Personales.");
        System.out.println("2. Direccion.");
        System.out.println("3. Metodo de pago.");
        System.out.println("4. Datos de Miembro.");
        System.out.println("5. Ver el estado del registro.");
        System.out.println("6. Finalizar Registro.");
        System.out.println("7. Salir sin guardar.");
    }

    /**
     * Funcion que pregunta al usuario por sus datos
     * 
     * @return devuelve los datos personales.
     */
    public DatosPersonales datosPersonalesCase() {
        datosPersonales = new DatosPersonales();

        scan.nextLine();
        System.out.println("El orden de los datos es el siguiente: nombre, apellidos, edad, dni, contrasenia.");
        System.out.println("Ingrese su dni: ");
        entrada = scan.nextLine();
        datosPersonales.setDni(entrada);
        System.out.println("Ingrese su nombre: ");
        entrada = scan.nextLine();
        datosPersonales.setNombre(entrada);
        System.out.println("Ingrese sus apellidos: ");
        entrada = scan.nextLine();
        datosPersonales.setApellidos(entrada);
        System.out.println("Ingrese su edad: ");
        numero = scan.nextInt();
        datosPersonales.setEdad(numero);
        scan.nextLine();
        System.out.println("Ha finalizado el registro de Datos Personales.");
        return datosPersonales;
    }

    /**
     * Funcion que pregunta al usuario su direccion
     * 
     * @return todos los datos de direccion
     */
    public Direccion direccionCase() {
        direccion = new Direccion();
        scan.nextLine();
        System.out.println("El orden de los datos es el siguiente: CP, calle, numero, puerta, provincia y pais.");
        System.out.println("Introduzca el codigo postal: ");
        entrada = scan.nextLine();
        direccion.setCodigoPostal(entrada);
        System.out.println("Introduzca su calle: ");
        entrada = scan.nextLine();
        direccion.setCalle(entrada);
        scan.nextLine();
        System.out.println("Introduzca el piso y puerta: ");
        entrada = scan.nextLine();
        direccion.setPuerta(entrada);
        System.out.println("Introduzca su Provincia: ");
        entrada = scan.nextLine();
        direccion.setProvincia(entrada);
        System.out.println("Introduzca su Pais: ");
        entrada = scan.nextLine();
        direccion.setPais(entrada);
        System.out.println("Ha finalizado el registro de la Direccion.");
        return direccion;
    }

    /**
     * Funcion que pregunta los datos de la tarjeta del usuario
     * 
     * @return datos de la tarjeta
     */
    public Tarjeta tarjetaCase() {
        tarjeta = new Tarjeta();
        scan.nextLine();
        System.out.println("El orden de los datos es el siguiente: numero Tarjeta, titular, fecha Caducidad, CVV.");
        System.out.println("Introduzca el numero de Tarjeta: ");
        entrada = scan.nextLine();
        tarjeta.setidTarjeta(entrada);
        System.out.println("Introduzca su titular: ");
        entrada = scan.nextLine();
        tarjeta.setTitular(entrada);
        scan.nextLine();
        System.out.println("Introduzca la fecha de Caducidad: ");
        entrada = scan.nextLine();
        tarjeta.setFechaCaducidad(entrada);
        System.out.println("Introduzca su CVV: ");
        numero = scan.nextInt();
        tarjeta.setCvv(numero);
        System.out.println("Ha finalizado el registro de la Direccion.");
        return tarjeta;

    }

    /**
     * Metodo que lista el miembro
     */
    public void listarCase() {
        System.out.println("Este es el estado actual de tu registro: ");
        System.out.println(miembro.toString());
        System.out.println(datosPersonales.toString());
        System.out.println(direccion.toString());
        System.out.println(tarjeta.toString());
    }

    /**
     * Funcion que pregunta al usuario los datos de miembro
     * 
     * @return datos de miembro
     */
    public Miembro miembroCase() {
        miembro = new Miembro();
        System.out.println("Guardando en nuestra base de datos . . .");
        scan.nextLine();
        System.out.println("El orden de los datos es el siguiente: email, contrasenia.");
        System.out.println("Introduzca su email: ");
        entrada = scan.nextLine();
        miembro.setEmail(entrada);
        System.out.println("Introduzca una contraseña: ");
        entrada = scan.nextLine();
        miembro.setContrasenia(entrada);
        System.out.println("Vuelva a introducir su contraseña: ");
        entrada = scan.nextLine();
        miembro.setContrasenia(entrada);
        scan.nextLine();
        return miembro;
    }

    /**
     * Metodo para complementar los datos introducidor anteriormente y poder
     * insertar el miembro con todo lo requerido.
     */
    public void finalizarCase() {
        try {
            datosPersonalesController.insertar(datosPersonales);
            direccionController.insertar(direccion);
            tarjetaController.insertar(tarjeta);
            miembro2 = new Miembro("00001", "Miembro", datosPersonales, miembro.getEmail(), miembro.getContrasenia(),
                    direccion, tarjeta);
            miembroController.insertar(miembro2);
        } catch (DatosPersonalesException e) {
            System.out.println("Ha ocurrido un error inesperado al insertar los datos personales.");
        } catch (BbddException e) {
            System.out.println("Ha ocurrido un error inesperado al usar la base de datos.");
        } catch (DireccionException e) {
            System.out.println("Ha ocurrido un error inesperado al insertar la direccion.");
        } catch (TarjetaException e) {
            System.out.println("Ha ocurrido un error inesperado al insertar los datos de la tarjeta.");
        } catch (MiembroException e) {
            System.out.println("Ha ocurrido un error inesperado al insertar el miembro");
        }
    }

    /**
     * Metodo para salir de los menus.
     */
    public void salirCase() {
        System.out.println("Muchas gracias por utilizar nuestra aplicacion. Esperamos que haya sido de su agrado.");
        salir = true;
    }

    private String limpiar(String entrada) {
        entrada = entrada.substring(0, entrada.length() - 2);
        return entrada;
    }

    /**
     * Menu del mercado
     */
    public void menuMercado() {
        while (!salir) {
            printMercado();
            try {
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = Integer.parseInt(scan.nextLine());
                switch (opcion) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        listarCarteraCase();
                        break;
                    case 4:
                        System.out.println("Listado de las monedas:  ");
                        // Aqui pondremos un metodo que realice una consulta con X monedas que
                        // introduzca el miembro
                        break;
                    case 5:
                        salirCase();
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                scan.next();
            }
        }
    }

    /**
     * Funcion que lista el contenido de una cartera
     * @return una cartera
     */
    public String listarCarteraCase() {
        miembro = new Miembro();
        wallet = new Wallet();
        String listado = "";
        System.out.println("Introduzca su dni para comprobar su cartera: ");
        scan.nextLine();
        entrada = scan.nextLine();
        try {
            miembro = miembroController.buscarDni(entrada);
            wallet = walletController.buscarUid(miembro.getUid());
            listado = mercadoController.listarMercadoWallet(wallet);
        } catch (WalletException e) {
            System.out.println("Ha ocurrido un error inesperado");
        } catch (BbddException e) {
            System.out.println("Ha ocurrido un error inesperado");
        } catch (MiembroException e) {
            System.out.println("Ha ocurrido un error inesperado");
        }
        System.out.println("Su cartera contiene: ");
        return listado;
    }

    /**
     * Funcion que realiza la accion de comprar
     * 
     * @return la moneda comprada
     */
    public Moneda comprarCase() {
        moneda = new Moneda();
        System.out.println("Introduzca el ticket de la moneda a comprar: ");
        scan.nextLine();
        entrada = scan.nextLine();
        miembro.setEmail(entrada);
        System.out.println("Introduzca una contraseña: ");
        entrada = scan.nextLine();
        miembro.setContrasenia(entrada);
        System.out.println("Vuelva a introducir su contraseña: ");
        entrada = scan.nextLine();
        miembro.setContrasenia(entrada);
        scan.nextLine();
        return moneda;
    }

    /**
     * Menu de configuracion
     */
    public void menuConfiguracion() {
        while (!salir) {
            printMercado();
            try {
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = Integer.parseInt(scan.nextLine());
                switch (opcion) {
                    case 1:
                        menuRegistro();
                        break;
                    case 2:
                        eliminarCase();
                        break;
                    case 3:
                        salirCase();
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                scan.next();
            }
        }
    }

    /**
     * Metodo que elimina definitivamente al usuario
     */
    public void eliminarCase() {
        miembro = new Miembro();
        scan.nextLine();
        System.out.println("Procederemos a eliminar su cuenta.");
        System.out.println("Por favor, introduzca su dni: ");
        entrada = scan.nextLine();
        try {
            miembro = miembroController.buscarDni(entrada);
            System.out.println("¿Es usted este usuario? ");
            decision();
            System.out.println("Para borrar definitivamente su cuenta escriba: 'Confirmar' .");
            entrada = scan.nextLine();
            if (!entrada.equalsIgnoreCase("confirmar")) {
                salirCase();
            }
            miembroController.eliminar(miembro);
        } catch (MiembroException e) {
            System.out.println("Ha ocurrido un error inesperado al trabajar con los datos del Miembro.");
        } catch (BbddException e) {
            System.out.println("Ha ocurrido un error inesperado al trabajar con la base de datos.");
        }
        System.out.println("Eliminando . . . ");
        System.out.println("Lamentamos que nos hayas tenido que dejarnos. ");
        System.out.println("Gracias por utilizar Exchange. Esperamos que vuelvas pronto.");
    }

    /**
     * Funcion que pregunta al usuario
     * 
     * @return True o en caso contrario, false.
     */
    public boolean decision() {
        entrada = scan.nextLine();
        if (entrada.equalsIgnoreCase("yes") || entrada.equalsIgnoreCase("y") || entrada.equalsIgnoreCase("si")
                || entrada.equalsIgnoreCase("s")) {
            return true;
        }
        return false;
    }

    /**
     * Metodo que imprime por pantalla el menu de Configuracion
     */
    public void printConfiguracion() {

        System.out.println("¿Que desea configurar?");
        System.out.println("1. Cambiar mis datos.");
        System.out.println("2. Eliminar mi cuenta.");
        System.out.println("3. salir.");

    }

    /**
     * Metodo que imprime por pantalla el menu de Mercado
     */
    public void printMercado() {
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Comprar.");
        System.out.println("2. Vender.");
        System.out.println("3. Listar mis monedas.");
        System.out.println("4. Listar Top 10 monedas.");
        System.out.println("5. Listar X monedas.");
        System.out.println("6. Salir.");
    }

}
