package org.maana.iot_project.messages;

import javax.xml.bind.annotation.XmlRootElement;

import org.maana.iot_project.models.device.DeviceState;

@XmlRootElement
public class DeviceStateChangeRequestMessage {

	
	private long userId;
	private long deviceId;
	private DeviceState deviceState;
	
	public DeviceStateChangeRequestMessage() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public DeviceState getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(DeviceState deviceState) {
		this.deviceState = deviceState;
	}

}
