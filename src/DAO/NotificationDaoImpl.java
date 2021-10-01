package DAO;

import beans.Membre;
import beans.Notification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class NotificationDaoImpl implements NotificationDao {

    private DaoFactory daoFactory ;

    public NotificationDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Vector<Object> getAll(String membre) {
        Connection connection=null ;
        Statement statement=null;
        ResultSet resultSet=null ;

        Vector<Object> tags=new Vector<>() ;

        try {
            connection=daoFactory.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from tags where id_membre='"+membre+"' and  etat='actif' order by id_pub desc ;");

            while (resultSet.next()){
                tags.add(resultSet.getInt(1));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tags;
    }

    @Override
    public Vector<Object> syncroNotification(String membre, int pub) {
        Connection connection=null ;
        Statement statement=null;
        ResultSet resultSet=null ;

        Vector<Object> tags=new Vector<>() ;

        try {
            connection=daoFactory.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from tags where id_pub >"+pub+" and id_membre='"+membre+"' and  etat='actif' order by id_pub desc ;");

            while (resultSet.next()){
                tags.add(resultSet.getInt(1));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tags;
    }
}
