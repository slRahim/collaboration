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

@WebServlet(name = "AllPublication")
public class AllPublication extends HttpServlet {

    private PublicationDao publicationDao;
    private NotificationDao notificationDao ;

    public void init() throws ServletException{
        DaoFactory daoFactory=DaoFactory.getInstance();
        this.publicationDao=daoFactory.getPublicationDao();
        this.notificationDao=daoFactory.getNotificationDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_membre=request.getParameter("id_membre");
        Object [] objects=publicationDao.getAll();

        request.setAttribute("tags_pub",notificationDao.getAll(id_membre));
        request.setAttribute("list_publication",objects[0]);
        request.setAttribute("list_membre",objects[1]);
        request.setAttribute("id_membre",id_membre);
        this.getServletContext().getRequestDispatcher("/recherche_pub.jsp").forward(request,response);

    }
}
