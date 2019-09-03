package model;

import org.eclipse.persistence.annotations.PrimaryKey;

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


    @ElementCollection
    private Map<String, String> matches;

    public OrdinaryItem() {
    }

    public OrdinaryItem(String name, String statistic_name, String ammount, Map matches){
        this.ammount = ammount;
        this.name = name;
        this.statistic_name = statistic_name;
        this.matches = matches;
    }

    public void setMatches(HashMap matches) {
        this.matches = matches;

    }
}
