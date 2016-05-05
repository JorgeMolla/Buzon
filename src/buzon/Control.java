package buzon;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
        System.out.println("");
        System.out.println("Contraseña: ");
        cont = teclado.nextLine();
        System.out.println("");

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

    public static void cambiarContrasenya(Usuario pers) {

        Scanner cad = new Scanner(System.in);
        FileOutputStream escribir;
        ObjectOutputStream escribirObjeto;
        FileInputStream lectura;
        ObjectInputStream lecturaObjeto;
        Object aux;
        Usuario auxiliar = new Usuario();
        ArrayList<Usuario> lista = new ArrayList();

        try {
            lectura = new FileInputStream("usuarios.txt");
            lecturaObjeto = new ObjectInputStream(lectura);

            aux = lecturaObjeto.readObject();

            while (aux != null) {
                if (aux instanceof Usuario) {
                    auxiliar = (Usuario) aux;
                    lista.add(auxiliar);
                }

                aux = lecturaObjeto.readObject();

            }

            lecturaObjeto.close();
        } catch (EOFException e) {

        } catch (Exception es) {

        }

        for (Usuario d : lista) {
            if (d.getNombre().compareTo(pers.getNombre()) == 0) {
                int intentos = 0;
                String nueva, vieja, nueva2;
                boolean valido = false;
                do {
                    System.out.println("Introduce la contraseña antigua");
                    vieja = cad.nextLine();
                    System.out.println("");
                    System.out.println("Introduce la nueva contraseña");
                    nueva = cad.nextLine();
                    System.out.println("");
                    System.out.println("Vuelve a introducir la nueva contraseña");
                    nueva2 = cad.nextLine();
                    System.out.println("");
                    if (pers.getContraseña().compareTo(vieja) != 0 || nueva.compareTo(nueva2) != 0) {
                        System.out.println("Error en los datos");
                        System.out.println("");
                        intentos++;
                    } else {
                        d.setContraseña(nueva);
                        System.out.println("Contraseña cambiada");
                        System.out.println("");
                        valido = true;
                    }

                } while (intentos <= 2 && valido == false);

                break;
            }

        }

        try {
            escribir = new FileOutputStream("usuarios.txt");
            escribirObjeto = new ObjectOutputStream(escribir);

            for (Usuario f : lista) {
                escribirObjeto.writeObject(f);

            }

            escribirObjeto.close();

        } catch (IOException e) {

        }

    }

    public static void altaUsuario() {

        Scanner cad = new Scanner(System.in);
        FileInputStream lectura;
        ObjectInputStream lecturaObjeto;
        FileOutputStream escribir;
        ObjectOutputStream escribirObjeto;
        Object aux;
        ArrayList<Usuario> lista = new ArrayList();
        Usuario auxiliar = new Usuario();
        String nombre, cont;

        System.out.println("Introduce el nombre del nuevo usuario");
        nombre = cad.nextLine();
        System.out.println("");
        System.out.println("Introduce la contraseña del nuevo usuario");
        cont = cad.nextLine();
        System.out.println("");

        try {
            lectura = new FileInputStream("usuarios.txt");
            lecturaObjeto = new ObjectInputStream(lectura);

            aux = lecturaObjeto.readObject();

            while (aux != null) {
                if (aux instanceof Usuario) {
                    auxiliar = (Usuario) aux;
                    lista.add(auxiliar);

                }

                aux = lecturaObjeto.readObject();
            }

        } catch (EOFException e) {

        } catch (Exception es) {

        }

        auxiliar = new Usuario(nombre, cont);
        lista.add(auxiliar);

        try {
            escribir = new FileOutputStream("usuarios.txt");
            escribirObjeto = new ObjectOutputStream(escribir);

            for (Usuario d : lista) {
                escribirObjeto.writeObject(d);
            }

            escribirObjeto.close();

        } catch (IOException e) {

        }

    }

    public static void bajaUsuario() {

        Scanner cad = new Scanner(System.in);
        FileInputStream lectura;
        ObjectInputStream lecturaObjeto;
        FileOutputStream escribir;
        ObjectOutputStream escribirObjeto;
        Object aux;
        ArrayList<Usuario> lista = new ArrayList();
        Usuario auxiliar = new Usuario();
        String nombre;

        System.out.println("Introduce el nombre del usuario a eliminar");
        nombre = cad.nextLine();
        System.out.println("");

        try {
            lectura = new FileInputStream("usuarios.txt");
            lecturaObjeto = new ObjectInputStream(lectura);

            aux = lecturaObjeto.readObject();

            while (aux != null) {
                if (aux instanceof Usuario) {
                    auxiliar = (Usuario) aux;
                    lista.add(auxiliar);

                }

                aux = lecturaObjeto.readObject();
            }

        } catch (EOFException e) {

        } catch (Exception es) {

        }

        for (Usuario d : lista) {
            if (d.getNombre().compareTo(nombre) == 0) {
                lista.remove(d);
                break;
            }
        }

        try {
            escribir = new FileOutputStream("usuarios.txt");
            escribirObjeto = new ObjectOutputStream(escribir);

            for (Usuario d : lista) {
                escribirObjeto.writeObject(d);
            }

            escribirObjeto.close();

        } catch (IOException e) {

        }

    }

    public static void listaUsuario() {

        FileInputStream lectura;
        ObjectInputStream lecturaObjeto;
        Object aux;
        Usuario auxiliar = new Usuario();

        try {

            lectura = new FileInputStream("usuarios.txt");
            lecturaObjeto = new ObjectInputStream(lectura);

            aux = lecturaObjeto.readObject();

            while (aux != null) {
                if (aux instanceof Usuario) {
                    auxiliar = (Usuario) aux;
                    auxiliar.mostrarUsuario();

                }

                aux = lecturaObjeto.readObject();
            }

        } catch (EOFException e) {

        } catch (Exception es) {

        }
        System.out.println("");

    }

}
