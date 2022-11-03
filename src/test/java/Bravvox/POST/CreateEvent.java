package Bravvox.POST;

import org.junit.Assert;
import org.testng.annotations.Test;

import Bravvox.POST.CreateEventPojo; 
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEvent {



	@Test 
	public void CreateEvent() {
//		String[] items = null;
//		String token;
//
//		// User Token Generate
	RestAssured.baseURI = "https://qa.bravvox.com";
//
//		RequestSpecification request = RestAssured.given();
//
//		String payload = "{\r\n"
//				+ "    \"username\": \"Nura\",\r\n"
//				+ "    \"password\": \"Test123@\"\r\n"
//				+ "}\r\n"
//				+ "}";
//
//		request.header("Content-Type","application/json");
//		Response responseFormToken =   request.body(payload).post("/services/auth/v1/login");
//
//		String jsont = responseFormToken.asString();
//		responseFormToken.prettyPrint();
//		String[] couple = jsont.split("\",\"refreshToken\"");
//		String[] nexts = couple[0].split("token\":\"");
//		token = nexts[1];


		// Verify userable to Create Event



		CreateEventPojo p = new CreateEventPojo ();
		p.setTitle("Country  game");
		p.setSubtitle("Open for all the states");
		p.setDetails("public");
		p.setEventStartTime("2022-09-17T10:10:27.759Z");
		p.setEventEndTime("2022-12-28T13:02:35.922Z");
		p.setLocation("USA");
		p.setRequireAttendeeApproval(true);	
		p.setIsModerated(false);
		p.setIsPostingOpen(true);
		p.setIsPublic(true);

	
		RestAssured.given()
		
		.header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkb2N1bWVudElEIjoiYzhlN3JnZmtzcWE4NDB1MTc2czAiLCJ1c2VybmFtZSI6Ik51cmEiLCJyb2xlIjoiIiwibmFtZSI6Ik51cmEgYnJvb2tseW4gYWxiZXJ0YSBjYW5hZGEiLCJlbWFpbCI6ImRhdGF0ZXN0NjE2KzAzOEBnbWFpbC5jb20iLCJwaG9uZSI6IiIsImlzQWRtaW4iOmZhbHNlLCJpc0NvbnRlbnRDcmVhdG9yIjpmYWxzZSwiaXNWZXJpZmllZCI6dHJ1ZSwic3RhdHVzIjoiYWN0aXZlIiwiaW5mbHVlbmNlclN0YXR1cyI6ZmFsc2UsImV4cCI6MTY1MDA0MzM5MiwiaWF0IjoxNjUwMDI1MzkyLCJpc3MiOiJCcmF2dm94In0.58i35HGpUUItoSPvVk1ykbcEB8nMOz7i35MJN9uuNbw")
		.header("Accept","application/json","Content-Type","multipart/from-data");

		RequestSpecification request = null;
		Response createNewEventres =  request.body(p).get("/services/event/v1/event");
		Assert.assertEquals(401,createNewEventres.getStatusCode());
		createNewEventres.prettyPrint();

	}

}



