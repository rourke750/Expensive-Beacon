package com.untamedears.rourke750.ExpensiveBeacons;




import java.util.logging.Logger;

import net.minecraft.server.v1_5_R3.Block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.inventory.BeaconInventory;

import com.untamedears.citadel.Citadel;
import com.untamedears.citadel.entity.Faction;
import com.untamedears.citadel.entity.IReinforcement;
import com.untamedears.citadel.entity.PlayerReinforcement;

public class onListener implements Listener{
	private multiblockstructure multi;
	private StoredValues sv;
	public onListener(multiblockstructure plugin, StoredValues store){
		multi=plugin;
		sv= store;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockPlace(BlockPlaceEvent event){

		Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
		logger.info("Listener is enabled.");
		if(event.getBlock().getType().equals(Material.BEACON)) {
			Location loc= event.getBlock().getLocation();
			logger.info("Cords of block placed"+loc);
			String groupName = null;
			IReinforcement rein = Citadel.getReinforcementManager().getReinforcement(loc);
			if (rein instanceof PlayerReinforcement) {
			  groupName = ((PlayerReinforcement)rein).getOwner().getName();
			}
			logger.info("Setspeedeffects has run");
			if (groupName == null) {
				
				event.getPlayer().sendMessage("Reinforce the Beacon."); //tells players to reinforce the beacon.
			}
			multi.checkBuild(loc);
		}
	}
	@EventHandler(priority= EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent event){
		if(event.getBlock().getType().equals(Material.BEACON)) {
			Location loc= event.getBlock().getLocation();
			if(sv.getType(loc)!=null){
				sv.removeTier(loc);
				sv.removeType(loc);
			}
		}
	}
	@EventHandler(priority= EventPriority.HIGH)
	public void onPlayerInteract(InventoryOpenEvent event){
		if (event.getInventory() instanceof 
				BeaconInventory) event.setCancelled(true);
	}
}
