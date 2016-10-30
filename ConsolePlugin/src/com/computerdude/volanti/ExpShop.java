package com.computerdude.volanti;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExpShop implements CommandExecutor,Listener {
	public static ArrayList<String> simpleBook1 = new ArrayList<String>();
	public static ArrayList<String> uniqueBook2 = new ArrayList<String>();
	public static ArrayList<String> eliteBook3 = new ArrayList<String>();
	public static ArrayList<String> ultimateBook4 = new ArrayList<String>();
	public static ArrayList<String> legendaryBook5 = new ArrayList<String>();
	public static ArrayList<String> mindGemLore = new ArrayList<String>();
	
	public static void Init2() {
		simpleBook1.add(ChatColor.GRAY + "Cost: " + ChatColor.AQUA + "1 Mind Gem");
		uniqueBook2.add(ChatColor.GRAY + "Cost: " + ChatColor.AQUA + "1 Mind Gem");
		eliteBook3.add(ChatColor.GRAY + "Cost: " + ChatColor.AQUA + "3 Mind Gems");
		ultimateBook4.add(ChatColor.GRAY + "Cost: " + ChatColor.AQUA + "5 Mind Gems");
		legendaryBook5.add(ChatColor.GRAY + "Cost: " + ChatColor.AQUA + "25 Mind Gems");
		mindGemLore.add(ChatColor.GRAY + "Cost: " + ChatColor.AQUA + "1000 Exp");
}
	static int cost = 0;
	private void giveDP(Player player, String numeral){
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "givedp " + player.getName() + " " + numeral);
		}
	
	public static void openSecondGUI(Player player) {
		Inventory inv2 = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD 
				+ "Enchant Shop");
				
        ItemStack newItem = new ItemStack(Material.EMERALD, cost);
        ItemMeta newItemMeta = newItem.getItemMeta();
        newItemMeta.setDisplayName(ChatColor.RESET + "" + ChatColor.AQUA + "" + ChatColor.BOLD +"Mind Gem");
        newItemMeta.setLore(Arrays.asList(ChatColor.GRAY + "Trade this item at " + ChatColor.YELLOW + "" + ChatColor.BOLD + "/eshop"));
        newItem.setItemMeta(newItemMeta);
        newItem.addUnsafeEnchantment(Enchantment.DURABILITY, 10); 
		
		        ItemStack mindGem = new ItemStack (Material.EMERALD);
                ItemMeta mindGemMeta = mindGem.getItemMeta();
                mindGemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Mind Gem");
                mindGemMeta.setLore(mindGemLore);
                mindGem.setItemMeta(mindGemMeta);
                inv2.setItem(0, mindGem);
                mindGemMeta.addEnchant(Enchantment.DURABILITY, 10, true);
		
				ItemStack simpleBook = new ItemStack (Material.ENCHANTED_BOOK, 2);
		        ItemMeta simpleBookMeta = simpleBook.getItemMeta();
		        simpleBookMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Simple Enchantment Book");
		        simpleBookMeta.setLore(simpleBook1);
		        simpleBook.setItemMeta(simpleBookMeta);
		        inv2.setItem(2, simpleBook);
		        
		        
				ItemStack uniqueBook = new ItemStack (Material.ENCHANTED_BOOK);
		        ItemMeta uniqueBookMeta = uniqueBook.getItemMeta();
		        uniqueBookMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Unique Enchantment Book");
		        uniqueBookMeta.setLore(uniqueBook2);
		        uniqueBook.setItemMeta(uniqueBookMeta);
		        inv2.setItem(3, uniqueBook);
		        
				ItemStack eliteBook = new ItemStack (Material.ENCHANTED_BOOK);
		        ItemMeta eliteBookMeta = eliteBook.getItemMeta();
		        eliteBookMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Elite Enchantment Book");
		        eliteBookMeta.setLore(eliteBook3);
		        eliteBook.setItemMeta(eliteBookMeta);
		        inv2.setItem(4, eliteBook);
		        
				ItemStack ultimateBook = new ItemStack (Material.ENCHANTED_BOOK);
		        ItemMeta ultimateBookMeta = ultimateBook.getItemMeta();
		        ultimateBookMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Ultimate Enchantment Book");
		        ultimateBookMeta.setLore(ultimateBook4);
		        ultimateBook.setItemMeta(ultimateBookMeta);
		        inv2.setItem(5, ultimateBook);
		        
				ItemStack legendaryBook = new ItemStack (Material.ENCHANTED_BOOK);
		        ItemMeta legendaryBookMeta = legendaryBook.getItemMeta();
		        legendaryBookMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Enchantment Book");
		        legendaryBookMeta.setLore(legendaryBook5);
		        legendaryBook.setItemMeta(legendaryBookMeta);
		        inv2.setItem(6, legendaryBook);
		        
		        player.openInventory(inv2);
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Enchant Shop")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null 
				|| event.getCurrentItem().getType()==Material.AIR
				||!event.getCurrentItem().hasItemMeta()) {
			return;
		}
		
		switch(event.getCurrentItem().getType()) {
		case EMERALD:
			int expCost = 1000;
			int currentExp = player.getTotalExperience();
			if(player.getTotalExperience() >= expCost && player.getInventory().firstEmpty() != -1) {
				
				player.setTotalExperience(0);
				player.setLevel(0);
				player.setExp(0);
				player.giveExp(currentExp - expCost);
				player.getInventory().addItem(SpecialItems.getMindGem());
				player.sendMessage(Main.color("&2Purchase Success!"));
			} else {
            	player.sendMessage(Main.color("&4Transaction Failed. Make sure that your inventory isn't full."));
			}
			break;
		case ENCHANTED_BOOK:
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "" + ChatColor.BOLD + "Simple Enchantment Book") 
					&& player.getInventory().firstEmpty() != -1) {
            int cost = 1;          
          
            if (player.getInventory().containsAtLeast(SpecialItems.getMindGem(), cost)) {
            	
            	ItemStack temp = SpecialItems.getMindGem();
            	temp.setAmount(cost);
                player.getInventory().removeItem(temp);        
                giveDP(player, "16");
                giveDP(player, "16");
    			player.sendMessage(Main.color("&2Purchase Success!"));
            } else {
            	player.sendMessage(Main.color("&4Transaction Failed. Make sure that your inventory isn't full."));
            }
			} else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "" + ChatColor.BOLD + "Unique Enchantment Book") 
					&& player.getInventory().firstEmpty() != -1) {
				int cost = 1;        
	          
	            if (player.getInventory().containsAtLeast(SpecialItems.getMindGem(), cost)) {
	            	ItemStack temp = SpecialItems.getMindGem();
	            	temp.setAmount(cost);
	                player.getInventory().removeItem(temp);               
	                giveDP(player, "15");
	    			player.sendMessage(Main.color("&2Purchase Success!"));
	            } else {
	            	player.sendMessage(Main.color("&4Transaction Failed. Make sure that your inventory isn't full."));
	            } 
			} else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "Elite Enchantment Book") 
					&& player.getInventory().firstEmpty() != -1) {
				int cost = 3;       
	          
	            if (player.getInventory().containsAtLeast(SpecialItems.getMindGem(), cost)) {
	            	ItemStack temp = SpecialItems.getMindGem();
	            	temp.setAmount(cost);
	                player.getInventory().removeItem(temp);             
	                giveDP(player, "14");
	    			player.sendMessage(Main.color("&2Purchase Success!"));
	            } else {
	            	player.sendMessage(Main.color("&4Transaction Failed. Make sure that your inventory isn't full."));
	            }
			}else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "" + ChatColor.BOLD + "Ultimate Enchantment Book")
					&& player.getInventory().firstEmpty() != -1) {
				int cost = 5;        
	          
	            if (player.getInventory().containsAtLeast(SpecialItems.getMindGem(), cost)) {
	            	ItemStack temp = SpecialItems.getMindGem();
	            	temp.setAmount(cost);
	                player.getInventory().removeItem(temp);               
	                giveDP(player, "13");
	    			player.sendMessage(Main.color("&2Purchase Success!"));
	            } else {
	            	player.sendMessage(Main.color("&4Transaction Failed. Make sure that your inventory isn't full."));
	            }
			} else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.GOLD + "Legendary Enchantment Book" ) 
					&& player.getInventory().firstEmpty() != -1) {
				int cost = 25;         
				
	            if (player.getInventory().containsAtLeast(SpecialItems.getMindGem(), cost)) {
	            	ItemStack temp = SpecialItems.getMindGem();
	            	temp.setAmount(cost);
	                player.getInventory().removeItem(temp);               
	                giveDP(player, "12");
	    			player.sendMessage(Main.color("&2Purchase Success!"));
	            } else {
	            	player.sendMessage(Main.color("&4Transaction Failed. Make sure that your inventory isn't full."));
	            }
			}
			default:
				break;
}
	}
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
			
			if (cmd.getName().equalsIgnoreCase("eshop") && sender instanceof Player) {
				Player player = (Player) sender;
				openSecondGUI(player);
				return true;
			}
			return false; 
			
	}
	}
