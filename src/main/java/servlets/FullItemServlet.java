package servlets;


import dao.FullItemDAO;
import dao.OrdinaryITemDao;
import helpers.FullItemCreator;
import model.FullItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "collectionServlet", urlPatterns = {"/collections/fullItems/*"}, loadOnStartup = 1)
public class FullItemServlet extends HttpServlet {

    OrdinaryITemDao oID = new OrdinaryITemDao();
    FullItemDAO fullItemDAO = new FullItemDAO();
    FullItemCreator itemCreator = new FullItemCreator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = getIndexFromUri(req);
        FullItem itemToShow = fullItemDAO.getItem(index);
        resp.getWriter().write(fullItemDAO.writeJSONFullItem(itemToShow));

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = getIndexFromUri(req);
        FullItem itemToDel = fullItemDAO.getItem(index);
        fullItemDAO.delete(itemToDel);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("name");
        String desc = req.getParameter("desc");
        String firstParent = req.getParameter("p1");
        String secondParent = req.getParameter("p2");

        FullItem itemToAdd = itemCreator.makeItem(name, desc, firstParent, secondParent);
        fullItemDAO.add(itemToAdd);
    }

    private int getIndexFromUri(HttpServletRequest req) {
        String uri = req.getRequestURI();
        String[] uriParts = req.getRequestURI().split("/");
        String nameToParse = uriParts[3];
        int index = Integer.valueOf(nameToParse);
        return index;
    }


}

