package suntest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


import org.hamcrest.core.IsEqual;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRestApi {

	public static String getData(String userName,String password)
	{
		String jsonfile="{\n"
				+ "    \"name\": \""+userName+"\",\n"
				+ "    \"job\": \""+password+"\"\n"
				+ "}";
		return jsonfile;
	}
	static String putjsonfile="{\n"
			+ "    \"name\": \"neo\",\n"
			+ "    \"job\": \"hacker\"\n"
			+ "}";
	
	@Test(dataProvider="BookTests")
	public void postRequest(String uname,String pword) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in";
		String response=given().header("Content-Type","application/json")
		.body(getData(uname,pword))
		.when().post("api/users").then().statusCode(201).extract().response().asString();
		System.out.println(response);
		JsonPath js =new JsonPath(response);
		String id=js.get("id");
		System.out.println("Extracted id is "+ id);
	}
	@DataProvider(name="BookTests")
	public Object[][] getNewData(){
		return new Object[][] {{"Sunny","husband"},{"shivali","wife"},{"neo","gamer"}};
	}
	public void putRequest() {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in";
		String response=given().header("Content-Type","application/json")
		.body(putjsonfile)
		.when().put("api/users").then().statusCode(200).extract().response().asString();
		System.out.println(response);
		JsonPath js =new JsonPath(response);
		String id=js.get("id");
		System.out.println("Extracted id is "+ id);
	}
	
	
	public void getRequest() {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in/api/users/2";
		String response=given()
		.when().get().then().statusCode(200).extract().response().asString();
		System.out.println(response);
	}
	
	
	public void deleteRequest() {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in/api/users/2";
		String response=given().header("Content-Type","application/json")
		.when().delete().then().statusCode(204).extract().response().asString();
		System.out.println(response);
	}
}
