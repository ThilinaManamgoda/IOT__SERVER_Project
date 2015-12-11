package org.maana.iot_project.messages;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserSensorStateMessage {

	private long sensorId;
	private long userId;
	private long sensorCriticalValue;
	
	public long getSensorId() {
		return sensorId;
	}

	public void setSensorId(long sensorId) {
		this.sensorId = sensorId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	

	public long getSensorCriticalValue() {
		return sensorCriticalValue;
	}

	public void setSensorCriticalValue(long sensorCriticalValue) {
		this.sensorCriticalValue = sensorCriticalValue;
	}

	public UserSensorStateMessage() {
	}
	
	
	
}
