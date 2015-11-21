package org.maana.iot_project.services;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.maana.iot_project.database.UserDataBase;
import org.maana.iot_project.models.User;
import org.maana.iot_project.models.device.Device;
import org.maana.iot_project.models.device.DeviceControRequestlMessage;
import org.maana.iot_project.models.device.DeviceControlMessage;
import org.maana.iot_project.models.device.DeviceType;
import org.maana.iot_project.models.device.EventDevice;



public class DeviceEventHandlerService {

	private  DeviceControllerService deviceControllerService = DeviceControllerService.getInstanceOfThisClass();
	private   UserDataBase userDataBase =UserDataBase.getInstanceOfThisClass();
	private static DeviceEventHandlerService deviceEventHandlerService = null;
	private static final  String MQTT_TOPIC="device/";
	
	public DeviceEventHandlerService() {	
		System.out.println("DeviceEventHandlerService ....");
	
	}

	public static DeviceEventHandlerService getInstanceOfThisCalss(){
		
		if(deviceEventHandlerService == null){
			System.out.println("deviceEventHandlerService this should run only once");
			deviceEventHandlerService = new DeviceEventHandlerService();
			return deviceEventHandlerService;
		}else{
			return deviceEventHandlerService;
		}
	}	
	public void handleDeviceEvent(long userId,DeviceControRequestlMessage deviceControRequestlMessage){
		System.out.println("in DeviceEventHandlerService : handleDeviceEvent");
		User user = userDataBase.getUserById(userId);
		
		Device device = user.getDeviceById(deviceControRequestlMessage.getDeviceId());
		DeviceType deviceType =device.getDeviceType();
		long deviceId=deviceControRequestlMessage.getDeviceId();
		EventDevice eventDevice = deviceType.getDeviceModel().getEvent(deviceControRequestlMessage.getEventId());
		
		String command = eventDevice.getEventCommand();
		
		DeviceControlMessage deviceControlMessage =new DeviceControlMessage();
		deviceControlMessage.setUserId(userId);
		deviceControlMessage.setDeviceId(deviceId);
		deviceControlMessage.setCommand(command);
		
		 System.out.println("deviceControlMessage is produced ");
		String userId_String =String.valueOf(userId);
		try {
			 //CONVERT deviceControlMessage OBJECT TO JSON OBJECT
			String JSONMessage =createJsonObjectOfObject(deviceControlMessage);
			 //CREATING MQTT MESSAGE WHICH CONTAIN deviceControlMessage JSON OBJECT 
	        MqttMessage mqttMessage = new MqttMessage();
	        mqttMessage.setPayload(JSONMessage.getBytes());
	        //SENDIN TO SENSOR VIA DEVICE_SENSOR_CONTROLLER_SERVICE
	        System.out.println("going deviceControllerService : sendDeviceControlMessage ");
			deviceControllerService.sendDeviceControlMessage(mqttMessage, createTopic(userId),userId_String);
		
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String createTopic(long userId){
		return MQTT_TOPIC+String.valueOf(userId);
	}
	private String createJsonObjectOfObject(final DeviceControlMessage deviceControlMessage) throws JsonGenerationException, JsonMappingException, IOException{
		  ObjectMapper mapper = new ObjectMapper();
		  return  mapper.writeValueAsString(deviceControlMessage);
	}
}
