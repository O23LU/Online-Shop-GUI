package userAuth;

public class Address {
	private int housenumber;
	private String postcode;
	private String city;
	public Address (int housenumber,String postcode,String city) {
		this.housenumber = housenumber;
		this.postcode = postcode;
		this.city = city;
	}
	public String toString() {
		String output = ((housenumber)+", "+(postcode)+", "+(city)); //displays address
		return output;
	}
}
