package apitests;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import helper.BaseClass;
import io.restassured.http.ContentType;

public class PUTTest extends BaseClass{
	
	/**
	 * Update is verified using PUT HTTP method
	 * and the status code is validated with 200 
	 * from the response
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPutForUpdate()
	{
		test = extent.createTest("testPutForUpdate");
		JSONObject request = new JSONObject();
		request.put("name","Tiasha");
		request.put("job","Tester");
			
		given().
			header("content-type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			assertThat().
			statusCode(HttpStatus.SC_OK);
	}

}
