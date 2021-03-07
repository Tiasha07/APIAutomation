package apitests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import helper.BaseClass;

public class DELETETest extends BaseClass{
	
	/**
	 * Deletion of record is verified using DELETE HTTP method
	 * and verified with the status code as 204 
	 * from the response
	 */
	
	@Test
	public void testDelete()
	{
		test = extent.createTest("testDelete");
		given().
			delete("/users/2").
		then().
			assertThat().
			statusCode(204);
	}
	

}
