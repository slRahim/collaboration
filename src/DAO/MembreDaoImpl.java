package DAO;

import beans.Compte;
import beans.Membre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MembreDaoImpl implements MembreDao {

    private DaoFactory daoFactory ;

    public MembreDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public String connexion(Compte compte) {
        Connection connection=null ;
        Statement statement=null ;
        ResultSet resultSet=null ;
        String str="" ;
        try {
            connection=daoFactory.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from compte where compte.id_mail='"+compte.getId_email()+
                    "' and  compte.password='"+compte.getPassword()+"' ;");

            resultSet.next() ;
            str=resultSet.getString(4);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return str;
    }

    @Override
    public String addMembre(Membre membre, Compte compte) {
        return null;
    }

    @Override
    public String editMembre(Membre membre, Compte compte) {
        return null;
    }

    @Override
    public void dropMembre(Membre membre) {

    }

    @Override
    public Object[] getInfo(Membre membre) {
        return new Object[0];
    }

    @Override
    public Vector<String> getAll() {
        Connection connection=null ;
        Statement statement=null ;
        ResultSet resultSet=null ;

        Vector<String> membres=new Vector<>();
        Membre membre ;

        try {
            connection=daoFactory.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from membre ;");

            while (resultSet.next()){
               /* membre=new Membre();
                membre.setId_membre(resultSet.getString(1));
                membre.setNom(resultSet.getString(2));
                membre.setPrenom(resultSet.getString(3));
                membre.setAdresse(resultSet.getString(4));
                membre.setTel(resultSet.getString(5));
                membre.setRole(resultSet.getString(6));*/

                membres.add(resultSet.getString(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return membres;
    }

    @Override
    public Membre visit(Membre membre) {
        return null;
    }
}
