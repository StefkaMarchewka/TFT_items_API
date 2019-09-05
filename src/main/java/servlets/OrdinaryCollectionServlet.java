package servlets;

import dao.OrdinaryITemDao;
import jdk.nashorn.api.scripting.JSObject;
import model.OrdinaryItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrdinaryCollectionservlet", urlPatterns = {"/collections/ordinary"}, loadOnStartup = 1)
public class OrdinaryCollectionServlet extends HttpServlet {

    OrdinaryITemDao oID = new OrdinaryITemDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(oID.getAllItems());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        oID.delateItems();

    }


}