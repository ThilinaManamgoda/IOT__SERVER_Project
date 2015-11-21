package org.maana.iot_project.models.device;

public class EventDevice {

	private long eventId;
	private String eventName;
	private String eventCommand;
	
	public EventDevice() {
	
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventCommand() {
		return eventCommand;
	}

	public void setEventCommand(String eventCommand) {
		this.eventCommand = eventCommand;
	}
	
	
	
}
