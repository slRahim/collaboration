package servlet;

import DAO.CommentaireDao;
import DAO.DaoFactory;
import beans.Commentaire;
import beans.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddComment")
public class AddComment extends HttpServlet {


    private CommentaireDao commentaireDao;

    public void init() throws ServletException{
        DaoFactory daoFactory=DaoFactory.getInstance();
        this.commentaireDao=daoFactory.getCommentaireDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String text_comment=request.getParameter("text_comment");
         int id_pub=Integer.parseInt(request.getParameter("id_pub"));

        Commentaire commentaire=new Commentaire();
        commentaire.setMembre(request.getParameter("id_membre"));
        commentaire.setContenu(text_comment);

        Publication publication=new Publication();
        publication.setId_pub(id_pub);


        commentaireDao.addComment(commentaire,publication);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
