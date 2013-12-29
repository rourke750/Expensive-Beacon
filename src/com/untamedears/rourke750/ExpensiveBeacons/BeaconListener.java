package com.untamedears.rourke750.ExpensiveBeacons;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
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
import org.bukkit.inventory.BeaconInventory;

import com.untamedears.citadel.Citadel;
import com.untamedears.citadel.entity.IReinforcement;
import com.untamedears.citadel.entity.PlayerReinforcement;

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
			}
		}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onChunkLoadEvent(ChunkLoadEvent event){
		//event.getChunk().get
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerOpenInventory(InventoryOpenEvent event) {
		if (event.getInventory() instanceof BeaconInventory)
			event.setCancelled(true);
	}
	
}
