package org.maana.iot_project.models;

public class ServerConstants {

	// CONSTANTS FOR USER DEVICE CONTROL
	public final static String URL_FOR_DEVICES = "/{userId}/devices";
	public final static String URL_FOR_ADD_DEVICES = "/{userId}/adddevice";
	public final static String URL_FOR_GET_DEVICE_STATE = "/{deviceId}/getstate";
	// CONSTANTS FOR ADMIN DEVICE
	public final static String URL_FOR_ADD_DEVICE_EVENT = "/{deviceId}/addevent";
	public final static String URL_FOR_ADMIN_ADD_DEVICES = "/admin/adddevice";
	public final static String URL_FOR_ADMIN_ADD_DEVICE_STATE = "{deviceId}/addstate";
	// CONSTANTS FOR ADMIN SENSOR
	public final static String URL_FOR_ADD_SENSOR = "/admin/addsensor";
	public final static String URL_FOR_ADD_SENSOR_ACTION_DEVICE = "/{sensorId}/addsensoraction/device";
	// CONSTANTS FOR USER SENSOR
	public final static String URL_FOR_SENSOR = "/{userId}/sensors";
	public static final String URL_FOR_GET_SENSOR_CRITICAL_VALUE = "/{sensorId}/getsensorstate";
	// CONSTANTS FOR USER ACCOUNST
	public final static String URL_FOR_USERS = "/user";
	public final static String URL_FOR_USERS_GET_OR_DELETE = "/{userId}";
	// SENSOR ACTION EMAIL SENDING CONSTANT
	public final static String URL_FOR_ADD_SENSOR_ACTION_EMAIL = "/{sensorId}/addsensoraction/email";
	public final static String EMAIL_FROM_EMAIL_ADDRESS = "maanafuntest@gmail.com";
	public final static String EMAIL_USERNAME = "maanafuntest@gmail.com";
	public final static String EMAIL_PASSWORD = "1manaMgoda";
	public final static String EMAIL_SUBJECT = "IOT_SERVER";
	public final static String EMAIL_MESSAGE = "This is from IOT server ";
	public final static String EMAIL_MESSAGE_SENSOR_TYPE = "sensor type : ";
	public final static String EMAIL_MESSAGE_SENSOR_MODEL = "sensor model : ";
	public final static String EMAIL_MESSAGE_SENSOR_ID = "sensor ID : ";
	public final static String EMAIL_MESSAGE_SENSOR_VALUE = "sensor Value : ";
	// CONSTANTS FOR SENSOR EVENT HANDLING
	public final static int LAGER_THAN = 1;
	public final static int LESS_THAN = 2;
	public final static int LESS_OR_EQUAL = 3;
	public final static int LARGER_OR_EQUAL = 4;
	public final static int EQUAL = 5;
}
