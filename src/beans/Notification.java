package beans;

public class Notification {

    int id_not ;
    String contenu ;
    String date ;
    String etat ;

    public int getId_not() {
        return id_not;
    }

    public void setId_not(int id_not) {
        this.id_not = id_not;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
