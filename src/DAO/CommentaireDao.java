package DAO;

import beans.Commentaire;
import beans.Publication;

import java.util.Vector;

public interface CommentaireDao {

    Vector<Commentaire> getAll(Publication publication) ;
    void addComment(Commentaire commentaire , Publication publication) ;


}
