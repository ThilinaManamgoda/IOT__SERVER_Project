package org.maana.iot_project.models.sensor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sensor_Model {

	private String sensorModel;
	private Sensor_Type sensorType;

	public Sensor_Model() {

	}

	public String getSensorModel() {
		return sensorModel;
	}

	public void setSensorModel(String sensorModel) {
		this.sensorModel = sensorModel;
	}

	public Sensor_Type getSensorType() {
		return sensorType;
	}

	public void setSensorType(Sensor_Type sensorType) {
		this.sensorType = sensorType;
	}

}
