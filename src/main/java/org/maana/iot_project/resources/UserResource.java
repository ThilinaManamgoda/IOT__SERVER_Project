package org.maana.iot_project.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.maana.iot_project.models.ServerConstants;
import org.maana.iot_project.models.User;
import org.maana.iot_project.services.UserService;

//URI FOR THIS CLASS IS "/user"
@Path(ServerConstants.URL_FOR_USERS)

// DECLARE THAT THIS CLASS TAKE JOSON
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UserResource {

	// GET USERSERVICE CLASS INSTANCE

	@Path(ServerConstants.URL_FOR_USERS_GET_OR_DELETE)
	@GET
	public Response getUserById(@PathParam("userId") long id) {
		UserService userService = new UserService();
		
			User temp_user = userService.getUSerById(id);
			return Response.ok().entity(temp_user).build();

	}

	// STORE USER
	@POST
	public Response storeUser(User user, @Context UriInfo uriInfo) {
		UserService userService = new UserService();
		long userId = userService.noOfUsers() + 1;
		user.setId(userId);
		userService.putUser(user, userId);
		String userId_String = String.valueOf(userId);
		// CREATE URI FOR CREATED USER
		URI uri = uriInfo.getAbsolutePathBuilder().path(userId_String).build();
		return Response.created(uri).entity(user).build();

	}

	// DELETE USER
	@Path(ServerConstants.URL_FOR_USERS_GET_OR_DELETE)
	@DELETE
	public Response deleteUser(@PathParam("userId") long userId) {
		UserService userService = new UserService();
		
			User temp_user = userService.deleteUser(userId);
			return Response.ok().entity(temp_user).build();

	}
}
