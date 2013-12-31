package com.untamedears.rourke750.ExpensiveBeacons;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.inventory.BeaconInventory;

import com.untamedears.citadel.Citadel;
import com.untamedears.citadel.entity.IReinforcement;
import com.untamedears.citadel.entity.PlayerReinforcement;
import com.untamedears.citadel.events.PlayerDamageReinforcementEvent;
import com.untamedears.rourke750.ExpensiveBeacons.DataBase.ChunkStructure;
import com.untamedears.rourke750.ExpensiveBeacons.DataBase.Info;

public class BeaconListener implements Listener {
	private MultiBlockStructure multi;
	private StoredValues sv;
	private ExpensiveBeaconsPlugin plugin;

	public BeaconListener(MultiBlockStructure multi, StoredValues store, ExpensiveBeaconsPlugin plugin) {
		this.multi = multi;
		sv = store;
		this.plugin=plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockPlace(BlockPlaceEvent event) {
		Logger logger = Logger.getLogger(ExpensiveBeaconsPlugin.class.getName());
		if (event.getBlock().getType().equals(Material.BEACON)) {
			Location loc = event.getBlock().getLocation();
			String groupName = null;
			IReinforcement rein = Citadel.getReinforcementManager().getReinforcement(loc);
			if (rein instanceof PlayerReinforcement) {
				groupName = ((PlayerReinforcement) rein).getOwner().getName();
			}
			if (groupName == null) {
				event.getPlayer().sendMessage("Reinforce the Beacon."); //tells players to reinforce the beacon.
			}
			multi.checkBuild(loc);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
		public void onBlockBreak(BlockBreakEvent event){
		if(event.getBlock().getType().equals(Material.BEACON)) {
			Location loc= event.getBlock().getLocation();
			Info info = sv.getBeaconInfo(loc);
			if (info == null){
				isBlock(event);
				return;
			}
			if (info.hitPoints==0){
				if(!info.broken){
					info.updateIfBroken(true);
					info.updateBrokenTime(System.currentTimeMillis());
				}
				if(info.broken){
					long brokentime = info.brokenTime + 60000 * plugin.getConfig().getLong("beacon_death_invulnerability");
					if(brokentime <= System.currentTimeMillis()){
						sv.removeBeaconInfo(loc, info.beaconid);
					}
					else event.setCancelled(true);
				}
			}
			else{
				event.setCancelled(true);
				info.updateHitPoints(info.hitPoints-1);
			}
			}
			isBlock(event);
		}
	public void isBlock(BlockBreakEvent event){
		int i = 0;
		if(event.getBlock().getType().equals(Material.DIAMOND_BLOCK) || event.getBlock().getType().equals(Material.BEACON)) {
			System.out.print("Diamond check yes");
			if (sv.getChunkStructure() == null) return;
			for (ChunkStructure str: sv.getChunkStructure()){
				i++;
				System.out.print("Went through chunk structures.");
				List<Location> locs = str.struct;
				for (Location loc: locs){
					if (event.getBlock().getLocation().equals(loc)){
						System.out.print("Found a match");
						Info info =sv.getBeaconInfo(str.mainbecid);
						if (info.hitPoints==0){
							if(!info.broken){
								info.updateIfBroken(true);
								info.updateBrokenTime(System.currentTimeMillis());
							}
							if(info.broken){
								long brokentime = info.brokenTime + 60000 * plugin.getConfig().getLong("beacon_death_invulnerability");
								if(brokentime <= System.currentTimeMillis()){
									sv.removeBeaconInfo(loc, info.beaconid);
								}
								else event.setCancelled(true);
							}
						}
						else{
							System.out.print("Event was cancelled and subtracted one health");
							event.setCancelled(true);
							info.updateHitPoints(info.hitPoints-1);
						}
						//return;
					}
				}
			}
			System.out.print("Amount of time looped was: "+ i);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onChunkLoadEvent(ChunkLoadEvent event){
		sv.addToCheckList(event.getChunk());
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onChunkUnLoadEvent(ChunkUnloadEvent event){
		sv.removeCheckList(event.getChunk());
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerOpenInventory(InventoryOpenEvent event) {
		if (event.getInventory() instanceof BeaconInventory)
			event.setCancelled(true);
	}
	
}
