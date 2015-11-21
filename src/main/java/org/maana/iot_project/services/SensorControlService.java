package org.maana.iot_project.services;

import java.io.File;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

public class SensorControlService implements MqttCallback {

public final static String MQTT_SENSOR_CONNCETION_ID="12345";	
	
	public static SensorControlService sensorControlService = null;
	public  SensorEventHandlerService sensorEventHandlerService =  SensorEventHandlerService.getInstanceOfThisClass();
	private static MqttClient mqttClient = null;
	public final static String userName ="admin";
	public final static String password = "admin";
	public final static String saveFilesForListen = "saveFilesForSensorListen";
	public final static String saveFilesForSend= "saveFilesForSensorSend";
	public final static String topic = "sensors/#";
	  // The URL of the Message Broker
    public static final String BROKER_URL = "tcp://localhost:1883";

    // The temp directory to use for mqtt client
    public static final String TMP_DIR= System.getProperty("java.io.tmpdir");
    
    
    public static SensorControlService getInstanceOfThisClass(){
    	if(sensorControlService==null){
    		sensorControlService = new SensorControlService(true);
    		return sensorControlService;
    	}else{
    		return sensorControlService;
    	}
    }
    public SensorControlService(boolean cleanSession) {
    	//MAKE CONNECTION WITH WSO2 MESSAGE BROKER
		MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(cleanSession);
        options.setUserName(userName);
        options.setPassword(password.toCharArray());
        try {
			mqttClient = new MqttClient(BROKER_URL, MQTT_SENSOR_CONNCETION_ID,
			        new MqttDefaultFilePersistence(TMP_DIR + File.separator + saveFilesForListen));
			mqttClient.setCallback(this);
	        mqttClient.connect(options);
	        mqttClient.subscribe(topic, 1);
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
		System.out.println("Message : "+message.toString());
		sensorEventHandlerService.handleSensorEvent(message);
	}
}
