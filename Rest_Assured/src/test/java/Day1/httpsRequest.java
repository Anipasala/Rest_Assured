package Day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class httpsRequest {
	int id;

	@Test(priority=1)
	void getUser() {

		given()

		.when()

		.get("https://reqres.in/api/users?page=2")

		.then()

		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();

	}

	//@Test
	void createUser() {

		HashMap<String,String> data= new HashMap<>();

		data.put("name","morpheus");
		data.put("job","leader");


		given()
		
		.header("x-api-key", "reqres-free-v1")
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		
		.then()
		.statusCode(201)
		.log().all();
	}

	@Test(priority=2)
	void takingIdFromCreateUsers() {

		HashMap<String,String> data= new HashMap<>();

		data.put("name","morpheus");
		data.put("job","leader");


		id=given()
				.header("x-api-key", "reqres-free-v1")
				.contentType("application/json")
				.body(data)
				
				
				.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");

	}
	
	@Test(priority=3)
	void updateUser() {
		
		HashMap<String,String> data= new HashMap<>();

		data.put("name","morpheus");
		data.put("job","software engineer");
		
		given()
		
		.header("x-api-key", "reqres-free-v1")
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users" +id)
		
		.then()
		
		.statusCode(201)
		.log().all();
		
	}
	@Test(priority=4)
	void deleteUser() {
		
		
		given()
		.header("x-api-key", "reqres-free-v1")
		
		.when()
		
		 .delete("https://reqres.in/api/users\" +id")
		
		.then()
		.statusCode(204);
	}



}
