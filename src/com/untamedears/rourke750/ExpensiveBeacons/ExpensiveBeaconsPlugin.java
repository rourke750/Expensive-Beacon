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

import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.SpeedBeacon;
import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.StrengthBeacon;

public class ExpensiveBeaconsPlugin extends JavaPlugin {
	public static ExpensiveBeaconsPlugin instance;
	
	private StrengthBeacon strb;
	private BeaconListener ls;
	private SpeedBeacon sb;
	private StoredValues sv;
	private SaveManager sm;
	public BufferedWriter writer;
	private Effects ef = null;
	private File file;
	private Logger logger;
	
	public static StaticBeaconStructure testStructure;
	
	public void onLoad() {
		instance = this;
		
		logger = this.getLogger();
	}

	public void onEnable() {
		testStructure = StaticBeaconStructure.loadFromFile(new File(this.getDataFolder(), "test_structure.txt"));
		
		SpeedBeacon sb = new SpeedBeacon();
		StrengthBeacon strb = new StrengthBeacon();
		logger.info("Plugin Enabled, Welcome to Alpha testing!");
		sv = new StoredValues();
		String dir = this.getDataFolder() + File.separator + "Expensive Beacons" + File.separator;
		new File(dir).mkdirs();
		MultiBlockStructure ms = new MultiBlockStructure(this, ls, sb, sv, strb);
		ls = new BeaconListener(ms, sv);
		SaveManager sm = new SaveManager(this, sv);
		Effects ef = new Effects();
		enableListener();
		try {
			File existing = new File(dir + "StoredBeacons.txt");
			if (existing.exists()) {
				Logger.getLogger(ExpensiveBeaconsPlugin.class.getName()).log(Level.INFO, "Existing file", "");
				FileWriter fw = new FileWriter(existing.getAbsoluteFile(), true);
				writer = new BufferedWriter(fw);
				file = existing;
				logger.info("Logger pre load occured.");
				sm.load(file);
			}
			else {
				Logger.getLogger(ExpensiveBeaconsPlugin.class.getName()).log(Level.INFO, "Making a new file", "");
				PrintWriter fstream = new PrintWriter(dir + "StoredBeacons.txt");
				writer = new BufferedWriter(fstream);
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		final Effects eff = ef;

		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				logger.info("AutoScheduler");
				eff.runEffects(sv.getTypeMap(), sv.getTierMap());
			}
		}, 0, 100);
		final SaveManager smm = sm;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				logger.info("AutoScheduler");
				try {
					smm.save(file);
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, 300);
	}

	public void onDisable() {
		final SaveManager smm = sm;
		try {
			smm.save(file);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void enableListener() {
		getServer().getPluginManager().registerEvents(ls, this);
	}
}
