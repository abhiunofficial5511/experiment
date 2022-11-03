package Parameters;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Path {

		@Test(priority =1)
	public void A() {


		RestAssured
		.given()
		.accept(ContentType.JSON)
		.pathParam("id",12)
		.when()
		.get("https://reqres.in/api/users/{id}")
		.then()

		.log().body().statusCode(200);
   

	}

	   @Test (priority =2)
	public void B () {

		JSONObject req = new JSONObject ();
		req.put("id" ,12);
		req.put("email", "jagan@.howell@reqres.in");
		req.put("first_name", "preet");
		req.put("last_name", "jagan");
		req.put("avatar", "https://reqres.in/img/faces/12-image.jpg");

		RestAssured
		.given()
		.accept(ContentType.JSON)
		.pathParam("id",12)
		.when()
		.put("https://reqres.in/api/users/{id}")
		.then()

		.log().all().statusCode(200);




	}

	  @Test (priority =3)
	public void C() {


		RestAssured
		.given()
		.accept(ContentType.JSON)
		.pathParam("id",12)
		.when()
		.get("https://reqres.in/api/users/{id}")
		.then()

		.log().body().statusCode(200);


	}


	//@Test (priority =4)
	public void D() {


		RestAssured
		.given()
		.accept(ContentType.JSON)
		.queryParam("page",2)
		.when()
		.get("https://reqres.in/api/users")
		.then()

		.log().all().statusCode(200);




	}

	//@Test
	public void E(String baseURI) {

		RestAssured. baseURI = "https://reqres.in ";

		RestAssured.given()
		.auth().preemptive()
		.basic("eve.holt@reqres.in","pistol")
		.when()
		.post("/api/register")
		.then()

		.log().body().statusCode(200);


	}
}
