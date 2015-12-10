package org.maana.iot_project.messages;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceControlMessage {

	private long deviceId;
	private long userId;
	private String command;
	
	public DeviceControlMessage() {
		
	
	}

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

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	

}
