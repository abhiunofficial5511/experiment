package Parameters;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class Specification {

		@Test
	public void res() {

		RequestSpecification   requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://reqres.in");
		requestSpecification.basePath("/api/unknown")



		.get()
		.then()
		.log().all();






	}


	@Test
	public void New() {

		RequestSpecification   requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://reqres.in");
		



		JSONObject request = new JSONObject();

		request.put("name","Jagan");
		request.put("job","QA");

		System.out.println(request);

		given().
		body(request.toJSONString()).
		put("/users/2").
		then().
		log().all();

	}


}
