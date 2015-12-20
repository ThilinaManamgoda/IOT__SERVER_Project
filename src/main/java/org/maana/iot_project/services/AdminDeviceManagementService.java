package org.maana.iot_project.services;

import org.maana.iot_project.database.DeviceDataBase;
import org.maana.iot_project.models.device.Device;
import org.maana.iot_project.models.device.DeviceState;
import org.maana.iot_project.models.device.EventDevice;

public class AdminDeviceManagementService {

	DeviceDataBase dataBase = DeviceDataBase.getInstanceOfThisClass();

	public AdminDeviceManagementService() {
	}

	public Device addDevice(Device device) {
		long deviceId = noOfDevices() + 1;
		device.setDevice_Id(deviceId);
		dataBase.addDevice(deviceId, device);
		return device;
	}

	public Device getDevice(long deviceId) {
		return dataBase.getDevice(deviceId);
	}

	private long noOfDevices() {

		return dataBase.noOfDevices();
	}

	public EventDevice addDeviceEvent(long deviceId, EventDevice eventDevice) {
		Device device = dataBase.getDevice(deviceId);
		device.getDeviceType().getDeviceModel().addEvent(eventDevice.getEventId(), eventDevice);
		return eventDevice;
	}

	public DeviceState addState(long deviceId, DeviceState deviceState) {

		Device device = dataBase.getDevice(deviceId);
		System.out.println(device);
		device.addState(deviceState.getStateId(), deviceState);
		return deviceState;
	}
}
