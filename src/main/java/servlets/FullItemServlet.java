package servlets;


import dao.FullItemDAO;
import helpers.FullItemCreator;
import model.FullItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FullItemServlet", urlPatterns = {"/collection/fullItem/*"}, loadOnStartup = 1)
public class FullItemServlet extends HttpServlet {

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


    private int getIndexFromUri(HttpServletRequest req) {
        String[] uriParts = req.getRequestURI().split("/");
        int lastElemFromUri = uriParts.length-1;
        String nameToParse = uriParts[lastElemFromUri];
        int index = Integer.parseInt(nameToParse);
        return index;
    }

}

