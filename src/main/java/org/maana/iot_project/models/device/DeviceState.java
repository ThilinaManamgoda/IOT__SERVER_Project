package org.maana.iot_project.models.device;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceState {

	private int stateId;
	private String StateName;

	public DeviceState() {
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

}
