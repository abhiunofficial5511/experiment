import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test
public class Test02 {


	public void test_02 () {

		given().
		get("https://reqres.in/api/users?page=2").
		then().
 	    statusCode(200).
		body("data.id[1]", equalTo(8));
		
		
	

	}


}   
