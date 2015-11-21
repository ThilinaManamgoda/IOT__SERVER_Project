package org.maana.iot_project.models.device;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Device {

	private Long device_Id;
	private String deviceName;
	private DeviceType deviceType;
	private Date device_Created_Date;

	public Device() {
	}

	public Long getDevice_Id() {
		return device_Id;
	}

	public void setDevice_Id(Long device_Id) {
		this.device_Id = device_Id;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public Date getDevice_Created_Date() {
		return device_Created_Date;
	}

	public void setDevice_Created_Date(Date device_Created_Date) {
		this.device_Created_Date = device_Created_Date;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

}