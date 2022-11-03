import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;


public class MethodPatch {

	@Test (priority = 1)
	public void A() {

		RestAssured.
		when().
		get("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().body();  



	}

 	@Test (priority = 2)
	public void B() { 

		JSONObject req = new JSONObject ();

		req.put("first_name" ,"Jagan");
		req.put("last_name","preet");
		req.put("email","jagan@yopmail.com");

		baseURI = "https://reqres.in";
		RestAssured.
		given().
		header("Content-Type","application/json").
		when().
		put("/api/users/2").
		then().
		statusCode(200).
		log().body();

		System.out.println(req.toJSONString());

	} 


	@Test (priority = 3)
	public void C() {

		
		RestAssured.
		given().
		header("Content-Type","application/json").
		when().
		get("https://reqres.in/api/users/2 ").
		then().
		statusCode(200).
		log().all();





	}


@Test (priority = 4)
	public void Delete() {

		baseURI = "https://reqres.in";
		RestAssured.
		when().
		delete("/api/users/2").
		then().
		statusCode(204).
		log().all();



	}

}



