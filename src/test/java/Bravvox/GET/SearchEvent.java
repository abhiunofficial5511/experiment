package Bravvox.GET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SearchEvent {

	@Test
	public void SearchEvent() {
		String[] items = null;
		String token;
 
		// User Token Generate
		RestAssured.baseURI = "https://qa.bravvox.com";

		RequestSpecification request = RestAssured.given();

		String payload = "{\r\n"
				+ "    \"username\": \"Andy\",\r\n" 
				+ "    \"password\": \"Test123@\"\r\n"
				+ "}\r\n"
				+ "}";

		request.header("Content-Type","application/json");
		Response responseFormToken =   request.body(payload).post("/services/auth/v1/login");

		String jsont = responseFormToken.asString();
		responseFormToken.prettyPrint();
		String[] couple = jsont.split("\",\"refreshToken\"");
		String[] nexts = couple[0].split("token\":\"");
		token = nexts[1];


		// Search Event on bravvox platform


		RestAssured.given()
		.header("Content-Type","application/json").header("Authorization",token)
		.when()
		.get("/services/search/v1/active-search?keyword=cricket&limit=50&offset=0&type=event")
		.then()
		.log().all();



	}
}
