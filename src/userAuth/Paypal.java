package userAuth;

public class Paypal implements PaymentMethod {
	private String paypalemail;
	public Paypal(String paypalemail) {
		this.paypalemail = paypalemail;
	}
	public Receipt processPayment(double amount, Address fullAddress) { //inherited from PaymentMethod
		return new Receipt(("Paid for using paypal with email: "+(paypalemail)),amount,fullAddress);
	}
}
