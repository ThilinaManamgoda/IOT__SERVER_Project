package org.maana.iot_project.database;

import java.util.HashMap;

import org.maana.iot_project.models.sensor.Sensor;

import com.maanadev.mongo.MongodbImplement;

public class SensorDatabase implements DataBaseConstants{

	public static SensorDatabase sensorDatabase=null;
	private MongodbImplement<Sensor> database =null;
	public SensorDatabase() {
		database = new MongodbImplement<Sensor>(SENSOR_DATABASE, SENSOR_COLLECTION, Sensor.class);
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
		return database.get(String.valueOf(sensorId));
	}
	public void addSensor(long sensorId,Sensor sensor){
		database.save(sensor);
	}
	public long noOfSensors(){
		return database.getCount();
	}
}
