package servlets;

import dao.OrdinaryItemDao;
import model.OrdinaryItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "OrdinaryItemServlet", urlPatterns = { "collection/ordinaryItem/*"}, loadOnStartup = 1)
    public class OrdinaryItemServlet extends HttpServlet {

        OrdinaryItemDao dao = new OrdinaryItemDao();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = getId(req);
            resp.getWriter().write(dao.getItemByIdToJSON(id));
        }

        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = getId(req);
            OrdinaryItem itemToDel = dao.getOrdinaryItem(id);
            dao.delete(itemToDel);
        }

        private int getId(HttpServletRequest req) {
            String[] uriParts = req.getRequestURI().split("/");
            int lastElement = uriParts.length-1;
            return Integer.parseInt(uriParts[lastElement]);
        }
    }
