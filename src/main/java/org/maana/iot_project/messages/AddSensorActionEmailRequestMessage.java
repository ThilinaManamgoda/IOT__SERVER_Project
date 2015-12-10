package org.maana.iot_project.messages;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddSensorActionEmailRequestMessage {

	private String email;
	private int sensorThresholdValue;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSensorThresholdValue() {
		return sensorThresholdValue;
	}
	public void setSensorThresholdValue(int sensorThresholdValue) {
		this.sensorThresholdValue = sensorThresholdValue;
	}
	public String getCondtion() {
		return condtion;
	}
	public void setCondtion(String condtion) {
		this.condtion = condtion;
	}
	private String condtion;
	public AddSensorActionEmailRequestMessage() {
	}
}
