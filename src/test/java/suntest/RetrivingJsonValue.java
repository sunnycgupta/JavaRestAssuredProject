package suntest;

import io.restassured.path.json.JsonPath;

public class RetrivingJsonValue {

	public static String getData() {
		String complexJson="{\n"
				+ "  \"dashboard\": {\n"
				+ "    \"purchaseAmount\": 910,\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\n"
				+ "  },\n"
				+ "  \"courses\": [\n"
				+ "    {\n"
				+ "      \"title\": \"Selenium Python\",\n"
				+ "      \"price\": 50,\n"
				+ "      \"copies\": 6\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"title\": \"Cypress\",\n"
				+ "      \"price\": 40,\n"
				+ "      \"copies\": 4\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"title\": \"RPA\",\n"
				+ "      \"price\": 45,\n"
				+ "      \"copies\": 10\n"
				+ "    }\n"
				+ "  ]\n"
				+ "}";
		return complexJson;
	}
	public static void main(String[] args) {
		
		int str=JsonPath.from(getData()).get("courses.size()");
		
		System.out.println(str);
		int purchaseamt=JsonPath.from(getData()).getInt("dashboard.purchaseAmount");
		System.out.println(purchaseamt);
		
		for(int i=0;i<str;i++) {
			String value=JsonPath.from(getData()).get("courses["+i+"].title").toString();
			System.out.println(value);
			System.out.println(JsonPath.from(getData()).get("courses["+i+"].price").toString());
		}

		System.out.println("Printing the copies for RPA");
		
		for(int i=0;i<str;i++) {
			String value=JsonPath.from(getData()).get("courses["+i+"].title").toString();
			if(value.equalsIgnoreCase("RPA")) {
				int copies =JsonPath.from(getData()).get("courses["+i+"].copies");
				break;
			}
		}
		
		System.out.println("Matching the purchase amount");
		int expAmount=0;
		for(int i=0;i<str;i++) {
			int result=0;
			int valueprice=JsonPath.from(getData()).get("courses["+i+"].price");
			int valuecopy=JsonPath.from(getData()).get("courses["+i+"].copies");
			result=valueprice*valuecopy;
			expAmount=expAmount+result;
		}
		System.out.println(expAmount);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
