package buzon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Buzon {

    public static void main(String[] args) {

        int contador = 0, valido;

        do { // Comprobamos que el usuario existe

            valido = Control.comprobar_usuario();
            if (valido == 0) {
                System.out.println("Usuario o contraseña incorrectos, vuelva a introducirlos");
                System.out.println("");
                contador++;
            }

        } while (valido == 0 || contador <= 2);

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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;

                default:
                    throw new AssertionError();
            }

        } while (opcion != 0);

    }
    
    
    public static void menu_usuarionormal(){
        
    }
    
    
    

}
