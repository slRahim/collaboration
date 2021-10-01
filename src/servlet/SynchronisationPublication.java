package servlet;

import DAO.DaoFactory;
import DAO.PublicationDao;
import beans.Publication;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SynchronisationPublication")
public class SynchronisationPublication extends HttpServlet {

    private PublicationDao publicationDao;

    public void init() throws ServletException{
        DaoFactory daoFactory=DaoFactory.getInstance();
        this.publicationDao=daoFactory.getPublicationDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int last_pub=Integer.parseInt(request.getParameter("last_pub"));
        Publication publication=new Publication();
        publication.setId_pub(last_pub);
         Object[] objects=publicationDao.synchroPub(publication);

         Gson gson=new Gson();
        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(objects));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
