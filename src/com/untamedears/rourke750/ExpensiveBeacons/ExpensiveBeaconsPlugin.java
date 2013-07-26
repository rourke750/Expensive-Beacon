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

import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.BeaconManager;
import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.SpeedBeacon;
import com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes.StrengthBeacon;

public class ExpensiveBeaconsPlugin extends JavaPlugin {
	public static ExpensiveBeaconsPlugin instance;
	private BeaconManager bm;
	private StrengthBeacon strb;
	private SpeedBeacon sb;
	private BeaconListener ls;
	private StoredValues sv;
	private SaveManager sm;
	public BufferedWriter writer;
	private Effects ef = null;
	private File file;
	private Logger logger;
	
	public static StaticBeaconStructure speedstucture1;
	public static StaticBeaconStructure speedstucture2;
	public static StaticBeaconStructure speedstucture3;
	public static StaticBeaconStructure speedstucture4;
	public static StaticBeaconStructure speedstucture5;
	public static StaticBeaconStructure strengthstucture1;
	public static StaticBeaconStructure strengthstucture2;
	public static StaticBeaconStructure strengthstucture3;
	public static StaticBeaconStructure strengthstucture4;
	public static StaticBeaconStructure strengthstucture5;
	public void onLoad() {
		instance = this;
		
		logger = this.getLogger();
	}

	public void onEnable() {
		BeaconManager bm = new BeaconManager(sb, strb);
		String dir = this.getDataFolder() + File.separator + "Expensive Beacon Types" + File.separator;
		new File(dir).mkdirs();
		String type=null;
		for (int i=0; i<1; i++){
			if (i==0){
				type="speed_structure1.txt";
			}
			if (i==1){
				type="speed_structure2.txt";
			}
			if (i==2){
				type="speed_structure3.txt";
			}
			if (i==3){
				type="speed_structure4.txt";
			}
			if (i==4){
				type="speed_structure5.txt";
			}
			if (i==5){
				type="strength_structure1.txt";
			}
			if (i==6){
				type="strength_structure2.txt";
			}
			if (i==7){
				type="strength_structure3.txt";
			}
			if (i==8){
				type="strength_structure4.txt";
			}
			if (i==9){
				type="strength_structure5.txt";
			}
			try {
				File beacon = new File(dir + type);
				if (beacon.exists()) {
					continue;
				}
				else {
					Logger.getLogger(ExpensiveBeaconsPlugin.class.getName()).log(Level.INFO, "Making a new file", "");
					PrintWriter fstream = new PrintWriter(dir + type);
					writer = new BufferedWriter(fstream);
					bm.CreateBeaconFiles(beacon, type);
				}

			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		speedstucture1 = StaticBeaconStructure.loadFromFile(new File(dir, "speed_structure1.txt"));
		speedstucture2 = StaticBeaconStructure.loadFromFile(new File(dir, "speed_structure2.txt"));
		speedstucture3 = StaticBeaconStructure.loadFromFile(new File(dir, "speed_structure3.txt"));
		speedstucture4 = StaticBeaconStructure.loadFromFile(new File(dir, "speed_structure4.txt"));
		speedstucture5 = StaticBeaconStructure.loadFromFile(new File(dir, "speed_structure5.txt"));
		strengthstucture1 = StaticBeaconStructure.loadFromFile(new File(dir, "strength_structure1.txt"));
		strengthstucture2 = StaticBeaconStructure.loadFromFile(new File(dir, "strength_structure2.txt"));
		strengthstucture3 = StaticBeaconStructure.loadFromFile(new File(dir, "strength_structure3.txt"));
		strengthstucture4 = StaticBeaconStructure.loadFromFile(new File(dir, "strength_structure4.txt"));
		strengthstucture5 = StaticBeaconStructure.loadFromFile(new File(dir, "strength_structure5.txt"));
		logger.info("Plugin Enabled, Welcome to Alpha testing!");
		sv = new StoredValues();
		dir = this.getDataFolder() + File.separator + "Player Beacon Saves" + File.separator;
		new File(dir).mkdirs();
		MultiBlockStructure ms = new MultiBlockStructure(this, ls, sv, speedstucture1, speedstucture2, speedstucture3,
				speedstucture4, speedstucture5, strengthstucture1, strengthstucture2, strengthstucture3, 
				strengthstucture4, strengthstucture5);
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
				file = existing;
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		final Effects eff = ef;

		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
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
