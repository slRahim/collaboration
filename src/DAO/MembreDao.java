package DAO;

import beans.Compte;
import beans.Membre;

import java.util.Vector;

public interface MembreDao {

    String connexion(Compte compte);
    String addMembre(Membre membre , Compte compte) ;
    String editMembre(Membre membre , Compte compte) ;
    void dropMembre(Membre membre) ;
    Object[] getInfo(Membre membre);
    Vector<String> getAll() ;
    Membre visit(Membre membre) ;

}
