package servlet;

import DAO.DaoFactory;
import DAO.NotificationDao;
import DAO.PublicationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PublicationTag")
public class PublicationTag extends HttpServlet {

    private PublicationDao publicationDao ;
    private NotificationDao notificationDao ;

    public void init() throws ServletException{
        DaoFactory daoFactory=DaoFactory.getInstance();
        this.publicationDao=daoFactory.getPublicationDao();
        this.notificationDao=daoFactory.getNotificationDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String mot_cle=request.getParameter("mot_cle");
          String id_membre= (String) request.getSession().getAttribute("id_membre");

        Object [] objects=publicationDao.getPubMot(mot_cle);

        request.setAttribute("tags_pub",notificationDao.getAll(id_membre));
        request.setAttribute("publications",objects[0]);
        request.setAttribute("membres",objects[1]);
        request.setAttribute("commentaires",objects[2]);
        request.setAttribute("motCles",objects[3]);
        this.getServletContext().getRequestDispatcher("/publication.jsp").forward(request,response);
    }
}
