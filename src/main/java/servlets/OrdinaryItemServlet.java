package servlets;

import dao.OrdinaryITemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "OrdinaryItemServlet", urlPatterns = { "collection/ordinaryItem/*"}, loadOnStartup = 1)
    public class OrdinaryItemServlet extends HttpServlet {

        OrdinaryITemDao oID = new OrdinaryITemDao();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String[] uriParts = req.getRequestURI().split("/");
            int id = Integer.parseInt(uriParts[3]);
            resp.getWriter().write(oID.getItemByNameToJSON(id));
        }

        @Override
        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        }

        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        }
    }
