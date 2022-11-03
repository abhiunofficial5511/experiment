package Bravvox.DELETE;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RenoveAdmin {
	
	 
	@Test
	public void Removeadmin() {
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


		// Remove admin from event


	RestAssured.given()
	.header("Content-Type","application/json").header("Authorization",token)
	.when()
	.delete("/services/event/v1/event/c9aj6ipcg4h0nn8g6vm0/admin/c9b7l3v4a989ns91ic8g")
	.then()
	.log().all();

	}
	
}
