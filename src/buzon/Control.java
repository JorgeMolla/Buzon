package buzon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {

    ArrayList<Usuario> u = new ArrayList();

    public static int comprobar_usuario() {

        Scanner teclado = new Scanner(System.in);
        int valido = 0;
        FileOutputStream lectura;
        ObjectOutputStream lectura_objeto;
        Usuario aux = new Usuario();
        String usu, cont;

        System.out.println("Usuario: ");
        usu = teclado.nextLine();
        System.out.println("Contraseña: ");
        cont = teclado.nextLine();

        try {

            lectura = new FileOutputStream("usuarios.txt");
            lectura_objeto = new ObjectOutputStream(lectura);

        } catch (IOException e) {
            System.out.println("Fallo con fichero");
        }

        return valido;
    }

}
