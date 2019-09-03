import model.OrdinaryItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class MainTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tft_items");
        EntityManager em = emf.createEntityManager();

        fillDBOrdinaryItems(em);
        em.clear();

        em.close();
        emf.close();

    }


    public static void fillDBOrdinaryItems(EntityManager em){

        Map<String, String> bFAndBF = new HashMap<String, String>();
        bFAndBF.put("B.F. Sword", "Infinity edge");
        OrdinaryItem BFSword = new OrdinaryItem("B.F. Sword", "Attack damage", "+20", bFAndBF);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(BFSword);
        transaction.commit();
        System.out.printf("added new item");
    };
}
