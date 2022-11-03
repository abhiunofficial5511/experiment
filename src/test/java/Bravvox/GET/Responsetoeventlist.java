package Bravvox.GET;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Responsetoeventlist {

	@Test
	public void Userresponse() {

		String[] items = null;
		String token;

		// User Token Generate
		RestAssured.baseURI = "https://qa.bravvox.com";

		RequestSpecification request = RestAssured.given();

		String payload = "{\r\n"
				+ "    \"username\": \"Mike\",\r\n"
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






		// verify user able to  Respond as Not attending 



		RestAssured.given().
		header("Authorization",token)
		.header("Accept","application/json","Content-Type","multipart/from-data")
		.when()
		.get("/services/event/v1/event/c97vkc8r67nih8v3ul1g/attendees?limit=10&offset=0&status=all&response=not_attending")
		.then()
		.log().all();


	}


}
