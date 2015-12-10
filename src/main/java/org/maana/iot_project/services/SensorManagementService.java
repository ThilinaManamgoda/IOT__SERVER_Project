package org.maana.iot_project.services;

import org.maana.iot_project.messages.AddSensorActionEmailRequestMessage;
import org.maana.iot_project.models.User;
import org.maana.iot_project.models.sensor.Sensor;
import org.maana.iot_project.optional_apis.SendMailTLS;

public class SensorManagementService {

	
	
	public SensorManagementService() {
	}
	
	
	
	public void addSensorActionEmail(long userId, long sensorId, AddSensorActionEmailRequestMessage actionEmailRequestMessage){
		UserService userService = new UserService();
		User user = userService.getUSerById(userId);
		Sensor sensor = user.getSensor(sensorId);
		
		SendMailTLS sendMailTLS = new SendMailTLS();
		sendMailTLS.setCondition(actionEmailRequestMessage.getCondition());
		sendMailTLS.setToEmailAddress(actionEmailRequestMessage.getEmail());
		sendMailTLS.setSensorthresholdValue(actionEmailRequestMessage.getSensorThresholdValue());
		sensor.addSensorAction(sendMailTLS);
		System.out.println("okkkkk");
		userService.putUser(user, userId);
	}
}
