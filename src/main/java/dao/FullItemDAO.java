package dao;

import model.FullItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.persistence.*;
import java.util.List;

public class FullItemDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tft_items");
    private EntityManager em = emf.createEntityManager();

    public void add(FullItem item){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(item);
        transaction.commit();
    }

    public String getAllItems(){
        Query query = em.createQuery("from FullItem");
        List<FullItem> itemList = query.getResultList();
        StringBuilder jsonString = new StringBuilder();
        for (FullItem  item: itemList
        ) {
            JSONObject sampleObject = new JSONObject();
            sampleObject.put("name", item.getName());
            sampleObject.put("specialEffect", item.getSpecialEffect());
            JSONArray buildingItems = new JSONArray();
            buildingItems.add(item.getBuildingItems().get(0));
            buildingItems.add(item.getBuildingItems().get(1));
            sampleObject.put("building Items", buildingItems);
            jsonString.append(sampleObject.toJSONString()).append("\n");
        }
        return jsonString.toString();
    }


    public FullItem getByName(String name){
        Query query = em.createQuery("from FullItem where name = :name");
        query.setParameter("name", name);
        List<FullItem> resultList = query.getResultList();
        return resultList.get(0);
    }

    public FullItem getItem(int index){
        FullItem item = em.find(FullItem.class, index);
        return item;
    };

    public void delete(FullItem item){
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            item = em.find(item.getClass(), item.getId());
            em.remove(item);
            em.flush();
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(trans.isActive()) trans.rollback();
        }

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
