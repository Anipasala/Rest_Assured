package Day2;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DifferentMethodsOfCreatingUsers {
	
	///First using hashmap
	
	//@Test
	void usingHashMap() {

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
	
	//Using JSONObject entering the data
	
	@Test
	void usingJSonOBject() {

		JSONObject data = new JSONObject();
		
		data.put("name","morpheus");
		data.put("job","leader");

		given()
		.header("x-api-key", "reqres-free-v1")
	    .contentType("application/json")
		.body(data.toString())
				
				
		.when()
		.post("https://reqres.in/api/users")
				
		
		.then()
		.statusCode(201)
		.body("id", equalTo(558))
		.log().all();

	}
	//// entering data using pojo or from a class
	//@Test
	void usingPOJOClass() {

		PojoClass data= new PojoClass();
		
		data.setAge(10);
		data.setJob("Trainer");
		data.setName("Anirudh");

		given()
		.header("x-api-key", "reqres-free-v1")
	    .contentType("application/json")
		.body(data)
				
				
		.when()
		.post("https://reqres.in/api/users")
				
		
		.then()
		.statusCode(201)
		.log().all()
		.header("Content-Type",equalTo("application/json; charset=utf-8"));
		

	}
	
	//@Test
	void usingExternalFiles() throws FileNotFoundException {

		File f= new File(".\\externalFileToPractice.json");
		FileReader fr= new FileReader(f);
		JSONTokener jt= new JSONTokener(fr);
		
		JSONObject data= new JSONObject();
		
		

		given()
		.header("x-api-key", "reqres-free-v1")
	    .contentType("application/json")
		.body(data.toString())
				
				
		.when()
		.post("https://reqres.in/api/users")
				
		
		.then()
		.statusCode(201)
		.body("name", equalTo("morpheus"))
		.log().all();

	}
	

}
