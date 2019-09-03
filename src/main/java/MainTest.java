import model.FullItem;
import model.OrdinaryItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {
    List<FullItem> allFullItems = new ArrayList<>();

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tft_items");
        EntityManager em = emf.createEntityManager();

        fillDBOrdinaryItems(em);
        em.clear();

        em.close();
        emf.close();

    }

    public static void fillDBFullItems(EntityManager em){

    }

    public void createFullItems(){
        allFullItems = new ArrayList<>();
        Map<String, String> infEndg = new HashMap<String, String>();
        infEndg.put("BF Sword", "BF Sword");
        FullItem infinityEdge = new FullItem("Infinity Edge", "Critical Strikes deal +200% damage", infEndg);
        allFullItems.add(infinityEdge);

        Map<String, String> swordOfDivineMap= new HashMap<String, String>();
        infEndg.put("BF Sword", "Recurve Bow");
        FullItem swordOfDivineObj = new FullItem("Sword of Divine", "Every 1s gain a 7% chance to gain 100% Critical Strike", swordOfDivineMap);
        allFullItems.add(swordOfDivineObj);

        Map<String, String> HextechMap= new HashMap<String, String>();
        infEndg.put("BF Sword", "Needlessly Large Rod");
        FullItem NeedlesslyLargeRod = new FullItem("Needlessly Large Rod", "Heal for 25% of all damage dealt", HextechMap );
        allFullItems.add(NeedlesslyLargeRod);


        Map<String, String> GuardianAngelMap= new HashMap<String, String>();
        GuardianAngelMap.put("BF Sword", "Chain Vest");
        FullItem GuardianAngelIbj = new FullItem("Guardian Angel", "Wearer revives with 500 Health after a 2 sec delay", GuardianAngelMap);
        allFullItems.add(GuardianAngelIbj);

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
