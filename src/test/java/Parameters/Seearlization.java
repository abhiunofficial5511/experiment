package Parameters;

import java.util.HashMap;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.node.ObjectNode;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Seearlization {
	
	public static final ResponseSpecification responseSpecification = null;

	public class SerializeMap_To_JSON_Object {
	    @BeforeClass
	    public void before_class() {
	        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	        requestSpecBuilder.setBaseUri("https://api.getpostman.com");
	        requestSpecBuilder.log(LogDetail.ALL);
	        //requestSpecBuilder.addHeader("give the path of header");
	        RestAssured.requestSpecification = requestSpecBuilder.build();
	    }

	    @Test
	    public void validate_post_request_payload_as_map() throws JsonProcessingException {
	        HashMap<String, Object> mainobject = new HashMap<String, Object>();
	        HashMap<String, String> nestedobject = new HashMap<String, String>();
	        nestedobject.put("name", "myfourthworkspace");
	        nestedobject.put("type", "koibhi");
	        nestedobject.put("description", "hello");
	        mainobject.put("workspace", nestedobject);
	        // we are using object mapper class
	        ObjectMapper objectMapper = new ObjectMapper() {
				
				public Object serialize(ObjectMapperSerializationContext context) {
					// TODO Auto-generated method stub
					return null;
				}
				
				public Object deserialize(ObjectMapperDeserializationContext context) {
					// TODO Auto-generated method stub
					return null;
				}
			};  // writevalueasstring method will convert the java object into json object and json object as a string
	        String mainobjectstr = ((Object) objectMapper).writeValueAsString(mainobject);
	        Object responseSpecification;
			given().body(mainobjectstr).when().post("/workspaces").then().spec(responseSpecification).assertThat().body("workspace.name", equals("myfourthworkspace"));
	    }

	    @Test
	    public void validate_post_request_payload_as_objectnode() throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        ObjectNode nestedobjectNode = objectMapper.createObjectNode();
	        nestedobjectNode.put("name", "myfourthworkspace1");
	        nestedobjectNode.put("type", "koibhi");
	        nestedobjectNode.put("description", "hello");
	        ObjectNode mainobjectnode = objectMapper.createObjectNode();
	        ((Object) mainobjectnode).set("workspace", nestedobjectNode);
	        // we are using object mapper class
	        // writevalueasstring method will convert the java object into json object and json object as a string
	        String mainobjectstr = objectMapper.writeValueAsString(mainobjectnode);
	        given().body(mainobjectstr).when().post("/workspaces").then().spec(responseSpecification).assertThat().body("workspace.name", equals("myfourthworkspace"));
	    }
	}

	public RequestSpecification given() {
		// TODO Auto-generated method stub
		return null;
	}

}
