package helpers;

import model.FullItem;

import java.util.ArrayList;
import java.util.List;

public class FullItemCreator {
    private List<FullItem> allFullItems = new ArrayList();

    public List<FullItem> getItemsList(){
        return allFullItems;
    }

    public void createItemsList(){
        saveItemToList("Infinity Edge", "Critical Strikes deal +200% damage", "B.F. Sword", "B.F. Sword");
        saveItemToList("Hextech Gunblade", "Heal for 25% of all damage dealt.", "B.F. Sword", "Needlessly Large Rod");
        saveItemToList("Guardian Angel", "Wearer revives with 500 Health after a 2 sec delay", "B.F Sword", "Chain Vest ");
        saveItemToList("Spear of Shojin", "After casting, gain 15% of max mana per attack", "B.F Sword", "Tear of the Goddess");
        saveItemToList("Sword of the Divine", "Every 1s gain a 7% chance to gain 100% Critical Strike", "B.F. Sword", "Recurve Bow");
        saveItemToList("Youmuu’s Ghostblade", "Wearer is also an Assassin", "B.F. Sword", "Spatula");
        saveItemToList("The Bloodthirster", "Attacks heal for 40% of damage", "B.F. Sword", "Negatron Cloak");
        saveItemToList("Zeke's Herald", "On start of combat, allies 2 spaces to the left and right gain +15% Attack Speed.", "B.F. Sword", "Giant’s Belt");
        saveItemToList("Locket of the Iron Solari", "On start of combat, allies two spaces to the left and right gain a shield of 250 for 6 seconds.", "Chain Vest", "Needlessly Large Rod ");
        saveItemToList("Thornmail", "Reflect 100% of mitigated damage taken from attacks as magic damage.", "Chain Vest", "Chain Vest");
        saveItemToList("Phantom Dancer", "Wearer dodges all Critical Strikes.","Chain Vest",  "Recurve Bow");
        saveItemToList("Frozen Heart", "Adjacent enemies lose 25% Attack Speed.", "Chain Vest", "Tear of the Goddess");
        saveItemToList("Sword Breaker", "Attacks have a 25% chance to disarm", "Chain Vest", "Negatron Cloak");
        saveItemToList("Red Buff", "Attacks burn for 20% of max HP over 10s and disable healing", "Chain Vest", "Giant’s Belt");
        saveItemToList("Knight’s Vow", "Wearer is also a Knight", "Chain Vest", "Spatula" );
        saveItemToList("Titanic Hydra", "Attacks deal 10% of the wearer's max HP as splash.", "Giant's Belt", "Recurve Bow");
        saveItemToList("Morellonomicon","Spells deal burn damage equal to 20% of enemy’s max hp over 10s & prevent healing.", "Giant's Belt", "Needlessly Large Rod");
        saveItemToList("Redemption", "At 25% health heal all nearby allies for 1200 HP.", "Giant's Belt", "Tear of the Goddess ");
        saveItemToList("Zephyr", "On start of combat, banish an enemy for 5 seconds", "Giant's Belt", "Negatron Cloak");
        saveItemToList("Warmog's Armor","Wearer regenerates 6% of missing health per second.",  "Giant's Belt", "Giant's Belt");
        saveItemToList("Frozen Mallet", "Wearer is also a Glacial.", "Giant's Belt", "Spatula");
        saveItemToList("Guinsoo's Rageblade","Attacks grant 5% Attack Speed. Stacks infinitely.",  "Recurve Bow ", "Needlessly Large Rod");
        saveItemToList("Rabadon's Deathcap", "Wearer's Ability Damage increased by 50%.", "Needlessly Large Rod", "Needlessly Large Rod");
        saveItemToList("Yuumi", "Wearer is also a Sorcerer.", "Spatula", "Needlessly Large Rod");
        saveItemToList("Ionic Spark", "Whenever an enemy casts a spell, they take 125 true damage", "Negatron Cloak","Needlessly Large Rod" );
        saveItemToList("Luden's Echo", "Deal 180 splash damage on ability hit.", "Tear of the Goddess", "Needlessly Large Rod ");
        saveItemToList("Hush", "33% chance on hit to prevent the enemy champion from gaining mana for 4 seconds.", "Tear of the Goddess", "Negatron Cloak");
        saveItemToList("Cursed Blade", "Attacks have a 20% chance to Shrink (Reduce enemy's star level by 1)", "Recurve Bow", "Negatron Cloak");
        saveItemToList("Runaan's Hurricane", "Attacks hit 1 additional enemy. This extra hit does 75% damage and applies on-hit effects.", "Spatula", "Negatron Cloak");
        saveItemToList("Dragon’s Claw", "83% resistance to magic damage", "Negatron Cloak", "Negatron Cloak");
        saveItemToList("Stattik Shiv", "Every 3rd attack deals 100 splash magical damage to 2 additional targets.", "Tear of the Goddess", "Recurve Bow");
        saveItemToList("Rapid Fire Cannon", "Attacks cannot be dodged. Attack Range is doubled.", "Recurve Bow", "Recurve Bow");
        saveItemToList("Blade of the Ruined King", "Wearer is also a Blademaster.", "Recurve Bow ", "Spatula");
        saveItemToList("Force of Nature", "Gain + team size","Spatula", "Spatula" );
        saveItemToList("Darkin", "Wearer is also a Demon","Tear of the Goddess", "Spatula");
        saveItemToList("Seraph's Embrace", "Regain 20 mana each time a spell is cast.", "Tear of the Goddess", "Tear of the Goddess");
    }

    private void saveItemToList(String name, String specialEffect, String firstParent, String secondParent){
        ArrayList<String> parents = new ArrayList<String>();
        parents.add(firstParent);
        parents.add(secondParent);
        FullItem fullItem = new FullItem(name, specialEffect, parents);
        allFullItems.add(fullItem);

    }

    public FullItem makeItem(String name, String specialEffect, String firstParent, String secondParent){
        ArrayList<String> parents = new ArrayList<String>();
        parents.add(firstParent);
        parents.add(secondParent);
        return new FullItem(name, specialEffect, parents);
    }
}
