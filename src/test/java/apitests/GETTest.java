package apitests;

import org.testng.annotations.Test;

import helper.BaseClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GETTest extends BaseClass{

	/**
	 * List of users is verified using GET HTTP method
	 * and the status code is validated with 200 
	 * from the response
	 */
	@Test
	public void GetListOfUsers()
	{
		test = extent.createTest("GetListOfUsers");
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[0].first_name",equalTo("Michael"));
	}


	/**
	 * Single user is verified using GET HTTP method
	 * and the status code, first_name, text is verified 
	 * from the response
	 */
	@Test
	public void GetSingleUser()
	{
		test = extent.createTest("GetSingleUser");
		given().
		get("/users/2").
		then().
		statusCode(200).
		body("data.first_name",equalTo("Janet")).
		body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	}

}
