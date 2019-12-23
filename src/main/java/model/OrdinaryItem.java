package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrdinaryItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    private String name;
    private String statistic_name;
    private String amount;

    public OrdinaryItem() {
    }

    public OrdinaryItem(String name, String statistic_name, String ammount){
        this.amount = ammount;
        this.name = name;
        this.statistic_name = statistic_name;
    }

    public String getName() {
        return name;
    }

    public String getStatistic_name() {
        return statistic_name;
    }

    public String getAmount() {
        return amount;
    }

    public int getId() { return id; }
}
