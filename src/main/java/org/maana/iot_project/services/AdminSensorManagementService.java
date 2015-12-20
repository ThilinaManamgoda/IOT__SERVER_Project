package org.maana.iot_project.services;

import org.maana.iot_project.database.SensorDatabase;
import org.maana.iot_project.models.sensor.Sensor;

public class AdminSensorManagementService {

	private SensorDatabase sensorDatabase = new SensorDatabase();
	
	public AdminSensorManagementService() {
	}
	
	
	public Sensor addSensor(Sensor sensor){
		
		long sensorId=sensorDatabase.noOfSensors()+1;
		sensor.setSensorId(sensorId);
		sensorDatabase.addSensor(sensorId, sensor);
		return sensor;
	}
	
	public Sensor getSensor(long sensorId){
		
		return sensorDatabase.getSensor(sensorId);
		
	}
}
