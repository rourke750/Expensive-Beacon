package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.untamedears.rourke750.ExpensiveBeacons.DataBase.BeaconStorage;
import com.untamedears.rourke750.ExpensiveBeacons.DataBase.Info;

public class StoredValues {
	public StoredValues(BeaconStorage beaconstorage, ExpensiveBeaconsPlugin plugin, final Effects ef){
		bs = beaconstorage;
		this.plugin = plugin;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				ef.runEffects(info);
			}
		}, 0, plugin.getConfig().getInt("effects_applied"));
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
					saveMethod();
			}
		}, 0, plugin.getConfig().getInt("save"));
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				autoRepairMethod();
			}
		}, 0, plugin.getConfig().getInt("beacon_repair_time"));
	}
	private ExpensiveBeaconsPlugin plugin;
	private Map<Integer, Info> info = new HashMap<Integer, Info>();
	private Map<Location, Integer> loadedInfo = new HashMap<Location, Integer>();
	private BeaconStorage bs;
	
	public List<Location> getAllBeaconLocations(){
		List<Location> locs = new ArrayList<Location>();
		for (Info in: info.values())
			locs.add(in.loc);
		return locs;
	}
	
	public void addStoredInfo(){
		Info in;
		List<Integer> num = bs.getAllBeaconIds();
		for (int x=0; x<num.size(); x++){
			int y=num.get(x);
			in = bs.getBeaconInfo(y);
			info.put(in.beaconid, in);
		}
		
	}
	public Info getBeaconInfo(Location loc){
		Info in = bs.getBeaconInfo(loc);
		if (in == null) return null;
		return info.get(in.beaconid);
	}
	public void removeBeaconInfo(Integer id){
		bs.deleteBeacon(id);
		info.remove(id);
	}
	public void addInfo(Info info){
		this.info.put(info.beaconid, info);
	}
	public int getlastId(){
		return bs.getLastId();
	} 
	public void createBeacon(List<Location> locations, Info info){
		bs.createBeacon(locations, info);
		this.info.put(info.beaconid, info);
	}
	public void saveMethod(){
		bs.saveAllBeacons(info.values());
	}
	
	public Info isInDatabase(Location loc){
		int id = -1;
		if (loadedInfo.get(loc) == null){
			id = bs.getBeaconPrimaryId(loc);
			if (id == -1) return null;
			loadedInfo.put(loc, id);
		}
		id = loadedInfo.get(loc);
		Info info = this.info.get(id);
		return info;
	}
	
	public void autoRepairMethod(){
		int addition = plugin.getConfig().getInt("beacon_hitpoints")/95;
		for (Info in: info.values()){
			if ((addition + in.hitPoints)>plugin.getConfig().getInt("beacon_hitpoints")) continue;
			in.updateHitPoints(addition + in.hitPoints);
		}
	}
}
