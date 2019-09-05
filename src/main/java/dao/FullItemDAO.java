package dao;

import model.FullItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.*;
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

    public void delete(FullItem item){
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();

            item = em.find(item.getClass(), item.getId());
            //Query query = em.createQuery("delete FullItem  where name = :name");
            //query.setParameter("name", item.getName());
            //query.executeUpdate();


            em.remove(item);
            em.flush();
            trans.commit();
        }catch (Exception e){
            System.out.println("error occured");
        }
        finally {
            if(trans.isActive()) trans.rollback();
            em.close();
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
