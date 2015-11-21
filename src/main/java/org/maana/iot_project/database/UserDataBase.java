package org.maana.iot_project.database;

import java.util.HashMap;
import java.util.Map;

import org.maana.iot_project.models.User;

public class UserDataBase {

	
	private static Map<Long, User> DataBase = new HashMap<Long, User>();
	private static UserDataBase userDataBase = null;
	
	public UserDataBase() {	}

	public static UserDataBase getInstanceOfThisClass(){
		if(userDataBase == null){
			userDataBase = new UserDataBase();
			return userDataBase;
		} else{
			return userDataBase;
		}
	}
	//STORE USER
	public void  putUser(User user,long id){
		
		DataBase.put(id, user);
		
	}
	//GET USER
	public User getUserById(long id){
		return DataBase.get(id);
	}
	
	//CHECK WHETHER USER IS VALID OR NOT
	public  boolean isUserThere(long id){
		
		return DataBase.containsKey(id);
	}
	//RETURN NO OF USERS
	public  int noOfUsers(){
		return DataBase.size();
	}
	//REMOVE USER AND RETURN USER
	public  User deleteUser(long userId){
		return DataBase.remove(userId);
	}
}
