package org.maana.iot_project.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.maana.iot_project.models.ServerConstants;
import org.maana.iot_project.models.device.Device;
import org.maana.iot_project.models.device.DeviceState;
import org.maana.iot_project.models.device.EventDevice;
import org.maana.iot_project.services.AdminDeviceManagementService;

@Path(ServerConstants.URL_FOR_ADMIN_ADD_DEVICES)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminAddDeviceResource {

	
	@POST
	public Response addDevice(Device device){
		AdminDeviceManagementService addDeviceService = new AdminDeviceManagementService();
		Device return_device =addDeviceService.addDevice(device);
		return Response.ok().entity(return_device).build();
		
	}
	@Path(ServerConstants.URL_FOR_ADD_DEVICE_EVENT)
	@POST
	public Response addDeviceEvent(@PathParam("deviceId")long deviceId,EventDevice eventDevice){
		AdminDeviceManagementService addDeviceService = new AdminDeviceManagementService();
		EventDevice return_eventDevice=addDeviceService.addDeviceEvent(deviceId, eventDevice);
		return Response.ok().entity(return_eventDevice).build();
	}
	@Path(ServerConstants.URL_FOR_ADMIN_ADD_DEVICE_STATE)
	@POST
	public Response addState(@PathParam("deviceId")long deviceId,DeviceState deviceState){
		System.out.println(deviceState);
		AdminDeviceManagementService addDeviceService = new AdminDeviceManagementService();
		DeviceState return_deviceState = addDeviceService.addState(deviceId, deviceState);
		return Response.ok().entity(return_deviceState).build();
	}
}
