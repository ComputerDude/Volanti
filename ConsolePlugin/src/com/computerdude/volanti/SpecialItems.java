package com.computerdude.volanti;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpecialItems implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("givemindgem") && sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("volanti.admin")) {
				((Player) sender).getInventory().addItem(getMindGem());
			} else {
				player.sendMessage(Main.color("&cNo Permission"));
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("givesuncalc") && sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("volanti.admin")) {
				((Player) sender).getInventory().addItem(getSunCalc());
			} else {
				player.sendMessage(Main.color("&cNo Permission"));
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("givesugarcake") && sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("volanti.admin")) {
				((Player) sender).getInventory().addItem(getSugarCake());
			} else {
				player.sendMessage(Main.color("&cNo Permission"));
			}
			return true;
		} //else if(cmd.getName().equalsIgnoreCase("givequestbook") && sender instanceof Player) {
			//Player player = (Player) sender;
			//if(player.hasPermission("volanti.admin")) {
			//	((Player) sender).getInventory().addItem(QuestBook.getQuestBook());
			//} else {
			//	player.sendMessage(Main.color("&cNo Permission"));
			//}
		//	return true;
		//}
		return false;
	} 

	/**
	 * 
	 * @return The mind gem item.
	 */
	public static ItemStack getMindGem() {

		ItemStack newItem = setMeta(new ItemStack(Material.EMERALD),
				ChatColor.RESET + "" + ChatColor.AQUA + "" + ChatColor.BOLD + "Mind Gem", Arrays.asList(
						ChatColor.GRAY + "Trade this item at " + ChatColor.YELLOW + "" + ChatColor.BOLD + "/eshop"));
		newItem.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

		return newItem;

	}

	public static ItemStack getSunCalc() {
		ItemStack sunCalc = setMeta(new ItemStack(Material.WATCH),
				ChatColor.RESET + "" + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sun Dial",
				PaperClaim.sunlore);
		sunCalc.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

		return sunCalc;
	}
	
	public static ItemStack getSugarCake() {
		ItemStack sugarCake = setMeta(new ItemStack(Material.CAKE),
				ChatColor.RESET + "" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Sugar Cake",
				PaperClaim.cakelore);
		sugarCake.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		return sugarCake;
	}

	public static ItemStack setMeta(ItemStack material, String name, List<String> lore) {
		if (((material == null) || material.getType() == Material.AIR) || ((name == null) && lore == null))
			return null;

		ItemMeta im = material.getItemMeta();
		if (name != null)
			im.setDisplayName(name);
		if (lore != null)
			im.setLore(lore);

		material.setItemMeta(im);
		return material;

	}

}
