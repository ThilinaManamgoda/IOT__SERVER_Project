package org.maana.iot_project.models.device;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceType {

	private int deviceTypeId;
	private String deviceTypeName;
	private DeviceModel deviceModel;

	public DeviceType() {
	}

	public int getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(int deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}

	public DeviceModel getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(DeviceModel deviceModel) {
		this.deviceModel = deviceModel;
	}

}
