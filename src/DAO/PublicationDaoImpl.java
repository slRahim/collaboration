package DAO;

import beans.Commentaire;
import beans.Membre;
import beans.MotCle;
import beans.Publication;
import com.google.gson.Gson;

import java.sql.*;
import java.util.Vector;

public class PublicationDaoImpl implements PublicationDao {

    private DaoFactory daoFactory ;

    PublicationDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object[] getAll() {
        Object [] objects=new Object[5];

        Connection connection=null ;
        Statement statement=null;
        Statement statement1=null;
        Statement statement2=null;
        ResultSet resultSet=null ;
        ResultSet resultSet1=null ;
        ResultSet resultSet2=null ;

        Vector<Publication> publications=new Vector<>();
        Publication publication;
        Vector<Membre> membres=new Vector<>();
        Membre membre ;
        Vector<Vector<Commentaire>> commmentaires=new Vector<>();
        Vector<Commentaire> compub ;
        Commentaire commentaire ;
        Vector<Vector<MotCle>> motCles=new Vector<>();
        Vector<MotCle> motpub ;
        MotCle motCle ;

        try {
            connection=daoFactory.getConnection();
            statement=connection.createStatement();
            statement1=connection.createStatement();
            statement2=connection.createStatement();
            resultSet=statement.executeQuery("select * from publication order by id_pub desc ;");

            while (resultSet.next()){
                publication=new Publication();
                membre=new Membre();
                publication.setId_pub(resultSet.getInt(1));
                publication.setContenu(resultSet.getString(2));
                publication.setDate(resultSet.getString(3));
                publication.setCheminF(resultSet.getString(4));
                publication.setNote(resultSet.getInt(7));
                publications.add(publication);

                membre.setId_membre(resultSet.getString(5));
                membres.add(membre);

                resultSet1=statement1.executeQuery("select * from commentaire where commentaire.id_pub="+
                        publication.getId_pub()+" order by id desc ;");
                compub=new Vector<>();
                while (resultSet1.next()){
                    commentaire=new Commentaire();
                    commentaire.setId_com(resultSet1.getInt(1));
                    commentaire.setContenu(resultSet1.getString(2));
                    commentaire.setMembre(resultSet1.getString(4));
                    compub.add(commentaire);
                }

                resultSet2=statement2.executeQuery("select * from pub_cle where pub_cle.id_pub="+publication.getId_pub()+";");
                motpub=new Vector<>();
                while (resultSet2.next()){
                    motCle=new MotCle() ;
                    motCle.setMot(resultSet2.getString("mot"));
                    motpub.add(motCle);
                }

                commmentaires.add(compub);
                motCles.add(motpub);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        objects[0]=publications;
        objects[1]=membres;
        objects[2]=commmentaires;
        objects[3]=publications.get(0).getId_pub();
        objects[4]=motCles;
        return objects;
    }

    @Override
    public Object[] getPub(int id) {
        Object [] objects=new Object[4];

        Connection connection=null ;
        Statement statement=null;
        Statement statement1=null;
        Statement statement2=null;
        ResultSet resultSet=null ;
        ResultSet resultSet1=null ;
        ResultSet resultSet2=null ;

        Vector<Publication> publications=new Vector<>();
        Publication publication;
        Vector<Membre> membres=new Vector<>();
        Membre membre ;
        Vector<Vector<Commentaire>> commmentaires=new Vector<>();
        Vector<Commentaire> compub ;
        Commentaire commentaire ;
        Vector<Vector<MotCle>> motCles=new Vector<>();
        Vector<MotCle> motpub ;
        MotCle motCle ;

        try {
            connection=daoFactory.getConnection();
            statement=connection.createStatement();
            statement1=connection.createStatement();
            statement2=connection.createStatement();
            resultSet=statement.executeQuery("select * from publication where id_pub = "+id+";");

            while (resultSet.next()){
                publication=new Publication();
                membre=new Membre();
                publication.setId_pub(resultSet.getInt(1));
                publication.setContenu(resultSet.getString(2));
                publication.setDate(resultSet.getString(3));
                publication.setCheminF(resultSet.getString(4));
                publication.setNote(resultSet.getInt(7));
                publications.add(publication);

                membre.setId_membre(resultSet.getString(5));
                membres.add(membre);

                resultSet1=statement1.executeQuery("select * from commentaire where commentaire.id_pub="+
                        publication.getId_pub()+" order by id desc ;");
                compub=new Vector<>();
                while (resultSet1.next()){
                    commentaire=new Commentaire();
                    commentaire.setId_com(resultSet1.getInt(1));
                    commentaire.setContenu(resultSet1.getString(2));
                    commentaire.setMembre(resultSet1.getString(4));
                    compub.add(commentaire);
                }

                resultSet2=statement2.executeQuery("select * from pub_cle where pub_cle.id_pub="+publication.getId_pub()+";");
                motpub=new Vector<>();
                while (resultSet2.next()){
                    motCle=new MotCle() ;
                    motCle.setMot(resultSet2.getString("mot"));
                    motpub.add(motCle);
                }

                commmentaires.add(compub);
                motCles.add(motpub);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        objects[0]=publications;
        objects[1]=membres;
        objects[2]=commmentaires;
        objects[3]=motCles;
        return objects;

    }

    @Override
    public Object[] getPubMot(String mot) {
        Object [] objects=new Object[4];

        Connection connection=null ;
        Statement statement=null;
        Statement statement1=null;
        Statement statement2=null;
        ResultSet resultSet=null ;
        ResultSet resultSet1=null ;
        ResultSet resultSet2=null ;

        Vector<Publication> publications=new Vector<>();
        Publication publication;
        Vector<Membre> membres=new Vector<>();
        Membre membre ;
        Vector<Vector<Commentaire>> commmentaires=new Vector<>();
        Vector<Commentaire> compub ;
        Commentaire commentaire ;
        Vector<Vector<MotCle>> motCles=new Vector<>();
        Vector<MotCle> motpub ;
        MotCle motCle ;

        try {
            connection=daoFactory.getConnection();
            statement=connection.createStatement();
            statement1=connection.createStatement();
            statement2=connection.createStatement();
            resultSet=statement.executeQuery("select * from publication , pub_cle where publication.id_pub=pub_cle.id_pub and pub_cle.mot like '"+mot+"' order by publication.id_pub desc ;");

            while (resultSet.next()){
                publication=new Publication();
                membre=new Membre();
                publication.setId_pub(resultSet.getInt(1));
                publication.setContenu(resultSet.getString(2));
                publication.setDate(resultSet.getString(3));
                publication.setCheminF(resultSet.getString(4));
                publication.setNote(resultSet.getInt(7));
                publications.add(publication);

                membre.setId_membre(resultSet.getString(5));
                membres.add(membre);

                resultSet1=statement1.executeQuery("select * from commentaire where commentaire.id_pub="+
                        publication.getId_pub()+" order by id desc ;");
                compub=new Vector<>();
                while (resultSet1.next()){
                    commentaire=new Commentaire();
                    commentaire.setId_com(resultSet1.getInt(1));
                    commentaire.setContenu(resultSet1.getString(2));
                    commentaire.setMembre(resultSet1.getString(4));
                    compub.add(commentaire);
                }

                resultSet2=statement2.executeQuery("select * from pub_cle where pub_cle.id_pub="+publication.getId_pub()+";");
                motpub=new Vector<>();
                while (resultSet2.next()){
                    motCle=new MotCle() ;
                    motCle.setMot(resultSet2.getString("mot"));
                    motpub.add(motCle);
                }

                commmentaires.add(compub);
                motCles.add(motpub);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        objects[0]=publications;
        objects[1]=membres;
        objects[2]=commmentaires;
        objects[3]=motCles;
        return objects;
    }

    @Override
    public synchronized void  addPub(Publication publication, Membre membre, Vector<String> indexs, Vector<String> tags) {
        Connection connection=null ;
        PreparedStatement statement=null ;
        Statement statement1=null;
        ResultSet resultSet=null ;

        try {
            connection=daoFactory.getConnection();
            statement=connection.prepareStatement("insert into publication(contenut,date, chemin_fichier, id_membre)" +
                    "values (?,CURRENT_TIMESTAMP,?,?);");
            statement.setString(1,publication.getContenu());
            statement.setString(2,publication.getCheminF());
            statement.setString(3,membre.getId_membre());
            statement.executeUpdate();

           statement1=connection.createStatement();
            resultSet=statement1.executeQuery("SELECT LAST_INSERT_ID();");
            resultSet.next();
            if (indexs.size()>0 && !indexs.get(0).equals("")){
                addindex(indexs,resultSet.getInt(1));
            }
            if (tags.size()>0 && !tags.get(0).equals("")){
                addTag(tags,resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropPub(Publication publication) {

    }

    @Override
    public Object[] synchroPub(Publication pub) {
        Object [] objects=new Object[2];

        Connection connection=null ;
        Statement statement=null;
        ResultSet resultSet=null ;

        Vector<Publication> publications=new Vector<>();
        Publication publication;
        Vector<Membre> membres=new Vector<>();
        Membre membre ;


        try {
            connection=daoFactory.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from publication where id_pub>"+pub.getId_pub()+" order by id_pub desc ;");

            while (resultSet.next()){
                publication=new Publication();
                membre=new Membre();
                publication.setId_pub(resultSet.getInt(1));
                publication.setContenu(resultSet.getString(2));
                publication.setDate(resultSet.getString(3));
                publication.setCheminF(resultSet.getString(4));
                publications.add(publication);

                membre.setId_membre(resultSet.getString(5));
                membres.add(membre);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        objects[0]=publications;
        objects[1]=membres;

        return objects;

    }

    public void addindex(Vector<String> indexs, int id){
        Connection connection=null ;
        PreparedStatement statement=null;

        try {
            connection=daoFactory.getConnection();
            for (int i = 0; i <indexs.size() ; i++) {
                statement=connection.prepareStatement("insert into pub_cle(id_pub, mot) value (?,?)");
                statement.setInt(1,id);
                statement.setString(2,indexs.elementAt(i));
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTag(Vector<String> tags,int id){
        Connection connection=null ;
        PreparedStatement statement=null;

        try {
            connection=daoFactory.getConnection();
            for (int i = 0; i <tags.size() ; i++) {
                statement=connection.prepareStatement("insert into tags(id_pub, id_membre) value (?,?)");
                statement.setInt(1,id);
                statement.setString(2,tags.elementAt(i));
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
