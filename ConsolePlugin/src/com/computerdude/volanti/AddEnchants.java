package com.computerdude.volanti;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddEnchants implements Listener {
	public static ArrayList<String> cheetah1 = new ArrayList<String>();
	public static ArrayList<String> cheetah2 = new ArrayList<String>();
	public static ArrayList<String> cheetah3 = new ArrayList<String>();

	public static ArrayList<String> burningEmber1 = new ArrayList<String>();
	public static ArrayList<String> burningEmber2 = new ArrayList<String>();
	public static ArrayList<String> burningEmber3 = new ArrayList<String>();

	public static ArrayList<String> execute1 = new ArrayList<String>();
	public static ArrayList<String> execute2 = new ArrayList<String>();
	public static ArrayList<String> execute3 = new ArrayList<String>();
	public static ArrayList<String> execute4 = new ArrayList<String>();
	public static ArrayList<String> execute5 = new ArrayList<String>();
	public static ArrayList<String> execute6 = new ArrayList<String>();

	public static void Init() {
		cheetah1.add(ChatColor.GRAY + "Cheetah I"); // Boots 1
		cheetah2.add(ChatColor.GRAY + "Cheetah II"); // Boots 2
		cheetah3.add(ChatColor.GRAY + "Cheetah III"); // Boots 3

		burningEmber1.add(ChatColor.GRAY + "Burning Ember I"); // Chestplate 1
		burningEmber2.add(ChatColor.GRAY + "Burning Ember II"); // Chestplate 2
		burningEmber3.add(ChatColor.GRAY + "Burning Ember III"); // Chestplate 3

		execute1.add(ChatColor.GRAY + "Execute I"); // Sword 1
		execute2.add(ChatColor.GRAY + "Execute II"); // Sword 2
		execute3.add(ChatColor.GRAY + "Execute III"); // Sword 3
		execute4.add(ChatColor.GRAY + "Execute IV"); // Sword 4
		execute5.add(ChatColor.GRAY + "Execute V"); // Sword 5
		execute6.add(ChatColor.GRAY + "Execute VI"); // Sword 6
	}

	// Chance for Execute 6: 35/100
	// Chance for Execute 6: 30/100
	// Chance for Execute 6: 20/100
	// Chance for Execute 6: 9/100
	// Chance for Execute 5: 5/100
	// Chance for Execute 6: 1/100
	int chance = ThreadLocalRandom.current().nextInt(1, 100);
	static ItemStack customSwordEnchants = new ItemStack(Material.DIAMOND_SWORD);
	ItemMeta customSwordMeta = customSwordEnchants.getItemMeta();

	@EventHandler
	public void onPlayerCraft(CraftItemEvent e) {
		if (e.getResult().equals(customSwordEnchants)) {
			if (chance == 1 || chance == 2 || chance == 3 || chance == 4 || chance == 5 || chance == 6 || chance == 7
					|| chance == 8 || chance == 9 || chance == 10 || chance == 11 || chance == 12 || chance == 13
					|| chance == 14 || chance == 15 || chance == 16 || chance == 17 || chance == 18 || chance == 19
					|| chance == 20 || chance == 21 || chance == 22 || chance == 23 || chance == 24 || chance == 25
					|| chance == 26 || chance == 27 || chance == 28 || chance == 29 || chance == 30 || chance == 31
					|| chance == 32 || chance == 33 || chance == 34 || chance == 35) {

				customSwordMeta.setLore(execute1);
			} else if (chance == 36 || chance == 37 || chance == 38 || chance == 39 || chance == 40 || chance == 41
					|| chance == 42 || chance == 43 || chance == 44 || chance == 45 || chance == 46 || chance == 47
					|| chance == 48 || chance == 49 || chance == 50 || chance == 51 || chance == 52 || chance == 53
					|| chance == 54 || chance == 55 || chance == 56 || chance == 57 || chance == 58 || chance == 59
					|| chance == 60 || chance == 61 || chance == 62 || chance == 63 || chance == 64 || chance == 65) {
				customSwordMeta.setLore(execute2);
			} else if (chance == 66 || chance == 67 || chance == 68 || chance == 69 || chance == 70 || chance == 71
					|| chance == 72 || chance == 73 || chance == 74 || chance == 75 || chance == 76 || chance == 77
					|| chance == 78 || chance == 79 || chance == 80 || chance == 81 || chance == 82 || chance == 83
					|| chance == 84 || chance == 85) {
				customSwordMeta.setLore(execute3);
			} else if (chance == 86 || chance == 87 || chance == 88 || chance == 89 || chance == 90 || chance == 91
					|| chance == 92 || chance == 93 || chance == 94) {
				customSwordMeta.setLore(execute4);
			} else if (chance == 95 || chance == 96 || chance == 97 || chance == 98 || chance == 99) {
				customSwordMeta.setLore(execute5);
			} else if (chance == 100) {
				customSwordMeta.setLore(execute6);
			}

		}
	}
	
	
}
