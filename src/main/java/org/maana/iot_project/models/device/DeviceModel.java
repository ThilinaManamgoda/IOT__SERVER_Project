package org.maana.iot_project.models.device;


import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class DeviceModel {

	private int id;
	private String modelName;
	private HashMap<Long, EventDevice> event_List=null;
	
	public DeviceModel() { }
	public void addEvent(long index,EventDevice e) {
		 event_List.put(index, e);
	}
	public EventDevice getEvent(long index) {
		return event_List.get(index);
	}
	public DeviceModel(int id, String modelName) {
		this.id = id;
		this.modelName = modelName;
		event_List = new HashMap<Long, EventDevice>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public HashMap<Long, EventDevice> getEvent_List() {
		return event_List;
	}
	public void setEvent_List(HashMap<Long, EventDevice> event_List) {
		this.event_List = event_List;
	}
	
	
}
