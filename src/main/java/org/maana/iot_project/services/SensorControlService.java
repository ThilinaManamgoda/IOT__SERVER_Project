package org.maana.iot_project.services;

import java.io.File;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.maana.iot_project.models.MQTT_Constants;

public class SensorControlService implements MqttCallback, MQTT_Constants {

	public static SensorControlService sensorControlService = null;

	private static MqttClient mqttClient = null;

	public static SensorControlService getInstanceOfThisClass() {
		if (sensorControlService == null) {
			sensorControlService = new SensorControlService(true);
			return sensorControlService;
		} else {
			return sensorControlService;
		}
	}

	public SensorControlService(boolean cleanSession) {
		// MAKE CONNECTION WITH WSO2 MESSAGE BROKER
		MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(cleanSession);
		options.setUserName(userName);
		options.setPassword(password.toCharArray());
		try {
			mqttClient = new MqttClient(BROKER_URL, MQTT_SENSOR_CONNCETION_ID,
					new MqttDefaultFilePersistence(TMP_DIR + File.separator + saveFilesForListen));
			mqttClient.setCallback(this);
			mqttClient.connect(options);
			mqttClient.subscribe(TOPIC_SENSOR, 1);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Subscribed !!");

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
		// TODO Auto-generated method stub
		System.out.println("Message arrived");
		System.out.println("Going to sensorEventHandlerService");

		SensorManagementService sensorManagementService = new SensorManagementService();
		sensorManagementService.updateStatesOfSensor(message);
		SensorEventHandlerService sensorEventHandlerService = new SensorEventHandlerService();
		sensorEventHandlerService.handleSensorEvent(message);
	}
}
