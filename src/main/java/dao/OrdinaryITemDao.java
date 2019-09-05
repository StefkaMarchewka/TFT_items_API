package dao;


// we didnt implement interface cuz we are laze and mentors are't here... :(

import model.OrdinaryItem;
import org.json.simple.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
