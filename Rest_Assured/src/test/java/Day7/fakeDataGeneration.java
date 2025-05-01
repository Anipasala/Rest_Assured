package Day7;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class fakeDataGeneration {
	
	@Test
	void  testGenerationOfFakeData() {
		
		Faker faker= new Faker();
		
		String firstname= faker.name().firstName();
		
		String lastname=faker.name().lastName();
		
		String email=faker.internet().emailAddress();
		
		String phoneNumber= faker.phoneNumber().cellPhone();
		String fullname= faker.name().fullName();
		
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(email);
		System.out.println(phoneNumber);
		System.out.println(fullname);
		
	}

}
