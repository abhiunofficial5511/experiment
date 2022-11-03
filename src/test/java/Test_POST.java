import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_POST {

	@Test
	public void Methododpost() {

		JSONObject request = new JSONObject();

		request.put("last name","Jagan");
		request.put("first name","Preet");
 
		System.out.println(request);


		given(). 	
		body(request.toJSONString()).

		when().
		post("https://reqres.in/api/users").

		then().
		statusCode(201);

	}



	//	@Test
	public void Methododput() {

		JSONObject request = new JSONObject();

		request.put("last name","Preet");
		request.put("first name","Jagan");

		System.out.println(request);
		System.out.println(request.toJSONString());

		given(). 	
		body(request.toJSONString()).

		when().
		put("https://reqres.in/api/users").

		then().
		statusCode(200).
		log().all();
	}


	public void MethodPatch() {


	}


	//		@Test

	public void MethodDelete() {

		when().   
		delete("https://reqres.in/api/users").

		then().
		statusCode(204).
		log().all();
	}












}
