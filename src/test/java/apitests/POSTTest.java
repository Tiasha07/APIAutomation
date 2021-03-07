package apitests;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import helper.BaseClass;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class POSTTest extends BaseClass{

	/**
	 * Registration-Successful is verified using POST HTTP method
	 * and the status code is validated with 200 
	 * from the response
	 * Note: now the response is showing 400 instead of 200 
	 * (hence, this should fail)
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPOSTForRegistration()
	{
		test = extent.createTest("testPOSTForRegistration");
		JSONObject request = new JSONObject();
		request.put("email","eve1.holt@reqres.in");
		request.put("password","pistol");
	
		int code = given().
			header("content-type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/register").
		thenReturn().
			statusCode(); 
		Assert.assertEquals(HttpStatus.SC_OK, code);
	}
	
	/**
	 * Create is verified using POST HTTP method
	 * and the status code is validated with 201 
	 * from the response
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPOSTForCreate()
	{
		test = extent.createTest("testPOSTForCreate");
		JSONObject request = new JSONObject();
		request.put("name","Tiasha");
		request.put("job","Tester");
	
		given().
			header("content-type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201);
	}

}
