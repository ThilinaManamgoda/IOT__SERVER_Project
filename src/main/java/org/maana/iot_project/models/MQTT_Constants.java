package org.maana.iot_project.models;

public interface MQTT_Constants {
	public final static String userName = "admin";
	public final static String password = "admin";
	public final static String saveFilesForListen = "saveFilesForListen";
	public final static String saveFilesForSend = "saveFilesForSend";
	public static final String BROKER_URL = "tcp://localhost:1883";
	public final static String saveFilesForState = "saveFilesForState";
	public static final String MQTT_TOPIC_STATE = "devicestate/";
	public static final String MQTT_TOPIC_DEVICE = "device/";
	public final static String TOPIC_SENSOR = "sensors/#";
	public final static String MQTT_SENSOR_CONNCETION_ID = "SENSOR_CONNECTION";
	// The temp directory to use for mqtt client
	public static final String TMP_DIR = System.getProperty("java.io.tmpdir");
}
