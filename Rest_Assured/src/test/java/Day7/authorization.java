package Day7;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class authorization {
	
	@Test
	void testBasicAuthecation() {
		
		given()
		.auth().basic("postman", "password")
		
		.when()
		
		  .get("https://postman-echo.com/basic-auth")
		  
		 .then()
		 .statusCode(200);
		
		
	}
        @Test	
        void testdigestAuthecation() {
		
		given()
		.auth().digest("postman", "password")/// enter username, password
		
		.when()
		
		  .get("https://postman-echo.com/basic-auth")
		  
		 .then()
		 .statusCode(200);
		
	}
        @Test
        void testpreemptiveAuthecation() {
    		
    		given()
    		.auth().preemptive().basic("postman", "password")
    		
    		.when()
    		
    		  .get("https://postman-echo.com/basic-auth")
    		  
    		 .then()
    		 .statusCode(200);
    		
    		
    	}
        
        @Test
        void bearerTokenAuthecation() {
        	
        	String bearerToken="ghp_24pH@Icz1PKHC1q0tLwj57AuDYmtSz2fuYKP";
        	
        	given()
        	.header("Authorization" , "Bearer "+ bearerToken)
        	
        	.when()
        	
        	.get("https://api.github.com/user/repos")
        	
        	.then()
        	.statusCode(200)
        	.log().all();
        }
        
       // @Test
        void auth1Authecation() {
        
        	
        	given()
              
        	.auth().oauth("consumerke", "consumerSecrat", "accessToken", "tokenSecrate")

        	.when() 
        	.get("url")
     
        	.then()
              .statusCode(200)
        	  .log().all();
        }
        
        
        @Test
          void auth2Authecation() {
        
        	
        	given()
              
        	.auth().oauth2("ghp_24pH0Icz1PKHC1q0tLwj57AuDYmtSz2fuYKP")

        	.when() 
        	.get("https://api.github.com/user/repos")
     
        	.then()
              .statusCode(200)
        	  .log().all();
        }
        
        @Test
        void testAPIKeyAutecaton() {
      
      	
      	given()
            
      	.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c") //appid is APIKey

      	.when() 
      	  .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units metric&cnt=7")
   
      	.then()
            .statusCode(200)
      	  .log().all();
      }
        
        

}
