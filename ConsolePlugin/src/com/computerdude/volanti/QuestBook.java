package com.computerdude.volanti;

/*import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
*/import org.bukkit.event.Listener;/*
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
*/
public class QuestBook implements Listener {
	/*static int questsCompleted = 0;
	
	String QuestOption1 = Main.color("&0&lKill 1 Player");
	String QuestOption2 = Main.color("&0&lSell 25 Iron");
	String QuestOption3 = Main.color("&0&lChange your faction title");
	String QuestOption4 = Main.color("&0&lKill 15 Zombies");
	String QuestOption5 = Main.color("&0&lEquip Diamond Boots");
	
	String Quest1 = null;
	String Quest2 = null;
	String Quest3 = null;
	
	public static void addQuestOption(String option) {
		int num = ThreadLocalRandom.current().nextInt(1, 5);
		if (num == 1 && questsCompleted == 0) {
        
		}
	}

	public static ItemStack getQuestBook() {
		ItemStack sugarCake = SpecialItems.setMeta(new ItemStack(Material.ENCHANTED_BOOK),
				ChatColor.RESET + "" + ChatColor.GOLD + "" + ChatColor.BOLD + "Quest Book", PaperClaim.questlore);
		sugarCake.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

		return sugarCake;
	}
	
	
	
	@EventHandler(priority=EventPriority.HIGH)
 	public void onPlayerClick(PlayerInteractEvent event) {
    	 Player p = event.getPlayer();
    	 if(p.getInventory().getItemInMainHand().getType() == Material.ENCHANTED_BOOK
    	    	    && p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(PaperClaim.questlore)){
    	    	    	p.getInventory().removeItem(getQuestBook());
    	    	    	
    	    	    }
	}
*/
}
