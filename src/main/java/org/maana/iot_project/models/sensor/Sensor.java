package org.maana.iot_project.models.sensor;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import org.maana.iot_project.optional_apis.SensorAction;

@XmlRootElement
public class Sensor {
	
	private long sensorId;
	private Sensor_Model sensor_Model;
	private int sensorCriticalValue;
	private ArrayList<SensorAction> sensorActions;
	
	public boolean addSensorAction(SensorAction arg0) {
		return sensorActions.add(arg0);
	}

	public SensorAction getSensorAction(int arg0) {
		return sensorActions.get(arg0);
	}

	public Sensor(){sensorActions = new ArrayList<SensorAction>(); }

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

	public ArrayList<SensorAction> getSensorActions() {
		return sensorActions;
	}

	public void setActions(ArrayList<SensorAction> sensorActions) {
		this.sensorActions = sensorActions;
	}
	
	
	
}
