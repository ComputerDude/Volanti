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

import net.milkbowl.vault.economy.EconomyResponse;

public class ShopGUI implements CommandExecutor,Listener{
	
	public static ArrayList<String> crate1 = new ArrayList<String>();
	public static ArrayList<String> crate2 = new ArrayList<String>();
	public static ArrayList<String> crate3 = new ArrayList<String>();
	public static ArrayList<String> gkit1 = new ArrayList<String>();
	public static ArrayList<String> gkit2 = new ArrayList<String>();
	public static ArrayList<String> gkit3 = new ArrayList<String>();
	public static ArrayList<String> sunDialLore = new ArrayList<String>();

	
	public static void Init() {
		crate1.add(ChatColor.GRAY + "Cost: " + ChatColor.GREEN + "$10,000");
		crate2.add(ChatColor.GRAY + "Cost: " + ChatColor.GREEN + "$100,000");
		crate3.add(ChatColor.GRAY + "Cost: " + ChatColor.GREEN + "$500,000");
		gkit1.add(ChatColor.GRAY + "Cost: " + ChatColor.GREEN + "$1,000,000");
		gkit2.add(ChatColor.GRAY + "Cost: " + ChatColor.GREEN + "$1,500,000");
		gkit3.add(ChatColor.GRAY + "Cost: " + ChatColor.GREEN + "$1,000,000");
		sunDialLore.add(ChatColor.GRAY + "Cost: " + ChatColor.GREEN + "$10,000");
	}
			
