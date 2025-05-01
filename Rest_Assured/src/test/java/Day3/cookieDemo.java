package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class cookieDemo {
	@Test
	void getcookies() {
		
      Response res=		
		given()
		
		.when()
		
		.get("https://www.google.com/");
      
      String cookie=res.getCookie("AEC");
      System.out.println(cookie);
      
      Map<String,String>all=res.getCookies();
      
      for(Map.Entry<String,String> single:all.entrySet()){
    	  
    	  System.out.println(single.getKey()+"------"+single.getValue());
    	  
      }
      
	}

}
