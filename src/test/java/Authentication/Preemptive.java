package Authentication;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class Preemptive {

	@Test
	public void Auth_01() {

		RestAssured
		.given()
		.auth().preemptive()
		.basic("eve.holt@reqres.in","cityslicka") 
		.when() 
		.get("https://reqres.in/api/login")
		.then()
		.statusCode(200)
		.log().all();


	}

}