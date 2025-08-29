package userAuth;
import java.util.ArrayList;

public class Customer extends User {
	private int authlevel = 0;
	ArrayList<Product> Basket = new ArrayList<Product>();
	
	public Customer(int userID, String username,String name, int housenumber, String postcode, String city) {
		super(userID, username, name, housenumber, postcode, city);
	}
	
	public void addtobasket(Product item) { //adds to basket arraylist
		Basket.add(item);
	}
	public String displaybasket() {
		String output = "";
		for (int i = 0; i < Basket.size(); i++) {
			Product item = Basket.get(i);
			output = output + (item.toString(0))+"\n"; 
		}
		return output;
	}
	public int authlevel() { //getters
		int output = this.authlevel;
		return output;
	}
	public int basketsize() {
		return (Basket.size());
	}
	public void emptybasket() { //clears basket array list
		Basket.clear();
	}
}
