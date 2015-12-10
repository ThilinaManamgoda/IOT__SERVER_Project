package org.maana.iot_project.messages;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddSensorActionEmailRequestMessage {

	private String email;
	private int sensorThresholdValue;
	private long sensorId;
	private int condition;
	public AddSensorActionEmailRequestMessage() {
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public long getSensorId() {
		return sensorId;
	}
	public void setSensorId(long sensorId) {
		this.sensorId = sensorId;
	}
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
	

	
}
