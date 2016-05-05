package buzon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Buzon {

    static Usuario aux = new Usuario();

    public static void main(String[] args) {

        int contador = 0, valido;

        do { // Comprobamos que el usuario existe

            valido = Control.comprobar_usuario(aux);
            if (valido == 0) {
                System.out.println("Usuario o contraseña incorrectos, vuelva a introducirlos");
                System.out.println("");
                contador++;
            }

        } while (valido == 0 && contador <= 2);

        if (valido == 0) { // Usuario no existe

            System.out.println("Error ha sobrepasado el número máximo de intentos");

        } else if (valido == 1) { //Superusuario

            Buzon.menu_superusuario();

        } else { //Usuario normal

            Buzon.menu_usuarionormal();

        }

    }

    public static void menu_superusuario() {

        Scanner tec = new Scanner(System.in);
        int opcion = 0;

        Mensajes m = new Mensajes();
        m.Mostrar_Mensaje(aux);
        do {
            do {

                System.out.println("0. Salir\n1. Cambiar contraseña\n2. Alta usuario\n3. Baja usuario\n4. Listado usuarios\n5. Enviar mensaje");
                try {
                    opcion = tec.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error, introduce un número");
                    System.out.println("");
                }

                System.out.println("");

                if (opcion < 0 || opcion > 5) {
                    System.out.println("Error de datos, vuelve a introducirlo");
                }

            } while (opcion < 0 || opcion > 5);

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    Control.cambiarContrasenya(aux);
                    break;
                case 2:
                    Control.altaUsuario();
                    break;
                case 3:
                    Control.bajaUsuario();
                    break;
                case 4:
                    Control.listaUsuario();
                    break;
                case 5:
                    m.Escribir_Mensaje();
                    break;

                default:
                    throw new AssertionError();
            }

        } while (opcion != 0);

    }

    public static void menu_usuarionormal() {

        Scanner tec = new Scanner(System.in);
        int opcion = 0;

        Mensajes m = new Mensajes();
        m.Mostrar_Mensaje(aux);
        do {
            do {
                System.out.println("0. Salir\n1. Cambiar contraseña\n2. Enviar mensaje");
                try {
                    opcion = tec.nextInt();
                    System.out.println("");
                } catch (InputMismatchException e) {
                    System.out.println("Error de datos");
                    System.out.println("");
                }

                if (opcion < 0 || opcion > 2) {
                    System.out.println("Error de datos");
                    System.out.println("");
                }

            } while (opcion < 0 || opcion > 2);

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    Control.cambiarContrasenya(aux);
                    break;
                case 2:

                    m.Escribir_Mensaje();
                    break;
                default:
                    throw new AssertionError();
            }

        } while (opcion != 0);

    }

}
