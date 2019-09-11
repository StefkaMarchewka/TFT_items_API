package servlets;


import com.google.gson.Gson;
import dao.FullItemDAO;
import dao.OrdinaryITemDao;
import helpers.FullItemCreator;
import model.FullItem;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "itemServlet", urlPatterns = {"/collection/*"}, loadOnStartup = 1)
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
//        String name= req.getParameter("name");
//        String desc = req.getParameter("desc");
//        String firstParent = req.getParameter("p1");
//        String secondParent = req.getParameter("p2");


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
        System.out.println("Request JSON string :" + jsonBuff.toString());
        JSONParser parser = new JSONParser();
        String jsonBuffStr = jsonBuff.toString();
        Gson gson = new Gson();
        FullItem itemToAdd = gson.fromJson(jsonBuffStr, FullItem.class);
        fullItemDAO.add(itemToAdd);
    }



    private int getIndexFromUri(HttpServletRequest req) {
        String uri = req.getRequestURI();
        String[] uriParts = req.getRequestURI().split("/");
        String nameToParse = uriParts[2];
        int index = Integer.valueOf(nameToParse);
        return index;
    }


}

