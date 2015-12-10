package org.maana.iot_project.messages;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SensorControlRequestMessage {

	private long userId;
	private long sensorId;
	private int sensorCriticalValue;
	
	public SensorControlRequestMessage() {	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getSensorId() {
		return sensorId;
	}

	public void setSensorId(long sensorId) {
		this.sensorId = sensorId;
	}

	public int getSensorCriticalValue() {
		return sensorCriticalValue;
	}

	public void setSensorCriticalValue(int sensorCriticalValue) {
		this.sensorCriticalValue = sensorCriticalValue;
	}
	
}
