package org.maana.iot_project.database;

import org.maana.iot_project.models.User;

import com.maanadev.mongo.MongodbImplement;

public class UserDataBase implements DataBaseConstants {

	private MongodbImplement<User> DataBase = null;
	private static UserDataBase userDataBase = null;

	public UserDataBase() {

		DataBase = new MongodbImplement<User>(USER_DATABASE, USER_COLLECTION, User.class);
	}

	public static UserDataBase getInstanceOfThisClass() {
		if (userDataBase == null) {
			userDataBase = new UserDataBase();
			return userDataBase;
		} else {
			return userDataBase;
		}
	}

	// STORE USER
	public void putUser(User user, long id) {


		DataBase.save(user);

	}

	// GET USER
	public User getUserById(long id) {

		 return DataBase.get(String.valueOf(id));
	}

	// RETURN NO OF USERS
	public long noOfUsers() {

		return DataBase.getCount();
	}

	// REMOVE USER AND RETURN USER
	public User deleteUser(long userId) {
		User user = DataBase.get(String.valueOf(userId));
		DataBase.delete(String.valueOf(userId));
		return user;
	}
}
