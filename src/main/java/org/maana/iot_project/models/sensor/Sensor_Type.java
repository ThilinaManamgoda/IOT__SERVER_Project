package org.maana.iot_project.models.sensor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sensor_Type {

	private String sensorType;
	
	public Sensor_Type() { }
	
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	
}
