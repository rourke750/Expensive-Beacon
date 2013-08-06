package com.untamedears.rourke750.ExpensiveBeacons;

import java.util.logging.Logger;

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
import org.bukkit.inventory.BeaconInventory;

import com.untamedears.citadel.Citadel;
import com.untamedears.citadel.entity.IReinforcement;
import com.untamedears.citadel.entity.PlayerReinforcement;

public class BeaconListener implements Listener {
	private MultiBlockStructure multi;
	private StoredValues sv;

	public BeaconListener(MultiBlockStructure plugin, StoredValues store) {
		multi = plugin;
		sv = store;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockPlace(BlockPlaceEvent event) {
		Logger logger = Logger.getLogger(ExpensiveBeaconsPlugin.class.getName());
		logger.info("Listener is enabled.");
		if (event.getBlock().getType().equals(Material.BEACON)) {
			Location loc = event.getBlock().getLocation();
			logger.info("Cords of block placed" + loc);
			String groupName = null;
			IReinforcement rein = Citadel.getReinforcementManager().getReinforcement(loc);
			if (rein instanceof PlayerReinforcement) {
				groupName = ((PlayerReinforcement) rein).getOwner().getName();
			}
			logger.info("Setspeedeffects has run");
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
			if(sv.getType(loc)!=null){
				sv.removeTier(loc);
				sv.removeType(loc);
			}
		}
		if (event.getBlock().getType()==Material.DIAMOND_BLOCK){
			for (Location loc: sv.getTypeMap().keySet()){
		if (event.getBlock().getLocation().distance(loc)<=30){
			multi.checkBuild(loc);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerOpenInventory(InventoryOpenEvent event) {
		if (event.getInventory() instanceof BeaconInventory)
			event.setCancelled(true);
	}
}
