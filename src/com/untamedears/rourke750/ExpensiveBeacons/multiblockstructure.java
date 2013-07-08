package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.logging.Logger;

import org.bukkit.Location;

import com.untamedears.com.rourke750.ExpensiveBeacons.BeaconTypes.SpeedBeacon;

public class multiblockstructure {
private onListener ls=null;
private ExpensiveBeaconsplugin pl=null;
private SpeedBeacon sb=null;
private StoredValues sv=null;
	public multiblockstructure(ExpensiveBeaconsplugin plugin, onListener lis,
			SpeedBeacon speed, StoredValues stored){
		pl=plugin;
		ls=lis;
		sb=speed;
		sv=stored;
	}
	public void checkBuild(Location loc){
		Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
		logger.info("Check Build is correct");
		String tier=null;
		String type=null;
		sb.tier5(loc);
		int level= sb.getLevel();
		if (level==5){
			tier="five";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
		if (level==4){
			tier="four";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
		if (level==3){
			tier="three";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
		if (level==2){
			tier="two";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
		if (level==1){
			tier="one";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
	}
}
