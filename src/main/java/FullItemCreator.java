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
        createFullItem("Locket of the Iron Solari", "On start of combat, allies two spaces to the left and right gain a shield of 250 for 6 seconds.", "Chain Vest", "Needlessly Large Rod ");
        createFullItem("Thornmail", "Reflect 100% of mitigated damage taken from attacks as magic damage.", "Chain Vest", "Chain Vest");
        createFullItem("Phantom Dancer:", "Wearer dodges all Critical Strikes.","Chain Vest",  "Recurve Bow");
        createFullItem("Frozen Heart", "Adjacent enemies lose 25% Attack Speed.", "Chain Vest", "Tear of the Goddess");
        createFullItem("Sword Breaker", "Attacks have a 25% chance to disarm", "Chain Vest", "Negatron Cloak");
        createFullItem("Red Buff", "Attacks burn for 20% of max HP over 10s and disable healing", "Chain Vest", "Giant’s Belt");
        createFullItem("Knight’s Vow", "Wearer is also a Knight", "Chain Vest", "Spatula" );
        createFullItem("Titanic Hydra", "Attacks deal 10% of the wearer's max HP as splash.", "Giant's Belt", "Recurve Bow");
        createFullItem("Morellonomicon","Spells deal burn damage equal to 20% of enemy’s max hp over 10s & prevent healing.", "Giant's Belt", "Needlessly Large Rod");
        createFullItem("Redemption", "At 25% health heal all nearby allies for 1200 HP.", "Giant's Belt", "Tear of the Goddess ");
        createFullItem("Zephyr", "On start of combat, banish an enemy for 5 seconds", "Giant's Belt", "Negatron Cloak");
        createFullItem("Warmog's Armor","Wearer regenerates 6% of missing health per second.",  "Giant's Belt", "Giant's Belt");
        createFullItem("Frozen Mallet", "Wearer is also a Glacial.", "Giant's Belt", "Spatula");
    }

    private void createFullItem(String name, String specialEffect, String firstParent, String secondParent){
        Map<String, String> parents = new HashMap<String, String>();
        parents.put(firstParent, secondParent);
        FullItem fullItem = new FullItem(name, specialEffect, parents);
        allFullItems.add(fullItem);

    }
}
