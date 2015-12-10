package org.maana.iot_project.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.maana.iot_project.messages.AddSensorActionEmailRequestMessage;
import org.maana.iot_project.models.ServerConstants;
import org.maana.iot_project.services.SensorManagementService;

@Path(ServerConstants.URL_FOR_SENSOR)
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public class SensorControlResource {

	
	@Path(ServerConstants.URL_FOR_ADD_SENSOR_ACTION_EMAIL)
	@POST
	public Response addEmailaction(@PathParam("userId")long userId,@PathParam("sensorId")long sensorId,AddSensorActionEmailRequestMessage actionEmailRequestMessage){
		SensorManagementService sensorManagementService = new SensorManagementService();
		sensorManagementService.addSensorActionEmail(userId, sensorId, actionEmailRequestMessage);
		return Response.ok().build();
		
	}
}
