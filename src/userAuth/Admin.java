package userAuth;

public class Admin extends User {
	private int authlevel = 1; //used for mouse and keyboard toString method
	public Admin(int userID, String username,String name, int housenumber, String postcode, String city) {
		super(userID, username, name, housenumber, postcode, city);
	}
	public int authlevel() {  //getter and setters
		int output = this.authlevel;
		return output;
	}
}
