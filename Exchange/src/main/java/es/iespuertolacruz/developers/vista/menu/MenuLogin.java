package es.iespuertolacruz.developers.vista.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertolacruz.developers.api.Direccion;
import es.iespuertolacruz.developers.api.Usuario;
import es.iespuertolacruz.developers.controller.UsuarioController;

public class MenuLogin {
    Usuario usuario;
    Direccion direccion = null;
    UsuarioController usuarioController = null;
    Scanner scan = new Scanner(System.in);
    boolean salir = false;
    int opcion;
    String mensaje;
    String entrada;
    int numero;

    public void menuPrincipal() {

        while (!salir) {

            System.out.println("Bienvenido, querido trader, a nuestro Exchange.");
            System.out.println("¿Que deseas hacer?");
            System.out.println("1. Log in.");
            System.out.println("2. Registrarse.");
            System.out.println("3. Listar Top 10 criptomonedas.");
            System.out.println("4. Listar criptomonedas.");
            System.out.println("5. Salir.");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese su ID de usuario o email: ");
                        mensaje = "Ingresando datos . . . ";
                        entrada = scan.nextLine();
                        if (!usuario.getUid().equalsIgnoreCase(entrada) || !usuario.getEmail().equalsIgnoreCase(entrada)){//Sustituir por un metodo que busque en la DB
                            mensaje = "Email/ID erroneo,";
                        }
                        System.out.println("Ingrese su contrasenia: ");
                        entrada = scan.nextLine();
                        if(!usuario.getContrasenia().equalsIgnoreCase(entrada)){//Sustituir por un metodo que busque en la DB
                            mensaje += " Contrasenia incorrecta.";
                        }
                        System.out.println(mensaje);
                        break;
                    case 2:
                        menuRegistro();
                        break;
                    case 3:
                        System.out.println("----------[TOP 10]---------- ");
                        //Aqui pondremos un metodo que será una consulta de la tabla monedas
                        break;
                    case 4:
                        System.out.println("Listado de las monedas:  ");
                        //Aqui pondremos un metodo que realice una consulta con X monedas que introduzca el usuario
                        break;
                    case 5:
                        System.out.println("Muchas gracias por utilizar nuestra aplicacion. Esperamos que haya sido de su agrado.");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scan.next();
            }
        }
    }

    public void menuRegistro(){
        usuario = new Usuario();
        direccion = new Direccion();

        while (!salir) {

            System.out.println("Comencemos con el registro.");
            System.out.println("¿Por donde deseas comenzar?");
            System.out.println("1. Datos del Usuario.");
            System.out.println("2. Direccion.");
            System.out.println("3. Metodo de pago.");
            System.out.println("4. Ver el estado del registro.");
            System.out.println("5. Finalizar Registro.");
            System.out.println("6. Salir sin guardar.");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("El orden de los datos es el siguiente: nombre, apellidos, edad, dni, contrasenia.");
                        System.out.println("Ingrese su nombre: ");
                        entrada = scan.nextLine();
                        usuario.setNombre(entrada);
                        System.out.println("Ingrese sus apellidos: ");
                        entrada = scan.nextLine();
                        usuario.setApellidos(entrada);
                        System.out.println("Ingrese su edad: ");
                        numero = scan.nextInt();
                        usuario.setEdad(numero);
                        System.out.println("Ingrese su DNI: ");
                        entrada = scan.nextLine();
                        usuario.setDni(entrada);
                        System.out.println("Ingrese una contrasenia: ");
                        entrada = scan.nextLine();
                        usuario.setContrasenia(entrada);
                        System.out.println("Ha finalizado el registro de Datos Personales.");
                        break;
                    case 2:
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
                        System.out.println("----------[TOP 10]---------- ");
                        //Aqui pondremos un metodo que será una consulta de la tabla monedas
                        break;
                    case 4:
                        System.out.println("Listado de las monedas:  ");
                        //Aqui pondremos un metodo que realice una consulta con X monedas que introduzca el usuario
                        break;
                    case 5:
                        System.out.println("Muchas gracias por utilizar nuestra aplicacion. Esperamos que haya sido de su agrado.");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scan.next();
            }
        }

    }
}