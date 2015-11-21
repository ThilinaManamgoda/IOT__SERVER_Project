package org.maana.iot_project.services;

import org.maana.iot_project.database.UserDataBase;
import org.maana.iot_project.models.User;
import org.maana.iot_project.models.device.Device;
import org.maana.iot_project.models.device.DeviceModel;
import org.maana.iot_project.models.device.DeviceType;
import org.maana.iot_project.models.device.DeviceTypes;
import org.maana.iot_project.models.device.EventDevice;
import org.maana.iot_project.models.sensor.Sensor;
import org.maana.iot_project.models.sensor.SensorCriticalAction;
import org.maana.iot_project.models.sensor.Sensor_Model;
import org.maana.iot_project.models.sensor.Sensor_Type;

public class UserService {
	
	
	private static UserService userservice = null;
	private UserDataBase userDataBase = UserDataBase.getInstanceOfThisClass();
	private SensorControlService sensorControlService = SensorControlService.getInstanceOfThisClass();
	public UserService() {
		System.out.println("UserService.....");
		EventDevice eventDevice = new EventDevice();
		eventDevice.setEventCommand("SET_SWITCH_ON");
		eventDevice.setEventId(214);
		eventDevice.setEventName( "SWITCH_ON");
		
		DeviceModel deviceModel = new DeviceModel(1, "PHILIPS");
		deviceModel.addEvent(214,eventDevice);
		
		DeviceType deviceType = new DeviceType();
		deviceType.setDeviceTypeId(1);
		deviceType.setDeviceModel(deviceModel);
		deviceType.setDeviceTypeName(DeviceTypes.BULB);
		
		Device device = new Device();
		device.setDevice_Id(1L);
		device.setDeviceType(deviceType);
		device.setDeviceName("BULB");
		
		Sensor sensor = new  Sensor();
		Sensor_Type sensor_Type = new Sensor_Type();
		sensor_Type.setSensorType("Temp");
		Sensor_Model sensor_Model = new Sensor_Model();
		sensor_Model.setSensorModel("Samsung");
		sensor_Model.setSensorType(sensor_Type);
		sensor.setSensor_Model(sensor_Model);
		
		SensorCriticalAction sensorCriticalAction = new SensorCriticalAction();
		sensorCriticalAction.setDevice(device);
		sensorCriticalAction.setEventId(214);
		sensorCriticalAction.setSensorCriticalValue(50);
		sensor.addSensorCriticalAction(sensorCriticalAction);
		
		User user = new User();
		user.setId(1);
		user.setEmail("maanafun@gmail.com");
		user.setName("Maana");
		user.setPhoneNumber("0770445855");
		user.addDevice(device, 1L);
		user.addSensor(1L, sensor);
		putUser(user);
		System.out.println("User is created.....");
	}
	// PROVIDE INSTANCE OF THIS CLASS
	public static UserService getInstanceOfThisClass() {

		if (userservice == null) {
			userservice = new UserService();
			return userservice;
		} else {
			return userservice;
		}
	}

	// GET USER BY ID
	public User getUSerById(long id) {
		return userDataBase.getUserById(id);
	}

	// PUT USER IN DATABASE
	public void putUser(User user) {
		
		long userId =userDataBase.noOfUsers()+1;
		user.setId(userId);
		userDataBase.putUser(user,userId);
	}

	// CHCKE USER IS VALID OR NOT
	public boolean isUserIsThere(long id) {
		return userDataBase.isUserThere(id);
	}
	//DELETE USER AND RETURN USER
	public User deleteUser(long userId){
		return userDataBase.deleteUser(userId);
	}
}
