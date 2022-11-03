package Bravvox.PATCH;

import org.testng.annotations.Test;

import Bravvox.PATCH.EditEventPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class EditEvent {


	@Test 
	public void Updateevent() {
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


		//	Verify event owner able to  Update Event


		EditEventPojo update = new EditEventPojo ();

		update.setSubtitle("national game");
		update.setSubtitle("Open states");
		update.setEventStartTime("2022-09-17T10:10:27.759Z");
		update.setEventEndTime("2022-12-28T13:02:35.922Z");
		update.setLocation("India");
		update.setRequireAttendeeApproval(true);	
		update.setIsModerated(false);
		update.setIsPostingOpen(true);
		update.setIsPublic(true);

		request.header("Authorization",token)
		.header("Accept","application/json","Content-Type","multipart/from-data");



		Response Updated =  request.body(update).patch("/services/event/v1/event/c9aj6ipcg4h0nn8g6vm0");	
		Assert.assertEquals(200,Updated.getStatusCode());	
		Updated.prettyPrint();	






	}
}



