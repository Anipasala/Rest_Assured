package Day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.specification.RequestSpecification;

public class updateUser {
	
	@Test
	void test_updateUser(ITestContext context) {
		
		
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		data.put("name", faker.name().fullName());
		
		
		String bearerToken="c35e10e748c6f113775527bcef204e9929b4c9f4b995a8ee253eec46aed57b06";
		int id= (Integer) context.getAttribute("user_id");
		
		 given()
				
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")	
			.body(data.toString())
			.pathParam("id", id)
		
		.when()
		
		.put("https://gorest.co.in/public/v2/users/{id}")
		.jsonPath().getInt("id");
		
		System.out.println("Generated id is: "+id);
		
		context.setAttribute("user_id", id);
	}

}
