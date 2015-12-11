package org.maana.iot_project.models;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.maana.iot_project.models.device.Device;
import org.maana.iot_project.models.sensor.Sensor;

//THIS ANNOTAION MAKE SURE THIS OBJ CAN BE FORM INTO JSON TYPE
@XmlRootElement
public class User {

	private String name;
	private String email;
	private long id;
	private String phoneNumber;
	private Map<Long, Device> devices = new HashMap<Long, Device>();
	private Map<Long, Sensor> sensors = new HashMap<Long, Sensor>();

	public Sensor getSensor(long sensorId) {
		return sensors.get(sensorId);
	}

	public Map<Long, Device> getDevices() {
		return devices;
	}

	public void setDevices(Map<Long, Device> devices) {
		this.devices = devices;
	}

	public Sensor addSensor(Long arg0, Sensor arg1) {
		return sensors.put(arg0, arg1);
	}

	// EMPTY CONSTRUCTOR
	public User() {
	}

	public Device getDeviceById(long deviceId) {
		return devices.get(deviceId);
	}

	public void addDevice(Device device, Long deviceId) {
		devices.put(deviceId, device);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Map<Long, Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(Map<Long, Sensor> sensors) {
		this.sensors = sensors;
	}

}
