package Parameters;

import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class Response {

	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://reqres.in");
		requestSpecBuilder.log(LogDetail.ALL);

		RestAssured.requestSpecification = requestSpecBuilder.build();
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL);
		RestAssured.responseSpecification = responseSpecBuilder.build();
	}
	@Test
	public void test(ResponseSpecification responseSpecification) {
		Response response = (Response) RestAssured.get("/api/users?page=2").then().spec(responseSpecification).log().all().contentType(ContentType.JSON).extract().response();
		
	}

 


}
