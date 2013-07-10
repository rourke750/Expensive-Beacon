package com.untamedears.rourke750.ExpensiveBeacons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.untamedears.com.rourke750.ExpensiveBeacons.BeaconTypes.SpeedBeacon;
import com.untamedears.com.rourke750.ExpensiveBeacons.BeaconTypes.StrengthBeacon;

public class ExpensiveBeaconsplugin extends JavaPlugin{
	private StrengthBeacon strb;
	private onListener ls;
	private SpeedBeacon sb;
	private StoredValues sv;
	private SaveManager sm;
	public BufferedWriter writer;
	private Effects ef=null;
	private File file;
	Logger logger = Logger.getLogger(ExpensiveBeaconsplugin.class.getName());
	public void onEnable(){
		SpeedBeacon sb = new SpeedBeacon();
		StrengthBeacon strb = new StrengthBeacon();
		logger.info("Plugin Enabled, Welcome to Alpha testing!");
		sv= new StoredValues();
		String dir= this.getDataFolder() +File.separator +"Expensive Beacons"+ File.separator;
		new File(dir).mkdirs();
		multiblockstructure ms= new multiblockstructure(this, ls, sb, sv, strb);
		ls = new onListener(ms, sv);
		SaveManager sm= new SaveManager(this, sv);
		Effects ef= new Effects();
		enableListener();
		try {
			File existing= new File(dir+"StoredBeacons.txt");
			if (existing.exists()){
				Logger.getLogger(ExpensiveBeaconsplugin.class.getName()).log(Level.INFO, "Existing file", "");
				FileWriter fw = new FileWriter(existing.getAbsoluteFile(), true);
                writer = new BufferedWriter(fw);
                sm.load(existing);
                file=existing;
			}
			else {
				Logger.getLogger(ExpensiveBeaconsplugin.class.getName()).log(Level.INFO, "Making a new file", "");
				PrintWriter fstream = new PrintWriter(dir+"StoredBeacons.txt");
				writer = new BufferedWriter(fstream);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		final Effects eff = ef;
		final StoredValues svv= sv;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			public void run(){
				logger.info("AutoScheduler");
				eff.runEffects(svv.getTypeMap(), svv.getTierMap());
			}
		}, 0, 100);
		final SaveManager smm= sm;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			public void run(){
				logger.info("AutoScheduler");
				try {
					smm.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, 12000);
	}
	public void onDisable(){
		try {
			sm.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void enableListener(){
		getServer().getPluginManager().registerEvents(ls, this);
	}
}
