package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.untamedears.citadel.Citadel;
import com.untamedears.citadel.entity.Faction;
import com.untamedears.citadel.entity.IReinforcement;
import com.untamedears.citadel.entity.PlayerReinforcement;
import com.untamedears.rourke750.ExpensiveBeacons.DataBase.Info;

public class Effects {
	private FileConfiguration config_;

	public Effects(FileConfiguration fi) {
		config_ = fi;
	}

	// Thank you Iebagi for making this code more efficient.
	Logger logger = Logger.getLogger(ExpensiveBeaconsPlugin.class.getName());

	public void runEffects(Map<Integer, Info> info) {
		Collection<Info> ty = info.values();
		for (Info run : ty) {
			long time = run.time + 60000 * config_.getLong("maturation_time");
			if (System.currentTimeMillis() <= time)
				continue;
			if (run.type.equals("speed")) {
				setSpeedEffects(run.loc, run.tier);
			}
			if (run.type.equals("strength")) {
				setStrengthEffects(run.loc, run.tier);
			}
			if (run.type.equals("regen")) {
				setRegenEffects(run.loc, run.tier);
			}
			if (run.type.equals("haste")) {
				setHasteEffects(run.loc, run.tier);
			}
			if (run.type.equals("super")) {
				setSuperEffects(run.loc, run.tier);
			}

		}
	}

	public void setSpeedEffects(Location loc, int tier) {
		int level = 0;
		int one = config_.getInt("beacon_speed.tier_1.range");
		int two = config_.getInt("beacon_speed.tier_2.range");
		int three = config_.getInt("beacon_speed.tier_3.range");
		int four = config_.getInt("beacon_speed.tier_4.range");
		int five = config_.getInt("beacon_speed.tier_5.range");
		int dist[] = { 0, one, two, three, four, five }; // Distances for this
															// beacon; In Array
															// form because if
															// someone wants a
															// 6th lvl, it can
															// be done without
															// changing alot of
															// code.
		switch (tier) { // if tier == 4 || 5, level = 1;
		case 4:
		case 5:
			level = 1;
			break;
		}

		Faction group = groupname(loc);
		if (group == null) {
			return;
		}
		for (Player name : Bukkit.getOnlinePlayers()) {

			if (!group.isMember(name.getUniqueId())
					&& !group.isModerator(name.getUniqueId())
					&& !group.isFounder(name.getUniqueId())) {
				continue;
			} else if (group.isPersonalGroup()) {
				if (group.equals(Citadel.getPersonalGroupManager()
						.getPersonalGroup(name.getUniqueId()).getGroupName())) {
					effecttype(name, loc, dist, tier, level,
							PotionEffectType.SPEED);
				}
			} else {
				effecttype(name, loc, dist, tier, level, PotionEffectType.SPEED);
			}
		}
	}

	public void setStrengthEffects(Location loc, int tier) {
		int level = 0;
		int one = config_.getInt("beacon_strength.tier_1.range");
		int two = config_.getInt("beacon_strength.tier_1.range");
		int three = config_.getInt("beacon_strength.tier_1.range");
		int four = config_.getInt("beacon_strength.tier_1.range");
		int five = config_.getInt("beacon_strength.tier_1.range");
		int dist[] = { 0, one, two, three, four, five };

		switch (tier) {
		case 4:
		case 5:
			level = 1;
			break;
		}

		Faction group = groupname(loc);
		if (group == null) {
			return;
		}
		for (Player name : Bukkit.getOnlinePlayers()) {
			if (!group.isMember(name.getUniqueId())
					&& !group.isModerator(name.getUniqueId())
					&& !group.isFounder(name.getUniqueId())) {
				continue;
			} else if (group.isPersonalGroup()) {
				if (group.equals(Citadel.getPersonalGroupManager()
						.getPersonalGroup(name.getUniqueId()).getGroupName())) {
					effecttype(name, loc, dist, tier, level,
							PotionEffectType.INCREASE_DAMAGE);
				}
			} else {
				effecttype(name, loc, dist, tier, level,
						PotionEffectType.INCREASE_DAMAGE);
			}
		}
	}

	public void setRegenEffects(Location loc, int tier) {
		int level = 0;
		int one = config_.getInt("beacon_regen.tier_1.range");
		int two = config_.getInt("beacon_regen.tier_1.range");
		int three = config_.getInt("beacon_regen.tier_1.range");
		int four = config_.getInt("beacon_regen.tier_1.range");
		int five = config_.getInt("beacon_regen.tier_1.range");
		int dist[] = { 0, one, two, three, four, five };

		switch (tier) {
		case 4:
		case 5:
			level = 1;
			break;
		}

		Faction group = groupname(loc);
		if (group == null) {
			return;
		}
		for (Player name : Bukkit.getOnlinePlayers()) {
			if (!group.isMember(name.getUniqueId())
					&& !group.isModerator(name.getUniqueId())
					&& !group.isFounder(name.getUniqueId())) {
				continue;
			} else if (group.isPersonalGroup()) {
				if (group.equals(Citadel.getPersonalGroupManager()
						.getPersonalGroup(name.getUniqueId()).getGroupName())) {
					effecttype(name, loc, dist, tier, level,
							PotionEffectType.REGENERATION);
				}
			} else {
				effecttype(name, loc, dist, tier, level,
						PotionEffectType.REGENERATION);
			}
		}
	}

