package buzon;

public class Mensajes {

    private String destinatario;
    private String remitente;
    private String cuerpo;

    public Mensajes(String destinatario, String remitente, String cuerpo) {
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.cuerpo = cuerpo;
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

}
