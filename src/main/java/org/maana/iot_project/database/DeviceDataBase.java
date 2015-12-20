package org.maana.iot_project.database;

import org.maana.iot_project.models.device.Device;

import com.maanadev.mongo.MongodbImplement;

public class DeviceDataBase implements DataBaseConstants {

	public static DeviceDataBase deviceDataBase = null;
	private MongodbImplement<Device> databaseMongodb = null;

	public DeviceDataBase() {
		databaseMongodb = new MongodbImplement<Device>(DEVICE_DATABASE, DEVICE_COLLECTION, Device.class);
	}

	public static DeviceDataBase getInstanceOfThisClass() {
		if (deviceDataBase == null) {
			deviceDataBase = new DeviceDataBase();
			return deviceDataBase;
		} else {
			return deviceDataBase;
		}
	}

	public Device getDevice(long deviceId) {

		return databaseMongodb.get(String.valueOf(deviceId));
	}

	public void addDevice(long deviceId, Device device) {
		databaseMongodb.save(device);
	}

	public long noOfDevices() {

		return databaseMongodb.getCount();
	}

}
