package model;

import java.util.HashMap;

public class OrdinaryItem {
    String name;
    String statistic_name;
    String ammount;
    HashMap matches;

    public OrdinaryItem(String name, String statistic_name, String ammount){
        this.ammount = ammount;
        this.name = name;
        this.statistic_name = statistic_name;
    }

    public void setMatches(HashMap matches) {
        this.matches = matches;
    }
}
