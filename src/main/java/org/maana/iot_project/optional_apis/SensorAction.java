package org.maana.iot_project.optional_apis;

public abstract class SensorAction {
	public int sensorThresholdValue;
	public abstract void execute(int sensorValue,String arg,long userId);
	public abstract int getCondition();
	public SensorAction() {
	}
	public abstract int getSensorthresholdValue();
	
}
