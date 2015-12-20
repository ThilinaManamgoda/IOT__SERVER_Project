package org.maana.iot_project.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.maana.iot_project.models.ServerConstants;
import org.maana.iot_project.models.sensor.Sensor;
import org.maana.iot_project.services.AdminSensorManagementService;

@Path(ServerConstants.URL_FOR_ADMIN_ADD_SENSOR)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminaddSensorResource {

	@POST
	public Response addSensor(Sensor sensor) {

		AdminSensorManagementService adminSensorManagementService = new AdminSensorManagementService();
		Sensor return_sensor = adminSensorManagementService.addSensor(sensor);
		return Response.ok().entity(return_sensor).build();
	}

}
