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

    @WebServlet(name = "OrdinaryItemServlet", urlPatterns = { "collections/ordinary/item/*"}, loadOnStartup = 1)
    public class OrdinaryItemServlet extends HttpServlet {

        OrdinaryITemDao oID = new OrdinaryITemDao();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String[] uriParts = req.getRequestURI().split("/");
            System.out.println(uriParts[3] + "dupa");
            resp.getWriter().write(oID.getItemByNameToJSON(3));

        }

        @Override
        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        }

        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        }


}