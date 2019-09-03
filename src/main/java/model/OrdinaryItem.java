package model;

import java.util.HashMap;

public class OrdinaryItem {
    private String name;
    private String statistic_name;
    private String ammount;
    private HashMap matches;

    public OrdinaryItem(String name, String statistic_name, String ammount){
        this.ammount = ammount;
        this.name = name;
        this.statistic_name = statistic_name;
    }

    public void setMatches(HashMap matches) {
        this.matches = matches;
    }
}
