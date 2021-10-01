package DAO;

import beans.Commentaire;
import beans.Publication;

import java.sql.*;
import java.util.Vector;

public class CommentaireDaoImpl implements CommentaireDao {

    private DaoFactory daoFactory ;

    public CommentaireDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Vector<Commentaire> getAll(Publication publication) {
        Connection connection=null ;
        Statement statement=null ;
        ResultSet resultSet=null;

        Commentaire commentaire ;
        Vector<Commentaire> commentaires=new Vector<>();

        try {
            connection=daoFactory.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from commentaire where id_pub="+
                    publication.getId_pub()+" order by id desc ;");

            while (resultSet.next()){
                commentaire=new Commentaire();
                commentaire.setContenu(resultSet.getString(2));
                commentaire.setMembre(resultSet.getString(4));

                commentaires.add(commentaire);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return commentaires;
    }

    @Override
    public void addComment(Commentaire commentaire, Publication publication) {
        Connection connection=null ;
        PreparedStatement statement=null ;

        try {
            connection=daoFactory.getConnection();
            statement=connection.prepareStatement("insert into commentaire (contenut, date, membre, id_pub)"+
                    " value(?,CURRENT_DATE (),?,?) ;");
            statement.setString(1,commentaire.getContenu());
            statement.setString(2,commentaire.getMembre());
            statement.setInt(3,publication.getId_pub());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
