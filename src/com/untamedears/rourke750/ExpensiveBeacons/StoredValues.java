package com.untamedears.rourke750.ExpensiveBeacons;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;

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
	}
	private ExpensiveBeaconsPlugin plugin;
	private Map<Location, Info> info = new HashMap<Location, Info>();
	private BeaconStorage bs;
	private Map<Chunk, List<Location>> chunk = new HashMap<Chunk, List<Location>>();
	
	public void addStoredInfo(){
		Info in;
		List<Integer> num = bs.getAllBeaconIds();
		int i = 0;
		for (int x=0; x<num.size(); x++){
			int y=num.get(i);
			in = bs.getBeaconInfo(y);
			info.put(in.loc, in);
			i++;
		}
	}
	public Info getBeaconInfo(Location loc){
		return info.get(loc);
	}
	public void removeBeaconInfo(Location loc, int id){
		info.remove(loc);
		bs.deleteBeacon(id);
	}
	public void addInfo(Location loc, Info info){
		this.info.put(loc, info);
	}
	public int getlastId(){
		return bs.getLastId();
	} 
	public void createBeacon(List<Location> locations, Info info){
		bs.createBeacon(locations, info);
	}
	public void saveMethod(){
		bs.saveAllBeacons(info.values());
	}
}
