package servlets;

import dao.OrdinaryITemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "collectionservlet", urlPatterns = {"/collections", "collections/item/*"}, loadOnStartup = 1)
public class CollectionServlet extends HttpServlet {

    OrdinaryITemDao oID = new OrdinaryITemDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "json";
        String uri = req.getRequestURI();
        System.out.println(uri);
//        if (req.getRequestURI().length() > "/collection".length()){
//            System.out.println("sending item");
//            resp.getWriter().write(oID.getItemByNameToJSON(req.getRequestURI().substring(11)));
//
//
//        }
       if (req.getRequestURI().equals("/collections")){
            resp.getWriter().write(json);
        }
       else {
           resp.getWriter().write("everything else than collection");
       }

        resp.getWriter().write("collection spy");




    }
}
