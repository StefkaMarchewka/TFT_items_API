import model.FullItem;
import model.OrdinaryItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MainTest {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tft_items");
        EntityManager em = emf.createEntityManager();
        FullItemCreator fullItemCreator = new FullItemCreator();
        fullItemCreator.createItemsList();
        List fullItems = fullItemCreator.getItemsList();
        fillDBOrdinaryItems(em);
        fillDBFullItems(em, fullItems);
        em.clear();
        em.close();
        emf.close();

    }

    public static void fillDBFullItems(EntityManager em, List<FullItem> itemToAdd){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        for (FullItem item:itemToAdd
             ) {
            em.persist(item);
        }
        transaction.commit();
    }




    public static void fillDBOrdinaryItems(EntityManager em){

        OrdinaryItem BFSword = new OrdinaryItem("B.F. Sword", "Attack damage", "+20");
        OrdinaryItem NeedLessLyLargeRod = new OrdinaryItem("Needlessly large rod", "Ability power", "+20");
        OrdinaryItem Negatron = new OrdinaryItem("Negatron Cloak", "Magic Resist", "+20");
        OrdinaryItem recurve = new OrdinaryItem("RECURVE BOW", "Attack speed", "+20%");
        OrdinaryItem spatula = new OrdinaryItem("SPATULA", "It must do something...", "");
        OrdinaryItem tear = new OrdinaryItem("TEAR OF THE GODDESS", "starting mana", "+20");
        OrdinaryItem belt = new OrdinaryItem("GIANT’S BELT", "health", "+200");
        OrdinaryItem vest = new OrdinaryItem("CHAIN VEST", "Armor", "+20");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(BFSword);
        em.persist(NeedLessLyLargeRod);
        em.persist(Negatron);
        em.persist(recurve);
        em.persist(spatula);
        em.persist(tear);
        em.persist(belt);
        em.persist(vest);
        transaction.commit();
        System.out.printf("added new item");
    };
}
