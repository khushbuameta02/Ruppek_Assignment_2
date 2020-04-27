package com.rupeek.customaerSearch.Tests;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.rupeek.genericfiles.IAutho;

import io.restassured.http.ContentType;
/**
 * 
 * @author Khushbu Ameta
 *
 */
public class GetUsersRecordTest implements IAutho {
	/**
	 * validation of User record with actual data in list
	 */
	@Test
	public void getUserRecordWithValidInput()
	{
   given().header("Authorization", TOKEN).get(USER_ENDPOINT).then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
   .body("first_name", Matchers.hasItem("Aliko")).and().body("last_name", Matchers.hasItem("Dangote")).and()
   .body("first_name", Matchers.hasItem("Bill")).and().body("last_name", Matchers.hasItem("Gates")).and()
   .body("first_name", Matchers.hasItem("Folrunsho")).and().body("last_name", Matchers.hasItem("Alakija"));
   
	}
	/**
	 * Validation with Wrong Token
	 */
	@Test
	public void getUsersRecordWithWrongToken()
	{
   given().header("Authorization","WRONG_TOKEN").get(USER_ENDPOINT)
   .then().assertThat().statusCode(401).and().contentType("");
   		
	}
	/**
	 * validation when Giving random body request to the server
	 */
	@Test
	public void getUsersRecordWithRandomBodyField()
	{
   given().header("Authorization", TOKEN).contentType(ContentType.JSON).body("{ \"title\" : \"rupeek\", \"google\" : \"pass\"}").get(USER_ENDPOINT)
   .then().assertThat().statusCode(200).and().contentType("");
	}
}
