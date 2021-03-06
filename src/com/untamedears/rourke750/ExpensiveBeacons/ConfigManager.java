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
		+ "			range: The range that the tier 1 speed beacon checks.\r\n" 
		+ "maturation_time: The amount of time for a beacon to become active, in minutes.\r\n"
		+ "beacon_hitpoints: The amount of breaks it takes to destroy the entire structure. 356210 is about the time of 20 layers of dro.\r\n"
		+ "beacon_death_invulnerability: The amount of time the beacon stays invulnerable after it's hitpoints reach zero.\r\n"
		+ "beacon_repair_time: The amount of time it takes to run the repair method. In ticks.\r\n"
		+ "beacon_force_repair_id: The item id which should be required when repairing.\r\n"
		+ "beacon_force_repair_cost: The cost it takes to repair a beacon when it is broken.\r\n");
		
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
		if (!config.contains("maturation_time")){
			config.set("maturation_time", 1440);
		}
		if (!config.contains("beacon_hitpoints")){
			config.set("beacon_hitpoints", 356210);
		}
		if (!config.contains("beacon_death_invulnerability")){
			config.set("beacon_death_invulnerability", 1440);
		}
		if (!config.contains("beacon_repair_time")){
			config.set("beacon_repair_time", 72000);
		}
		if (!config.contains("beacon_force_repair_id")){
			config.set("beacon_force_repair_id", 264);
		}
		if (!config.contains("beacon_force_repair_cost")){
			config.set("beacon_force_repair_cost", 64);
		}
		if (!config.contains("sql.hostname")){
			config.set("sql.hostname", "localhost");
		}
		if (!config.contains("sql.port")){
			config.set("sql.port", 3306);
		}
		if (!config.contains("sql.dbname")){
			config.set("sql.dbname", "Expensive");
		}
		if (!config.contains("sql.username")){
			config.set("sql.username", "");
		}
		if (!config.contains("sql.password")){
			config.set("sql.password", "");
		}
		plugin.saveConfig();
	}

	
}
