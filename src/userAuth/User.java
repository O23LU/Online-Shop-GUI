package userAuth;
import java.util.ArrayList;

public abstract class User {
	private int userID;          
	private String username; 
	private String name;
	private int housenumber;
	private String postcode;
	private String city;
	private int authlevel;
	
	public User (int userID, String username,String name, int housenumber, String postcode, String city) {
		this.userID = userID;
		this.username = username;
		this.name = name;
		this.housenumber = housenumber;
		this.postcode = postcode;
		this.city = city;
	}
	public String toString() {
		String output = ((userID)+", "+ (username)+", "+(name)+", "+ (housenumber)+", "+(postcode)+", "+(city));
		return output;
	}
	public int getuserID() {    //getters
		int output = this.userID;
		return output;
	}
	public int authlevel() {
		int output = this.authlevel;
		return output;
	}
	public int getHousenumber() {
		int output = this.housenumber;
		return output;
	}
	public String getPostcode() {
		String output = this.postcode;
		return output;
	}
	public String getCity() {
		String output = this.city;
		return output;
	}
	public static double basketsum(ArrayList<Product> basket) {  //sums the amounts in the basket
		double basketsum=0;
		for (int i = 0;i<basket.size();i++) {
			basketsum = basketsum + (basket.get(i).getRetailPrice());
		}
		return basketsum;
	}
}