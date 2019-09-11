package servlets;

import dao.FullItemDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "collectionServlet", urlPatterns = {"/collection"}, loadOnStartup = 1)
public class CollectionServlet extends HttpServlet {
    FullItemDAO dao = new FullItemDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(dao.getAllItems());

    }
}
