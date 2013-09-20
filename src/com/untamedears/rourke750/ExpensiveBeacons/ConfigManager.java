package com.untamedears.rourke750.ExpensiveBeacons;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
	private ExpensiveBeaconsPlugin plugin;
	public ConfigManager(ExpensiveBeaconsPlugin plu){
		plugin=plu;
	}
	public void initconfig(FileConfiguration config){
		config.options().header("Author: Rourke750\n"
		+ "Bukkit Page located here: http://dev.bukkit.org/bukkit-plugins/expensive-beacons/\r\n"
		+ "Github located here: https://github.com/rourke750/Expensive-Beacon\r\n"
		+ "\r\n"
		+ "apply_effects: This says how long effects will last on a player. (ticks)\r\n"
		+ "effects_applied: This determines how long the plugin waits to check if a player is within range to give them an effect. (ticks)\n"
		+ "save: How long before each save. (ticks)\r\n"
		+ "beacon_speed: Parent for defining speed beacon tiers.\r\n"
		+ "		tier_1: Tier 1 of the Speed Beacon.\r\n"
		+ "			range: The range that the tier 1 speed beacon checks.\r\n"
		+ "		tier_2: Tier 2 of the Speed Beacon.\r\n"
		+ "			range: The range that the tier 1 speed beacon checks.\r\n"
		+ "		tier_3: Tier 3 of the Speed Beacon.\r\n"
		+ "			range: The range that the tier 1 speed beacon checks.\r\n"
		+ "		tier_4: Tier 4 of the Speed Beacon.\r\n"
		+ "			range: The range that the tier 1 speed beacon checks.\r\n"
		+ " 	tier_5: Tier 5 of the Speed Beacon.\r\n"
		+ "			range: The range that the tier 1 speed beacon checks." +
		"\r\n");
		
		if (!config.contains("apply_effects")){
			config.set("apply_effects", 1200);
		}
		if (!config.contains("effects_applied")){
			config.set("effects_applied", 100);
		}
		if (!config.contains("save")){
			config.set("save", 24000);
		}
		if (!config.contains("beacon_speed.tier_1.range")){
			config.set("beacon_speed.tier_1.range", 30);
		}
		if (!config.contains("beacon_speed.tier_2.range")){
			config.set("beacon_speed.tier_2.range", 55);
		}
		if (!config.contains("beacon_speed.tier_3.range")){
			config.set("beacon_speed.tier_3.range", 72);
		}
		if (!config.contains("beacon_speed.tier_4.range")){
			config.set("beacon_speed.tier_4.range", 80);
		}
		if (!config.contains("beacon_speed.tier_5.range")){
			config.set("beacon_speed.tier_5.range", 100);
		}
		if (!config.contains("beacon_strength.tier_1.range")){
			config.set("beacon_strength.tier_1.range", 25);
		}
		if (!config.contains("beacon_strength.tier_2.range")){
			config.set("beacon_strength.tier_2.range", 47);
		}
		if (!config.contains("beacon_strength.tier_3.range")){
			config.set("beacon_strength.tier_3.range", 68);
		}
		if (!config.contains("beacon_strength.tier_4.range")){
			config.set("beacon_strength.tier_4.range", 80);
		}
		if (!config.contains("beacon_strength.tier_5.range")){
			config.set("beacon_strength.tier_5.range", 105);
		}
		if (!config.contains("beacon_regen.tier_1.range")){
			config.set("beacon_regen.tier_1.range", 25);
		}
		if (!config.contains("beacon_regen.tier_2.range")){
			config.set("beacon_regen.tier_2.range", 50);
		}
		if (!config.contains("beacon_regen.tier_3.range")){
			config.set("beacon_regen.tier_3.range", 65);
		}
		if (!config.contains("beacon_regen.tier_4.range")){
			config.set("beacon_regen.tier_4.range", 85);
		}
		if (!config.contains("beacon_regen.tier_5.range")){
			config.set("beacon_regen.tier_5.range", 100);
		}
		if (!config.contains("beacon_haste.tier_1.range")){
			config.set("beacon_haste.tier_1.range", 35);
		}
		if (!config.contains("beacon_haste.tier_2.range")){
			config.set("beacon_haste.tier_2.range", 60);
		}
		if (!config.contains("beacon_haste.tier_3.range")){
			config.set("beacon_haste.tier_3.range", 80);
		}
		if (!config.contains("beacon_haste.tier_4.range")){
			config.set("beacon_haste.tier_4.range", 100);
		}
		if (!config.contains("beacon_haste.tier_5.range")){
			config.set("beacon_haste.tier_5.range", 120);
		}
		if (!config.contains("beacon_super.range")){
			config.set("beacon_super.range", 300);
		}
		plugin.saveConfig();
	}

	
}
