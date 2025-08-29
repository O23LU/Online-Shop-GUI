package userAuth;

import java.time.LocalDate;

public class Receipt{
	private double amount;
	private Address fullAddress;
	private String paymentinfo;
	public Receipt (String paymentinfo,double amount,Address fullAddress) {
		this.amount = amount;
		this.fullAddress = fullAddress;
		this.paymentinfo = paymentinfo;
	}
	public String toString() {
		LocalDate currentdate = LocalDate.now();  //gets current date 
		String output = ("Receipt ("+(currentdate)+"):\nAddress: "+(fullAddress.toString())+"\nAmount Charged: £"+(String.format("%.2f", amount))+"\n"+(paymentinfo));
		return output;
	}
}
