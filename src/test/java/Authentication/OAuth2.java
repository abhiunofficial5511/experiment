 package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;



public class OAuth2 {

	@Test
	public void O() {



         RestAssured
		.given()
		.auth().oauth2("cefd86ed46b238d4ebaa8dc401aab1c6d06d7cf7")
		.post("http://coop.apps.symfonycasts.com/api/3045/chickens-feed") 
		.then()
		.statusCode(200)         
		.log().all();

	


	}

}