	public void setHasteEffects(Location loc, int tier) {
		int level = 0;
		int one = config_.getInt("beacon_haste.tier_1.range");
		int two = config_.getInt("beacon_haste.tier_1.range");
		int three = config_.getInt("beacon_haste.tier_1.range");
		int four = config_.getInt("beacon_haste.tier_1.range");
		int five = config_.getInt("beacon_haste.tier_1.range");
		int dist[] = { 0, one, two, three, four, five };

		switch (tier) {
		case 4:
		case 5:
			level = 1;
			break;
		}

		Faction group = groupname(loc);
		if (group == null) {
			return;
		}
		for (Player name : Bukkit.getOnlinePlayers()) {
			if (!group.isMember(name.getUniqueId())
					&& !group.isModerator(name.getUniqueId())
					&& !group.isFounder(name.getUniqueId())) {
				continue;
			} else if (group.isPersonalGroup()) {
				if (group.equals(Citadel.getPersonalGroupManager()
						.getPersonalGroup(name.getUniqueId()).getGroupName())) {
					effecttype(name, loc, dist, tier, level,
							PotionEffectType.FAST_DIGGING);
				}
			} else {
				effecttype(name, loc, dist, tier, level,
						PotionEffectType.FAST_DIGGING);
			}
		}
	}

	public void setSuperEffects(Location loc, int tier) {
		int one = config_.getInt("beacon_super.range");
		int dist[] = { 0, one };

		Faction group = groupname(loc);
		if (group == null) {
			return;
		}
		for (Player name : Bukkit.getOnlinePlayers()) {
			int level = 1;
			if (!group.isMember(name.getUniqueId())
					&& !group.isModerator(name.getUniqueId())
					&& !group.isFounder(name.getUniqueId())) {
				level = 3;
				PotionEffectType Types1[] = {PotionEffectType.WEAKNESS};
				for (PotionEffectType type : Types1) {
					if (type == PotionEffectType.WEAKNESS)
						level = 1;
					negativeeffecttype(name, loc, 50, level, type);
				}
				continue;
			}
			if (group.isPersonalGroup()) {
				if (group.equals(Citadel.getPersonalGroupManager()
						.getPersonalGroup(name.getUniqueId()).getGroupName())) {
					PotionEffectType Types[] = { PotionEffectType.FAST_DIGGING,
							PotionEffectType.REGENERATION,
							PotionEffectType.INCREASE_DAMAGE,
							PotionEffectType.SPEED };
					for (PotionEffectType type : Types) {
						effecttype(name, loc, dist, tier, level, type);
					}
				}
			} else {
				PotionEffectType Types[] = { PotionEffectType.FAST_DIGGING,
						PotionEffectType.REGENERATION,
						PotionEffectType.INCREASE_DAMAGE,
						PotionEffectType.SPEED };
				for (PotionEffectType type : Types) {
					effecttype(name, loc, dist, tier, level, type);
				}

			}
		}
	}

	public Faction groupname(Location loc) {
		IReinforcement rein = Citadel.getReinforcementManager()
				.getReinforcement(loc);
		if (rein != null && rein instanceof PlayerReinforcement) {
			return ((PlayerReinforcement) rein).getOwner();
		}
		return null;
	}

	public void effecttype(Player name, Location loc, int[] dist, int tier,
			int level, PotionEffectType type) {
		if (name.getLocation().getWorld() != loc.getWorld())
			return;
		double area = Math.sqrt( Math.pow((loc.getZ() - name.getLocation().getZ() ), 2) + 
				Math.pow((loc.getX() - name.getLocation().getX() ), 2) );
		if (area <= dist[tier]) {
			name.addPotionEffect(new PotionEffect(type, config_
					.getInt("apply_effects"), level), true);
		}

	}

	public void negativeeffecttype(Player name, Location loc, int dist,
			int level, PotionEffectType type) {
		if (name.getLocation().getWorld() != loc.getWorld())
			return;
		if (loc.distance(name.getLocation()) <= dist) {
			name.addPotionEffect(new PotionEffect(type, config_
					.getInt("apply_effects"), level), true);
		}
	}
}
