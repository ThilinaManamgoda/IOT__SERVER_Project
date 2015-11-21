package org.maana.iot_project.models.sensor;

import org.maana.iot_project.models.device.Device;

public class SensorCriticalAction {

	private int sensorCriticalValue;
	private Device device;
	private long eventId;
	
	public SensorCriticalAction() { }

	public int getSensorCriticalValue() {
		return sensorCriticalValue;
	}

	public void setSensorCriticalValue(int sensorCriticalValue) {
		this.sensorCriticalValue = sensorCriticalValue;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	
}
