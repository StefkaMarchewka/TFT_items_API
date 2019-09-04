package model;



import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class OrdinaryItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    private String name;
    private String statistic_name;
    private String ammount;




    public OrdinaryItem() {
    }

    public OrdinaryItem(String name, String statistic_name, String ammount){
        this.ammount = ammount;
        this.name = name;
        this.statistic_name = statistic_name;

    }

    public String getName() {
        return name;
    }

    public String getStatistic_name() {
        return statistic_name;
    }

    public String getAmmount() {
        return ammount;
    }
}
