package servlets;

import com.google.gson.Gson;
import dao.FullItemDAO;
import model.FullItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "collectionServlet", urlPatterns = {"/collection"}, loadOnStartup = 1)
public class CollectionServlet extends HttpServlet {
    FullItemDAO dao = new FullItemDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(dao.getAllItems());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder jsonBuff = new StringBuilder();
        String line = null;
        try {
            BufferedReader bodyReader = req.getReader();
            while ((line = bodyReader.readLine()) != null)
                jsonBuff.append(line);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Error parsing JSON ");
        }

        String jsonBuffStr = jsonBuff.toString();
        Gson gson = new Gson();
        FullItem itemToAdd = gson.fromJson(jsonBuffStr, FullItem.class);
        dao.add(itemToAdd);
    }
}
