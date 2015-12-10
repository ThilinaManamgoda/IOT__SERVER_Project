package org.maana.iot_project.database;

import java.util.HashMap;

import org.maana.iot_project.models.device.Device;

public class DeviceDataBase {

	
	public static DeviceDataBase deviceDataBase=null;
	private HashMap<Long, Device> database = new HashMap<Long, Device>();
			
	
	public DeviceDataBase() {
	}
	public static DeviceDataBase getInstanceOfThisClass(){
		if(deviceDataBase == null){
			deviceDataBase = new DeviceDataBase();
			return deviceDataBase;
		} else{
			return deviceDataBase;
		}
	}

	public HashMap<Long, Device> getDatabase() {
		return database;
	}

	public void setDatabase(HashMap<Long, Device> database) {
		this.database = database;
	}

	public Device getDevice(long deviceId){
		
		return database.get(deviceId);
	}
	public void addDevice(long deviceId,Device device){
		database.put(deviceId, device);	
	}
	public int noOfDevices(){
		
		return database.size();
	}
	
	
}
