package com.untamedears.rourke750.ExpensiveBeacons;




import java.util.logging.Logger;

import net.minecraft.server.v1_5_R3.Block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class onListener implements Listener{
	private multiblockstructure multi;
	public onListener(multiblockstructure plugin){
		multi=plugin;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockPlace(BlockPlaceEvent event){

		Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
		logger.info("Listener is enabled.");
		if(event.getBlock().getType().equals(Material.BEACON)) {
			Location loc= event.getBlock().getLocation();
			multi.checkBuild(loc);
		}
	}
}
