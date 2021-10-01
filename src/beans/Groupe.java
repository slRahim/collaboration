package beans;

public class Groupe {

    int id_groupe ;
    String titre ;
    String date ;
    int nb_user ;

    public int getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNb_user() {
        return nb_user;
    }

    public void setNb_user(int nb_user) {
        this.nb_user = nb_user;
    }
}
