package com.untamedears.rourke750.ExpensiveBeacons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;

import com.untamedears.rourke750.ExpensiveBeacons.DataBase.BeaconStorage;
import com.untamedears.rourke750.ExpensiveBeacons.DataBase.ChunkStructure;
import com.untamedears.rourke750.ExpensiveBeacons.DataBase.FakeChunk;
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
	private List<ChunkStructure> checklist = new ArrayList<ChunkStructure>();
	private Map<FakeChunk, ChunkStructure> struct = new HashMap<FakeChunk, ChunkStructure>();
	private BeaconStorage bs;
	
	public void addStoredInfo(){
		Info in;
		List<Integer> num = bs.getAllBeaconIds();
		int i = 0;
		for (int x=0; x<num.size(); x++){
			int y=num.get(i);
			in = bs.getBeaconInfo(y);
			info.put(in.loc, in);
			List<Block> blocks= bs.getBeaconStructure(y);
			int xx= in.loc.getChunk().getX();
			int z = in.loc.getChunk().getZ();
			World world = in.loc.getChunk().getWorld();
			List<Location> locs = new ArrayList<Location>();
			for (Block blo: blocks){
				locs.add(blo.getLocation());
			}
			ChunkStructure stru = new ChunkStructure(locs, in.loc);
			FakeChunk fakechunk = new FakeChunk(xx,z,world);
			struct.put(fakechunk, stru);
			i++;
		}
		
	}
	public Info getBeaconInfo(Location loc){
		return info.get(loc);
	}
	public void removeBeaconInfo(Location loc, int id){
		int x = loc.getChunk().getX();
		int z = loc.getChunk().getZ();
		FakeChunk fakechunk = new FakeChunk(x,z,loc.getWorld());
		struct.remove(fakechunk);
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
		ChunkStructure struct = new ChunkStructure(locations, info.loc);
		FakeChunk fakechunk = new FakeChunk(info.loc.getChunk().getX(), info.loc.getChunk().getZ(), info.loc.getChunk().getWorld());
		this.struct.put(fakechunk, struct);
		checklist.add(struct);
	}
	public void saveMethod(){
		bs.saveAllBeacons(info.values());
	}
	public void addToCheckList(Chunk chunk){
		for (FakeChunk x: struct.keySet()){
			if (x.x == chunk.getX() && x.z == chunk.getZ() && x.world.equals(chunk.getWorld())){
				System.out.print("Add to checklist worked");
				checklist.add(struct.get(x));
			}
		}
	}
	public void removeCheckList(Chunk chunk){
		for (FakeChunk x: struct.keySet()){
			if (x.x == chunk.getX() && x.z == chunk.getZ() && x.world.equals(chunk.getWorld())){
				System.out.print("Chunk unload occured");
				checklist.remove(struct.get(x));
			}
		}
		if(!chunk.unload()) chunk.unload();
	}
	public List<ChunkStructure> getChunkStructure(){
		return checklist;
	}
}
