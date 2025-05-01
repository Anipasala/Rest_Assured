package Day5;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class XMLParsing {
	
	
	  //@Test
	    void approach1() {
	        given()
	         
	        .when()
	            .get("http://localhost:8080/people.xml")
	        .then()
	            .statusCode(200) // Verify successful response
	            .body("people.person[0].name", equalTo("Alice Johnson"))
	            .header("Content-type", "text/xml")
	            .log().all(); // Log the entire response for inspection
	    }
	  
	 // @Test
	  void approach2() {
		  
		  Response res=
		  given()
	         
	        .when()
	            .get("http://localhost:8080/people.xml");
		  
		String name=  res.xmlPath().get("people.person[0].name").toString();
		Assert.assertEquals(name, "Alice Johnson");
		
		String head=res.getHeader("Content-Length").toString();
		Assert.assertEquals(head, "841");
		
	    int status=res.getStatusCode();
	    Assert.assertEquals(status, 200);
		  
	  }
	  @Test
       void UsingXMLObject() {
		  
		  Response res=
		  given()
	         
	        .when()
	            .get("http://localhost:8080/people.xml");
		  
		  XmlPath xmlp=new XmlPath(res.asString());
		  
		  List<String> total_names=xmlp.getList("people.person.name");
		  
		  for (String name:total_names) {
			  System.out.println(name);
		  }
		  
       }

}
