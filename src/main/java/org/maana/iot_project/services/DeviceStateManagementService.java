package org.maana.iot_project.services;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.maana.iot_project.messages.DeviceStateChangeRequestMessage;
import org.maana.iot_project.models.User;
import org.maana.iot_project.models.device.Device;

public class DeviceStateManagementService {

	
	public DeviceStateManagementService() {
	}

	public void updateDeviceState( MqttMessage message){
		
		DeviceStateChangeRequestMessage deviceStateChangeRequestMessage = getDeviceStateChangeRequestMessageObject(message);
		
		System.out.println(deviceStateChangeRequestMessage.getUserId());
		UserService userService = new UserService();

		long userId =deviceStateChangeRequestMessage.getUserId();
		System.out.println("3");
		User user =userService.getUSerById(userId);
		System.out.println("4");
		Device device = user.getDeviceById(deviceStateChangeRequestMessage.getDeviceId());
		System.out.println("5");
		device.setDeviceState(deviceStateChangeRequestMessage.getDeviceState());
		System.out.println("6");
		userService.putUser(user, userId);
		System.out.println("7");
	}

	private DeviceStateChangeRequestMessage getDeviceStateChangeRequestMessageObject( MqttMessage message){
		ObjectMapper mapper = new ObjectMapper();
		DeviceStateChangeRequestMessage deviceStateChangeRequestMessage = null;
		try {
			deviceStateChangeRequestMessage =mapper.readValue(message.toString(), DeviceStateChangeRequestMessage.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deviceStateChangeRequestMessage;
	}
}
