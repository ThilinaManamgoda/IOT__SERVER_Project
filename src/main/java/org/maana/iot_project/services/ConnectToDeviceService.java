package org.maana.iot_project.services;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.maana.iot_project.models.MQTT_Constants;

public class ConnectToDeviceService implements MQTT_Constants, MqttCallback {
	MqttClient mqttClientForchangeState;

	public void sendDeviceControlMessage(MqttMessage mqttMessage, String topic, String userId)
			throws MqttException, JsonGenerationException, JsonMappingException, IOException {
		System.out.println("in sendDeviceControlMessage ");
		// MAKE CONNECTION WITH WSO2 MESSAGE BROKER
		MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(true);
		options.setUserName(userName);
		options.setPassword(password.toCharArray());
		MqttClient mqttClientForSend = new MqttClient(BROKER_URL, userId,
				new MqttDefaultFilePersistence(TMP_DIR + File.separator + userId));

		mqttClientForSend.connect(options);

		// SENDING TO QEUE

		mqttClientForSend.publish(topic, mqttMessage);
		System.out.println("DeviceSensorControllerService mqqt message sent");
		System.out.println("DeviceSensorControllerService rest connection");

		// CLOSING CONNECTION AND RESOURCES
		mqttClientForSend.disconnect();
		mqttClientForSend.close();
	}

	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("Got Reply");
		DeviceManagementService deviceManagementService = new DeviceManagementService();
		deviceManagementService.updateDeviceState(message);
		System.out.println("updateed");
		mqttClientForchangeState.disconnect();
		mqttClientForchangeState.close();
	}

	public void waitingForStateReply(String userId, String topic) {
		MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(true);
		options.setUserName(userName);
		options.setPassword(password.toCharArray());

		try {
			mqttClientForchangeState = new MqttClient(BROKER_URL, userId,
					new MqttDefaultFilePersistence(TMP_DIR + File.separator + saveFilesForState + userId));
			mqttClientForchangeState.connect(options);
			mqttClientForchangeState.setCallback(this);
			mqttClientForchangeState.subscribe(topic);
			System.out.println("Waiting for device reply");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
