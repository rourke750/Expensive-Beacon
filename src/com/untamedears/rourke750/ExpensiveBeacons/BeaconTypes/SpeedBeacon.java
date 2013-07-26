package com.untamedears.rourke750.ExpensiveBeacons.BeaconTypes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SpeedBeacon {
	
	public void Beacons1(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos));
		br.append("(1,0,0)[57:0];(-1,0,0)[57:0];");
		
		br.flush();
		fos.close();
	}
	public void Beacons2(File file){
		
	}
	public void Beacons3(File file){
	
}
	public void Beacons4(File file){
	
}
	public void Beacons5(File file){
	
}
}