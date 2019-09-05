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
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tft_items");
    private EntityManager em = emf.createEntityManager();

    //nie działa z powodu niekompatybilnych typów, string nie mzo ebyc fullItem ???? dlacego tak?
    public FullItem getItemByName(String name){
        //Object fullItemObj = em.createNamedQuery("FullItem.findByName")
         //       .setParameter("inputName", name).getSingleResult();
        //FullItem fi = (FullItem) fullItemObj;
        List<FullItem> fullItemObj = em.createNamedQuery("FullItem.findByName", FullItem.class)
               .setParameter("inputName", name).getResultList();
        return fullItemObj.get(0);
    };

    public FullItem getByName(String name){
        Query query = em.createQuery("from FullItem where name = :name");
        query.setParameter("name", name);
        List<FullItem> resultList = query.getResultList();
        return resultList.get(0);
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


    public List<FullItem>




}
