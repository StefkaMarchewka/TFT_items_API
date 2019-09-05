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

@WebServlet(name = "collectionservlet", urlPatterns = {"/collections/fullitems/*"}, loadOnStartup = 1)
public class FullItemServlet extends HttpServlet {

    OrdinaryITemDao oID = new OrdinaryITemDao();
    FullItemDAO fullItemDAO = new FullItemDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = getItemNameFromUri(req);
        FullItem itemToShow = fullItemDAO.getByName(name);
        resp.getWriter().write(fullItemDAO.writeJSONFullItem(itemToShow));

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = getItemNameFromUri(req);
        FullItem itemToDel = fullItemDAO.getByName(name);
        fullItemDAO.delete(itemToDel);
    }

    private String getItemNameFromUri(HttpServletRequest req) {
        String uri = req.getRequestURI();

        String[] uriParts = req.getRequestURI().split("/");
        //System.out.println(uriParts[3] + " dupa");
        String name = "";
        String nameToParse = uriParts[3];
        if(nameToParse.contains("_")){
            String[] splited = nameToParse.split("_");
            StringBuilder sb = new StringBuilder();
            sb.append(splited[0]);
            sb.append(" ");
            sb.append(splited[1]);

            name = sb.toString();
        }else name = uriParts[3];
        return name;
    }


}

