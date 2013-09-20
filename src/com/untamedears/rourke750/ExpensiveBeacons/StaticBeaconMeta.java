package com.untamedears.rourke750.ExpensiveBeacons;

public class StaticBeaconMeta{
	private static int maxSize = 21;
	private static StaticBeaconStructure arr[] = new StaticBeaconStructure[maxSize];

	
	public StaticBeaconStructure getStruct(int i){
		return arr[i];
	}
	
	public void overStruct(int i, StaticBeaconStructure a){
		arr[i]=a;
	}
	
	public int getMaxSize(){
		return maxSize;
	}
}