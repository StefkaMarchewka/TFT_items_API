package dao;

import jdk.nashorn.api.scripting.JSObject;
import model.FullItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FullItemDAO {

    public void getItemByName(String name){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tft_items");
        EntityManager em = emf.createEntityManager();

        FullItem fullItem = em.find(FullItem.class, name);


    }

    public String writeJSONFullItem(FullItem item){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", item.getName());
        jsonObj.put("special effect", item.getSpecialEffect());
        JSONArray parents = new JSONArray().put();
        jsonObj.put()



    }




}
