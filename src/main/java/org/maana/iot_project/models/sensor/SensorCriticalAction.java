package org.maana.iot_project.models.sensor;

import org.maana.iot_project.messages.DeviceControRequestlMessage;
import org.maana.iot_project.models.device.Device;
import org.maana.iot_project.optional_apis.SensorAction;
import org.maana.iot_project.services.DeviceEventHandlerService;

public class SensorCriticalAction extends SensorAction{

	private int sensorThresholdValue;
	private Device device;
	private long eventId;
	private int condition;
	
	public void setCondition(int condition) {
		this.condition = condition;
	}

	public SensorCriticalAction() {super(); }


	public void setSensorCriticalValue(int sensorCriticalValue) {
		this.sensorThresholdValue = sensorCriticalValue;
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

	@Override
	public void execute(int sensorValue,String arg,long userId) {
	
		DeviceControRequestlMessage deviceControRequestlMessage = new DeviceControRequestlMessage();
		deviceControRequestlMessage.setDeviceId(getDevice().getDevice_Id());
		deviceControRequestlMessage.setEventId(getEventId());
		deviceControRequestlMessage.setUserId(userId);
		System.out.println("going : deviceEventHandlerService");
		DeviceEventHandlerService deviceEventHandlerService = new DeviceEventHandlerService();
		deviceEventHandlerService.handleDeviceEvent(userId, deviceControRequestlMessage);
	
		
	}

	@Override
	public int getCondition() {
		return condition;
	}

	@Override
	public int getSensorthresholdValue() {
		// TODO Auto-generated method stub
		return sensorThresholdValue;
	}
	
}
