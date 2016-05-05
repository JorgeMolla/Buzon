package buzon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Mensajes implements Serializable {

    private String destinatario;
    private String remitente;
    private String cuerpo;

    public Mensajes(String destinatario, String remitente, String cuerpo) {
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.cuerpo = cuerpo;
    }

    public Mensajes() {
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void Escribir_Mensaje() {
        Scanner teclado = new Scanner(System.in);
        FileOutputStream Escribir;
        ObjectOutputStream Esc_Mensaje;
        Object aux1;
        ArrayList<Mensajes> Men = new ArrayList();
        System.out.println("Destinatario: ");
        destinatario = teclado.nextLine();
        System.out.println("Remitente: ");
        remitente = teclado.nextLine();
        System.out.println("Cuerpo Mensaje: ");
        cuerpo = teclado.nextLine();
        Mensajes m = new Mensajes(destinatario, remitente, cuerpo);
        Men.add(m);

        try {
            Escribir = new FileOutputStream("Mensajes.txt");
            Esc_Mensaje = new ObjectOutputStream(Escribir);

            for (Mensajes Men1 : Men) {
                Esc_Mensaje.writeObject(Men1);
            }

            Esc_Mensaje.close();
        } catch (IOException e) {
        }//Fin "TRY-CATCH".

    }//Fin "ESCRIBIR MENSAJE".

    public void Mostrar_Mensaje(Mensajes pers) {
        FileInputStream Leer;
        ObjectInputStream Leer_Mensaje;
        Object aux2;
        Mensajes auxiliar = new Mensajes();
        ArrayList<Mensajes> lista = new ArrayList();
        FileOutputStream Escribir;
        ObjectOutputStream Esc_Mensaje;

        try {
            Leer = new FileInputStream("Mensajes.txt");
            Leer_Mensaje = new ObjectInputStream(Leer);

            aux2 = Leer_Mensaje.readObject();

            while (aux2 != null) {
                if (aux2 instanceof Mensajes) {
                    auxiliar = (Mensajes) aux2;
                    if (auxiliar.remitente.compareTo(pers.remitente) == 0) {
                        System.out.println("Remitente: " + auxiliar.remitente + "\n+" + "Mensaje: \n" + auxiliar.cuerpo);
                    } else {
                        lista.add(auxiliar);
                    }

                }
                aux2 = Leer_Mensaje.readObject();
            }

            Leer_Mensaje.close();
        } catch (IOException e) {

        } catch (Exception e) {

        }
//Fin "TRY-CATCH".

        try {
            Escribir = new FileOutputStream("Mensajes.txt");
            Esc_Mensaje = new ObjectOutputStream(Escribir);
            for (Mensajes lista1 : lista) {
                Esc_Mensaje.writeObject(lista1);
            }
            Esc_Mensaje.close();
        } catch (IOException e) {

        }

    }//Fin "MOSTRAR MENSAJE".

}
