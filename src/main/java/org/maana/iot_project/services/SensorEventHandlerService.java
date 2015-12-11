package org.maana.iot_project.services;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.maana.iot_project.messages.SensorControlRequestMessage;
import org.maana.iot_project.models.ServerConstants;
import org.maana.iot_project.models.User;
import org.maana.iot_project.models.sensor.Sensor;
import org.maana.iot_project.optional_apis.SensorAction;

public class SensorEventHandlerService {

	// EMPTY CONSTRUCTOR
	public SensorEventHandlerService() {
		// System.out.println("SensorEventHandlerService ......");

	}

	public void handleSensorEvent(MqttMessage mqttMessage) {
		System.out.println("sensorEventHandlerService : handleSensorEvent");
		SensorControlRequestMessage sensorControlRequestMessage = getSensorControlRequestMessage(mqttMessage);
		long userId = sensorControlRequestMessage.getUserId();
		long sensorId = sensorControlRequestMessage.getSensorId();
		int sensorCriticalValue = sensorControlRequestMessage.getSensorCriticalValue();

		UserService userService = new UserService();
		User user = userService.getUSerById(userId);
		Sensor sensor = user.getSensor(sensorId);

		ArrayList<SensorAction> sensorActions = sensor.getSensorActions();

		for (SensorAction action : sensorActions) {
			int condition = action.getCondition();
			switch (condition) {

			case (ServerConstants.LAGER_THAN): {

				if (sensorCriticalValue > action.getSensorthresholdValue()) {
					action.execute(sensor, "", userId);
				}
				break;
			}
			case (ServerConstants.LESS_THAN): {

				if (sensorCriticalValue < action.getSensorthresholdValue()) {
					action.execute(sensor, "", userId);
				}
				break;
			}
			case (ServerConstants.EQUAL): {

				if (sensorCriticalValue == action.getSensorthresholdValue()) {
					action.execute(sensor, "", userId);
				}
				break;
			}
			case (ServerConstants.LARGER_OR_EQUAL): {

				if (sensorCriticalValue >= action.getSensorthresholdValue()) {
					action.execute(sensor, "", userId);
				}
				break;
			}
			case (ServerConstants.LESS_OR_EQUAL): {

				if (sensorCriticalValue <= action.getSensorthresholdValue()) {
					action.execute(sensor, "", userId);
				}
				break;
			}
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
