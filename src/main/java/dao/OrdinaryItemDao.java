package dao;
import model.OrdinaryItem;
import org.json.simple.JSONObject;
import javax.persistence.*;
import java.util.List;

public class OrdinaryItemDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tft_items");
    private EntityManager em = emf.createEntityManager();

    public OrdinaryItemDao() {
    }

    public String  getItemByNameToJSON(int id){
        OrdinaryItem ordinaryItem = getOrdinaryItem(id);
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("name", ordinaryItem.getName());
        sampleObject.put("statistic name", ordinaryItem.getStatistic_name());
        sampleObject.put("amount", ordinaryItem.getAmount());

        return sampleObject.toJSONString();
    }

    public OrdinaryItem getOrdinaryItem(int id) {
        return em.find(OrdinaryItem.class, id);
    }

    public String getAllItems(){
        Query query = em.createQuery("from OrdinaryItem");
        List<OrdinaryItem> ordinaryItemList = query.getResultList();
        StringBuilder jsonString = new StringBuilder();

        for (OrdinaryItem  item: ordinaryItemList
             ) {
            JSONObject sampleObject = new JSONObject();
            sampleObject.put("item", item.getName());
            sampleObject.put("statistic name", item.getStatistic_name());
            sampleObject.put("amount", item.getAmount());
            jsonString.append(sampleObject.toJSONString()).append("\n");
        }
        return jsonString.toString();
    }

    public void deleteItems(){
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Query query = em.createQuery("from OrdinaryItem");
            List<OrdinaryItem> ordinaryItemList = query.getResultList();
            for (OrdinaryItem item: ordinaryItemList
                 ) {
                em.remove(item);
                em.flush();
            }
            et.commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if (et.isActive()) et.rollback();
            em.close();
        }
    }

    public void addItems(List<OrdinaryItem> ordinaryItem){
        deleteItems();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        for (OrdinaryItem item: ordinaryItem
             ) {
            em.persist(item);
        }
        transaction.commit();
        System.out.printf("added new item");
    }

    public void delete(OrdinaryItem item){
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
}
