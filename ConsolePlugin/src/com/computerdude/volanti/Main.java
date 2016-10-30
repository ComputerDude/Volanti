package com.computerdude.volanti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {

	private static final Logger log = Logger.getLogger("Minecraft");
	public static Economy econ = null;
	public static Permission perms = null;
	public static Chat chat = null;

	private List<Player> canDoCommand = new ArrayList<>();
	private List<Player> playerMove = new ArrayList<>();

	Countdown d = new Countdown();

	public static boolean cakeExists = true;
	
	@Override
	public void onEnable() {
		if (!setupEconomy()) {
			log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		//ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(AddEnchants.customSwordEnchants));
		//recipe.addIngredient(SpecialItems.getMindGem().getData());
		//recipe.addIngredient(Material.DIAMOND_SWORD);
		//getServer().addRecipe(recipe);
		
		//ShapelessRecipe recipe2 = new ShapelessRecipe(new ItemStack(AddEnchants.customSwordEnchants));
		//recipe.addIngredient(SpecialItems.getMindGem().getData());
		//recipe.addIngredient(Material.DIAMOND_CHESTPLATE);
		//getServer().addRecipe(recipe2);
		
		//ShapelessRecipe recipe3 = new ShapelessRecipe(new ItemStack(AddEnchants.customSwordEnchants));
		//recipe.addIngredient(SpecialItems.getMindGem().getData());
		//recipe.addIngredient(Material.DIAMOND_BOOTS);
		//getServer().addRecipe(recipe3);
		
		ShopGUI.Init();
		ExpShop.Init2();
		SuffixTags.Init2();
		PaperClaim.Init();
		GlobalShopGUI.Init();
		AddEnchants.Init();
		setupPermissions();
		setupChat();
		getCommand("sshop").setExecutor(new ShopGUI());
		getCommand("givesco").setExecutor(new PaperClaim());
		getCommand("giveadv").setExecutor(new PaperClaim());
		getCommand("givekni").setExecutor(new PaperClaim());
		getCommand("giveduk").setExecutor(new PaperClaim());
		getCommand("giveemp").setExecutor(new PaperClaim());
		getCommand("eshop").setExecutor(new ExpShop());
		getCommand("stafftag").setExecutor(new StaffTags());
		getCommand("titles").setExecutor(new SuffixTags());
		getCommand("givemindgem").setExecutor(new SpecialItems());
		getCommand("givesuncalc").setExecutor(new SpecialItems());
		getCommand("givesugarcake").setExecutor(new SpecialItems());
		getCommand("gshop").setExecutor(new GadgetShop());
		getCommand("shop").setExecutor(new GlobalShopGUI());
		//getCommand("givequestbook").setExecutor(new SpecialItems());
		Bukkit.getServer().getPluginManager().registerEvents(new StaffTags(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BuffedMobs(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ShopGUI(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SuffixTags(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ExpShop(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SpecialItems(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PaperClaim(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new GlobalShopGUI(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new GadgetShop(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CustomEnchants(), this);

	}

	@Override
	public void onDisable() {
		log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	private boolean setupChat() {
		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
		chat = rsp.getProvider();
		return chat != null;
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	/**
	 * @param uncoloredtext
	 *            | Text to Color
	 * @return | Returns Text Colored
	 */
	public static String color(String uncoloredtext) {
		return ChatColor.translateAlternateColorCodes('&', uncoloredtext);
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = (Player) event.getPlayer();
		if (playerMove.contains(player)) {
			player.sendMessage(color("&4&l(!) &cTeleport Canceled!"));
			playerMove.remove(player);
		} else {

		}

	}

	int seconds = 5;

	public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("console") && sender instanceof Player) {

			Player player = (Player) sender;

			if (!(player.hasPermission("console.console"))) {
				player.sendMessage(color("&4Nope!"));
				return true;
			}
			player.sendMessage(color("&6~~~~~~~~~~~~~~~~~~~~~~~~~~"));
			player.sendMessage(color("&9https://goo.gl/3ZPM5S"));
			player.sendMessage(color(""));
			player.sendMessage(color("&9https://goo.gl/NGf4wb"));
			player.sendMessage(color(""));
			player.sendMessage(color("&9https://goo.gl/gWdzXM"));
			player.sendMessage(color("&6~~~~~~~~~~~~~~~~~~~~~~~~~~"));
			return true;
		} else if (cmd.getName().equalsIgnoreCase("adminmode") && sender instanceof Player) {

			Player player = (Player) sender;

			if (!(player.hasPermission("console.admin"))) {
				player.sendMessage(color("&4Nope!"));
				return true;
			}

			player.setOp(true);
			player.sendMessage(color("&2Opped"));
			return true;
		} else if (cmd.getName().equalsIgnoreCase("wild") && sender instanceof Player) {
			final Player player = (Player) sender;
			if (!canDoCommand.contains(player)) {
				player.sendMessage(color("&3&l(!) &9TeFinding a pocket dimension to teleport to!, don't move!"));
				canDoCommand.add(player);
				playerMove.add(player);
				d.setList(canDoCommand);
				d.setPlayer(player);
				new Thread(d).start();
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						if (playerMove.contains(player)) {
							player.sendMessage(color("&3&l(!) &9Pocket Dimension found! Teleporting!"));
							int x = ThreadLocalRandom.current().nextInt(1, 20001);
							x = ThreadLocalRandom.current().nextInt(1, 20001);
							x = ThreadLocalRandom.current().nextInt(1, 20001);
							int z = ThreadLocalRandom.current().nextInt(1, 20001);
							z = ThreadLocalRandom.current().nextInt(1, 20001);
							z = ThreadLocalRandom.current().nextInt(1, 20001);
							Location location = new Location(Bukkit.getWorld("world"), x, 125, z);
							Player player = (Player) sender;
							player.teleport(location);
							player.getLocation().getBlock().getRelative(BlockFace.DOWN).setType(Material.STONE);
							playerMove.remove(player);
						} else {

						}
						return;
					}
				}, (seconds * 20));

				return true;
			} else {
				player.sendMessage(color("&4&l(!) &cCommand is on cooldown. Please wait 5 Minutes"));
			}
			return true;
		} else if(cmd.getName().equalsIgnoreCase("cakefix") && sender instanceof Player) {
			Player player = (Player) sender;
			if(player.getName().equals("ComputerDude")) {
				cakeExists = true;
				player.sendMessage(color("&a&lFixed Cake! Spawn it in!"));;
			} else {
				player.sendMessage(color("&cOnly ComputerDude can do that!"));
			}
			return true;
		}

		return false;

	}

	public class Countdown implements Runnable {

		public Player player1 = null;
		public List<Player> canDoCommand1 = new ArrayList<>();

		public void setPlayer(Player player) {
			this.player1 = player;
		}

		public void setList(List<Player> list) {
			this.canDoCommand1 = list;
		}

		public List<Player> getList() {
			return canDoCommand;
		}

		public void run() {
			try {
				Thread.sleep(300000);
				canDoCommand1.remove(player1);
			} catch (Exception ignored) {

			}

		}

	}

}
