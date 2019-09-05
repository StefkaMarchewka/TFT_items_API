package model;

import javax.persistence.*;
import java.util.List;

@NamedQuery(name="FullItem.findByName",
        query = "SELECT item.name FROM FullItem item where item.name like :inputName")

@Entity
public class FullItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialEffect;
    @ElementCollection
    private List<String> buildingItems;

    public FullItem() {
    }



    public FullItem(String name, String specialEffect, List<String> buildingItems) {
        this.name = name;
        this.specialEffect = specialEffect;
        this.buildingItems = buildingItems;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialEffect() {
        return specialEffect;
    }

    public List<String> getBuildingItems() {
        return buildingItems;
    }
}
