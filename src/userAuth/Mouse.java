package userAuth;

public class Mouse extends Product{
	private String type;
	private int buttons;
	public Mouse(int barcode, String brand, String type, String colour, ConnectivityType connectivity, int stockcount, double ogcost, double retailprice, int buttons,ProductCategory category) {
		super(barcode, brand, colour, connectivity, stockcount, ogcost, retailprice,category);
		this.buttons = buttons;
		this.type = type;
	}
	public String toString(int authlevel) { //toString method based on user auth level 
		if (authlevel == 1) {
			String output = ((getBarcode())+": "+(getBrand())+", "+getColor()+", "+(type)+", "+getConnectivity().toString().toLowerCase()+" "+(getCategory().toString().toLowerCase())+", with "+buttons+" buttons"+":   "+getQuantityInStock()+" in stock:   "+"bought for £"+getOriginalCost()+"   selling for £"+getRetailPrice());
			return output;
		}
		else if (authlevel == 0){
			String output = ((getBarcode())+": "+(getBrand())+", "+(getColor())+", "+(getConnectivity().toString().toLowerCase())+", "+(type)+" "+(getCategory().toString().toLowerCase())+" with; "+(buttons)+" buttons: £"+(getRetailPrice())+" - "+(getQuantityInStock())+" in stock");
			return output;
		}
		else {
			String output = ((getBarcode())+": "+(getBrand())+", "+(getColor())+", "+(getConnectivity().toString().toLowerCase())+", "+(type)+" "+(getCategory().toString().toLowerCase())+" with; "+(buttons)+" buttons: £"+(getRetailPrice()));
			return output;
		}
	}
	public int getbuttons() { //getters
		int output = this.buttons;
		return output;
	}
	public String gettype() {
		String output = this.type;
		return output;
	}
}
