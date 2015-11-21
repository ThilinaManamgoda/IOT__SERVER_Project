package org.maana.iot_project.services;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.maana.iot_project.database.UserDataBase;
import org.maana.iot_project.models.User;
import org.maana.iot_project.models.device.DeviceControRequestlMessage;
import org.maana.iot_project.models.sensor.Sensor;
import org.maana.iot_project.models.sensor.SensorControlRequestMessage;
import org.maana.iot_project.models.sensor.SensorCriticalAction;

public class SensorEventHandlerService {

	public static SensorEventHandlerService sensorEventHandlerService = null;
	
	private UserDataBase userDataBase = UserDataBase.getInstanceOfThisClass();

	private  DeviceEventHandlerService deviceEventHandlerService =DeviceEventHandlerService.getInstanceOfThisCalss();

	// EMPTY CONSTRUCTOR
	public SensorEventHandlerService() {
		System.out.println("SensorEventHandlerService ......");
		
		
		
	}

	public static SensorEventHandlerService getInstanceOfThisClass() {
		if (sensorEventHandlerService == null) {
			System.out.println("SensorEventHandlerService this should run only once");
			sensorEventHandlerService = new SensorEventHandlerService();
			return sensorEventHandlerService;
		} else {
			return sensorEventHandlerService;
		}
	}

	public void handleSensorEvent(MqttMessage mqttMessage) {
		System.out.println("sensorEventHandlerService : handleSensorEvent");
		SensorControlRequestMessage sensorControlRequestMessage = getSensorControlRequestMessage(mqttMessage);
		long userId = sensorControlRequestMessage.getUserId();
		long sensorId = sensorControlRequestMessage.getSensorId();
		int sensorCriticalValue = sensorControlRequestMessage.getSensorCriticalValue();
		
		User user = userDataBase.getUserById(userId);
		Sensor sensor = user.getSensor(sensorId);

		ArrayList<SensorCriticalAction> sensorCriticalActions = sensor.getCriticalActions();

		for (SensorCriticalAction action : sensorCriticalActions) {

			if (sensorCriticalValue > action.getSensorCriticalValue()) {
				DeviceControRequestlMessage deviceControRequestlMessage = new DeviceControRequestlMessage();
				deviceControRequestlMessage.setDeviceId(action.getDevice().getDevice_Id());
				deviceControRequestlMessage.setEventId(action.getEventId());
				deviceControRequestlMessage.setUserId(userId);
				System.out.println("going : deviceEventHandlerService");
				deviceEventHandlerService.handleDeviceEvent(userId, deviceControRequestlMessage);
			}
		}

	}

	private SensorControlRequestMessage getSensorControlRequestMessage(MqttMessage mqttMessage) {
		ObjectMapper mapper = new ObjectMapper();
		SensorControlRequestMessage sensorControlRequestMessage = null;
		try {
			sensorControlRequestMessage = mapper.readValue(mqttMessage.toString(), SensorControlRequestMessage.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sensorControlRequestMessage;
	}
}
