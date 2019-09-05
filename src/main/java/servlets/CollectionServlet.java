package servlets;

import dao.FullItemDAO;
import dao.OrdinaryITemDao;
import model.FullItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dupaservlet", urlPatterns = {"/dupa"}, loadOnStartup = 1)
public class CollectionServlet extends HttpServlet {

    OrdinaryITemDao oID = new OrdinaryITemDao();
    FullItemDAO fullItemDAO = new FullItemDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "json";
        String uri = req.getRequestURI();
        System.out.println(uri);


       if (req.getRequestURI().equals("/collections")){
            resp.getWriter().write(json);
        }
       else if (req.getRequestURI().contains("collections/item/")){
           String[] uriParts = req.getRequestURI().split("/");
           System.out.println(uriParts[3] + "dupa");
           String name = uriParts[3];
           FullItem itemToShow = fullItemDAO.getByName(name);
           resp.getWriter().write(fullItemDAO.writeJSONFullItem(itemToShow));
       }



        resp.getWriter().write("collection spy");




    }
}
