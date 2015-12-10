 package org.maana.iot_project.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.maana.iot_project.messages.DeviceControRequestlMessage;
import org.maana.iot_project.models.ServerConstants;
import org.maana.iot_project.services.DeviceEventHandlerService;


@Path (ServerConstants.URL_FOR_DEVICES)
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public class DeviceControlerResource {

	private DeviceEventHandlerService deviceEventHandlerService = DeviceEventHandlerService.getInstanceOfThisCalss();
	
	
	@POST
	public Response controlDevice(@PathParam ("userId") long userId,DeviceControRequestlMessage deviceControRequestlMessage){
		System.out.println("in DeviceControlerResource");
		deviceEventHandlerService.handleDeviceEvent(userId, deviceControRequestlMessage);
		return Response.ok().build();
		
	}
}
