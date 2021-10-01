package beans;

import java.util.Vector;

public class Publication {

    int id_pub ;
    String contenu ;
    String date ;
    String cheminF ;
    int note ;

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheminF() {
        return cheminF;
    }

    public void setCheminF(String cheminF) {
        this.cheminF = cheminF;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
