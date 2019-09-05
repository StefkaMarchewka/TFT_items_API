package servlets;

import dao.OrdinaryITemDao;
import model.OrdinaryItem;
import netscape.javascript.JSObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
            List<OrdinaryItem> ordinaryItemList = new ArrayList<>();
            for (Object object:  jsonList
                 ) {
                JSObject json = (JSObject) object;
                OrdinaryItem ordinaryItem = new OrdinaryItem((String) json.getMember("name"),
                        (String) json.getMember("statistic name"), (String) json.getMember("amount"));
                ordinaryItemList.add(ordinaryItem);
            }
            oID.addItems(ordinaryItemList);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("/collections")) {
            oID.delateItems();
        }
    }


}
