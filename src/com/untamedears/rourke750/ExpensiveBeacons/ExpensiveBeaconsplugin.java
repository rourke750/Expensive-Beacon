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

public class ExpensiveBeaconsplugin extends JavaPlugin{
	private onListener ls= null;
	private multiblockstructure ms=null;
	private SpeedBeacon sb=null;
	private StoredValues sv=null;
	private SaveManager sm=null;
	public BufferedWriter writer;
	private Effects ef= new Effects();
	private File file;
	public void onEnable(){
		String dir= this.getDatabase() +File.separator +"Expensive Beacons"+ File.separator;
		new File(dir).mkdirs();
		multiblockstructure ms= new multiblockstructure(this, ls, sb, sv);
		ls = new onListener(ms);
		SaveManager sm= new SaveManager(this, sv);
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
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			public void run(){
				ef.runEffects(sv.getTypeMap(), sv.getTierMap());
			}
		}, 0, 100);
	}
	public void onDisable(){
		try {
			sm.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void enableListener(){
		getServer().getPluginManager().registerEvents(ls, this);
	}
}
