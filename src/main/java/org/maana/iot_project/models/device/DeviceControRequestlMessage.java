package org.maana.iot_project.models.device;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceControRequestlMessage {

	private long deviceId;
	private long userId;
	private long eventId;
	
	 public DeviceControRequestlMessage() {	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	 
	 
}
