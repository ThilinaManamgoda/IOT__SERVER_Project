package org.maana.iot_project.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.maana.iot_project.models.ServerConstants;

@Path(ServerConstants.URL_FOR_ADMIN_ADD_DEVICES)
public class AdminaAddDevice {

	
	@POST
	public Response addDevice(){
		
		
		return Response.ok().build();
	}
}
