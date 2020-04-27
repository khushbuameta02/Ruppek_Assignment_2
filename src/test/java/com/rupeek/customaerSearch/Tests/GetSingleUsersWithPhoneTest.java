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
public class GetSingleUsersWithPhoneTest implements IAutho {
	/**
	 * Getting user detail by using phone number and validate it
	 */
	@Test
	public void getAutherizationWithValidphone()
	{
   given().header("Authorization", TOKEN).get(USER_PHONE + "/users/8037602400")
   .then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
   .body("first_name", Matchers.equalTo("Aliko")).and().body("last_name", Matchers.equalTo("Dangote"));
   
		
		
	}
	/**
	 * Validate with wrong phone number which does not exist
	 */
	@Test
	public void getAutherizationWithInValidphone()
	{
   given().header("Authorization",TOKEN).get(USER_PHONE +"/users/8037896075")
   .then().assertThat().statusCode(200).and().contentType("");
   		
	}

}