	private void buyKey(Player player, String keyName){
    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate key " + player.getName() + " " + keyName);
	}
	private void givePermission(Player player, String perm) {
	    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + player.getName() + " " + perm);
	}
	
	public static void openGUI(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Special Item Shop");
		
		//Simple Crate Key
		ItemStack keyOne = new ItemStack (Material.TRIPWIRE_HOOK);
		ItemMeta keyOneMeta = keyOne.getItemMeta();
		
		//Strange Crate Key
		ItemStack keyTwo = new ItemStack (Material.TRIPWIRE_HOOK);
		ItemMeta keyTwoMeta = keyTwo.getItemMeta();
		
		//Magical Crate Key
		ItemStack keyThree = new ItemStack (Material.TRIPWIRE_HOOK);
		ItemMeta keyThreeMeta = keyThree.getItemMeta();
		
		//Beta Kit
		ItemStack gkitOne = new ItemStack (Material.WATCH);
		ItemMeta GkitOneMeta = gkitOne.getItemMeta();
		
		//Blaze Kit
		ItemStack gkitTwo = new ItemStack (Material.BLAZE_ROD);
		ItemMeta GkitTwoMeta = gkitTwo.getItemMeta();
		
		//Archer Kit
		ItemStack gkitThree = new ItemStack (Material.BOW);
		ItemMeta GkitThreeMeta = gkitThree.getItemMeta();
		
		//Blank Pane
		ItemStack blank = new ItemStack (Material.STAINED_GLASS_PANE);
		ItemMeta blankMeta = blank.getItemMeta();
		blankMeta.setDisplayName(Main.color(" "));
		blank.setItemMeta(blankMeta);
		inv.setItem(0, blank);
		inv.setItem(8, blank);
		
		//Simple Crate Key
		keyOneMeta.setDisplayName(Main.color("&fSimple Crate Key"));
		keyOneMeta.setLore(crate1);
		keyOne.setItemMeta(keyOneMeta);
		inv.setItem(1, keyOne);


		
		//Strange Crate Key
		keyTwoMeta.setDisplayName(Main.color("&5Strange Crate Key"));
		keyTwoMeta.setLore(crate2);
		keyTwo.setItemMeta(keyTwoMeta);
		inv.setItem(2, keyTwo);


		
		//Magical Crate Key
		keyThreeMeta.setDisplayName(Main.color("&6Magical Crate Key"));
		keyThreeMeta.setLore(crate3);
		keyThree.setItemMeta(keyThreeMeta);
		inv.setItem(3, keyThree);

		
		//Beta Kit
		GkitOneMeta.setDisplayName(Main.color("&6&lBeta Kit"));
		GkitOneMeta.setLore(gkit1);
		gkitOne.setItemMeta(GkitOneMeta);
		inv.setItem(4, gkitOne);

		
		//Blaze Kit
		GkitTwoMeta.setDisplayName(Main.color("&6&lBlaze Kit"));
		GkitTwoMeta.setLore(gkit2);
		gkitTwo.setItemMeta(GkitTwoMeta);
		inv.setItem(5, gkitTwo);

		
		//Archer Kit
		GkitThreeMeta.setDisplayName(Main.color("&6&lArcher Kit"));
		GkitThreeMeta.setLore(gkit3);
		gkitThree.setItemMeta(GkitThreeMeta);
		inv.setItem(6, gkitThree);

		
		player.openInventory(inv);
		
		
	}
	
	
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Special Item Shop")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null 
				|| event.getCurrentItem().getType()==Material.AIR
				||!event.getCurrentItem().hasItemMeta()) {
			return;
		}
		
		switch(event.getCurrentItem().getType()) {
		case TRIPWIRE_HOOK:
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&fSimple Crate Key")) 
					&& player.getInventory().firstEmpty() != -1) {
				EconomyResponse r4 = Main.econ.withdrawPlayer(player, 10000);
				if(r4.transactionSuccess()) {
				buyKey(player, "Simple");
				player.sendMessage(ChatColor.GREEN + "Purchase Success!");
				} else {
					player.sendMessage(Main.color("&4Transaction Failed. Make sure that your inventory isn't full."));
				}
			} else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&5Strange Crate Key")) 
					&& player.getInventory().firstEmpty() != -1) {
				EconomyResponse r5 = Main.econ.withdrawPlayer(player, 100000);
				if(r5.transactionSuccess()) {
				buyKey(player, "Strange");
				player.sendMessage(ChatColor.GREEN + "Purchase Success!");
				} else {
					player.sendMessage(Main.color("&4Transaction Failed. Make sure that your inventory isn't full."));
				}
			} else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&6Magical Crate Key")) 
					&& player.getInventory().firstEmpty() != -1) {
				EconomyResponse r6 = Main.econ.withdrawPlayer(player, 100000);
				if(r6.transactionSuccess()) {
				buyKey(player, "Magical");
				player.sendMessage(ChatColor.GREEN + "Purchase Success!");
				} else {
					player.sendMessage(Main.color("&4Transaction Failed. Make sure that your inventory isn't full."));
				}
			}
			break;
		case WATCH:
			EconomyResponse r = Main.econ.withdrawPlayer(player, 1000000);
			if(r.transactionSuccess() ) {
			givePermission(player, "gkit.1");
			player.sendMessage(Main.color("&2Purchase Success!"));
			} else {
				player.sendMessage(Main.color("&4Insufficient Funds"));
			}
			break;
		case BLAZE_ROD:
			EconomyResponse r2 = Main.econ.withdrawPlayer(player, 1500000);
			if(r2.transactionSuccess()) {
			givePermission(player, "gkit.2");
			player.sendMessage(Main.color("&2Purchase Success!"));
			} else {
				player.sendMessage(Main.color("&4Insufficient Funds"));
			}
			break;
		case BOW:
			EconomyResponse r3 = Main.econ.withdrawPlayer(player, 1000000);
			if(r3.transactionSuccess()) {
			givePermission(player, "gkit.3");
			player.sendMessage(Main.color("&2Purchase Success!"));
			} else {
				player.sendMessage(Main.color("&4Insufficient Funds"));
			}
			break;
		default:
	        break;
		}
		
	}		
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if (cmd.getName().equalsIgnoreCase("sshop") && sender instanceof Player){
			Player player = (Player) sender;
			openGUI(player);
			return true;
		}
		
		return false;
	
	
	}
	
	
}
