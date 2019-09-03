import model.FullItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullItemCreator {
    private List<FullItem> allFullItems = new ArrayList<>();

    public List<FullItem> getItemsList(){
        return allFullItems;
    }

    public void createItemsList(){
        createFullItem("Infinity Edge", "Critical Strikes deal +200% damage", "B.F. Sword", "B.F. Sword");
        createFullItem("Hextech Gunblade", "Heal for 25% of all damage dealt.", "B.F. Sword", "Needlessly Large Rod");
        createFullItem("Guardian Angel", "Wearer revives with 500 Health after a 2 sec delay", "B.F Sword", "Chain Vest ");
        createFullItem("Spear of Shojin", "After casting, gain 15% of max mana per attack", "B.F Sword", "Tear of the Goddess");
        createFullItem("Sword of the Divine", "Every 1s gain a 7% chance to gain 100% Critical Strike", "B.F. Sword", "Recurve Bow");
        createFullItem("Youmuu’s Ghostblade", "Wearer is also an Assassin", "B.F. Sword", "Spatula");
        createFullItem("The Bloodthirster", "Attacks heal for 40% of damage", "B.F. Sword", "Negatron Cloak");
        createFullItem("Zeke's Herald", "On start of combat, allies 2 spaces to the left and right gain +15% Attack Speed.", "B.F. Sword", "Giant’s Belt");

    }

    private void createFullItem(String name, String specialEffect, String firstParent, String secondParent){
        Map<String, String> parents = new HashMap<String, String>();
        parents.put(firstParent, secondParent);
        FullItem fullItem = new FullItem(name, specialEffect, parents);
        allFullItems.add(fullItem);

    }
}
