package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.untamedears.citadel.Citadel;
import com.untamedears.citadel.entity.Faction;
import com.untamedears.citadel.entity.IReinforcement;
import com.untamedears.citadel.entity.PlayerReinforcement;

public class Effects {
	Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());

	public void runEffects(Map<Location, String> type, Map<Location, Integer> tier) {
		logger.info("Effects has run");
		int run3;
		Collection<String> ty = type.values();
		Collection<Integer> ti = tier.values();
		for (String run : ty) {
			logger.info(run);
			for (Location run2 : tier.keySet()) {
				run3 = tier.get(run2);
				logger.info(run2 + "        " + run + "          " + run3);
				if (type.get(run2).equals(run) && run == "speed" && run3 == 1) {
					setSpeedEffects(run2, run3);
				}
				if (type.get(run2).equals(run) && run == "speed" && run3 == 2) {
					logger.info("Speed two thingy at line 42 is true");
					setSpeedEffects(run2, run3);
				}
				if (type.get(run2).equals(run) && run == "speed" && run3 == 3) {
					setSpeedEffects(run2, run3);
				}
				if (type.get(run2).equals(run) && run == "speed" && run3 == 4) {
					setSpeedEffects(run2, run3);
				}
				if (type.get(run2).equals(run) && run == "speed" && run3 == 5) {
					setSpeedEffects(run2, run3);
				}
				if (type.get(run2).equals(run) && run == "strength" && run3 == 1) {
					setStrengthEffects(run2, run3);
				}
				if (type.get(run2).equals(run) && run == "strength" && run3 == 2) {
					setStrengthEffects(run2, run3);
				}
				if (type.get(run2).equals(run) && run == "strength" && run3 == 3) {
					setStrengthEffects(run2, run3);
				}
				if (type.get(run2).equals(run) && run == "strength" && run3 == 4) {
					setStrengthEffects(run2, run3);
				}
				if (type.get(run2).equals(run) && run == "strength" && run3 == 5) {
					setStrengthEffects(run2, run3);
				}
			}
		}
	}

	public void setSpeedEffects(Location loc, int tier) {
		logger.info("SetSpeed has run");
		int distance = 0, level = 0;
		if (tier == 1) {
			logger.info("LEVEL 1 BEACON");
			distance = 30;
		}
		if (tier == 2) {
			logger.info("LEVEL 2 BEACON");
			distance = 55;
		}
		if (tier == 3) {
			logger.info("LEVEL 3 BEACON");
			distance = 72;
		}
		if (tier == 4) {
			logger.info("LEVEL 4 BEACON");
			distance = 80;
			level = 1;
		}
		if (tier == 5) {
			logger.info("LEVEL 5 BEACON");
			distance = 100;
			level = 1;
		}
		logger.info("if tier one has run");
		Faction group = groupname(loc);
		for (Player name : Bukkit.getOnlinePlayers()) {
			if (group == null) {
				logger.info("Group is null" + loc);
				continue;
			}
			if (!group.isMember(name.toString()) && !group.isModerator(name.toString()) && !group.isFounder(name.toString()) && !group.isPersonalGroup()) {
				logger.info("Member is not in a group.");
				continue;
			}
			else {
				logger.info("Else ran.");
				if (loc.distance(name.getLocation()) <= distance) {
					logger.info("Potions has run");
					name.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, level));
				}
			}
		}
	}

	public void setStrengthEffects(Location loc, int tier) {
		int distance = 20, level = 0;
		if (tier == 1) {
			logger.info("LEVEL 1 BEACON");
			distance = 20;
		}
		if (tier == 2) {
			logger.info("LEVEL 2 BEACON");
			distance = 30;
		}
		if (tier == 3) {
			logger.info("LEVEL 3 BEACON");
			distance = 40;
		}
		if (tier == 4) {
			logger.info("LEVEL 4 BEACON");
			distance = 50;
			level = 1;
		}
		if (tier == 5) {
			logger.info("LEVEL 5 BEACON");
			distance = 70;
			level = 1;
		}
		Faction group = groupname(loc);
		for (Player name : Bukkit.getOnlinePlayers()) {
			if (group == null) {
				logger.info("Group is null" + loc);
				continue;
			}
			if (!group.isMember(name.toString()) && !group.isModerator(name.toString()) && !group.isFounder(name.toString()) && !group.isPersonalGroup()) {
				logger.info("Member is not in a group.");
				continue;
			}
			else {
				if (loc.distance(name.getLocation()) <= distance) {
					name.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, level));
				}
			}
		}
	}

	public Faction groupname(Location loc) {
		logger.info("public void faction cords" + loc);
		IReinforcement rein = Citadel.getReinforcementManager().getReinforcement(loc);
		if (rein != null && rein instanceof PlayerReinforcement) {
			return ((PlayerReinforcement) rein).getOwner();
		}
		return null;
	}

}
