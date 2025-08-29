package userAuth;

public class Creditcard {
	private int cardnumber;
	private int cvv;
	public Creditcard(int cardnumber,int cvv) {
		this.cardnumber = cardnumber;
		this.cvv = cvv;
	}
	public Receipt processPayment(double amount, Address fullAddress) { //inherited from PaymentMethod
		return new Receipt(("Paid for using Credit card with card number: "+(cardnumber)),amount,fullAddress);
	}
}