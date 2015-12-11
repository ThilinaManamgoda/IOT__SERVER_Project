package org.maana.iot_project.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.maana.iot_project.messages.DeviceControRequestlMessage;
import org.maana.iot_project.models.ServerConstants;
import org.maana.iot_project.models.device.DeviceState;
import org.maana.iot_project.services.DeviceEventHandlerService;
import org.maana.iot_project.services.DeviceManagementService;

@Path(ServerConstants.URL_FOR_DEVICES)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeviceControlerResource {


	@POST
	public Response controlDevice(@PathParam("userId") long userId,
			DeviceControRequestlMessage deviceControRequestlMessage) {
		System.out.println("in DeviceControlerResource");
		DeviceEventHandlerService deviceEventHandlerService = new DeviceEventHandlerService();
		deviceEventHandlerService.handleDeviceEvent(userId, deviceControRequestlMessage);
		return Response.ok().build();

	}
	@Path(ServerConstants.URL_FOR_GET_DEVICE_STATE)
	@GET
	public Response getDeviceState(@PathParam("userId") long userId,@PathParam("deviceId") long deviceId){
		DeviceManagementService deviceManagementService = new DeviceManagementService();
		DeviceState deviceState = deviceManagementService.getDeviceState(userId, deviceId);
		return Response.ok().entity(deviceState).build();
	}
}
