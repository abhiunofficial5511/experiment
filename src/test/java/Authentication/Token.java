package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Token { 

	@Test
	public void token() {
 
 
		RestAssured.
		given()
		.formParam("client_id","Media")
		.formParam("client_secret","4fabbc82c25bdf95ff35f11403b9edbc")
		.formParam("grant_type","client_credentials")
		.when()
		.post("http://coop.apps.symfonycasts.com/token")
		.then()
		.statusCode(200)
		.log().all();




}

}
