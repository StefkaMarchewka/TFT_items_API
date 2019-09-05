package servlets;

import dao.OrdinaryITemDao;
import netscape.javascript.JSObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "collectionservlet", urlPatterns = {"/collections", "collections/item/*"}, loadOnStartup = 1)
public class CollectionServlet extends HttpServlet {

    OrdinaryITemDao oID = new OrdinaryITemDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "json";
        String uri = req.getRequestURI();
        System.out.println(uri);

       if (req.getRequestURI().equals("/collections")){
            resp.getWriter().write(oID.getAllItems());
        }
       else if (req.getRequestURI().contains("collections/item/")){
           String[] uriParts = req.getRequestURI().split("/");
           System.out.println(uriParts[3] + "dupa");
           resp.getWriter().write(oID.getItemByNameToJSON(3));
       }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("/collections")){
            List jsonList = (List)  req.getAttribute("collection");
            JSObject json = (JSObject) jsonList.get(0);
            String name = (String) json.getMember("name");
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("/collections")) {
            oID.delateItems();
        }
    }


}
