package buzon;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {

    ArrayList<Usuario> u = new ArrayList();

    public static int comprobar_usuario(Usuario pers) {

        Scanner teclado = new Scanner(System.in);
        int valido = 0;
        FileInputStream lectura;
        ObjectInputStream lectura_objeto;
        Usuario auxiliar = new Usuario();
        String usu, cont;
        Object aux;

        System.out.println("Usuario: ");
        usu = teclado.nextLine();
        System.out.println("Contraseña: ");
        cont = teclado.nextLine();

        try {

            lectura = new FileInputStream("usuarios.txt");
            lectura_objeto = new ObjectInputStream(lectura);

            aux = lectura_objeto.readObject();

            while (aux != null) {
                if (aux instanceof Usuario) {
                    auxiliar = (Usuario) aux;
                    if (auxiliar.getNombre().compareTo(usu) == 0) {
                        if (auxiliar.getContraseña().compareTo(cont) == 0) {
                            if (auxiliar.getNombre().compareTo("00000") == 0) {
                                valido = 1;
                                pers.setNombre(auxiliar.getNombre());
                                pers.setContraseña(auxiliar.getContraseña());
                                break;
                            } else {
                                pers.setNombre(auxiliar.getNombre());
                                pers.setContraseña(auxiliar.getContraseña());
                                valido = 2;
                                break;
                            }

                        }

                    }

                }
                aux = lectura_objeto.readObject();
            }

            lectura_objeto.close();
        } catch (EOFException e) {

        } catch (Exception ex) {

        }

        return valido;
    }

    public static void cambiarContrasenya() {

        FileOutputStream escribir;
        ObjectOutputStream escribirObjeto;
        FileInputStream lectura;
        ObjectInputStream lecturaObjeto;
        Object aux;
        Usuario auxiliar = new Usuario();
        ArrayList<Usuario> lista = new ArrayList();
        String linea;

    }

    public static void altaUsuario() {

    }

    public static void bajaUsuario() {

    }

    public static void listaUsuario() {

    }

}
