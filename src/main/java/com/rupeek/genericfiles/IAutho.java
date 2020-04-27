package com.rupeek.genericfiles;

public interface IAutho {
	String BASE_URL_Authenticate="http://13.126.80.194:8080/authenticate";
	String TOKEN="Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXBlZWsiLCJleHAiOjE1ODc5ODQxMjEsImlhdCI6MTU4Nzk2NjEyMX0.I72KlUzndS8GrB4yuIhgQfaf7TBYhK84mHmG0khxMSB4Ld7l-PR5O-v-HyVEGImgxIEtyWLOBkSB8G8qthcYGQ";

	String USER_ENDPOINT="http://13.126.80.194:8080/api/v1/users";
	String USER_PHONE="http://13.126.80.194:8080/api/v1/{phone}";
	
}
