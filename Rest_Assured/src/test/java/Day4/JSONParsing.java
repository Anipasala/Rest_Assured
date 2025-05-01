package Day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.restassured.response.Response;


public class JSONParsing {
	
	@Test
	void valdatingUsingJson() {
		
		Response res=
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2");
		
		JSONObject jo = new JSONObject(res.asString());
		Boolean status=false;
		for (int i=0;i<jo.getJSONArray("data").length();i++) {
		String idvalues=jo.getJSONArray("data").getJSONObject(i).get("id").toString();
		
		if (idvalues.equals("7")) {
			
			status=true;
			
		}
		
		System.out.println(idvalues);
		
		}
		
		Assert.assertEquals(status, true);
		
       String email=res.jsonPath().get("data[2].email").toString();
       
       Assert.assertEquals(email, "tobias.funke@reqres.in");
       
       
		
	}
	@Test
	void valdatingUsingthen() {
		
	
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		
		.body("data[2].email", equalTo("tobias.funke@reqres.in"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
       
       
		
	}


}
