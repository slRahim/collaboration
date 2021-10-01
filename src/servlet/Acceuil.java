package servlet;

import DAO.DaoFactory;
import DAO.MembreDao;
import DAO.NotificationDao;
import DAO.PublicationDao;
import beans.Commentaire;
import beans.Compte;
import beans.Membre;
import com.google.gson.Gson;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "Acceuil")
public class Acceuil extends HttpServlet {

    private MembreDao membreDao;
    private PublicationDao publicationDao ;
    private NotificationDao notificationDao ;

    public void init() throws ServletException{
        DaoFactory daoFactory=DaoFactory.getInstance();
        this.membreDao=daoFactory.getMembreDao();
        this.publicationDao=daoFactory.getPublicationDao();
        this.notificationDao=daoFactory.getNotificationDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson=new Gson();
        Compte  compte=new Compte() ;
        compte.setId_email(request.getParameter("email"));
        compte.setPassword(request.getParameter("pass"));

        String str=membreDao.connexion(compte);
        if (str.equals("")){
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
        else {
            Object [] objects=publicationDao.getAll();


            HttpSession session = request.getSession();
            session.setAttribute("id_membre",str);
            request.setAttribute("tags_pub",notificationDao.getAll(str));
            request.setAttribute("publications",objects[0]);
            request.setAttribute("membres",objects[1]);
            request.setAttribute("commentaires",objects[2]);
            request.setAttribute("users",gson.toJson(membreDao.getAll()));
            request.setAttribute("l_pub",objects[3]);
            request.setAttribute("motCles",objects[4]);
            this.getServletContext().getRequestDispatcher("/Acceuil.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str= (String) request.getSession().getAttribute("id_membre");
        Gson gson=new Gson();

        Object [] objects=publicationDao.getAll();

        request.setAttribute("publications",objects[0]);
        request.setAttribute("tags_pub",notificationDao.getAll(str));
        request.setAttribute("membres",objects[1]);
        request.setAttribute("commentaires",objects[2]);
        request.setAttribute("users",gson.toJson(membreDao.getAll()));
        request.setAttribute("l_pub",objects[3]);
        request.setAttribute("motCles",objects[4]);
        this.getServletContext().getRequestDispatcher("/Acceuil.jsp").forward(request,response);
    }
}
