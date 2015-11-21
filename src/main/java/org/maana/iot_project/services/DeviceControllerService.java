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

public class DeviceControllerService implements MqttCallback{
	public final static String MQTT_SENSOR_CONNCETION_ID="123";	
	
	public static DeviceControllerService deviceControllerService = null;
	
	private static MqttClient mqttClient = null;
	public final static String userName ="admin";
	public final static String password = "admin";
	public final static String saveFilesForListen = "saveFilesForListen";
	public final static String saveFilesForSend= "saveFilesForSend";
	public final static String topic = "device/#";
	  // The URL of the Message Broker
    public static final String BROKER_URL = "tcp://localhost:1883";

    // The temp directory to use for mqtt client
    public static final String TMP_DIR= System.getProperty("java.io.tmpdir");
    
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
	public void sendDeviceControlMessage(MqttMessage mqttMessage,String topic,String userId ) throws MqttException, JsonGenerationException, JsonMappingException, IOException{
		System.out.println("in sendDeviceControlMessage ");
			//MAKE CONNECTION WITH WSO2 MESSAGE BROKER
			MqttConnectOptions options = new MqttConnectOptions();
	        options.setCleanSession(true);
	        options.setUserName(userName);
	        options.setPassword(password.toCharArray());
	        MqttClient mqttClientForSend = new MqttClient(BROKER_URL, userId,
	                new MqttDefaultFilePersistence(TMP_DIR + File.separator + saveFilesForSend));
	        mqttClientForSend.setCallback(this);
	        mqttClientForSend.connect(options);
	        mqttClientForSend.subscribe(topic, 1);
	    
	        
	       
	        //SENDING TO QEUE
	        
	        mqttClientForSend.publish(topic, mqttMessage);
	        System.out.println("DeviceSensorControllerService mqqt message sent");
	        System.out.println("DeviceSensorControllerService rest connection");
	        
	        //CLOSING CONNECTION AND RESOURCES
	        mqttClientForSend.disconnect();
	        mqttClientForSend.close();
	}
	
}
