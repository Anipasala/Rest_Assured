package Day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	@Test
	void JSONSchemaVAlidation() {
		
		given()
		
		.when()
		
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("testdat.json"));
		
		
	}
	@Test
	void XMLSchemaVAlidation() {
		
		given()
		
		.when()
		
		.get("http://localhost:8080/people.xml")
		
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmldata.xsd"));
		
		
	}

}
