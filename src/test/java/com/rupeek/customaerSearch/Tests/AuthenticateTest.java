package com.rupeek.customaerSearch.Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import com.rupeek.genericfiles.IAutho;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
/**
 * 
 * @author Khushbu Ameta
 *
 */

public class AuthenticateTest implements IAutho {

	@Test
	public void getTokenWithvalidinput()
	{
				
	given().contentType(ContentType.JSON).body("{ \"username\" : \"rupeek\", \"password\" : \"password\"}").post(BASE_URL_Authenticate).then().assertThat().statusCode(200)
			.and().contentType(ContentType.JSON).and().time(lessThan(9000L));
			
			Response response = given().contentType(ContentType.JSON).body("{ \"username\" : \"rupeek\", \"password\" : \"password\"}").post(BASE_URL_Authenticate);
			System.out.println(response.getBody().asString());
		}
	
	/**
	 * User_name related negative Scenarios
	 */
		
		@Test
		public void gettokenWithInvalidBlankusername() 
		{
			given().contentType(ContentType.JSON).body("{ \"username\" : \"\", \"password\" : \"password\"}").post(BASE_URL_Authenticate).then().assertThat().statusCode(401)
			.and().contentType("").and().time(lessThan(9000L));
			
		
		}
		@Test
		public void gettokenWithInvalidWrongusername() 
		{
			given().contentType(ContentType.JSON).body("{ \"username\" : \"google\", \"password\" : \"password\"}").post(BASE_URL_Authenticate).then().assertThat().statusCode(401)
			.and().contentType("").and().time(lessThan(9000L));
		}
		
		@Test
		public void gettokenWithInvalidRemoveusernameField() 
		{
			given().contentType(ContentType.JSON).body("{\"password\" : \"password\"}").post(BASE_URL_Authenticate).then().assertThat().statusCode(401)
			.and().contentType("").and().time(lessThan(9000L));
		}


		/**
		 * Password related negative Scenario
		 */
		@Test
		public void gettokenWithInvalidBlankpassword()
		{
			given().contentType(ContentType.JSON).body("{ \"username\" : \"\", \"password\" : \"\"}").post(BASE_URL_Authenticate).then().assertThat().statusCode(401)
			.and().contentType("").and().time(lessThan(9000L));
			
		
		}
		@Test
		public void gettokenWithInvalidWrongpassword()
		{
			given().contentType(ContentType.JSON).body("{ \"username\" : \"rupeek\", \"password\" : \"wrong\"}").post(BASE_URL_Authenticate).then().assertThat().statusCode(401)
			.and().contentType("").and().time(lessThan(9000L));
		}
		
		@Test
		public void gettokenWithInvalidRemovepasswordField()
		{
			given().contentType(ContentType.JSON).body("{\"username\" : \"rupeek\"}").post(BASE_URL_Authenticate).then().assertThat().statusCode(401)
			.and().contentType("").and().time(lessThan(9000L));
		}
}
