package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.logging.Logger;

import org.bukkit.Location;

import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.SpeedBeacon;
import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.StrengthBeacon;

public class MultiBlockStructure {
	private BeaconListener ls = null;
	private ExpensiveBeaconsPlugin pl = null;
	private SpeedBeacon sb = null;
	private StoredValues sv = null;
	private StrengthBeacon strb;

	public MultiBlockStructure(ExpensiveBeaconsPlugin plugin, BeaconListener lis, SpeedBeacon speed, StoredValues stored, StrengthBeacon str) {
		pl = plugin;
		ls = lis;
		sb = speed;
		sv = stored;
		strb = str;
	}

	Logger logger = Logger.getLogger(ExpensiveBeaconsPlugin.class.getName());

	public void checkBuild(Location loc) {
		int levels = sb.getLevel(loc);
		int levelstr = strb.getLevel(loc);
		if (sv.getType(loc) != null) {
			if (levels != sv.getTier(loc) || levelstr != sv.getTier(loc)) {
				logger.info("This should not have occured");
				sv.removeTier(loc);
				sv.removeType(loc);
			}
		}

		else {
			logger.info("Check Build is correct");
			int tier = 0;
			String type = null;
			logger.info("check build level" + levels);
			if (levels == 5) {
				tier = 5;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (levels == 4) {
				tier = 4;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (levels == 3) {
				tier = 3;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (levels == 2) {
				tier = 2;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (levels == 1) {
				tier = 1;
				type = "speed";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (levelstr == 5) {
				tier = 5;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (levelstr == 4) {
				tier = 4;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (levelstr == 3) {
				tier = 3;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (levelstr == 2) {
				tier = 2;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (levelstr == 1) {
				tier = 1;
				type = "strength";
				sv.setTier(loc, tier);
				sv.setType(loc, type);
			}
			if (tier==0){
			if (sv.getType(loc)!=null){
				sv.removeTier(loc);
				sv.removeType(loc);
				}
			}
		}
	}
}
