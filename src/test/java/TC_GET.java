import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;



public class TC_GET {


	@Test
	void test_01 () {


		Response response =  RestAssured.get("https://reqres.in/api/users?page=2");


		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("Content-type"));
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());

	}






	//@Test 

	void test_02() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
	}






	private RestAssured given() {
		// TODO Auto-generated method stub
		return null;
	}	  
}