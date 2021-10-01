package DAO;

import beans.Membre;
import beans.MotCle;
import beans.Publication;

import java.util.Vector;

public interface PublicationDao {

     Object[] getAll();
     Object[] getPub(int id);
     Object[] getPubMot(String  mot) ;
     void addPub(Publication publication , Membre membre,Vector<String> indexs,Vector<String> tags);
     void dropPub(Publication publication);
     Object[] synchroPub(Publication publication);


}
