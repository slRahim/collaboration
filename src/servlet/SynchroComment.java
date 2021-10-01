package servlet;

import DAO.CommentaireDao;
import DAO.DaoFactory;
import beans.Commentaire;
import beans.Publication;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.VetoableChangeListener;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "SynchroComment")
public class SynchroComment extends HttpServlet {

    private CommentaireDao commentaireDao;

    public void init() throws ServletException{
        DaoFactory daoFactory=DaoFactory.getInstance();
        this.commentaireDao=daoFactory.getCommentaireDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id_pub=Integer.parseInt(request.getParameter("id_pub"));

        Publication publication=new Publication();
        publication.setId_pub(id_pub);

        Gson gson=new Gson();

        Vector<Commentaire> commentaires=commentaireDao.getAll(publication);
        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(commentaires));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
