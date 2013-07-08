package com.untamedears.rourke750.ExpensiveBeacons;

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
		String tier=null;
		String type=null;
		if (sb.tier5(loc)==true){
			tier="five";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
		if (sb.tier4(loc)==true){
			tier="four";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
		if (sb.tier3(loc)==true){
			tier="three";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
		if (sb.tier2(loc)==true){
			tier="two";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
		if (sb.tier1(loc)==true){
			tier="one";
			type="speed";
			sv.setTier(loc, tier);
			sv.setType(loc, type);
		}
	}
}
