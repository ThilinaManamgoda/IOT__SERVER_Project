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

public class DeviceControllerService implements MqttCallback,MQTT_Constants{
	public final static String MQTT_SENSOR_CONNCETION_ID="123";	
	
	public static DeviceControllerService deviceControllerService = null;
	
	private static MqttClient mqttClient = null;

	private final static String topic = "device/#";

    
	public DeviceControllerService(boolean cleanSession, String userName, String password) throws MqttException {
		System.out.println("in DeviceSensorControllerService constructor");
			//MAKE CONNECTION WITH WSO2 MESSAGE BROKER
			MqttConnectOptions options = new MqttConnectOptions();
	        options.setCleanSession(cleanSession);
	        options.setUserName(userName);
	        options.setPassword(password.toCharArray());
	        mqttClient = new MqttClient(BROKER_URL, MQTT_SENSOR_CONNCETION_ID,
	                new MqttDefaultFilePersistence(TMP_DIR + File.separator + saveFilesForListen));
	        mqttClient.setCallback(this);
	        mqttClient.connect(options);
	        mqttClient.subscribe(topic, 1);
	    	System.out.println("Subscribed !!");
	    
	    	
	}
	
	public static DeviceControllerService getInstanceOfThisClass(){
		if(deviceControllerService == null){
			try {
				System.out.println("DeviceSenserControllerService this should run only once");
				deviceControllerService = new DeviceControllerService(true,userName,password);
			} catch (MqttException e) {
				e.printStackTrace();
			}
			return deviceControllerService;
		}else{
			return deviceControllerService;
		}
	}

	@Override
	public void connectionLost(Throwable arg0) {
		
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		
	}	
	
	
}
