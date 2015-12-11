package org.maana.iot_project.services;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.maana.iot_project.messages.AddSensorActionEmailRequestMessage;
import org.maana.iot_project.messages.SensorControlRequestMessage;
import org.maana.iot_project.messages.UserSensorStateMessage;
import org.maana.iot_project.models.User;
import org.maana.iot_project.models.sensor.Sensor;
import org.maana.iot_project.optional_apis.SendMailTLS;

public class SensorManagementService {

	public SensorManagementService() {
	}

	public void addSensorActionEmail(long userId, long sensorId,
			AddSensorActionEmailRequestMessage actionEmailRequestMessage) {
		UserService userService = new UserService();
		User user = userService.getUSerById(userId);
		Sensor sensor = user.getSensor(sensorId);

		SendMailTLS sendMailTLS = new SendMailTLS();
		sendMailTLS.setCondition(actionEmailRequestMessage.getCondition());
		sendMailTLS.setToEmailAddress(actionEmailRequestMessage.getEmail());
		sendMailTLS.setSensorthresholdValue(actionEmailRequestMessage.getSensorThresholdValue());
		sensor.addSensorAction(sendMailTLS);
		userService.putUser(user, userId);
	}

	public void updateStatesOfSensor(MqttMessage message) {

		SensorControlRequestMessage sensorControlRequestMessage = getSensorControlRequestMessage(message);
		long userId = sensorControlRequestMessage.getUserId();
		long sensorId = sensorControlRequestMessage.getSensorId();
		int sensorCriticalValue = sensorControlRequestMessage.getSensorCriticalValue();
		UserService userService = new UserService();
		User user = userService.getUSerById(userId);
		Sensor sensor = user.getSensor(sensorId);
		sensor.setSensorCriticalValue(sensorCriticalValue);
		userService.putUser(user, userId);
	}

	public UserSensorStateMessage getSensorState(long userId, long sensorId) {
		UserService userService = new UserService();
		User user = userService.getUSerById(userId);
		Sensor sensor = user.getSensor(sensorId);

		UserSensorStateMessage message = new UserSensorStateMessage();
		message.setSensorId(sensorId);
		message.setUserId(userId);
		message.setSensorCriticalValue(sensor.getSensorCriticalValue());
		return message;

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
