package testNGSessions;

import org.testng.annotations.Test;

public class CRUDOperationTest {
	public void createUser() {
		System.out.println("create user");
	}

	public void getUser(int userId) {
		System.out.println("get user: " + userId);
	}

	public void updateUser(int userId) {

	}

	public void deleteUser(int userId) {

	}
	
	
	@Test
	public void createUserTest() {
		createUser();//post -- 976
	}
	
	@Test
	public void getUserTest() {
		createUser();//post -- 123
		getUser(123);//get
	}
	
	@Test
	public void updateUserTest() {
		createUser();//post -- 435
		getUser(435);//get
		updateUser(435);//put
		getUser(435);//get
	}
	
	@Test
	public void deleteUserTest() {
		createUser();//post --- 673
		getUser(673);//get
		deleteUser(673);//delete
		getUser(673);//get
	}
	
	
	@Test
	public void getUserTesting() {
		int userId = 123;//hard coded user id
		//QA --> stage --> dev --> UAT -- PROD
		getUser(userId);
		//assert
		
	}
}
