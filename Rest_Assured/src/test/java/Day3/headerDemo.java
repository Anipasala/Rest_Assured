package Day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class headerDemo {
	
	
	@Test
	void getHeaders() {
		 Response res=		
					given()
					
					.when()
					
					.get("https://www.google.com/");
		 
		 String head=res.getHeader("Content-Type");
		 System.out.println(head);
		 
		Headers he= res.getHeaders();
		
		for (Header hd:he) {
			System.out.println(hd.getName()+"----" + hd.getValue());
		}
		
		
		
		
	}

}
