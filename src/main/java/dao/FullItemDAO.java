package dao;

import model.FullItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FullItemDAO {


    public FullItem getByName(EntityManager em, String name){
        Query query = em.createQuery("from FullItem where name = :name");
        query.setParameter("name", name);
        List resultList = query.getResultList();
        FullItem resultItem = (FullItem) resultList.get(0);
        return resultItem;
    }

    //this method should not work
    public void getItemByName(String name){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tft_items");
        EntityManager em = emf.createEntityManager();

        FullItem fullItem = em.find(FullItem.class, name);


    }

    public String writeJSONFullItem(FullItem item){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", item.getName());
        jsonObj.put("special effect", item.getSpecialEffect());
        JSONArray parents = new JSONArray();
        parents.add(item.getBuildingItems().get(0));
        parents.add(item.getBuildingItems().get(1));
        jsonObj.put("Creation objects", parents);
        return jsonObj.toJSONString();

    }




}
