package model;

import javax.persistence.*;
import java.util.Map;

@Entity

public class FullItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String specialEffect;
    @ElementCollection
    Map<String, String> buildingItems;

    public FullItem() {
    }

    public FullItem(String name, String specialEffect, Map<String, String> buildingItems) {
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

    public Map<String, String> getBuildingItems() {
        return buildingItems;
    }
}
