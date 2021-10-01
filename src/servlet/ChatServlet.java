package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import beans.* ;

@WebServlet(name = "ChatServlet")
public class ChatServlet extends HttpServlet {

        ArrayList<Sms> msgs = new ArrayList<Sms>();
        String msg;
        String author;
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            this.getServletContext().getRequestDispatcher("/chat.jsp").forward(req, resp);
        }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setCharacterEncoding("utf-8");
            // si la requete contient l'attribut "refresh"
            if(req.getParameter("refresh")!=null){
                int num = Integer.parseInt(req.getParameter("refresh"));
                //on parcours le array
                if(num < msgs.size() ){
                    String author,content;
                    int id;
                    for (int i = num; i < msgs.size(); i++) {
                        author = ((Sms) msgs.get(i)).getAuthor();
                        content = ((Sms) msgs.get(i)).getContent();
                        content = content.replace("\n", "");
                        System.out.println("messageContent : "+content);
                        // envoie de message de retour qui est sous forme d'un objet JSON
                        resp.getWriter().write("{\"author\":\""+author+"\",\"content\":\""+content+"\"}+");
                    }
                }
            }else{
                msg = req.getParameter("msg");
                author = req.getParameter("author");
                // création de l'objet message
                msgs.add(new Sms(msgs.size(),msg,author));
                resp.getWriter().write(author+"+"+msg+"+"+ msgs.size());
            }
        }
}

