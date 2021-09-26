package suntest;

import java.util.Arrays;
import java.util.List;

public class Message {

	public String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message=message;
	}
	
	public static void main(String[] args) {
		List<String> al=Arrays.asList("Sunny","funny","Money");
		System.out.println(al);
	}
}
