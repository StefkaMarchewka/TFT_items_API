package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "collection", urlPatterns = {"/collection"})
public class CollectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "json";
        if (req.getRequestURI().length() > "/collection".length()){

        }
        else if (req.getRequestURI().equals("/collection")){
            resp.getWriter().write(json);
        }


    }
}
