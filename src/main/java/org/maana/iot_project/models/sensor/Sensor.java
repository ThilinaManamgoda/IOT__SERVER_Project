package org.maana.iot_project.models.sensor;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sensor {
	
	private long sensorId;
	private Sensor_Model sensor_Model;
	private int sensorCriticalValue;
	private ArrayList<SensorCriticalAction> criticalActions;
	
	public boolean addSensorCriticalAction(SensorCriticalAction arg0) {
		return criticalActions.add(arg0);
	}

	public SensorCriticalAction getSensorCriticalAction(int arg0) {
		return criticalActions.get(arg0);
	}

	public Sensor(){criticalActions = new ArrayList<SensorCriticalAction>(); }

	public long getSensorId() {
		return sensorId;
	}

	public void setSensorId(long sensorId) {
		this.sensorId = sensorId;
	}

	public Sensor_Model getSensor_Model() {
		return sensor_Model;
	}

	public void setSensor_Model(Sensor_Model sensor_Model) {
		this.sensor_Model = sensor_Model;
	}

	public int getSensorCriticalValue() {
		return sensorCriticalValue;
	}

	public void setSensorCriticalValue(int sensorCriticalValue) {
		this.sensorCriticalValue = sensorCriticalValue;
	}

	public ArrayList<SensorCriticalAction> getCriticalActions() {
		return criticalActions;
	}

	public void setCriticalActions(ArrayList<SensorCriticalAction> criticalActions) {
		this.criticalActions = criticalActions;
	}
	
	
	
}
