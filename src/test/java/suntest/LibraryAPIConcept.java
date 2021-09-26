package suntest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LibraryAPIConcept {

	public CreatingBookPayload creatingBookPayload=new CreatingBookPayload("My Name is none","findMyBooks",123546987,"JohnWickNewSeries");
	private static String bookId=null;
	@Test
	public void addBookInLibrary() throws Exception {
		
		ObjectMapper om=new ObjectMapper();
		String addResource=om.writeValueAsString(creatingBookPayload);
		
		RestAssured.baseURI="http://216.10.245.166";
		/*
		 * String addResource="{\n" + "\n" +
		 * "\"name\":\"My name is learning valuesr\",\n" +
		 * "\"isbn\":\"findMyContentst\",\n" + "\"aisle\":\"255332210\",\n" +
		 * "\"author\":\"John wick series12\"\n" + "}\n" + "";
		 */
		String response=given().header("Content-Type","application/json").body(addResource).post("Library/Addbook.php").body().asString();

		System.out.println(response);
		
		bookId=JsonPath.from(response).getString("ID");
	}
	
	@Test
	public void getBookFromLibrary() {
		
		RestAssured.baseURI="http://216.10.245.166";
		
	    String response=given().header("Content-Type","application/json").queryParams("ID",bookId).get("Library/GetBook.php").asString();
		
	    System.out.println(response);
	}
	
	@Test
	public void xdeleteBookFromLibrary() {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String bookValue=String.format("\"%s\":\"%s\"","ID",bookId);
		String payload="{\n"+bookValue+"}\n";
		
		String response=given().header("Content-Type","application/json").body(payload).delete("Library/DeleteBook.php").asString();
		
		System.out.println(response);
	}
}
