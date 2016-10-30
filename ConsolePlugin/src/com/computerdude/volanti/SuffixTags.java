package com.computerdude.volanti;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SuffixTags implements CommandExecutor,Listener{
	public static ArrayList<String> locked = new ArrayList<String>();
	public static ArrayList<String> unlocked = new ArrayList<String>();
	public static ArrayList<String> enabled = new ArrayList<String>();
	
	public static void Init2() {
		unlocked.add(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "UNLOCKED");
		locked.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "LOCKED");
	}

	private void openTagGUI(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Tag Menu");
		
		ItemStack betaTag = new ItemStack (Material.NAME_TAG);
        ItemMeta betaTagMeta = betaTag.getItemMeta();
        betaTagMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Beta Tag");
        
        if(player.hasPermission("volanti.beta")) {
        	betaTagMeta.setLore(unlocked);
        } else {
        	betaTagMeta.setLore(locked);
        }
        
        betaTag.setItemMeta(betaTagMeta);
        inv.setItem(4, betaTag);
        
        ItemStack cakeTag = new ItemStack (Material.NAME_TAG);
        ItemMeta cakeTagMeta = cakeTag.getItemMeta();
        cakeTagMeta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Cake4Lyfe Tag");
        
        if(player.hasPermission("volanti.cakelyfe")) {
        	cakeTagMeta.setLore(unlocked);
        } else {
        	cakeTagMeta.setLore(locked);
        }
        
        cakeTag.setItemMeta(cakeTagMeta);
        inv.setItem(1, cakeTag);
		
        ItemStack none = new ItemStack (Material.BARRIER);
        ItemMeta noneMeta = none.getItemMeta();
        noneMeta.setDisplayName(Main.color("&4&lDisable Tags"));
        none.setItemMeta(noneMeta);
        inv.setItem(0, none);
        
        player.openInventory(inv);
        
	}

	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Tag Menu")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null 
				|| event.getCurrentItem().getType()==Material.AIR
				||!event.getCurrentItem().hasItemMeta()) {
			return;
		}
		switch(event.getCurrentItem().getType()) {
		case NAME_TAG:
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b&lBeta Tag")) && player.hasPermission("volanti.beta")) {
				player.sendMessage(Main.color("&e&l(!) &eEnabled &6Beta Tag"));
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
						"manuaddv " + player.getName() + " suffix &f&l <&b&lBeta&f&l>&r");
				player.closeInventory();
			} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&7&lCake4Lyfe Tag")) && player.hasPermission("volanti.beta")) {
				player.sendMessage(Main.color("&e&l(!) &eEnabled &6Cake4Lyfe Tag"));
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
						"manuaddv " + player.getName() + " suffix &f&l <&7&lCake4Lyfe&f&l>&r");
				player.closeInventory();
			} else {
				player.closeInventory();
            	player.sendMessage(Main.color("&cNo Permission"));
			}
			break;
		case BARRIER:
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
					"manudelv " + player.getName() + " suffix");
			player.sendMessage(Main.color("&4&lDisabled Tags"));
			player.closeInventory();
		default:
			break;
}
}
	
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if (cmd.getName().equalsIgnoreCase("titles") && sender instanceof Player){
			Player player = (Player) sender;
			openTagGUI(player);
			return true;
		}
		
		return false;
	
	
	}
	
}