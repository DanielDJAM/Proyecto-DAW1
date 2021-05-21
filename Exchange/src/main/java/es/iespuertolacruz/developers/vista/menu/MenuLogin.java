package es.iespuertolacruz.developers.vista.menu;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertolacruz.developers.api.CuentaBancaria;
import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.api.Tarjeta;
import es.iespuertolacruz.developers.api.Miembro;
import es.iespuertolacruz.developers.controller.MiembroController;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;

public class MenuLogin {
    private static final String DEBES_INSERTAR_UN_NUMERO = "Debes insertar un numero";
    private static final String ESCRIBE_UNA_DE_LAS_OPCIONES = "Escribe una de las opciones";
    private static final String REGRESANDO_AL_MENU_ANTERIOR = "Regresando al menu anterior.";

    Miembro miembro;
    Tarjeta tarjeta;
    CuentaBancaria cuentaBancaria;
    Direccion direccion;
    MiembroController miembroController;
    Scanner scan = new Scanner(System.in);
    boolean salir = false;
    int opcion;
    String mensaje = "";
    String entrada = "";
    int numero;

    
    public void menuPrincipal() throws BbddException, FicheroException, SQLException {

        while (!salir) {

            System.out.println("Bienvenido, querido trader, a nuestro Exchange.");
            System.out.println("¿Que deseas hacer?");
            System.out.println("1. Log in.");
            System.out.println("2. Registrarse.");
            System.out.println("3. Listar Top 10 criptomonedas.");
            System.out.println("4. Listar criptomonedas.");
            System.out.println("5. Salir.");

            try {

                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = Integer.parseInt(scan.nextLine());

                switch (opcion) {
                    case 1:
                        miembro = new Miembro();
                        miembroController = new MiembroController();
                        System.out.println("Ingrese su email: ");
                        entrada = scan.next();
                        miembro.setEmail(entrada);
                        System.out.println("Ingrese su contrasenia: ");
                        scan.nextLine();
                        entrada = scan.nextLine();
                        miembro.setContrasenia(entrada);
                        System.out.println("Comprobando datos introducidos . . . ");
                        break;
                    case 2:
                        menuRegistro();
                        break;
                    case 3:
                        System.out.println("----------[TOP 10]---------- ");
                        //Aqui pondremos un metodo que sera una consulta de la tabla monedas
                        break;
                    case 4:
                        System.out.println("Listado de las monedas:  ");
                        //Aqui pondremos un metodo que realice una consulta con X monedas que introduzca el miembro
                        break;
                    case 5:
                        System.out.println("Muchas gracias por utilizar nuestra aplicacion. Esperamos que haya sido de su agrado.");
                        salir = true;
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

    public void menuRegistro(){
        miembro = new Miembro();
        direccion = new Direccion();

        while (!salir) {

            System.out.println("Comencemos con el registro.");
            System.out.println("¿Por donde deseas comenzar?");
            System.out.println("1. Datos del Miembro.");
            System.out.println("2. Direccion.");
            System.out.println("3. Metodo de pago.");
            System.out.println("4. Ver el estado del registro.");
            System.out.println("5. Finalizar Registro.");
            System.out.println("6. Salir sin guardar.");

            try {

                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        scan.nextLine();
                        System.out.println("El orden de los datos es el siguiente: nombre, apellidos, edad, dni, contrasenia.");
                        System.out.println("Ingrese su nombre: ");
                        entrada = scan.nextLine();
                        miembro.setNombre(entrada);
                        System.out.println("Ingrese sus apellidos: ");
                        entrada = scan.nextLine();
                        miembro.setApellidos(entrada);
                        System.out.println("Ingrese su edad: ");
                        numero = scan.nextInt();
                        miembro.setEdad(numero);
                        scan.nextLine();
                        System.out.println("Ingrese su DNI: ");
                        entrada = scan.nextLine();
                        miembro.setDni(entrada);
                        System.out.println("Ingrese una contrasenia: ");
                        entrada = scan.nextLine();
                        miembro.setContrasenia(entrada);
                        System.out.println("Ha finalizado el registro de Datos Personales.");
                        break;
                    case 2:
                        scan.nextLine();
                        System.out.println("El orden de los datos es el siguiente: CP, calle, numero, puerta, provincia y pais.");
                        System.out.println("Introduzca el codigo postal: ");
                        entrada = scan.nextLine();
                        direccion.setCodigoPostal(entrada);
                        System.out.println("Introduzca su calle: ");
                        entrada = scan.nextLine();
                        direccion.setCalle(entrada);
                        System.out.println("Introduzca el numero del edificio: ");
                        numero = scan.nextInt();
                        direccion.setNumero(numero);
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
                        break;
                    case 3:
                        //menuMetodoPago();
                        break;
                    case 4:
                        System.out.println("Este es el estado actual de tu registro: ");
                        System.out.println(miembro.toString());
                        System.out.println(direccion.toString());
                        System.out.println(cuentaBancaria.toString());
                        System.out.println(tarjeta.toString());
                        break;
                    case 5:
                        System.out.println("Guardando en nuestra base de datos . . .");
                       /* miembroController.insertar(miembro);
                        direccionController.insertar(direccion);
                        tarjetaController.insertar(tarjeta);
                        cuentaBancariaController.insertar(cuentaBancaria);*/
                        break;
                    case 6:
                        System.out.println("Muchas gracias por utilizar nuestra aplicacion. Esperamos que haya sido de su agrado.");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                scan.next();
            }
        }

    }

    private String limpiar(String entrada){
        entrada = entrada.substring(0, entrada.length()-2);
        return entrada;
    }

   // public Object menuMetodoPago(){
      /*  tarjeta = null;
        cuentaBancaria = null;

        while (!salir) {

            System.out.println("Elige un metodo de pago");
            System.out.println("¿Cual deseas?");
            System.out.println("1. Tarjeta.");
            System.out.println("2. Cuenta bancaria.");
            System.out.println("3. Salir.");

            try {

                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has elegido hacer tus transacciones por tarjeta.");
                        System.out.println("Introduzca el titular: ");
                        entrada = scan.nextLine();
                        tarjeta.setTitular(entrada);
                        System.out.println("Introduce el numero de cuenta: ");
                        entrada = scan.nextLine();
                        tarjeta.setNumeroCuenta(entrada);
                        System.out.println("Introduce el CVV: ");
                        numero = scan.nextInt();
                        tarjeta.setCvv(numero);
                        scan.nextLine();
                        System.out.println("Introduce la fecha de caducidad: ");
                        entrada = scan.nextLine();
                        tarjeta.setFechaCaducidad(entrada);
                        if (validar(tarjeta)){//hacer metodo validar
                            System.out.println("Ha finalizado el registro de su metodo de pago correctamente.");
                            System.out.println(REGRESANDO_AL_MENU_ANTERIOR);
                            return tarjeta;
                            }
                        break;
                    case 2:
                        System.out.println("Has elegido hacer tus transacciones por Cuenta Bancaria.");
                        System.out.println("Introduzca el titular: ");
                        entrada = scan.nextLine();
                        cuentaBancaria.setTitular(entrada);
                        System.out.println("Introduce el numero de cuenta: ");
                        entrada = scan.nextLine();
                        cuentaBancaria.setNumeroCuenta(entrada);
                        System.out.println("Introduce ");
                        entrada = scan.nextLine();
                        cuentaBancaria.setIban(entrada);
                        if (validar(cuentaBancaria)){//hacer metodo validar
                            System.out.println("Ha finalizado el registro de su metodo de pago correctamente.");
                            System.out.println(REGRESANDO_AL_MENU_ANTERIOR);
                            return cuentaBancaria;
                            }
                        
                        break;
                    case 3:
                        System.out.println(REGRESANDO_AL_MENU_ANTERIOR);
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                scan.next();
            }
        }
        */
        
    }

//}