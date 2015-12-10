package org.maana.iot_project.services;

import org.maana.iot_project.database.UserDataBase;
import org.maana.iot_project.models.User;


public class UserService {
	
	

	private UserDataBase userDataBase = UserDataBase.getInstanceOfThisClass();
	private SensorControlService sensorControlService = SensorControlService.getInstanceOfThisClass();
	public UserService() {
		
	}
	
	// GET USER BY ID
	public User getUSerById(long id) {
		return userDataBase.getUserById(id);
	}

	// PUT USER IN DATABASE
	public void putUser(User user,long userId) {
		
	
		userDataBase.putUser(user,userId);
	}

	// CHCKE USER IS VALID OR NOT
	public boolean isUserIsThere(long id) {
		return userDataBase.isUserThere(id);
	}
	//DELETE USER AND RETURN USER
	public User deleteUser(long userId){
		return userDataBase.deleteUser(userId);
	}
	public int noOfUsers() {
		return userDataBase.noOfUsers();
	}
}
