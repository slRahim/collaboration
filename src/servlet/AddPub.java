package servlet;

import DAO.DaoFactory;
import DAO.PublicationDao;
import beans.Membre;
import beans.Publication;

import javax.activation.MailcapCommandMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "AddPub")
@MultipartConfig
public class AddPub extends HttpServlet {

    private PublicationDao publicationDao;

    public void init() throws ServletException{
        DaoFactory daoFactory=DaoFactory.getInstance();
        this.publicationDao=daoFactory.getPublicationDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection<Part> parts=request.getParts();
        String path=null;
        Iterator<Part> o=parts.iterator();
        if (!DaoFactory.extractFileName(o.next()).equals("")){
            path=DaoFactory.saveFiles(parts);
            DaoFactory.zipFile(path);
            path=path+".zip" ;
        }
        Publication  publication=new Publication() ;
        publication.setContenu(request.getParameter("contenu"));
        if (path!=null){
            publication.setCheminF(path.substring(49));
        }
        Membre membre=new Membre();
        membre.setId_membre(request.getParameter("membre"));
        Vector<String> indexs=new Vector<>(Arrays.asList(request.getParameter("liste_index").split(",")));
        Vector<String> tags=new Vector<>(Arrays.asList(request.getParameter("liste_tag").split(",")));


       publicationDao.addPub(publication,membre,indexs,tags);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
