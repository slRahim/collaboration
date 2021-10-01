package servlet;

import DAO.DaoFactory;
import DAO.NotificationDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SynchroNotification")
public class SynchroNotification extends HttpServlet {

    private NotificationDao notificationDao ;

    public void init() throws ServletException{
        DaoFactory daoFactory=DaoFactory.getInstance();
        this.notificationDao=daoFactory.getNotificationDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String id_membre= (String) request.getSession().getAttribute("id_membre");
      int pub=Integer.parseInt(request.getParameter("pub"));

        //System.out.println(id_membre+" last_pub "+pub);

        Gson gson=new Gson();
        response.setContentType("application/json");
       response.getWriter().print(gson.toJson(notificationDao.syncroNotification(id_membre,pub)));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
