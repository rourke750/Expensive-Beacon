package com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes;

import java.io.File;
import java.io.IOException;

public class BeaconManager {
	private SpeedBeacon sb;
	private StrengthBeacon strb;
 public BeaconManager (SpeedBeacon speed, StrengthBeacon strength){
	 sb=speed;
	 strb=strength;
 }
 	public void CreateBeaconFiles(File file, String type) throws IOException{
 		if (type=="speed_structure1.txt"){
 			sb.Beacons1(file);
 		}
 		if (type=="speed_structure2.txt"){
 			sb.Beacons2(file);
 		}
 		if (type=="speed_structure3.txt"){
 			sb.Beacons3(file);
 		}
 		if (type=="speed_structure4.txt"){
 			sb.Beacons4(file);
 		}
 		if (type=="speed_structure5.txt"){
 			sb.Beacons5(file);
 		}
 	}
}
