package dao;


// we didnt implement interface cuz we are laze and mentors are't here... :(

import model.OrdinaryItem;
import org.json.simple.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class OrdinaryITemDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tft_items");
    private EntityManager em = emf.createEntityManager();

    public OrdinaryITemDao() {
    }


    public String  getItemByNameToJSON(int id){
        OrdinaryItem ordinaryItem = em.find(OrdinaryItem.class, id);

        JSONObject sampleObject = new JSONObject();
        sampleObject.put("name", ordinaryItem.getName());
        sampleObject.put("statistic name", ordinaryItem.getStatistic_name());
        sampleObject.put("amount", ordinaryItem.getAmmount());




        return sampleObject.toJSONString();
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
            sampleObject.put("amount", item.getAmmount());
            jsonString.append(sampleObject.toJSONString()).append("\n");
        }


        return jsonString.toString();
    }






    public void delateItems(){
        Query query = em.createQuery("from OrdinaryItem");
        List<OrdinaryItem> ordinaryItemList = query.getResultList();

        int id = ordinaryItemList.size();
        for (int i = 0; i < id; i++) {
            Query queryToDelate = em.createQuery("delete from OrdinaryItem where id=:i" );
        }


    }


}
