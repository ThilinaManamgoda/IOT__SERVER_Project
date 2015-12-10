package org.maana.iot_project.optional_apis;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public  class SensorAction {
	public int sensorThresholdValue;
	public int condition;
	public  void execute(int sensorValue,String arg,long userId){};
	public  int getCondition(){return condition;};
	public SensorAction() {
	}
	public  int getSensorthresholdValue(){return sensorThresholdValue;};
	public  void setSensorthresholdValue(int sensorThresholdValue){};
}
