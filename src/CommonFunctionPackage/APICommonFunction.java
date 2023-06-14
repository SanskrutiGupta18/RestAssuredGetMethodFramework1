package CommonFunctionPackage;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class APICommonFunction {
	public static int statusCode(String BaseURI,String resource) {
		RestAssured.baseURI=BaseURI;
		int statusCode = given().header("Content-Type","application/json").when().get(resource).then().extract().statusCode();
		return statusCode;
	}
	public static String responseBody(String BaseURI,String resource) {
		RestAssured.baseURI=BaseURI;
		String responseBody = given().header("Content-Type","application/json").when().get(resource).then().extract().response().asString();
		return responseBody;
	}
}