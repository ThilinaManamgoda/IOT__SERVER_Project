package org.maana.iot_project.database;

import java.util.HashMap;

import org.maana.iot_project.models.sensor.Sensor;

public class SensorDatabase {

	public static SensorDatabase sensorDatabase=null;
	
	private HashMap<Long , Sensor> database = new HashMap<Long, Sensor>();
	public SensorDatabase() {
	}
	
	public static SensorDatabase getInstanceOfThisClass(){
		if(sensorDatabase == null){
			sensorDatabase = new SensorDatabase();
			return sensorDatabase;
		} else{
			return sensorDatabase;
		}
	}
	
	
	public Sensor getSensor(long sensorId){
		return database.get(sensorId);
	}
	public void addSensor(long sensorId,Sensor sensor){
		database.put(sensorId, sensor);	
	}
	public int noOfSensors(){
		return database.size();
	}
}
