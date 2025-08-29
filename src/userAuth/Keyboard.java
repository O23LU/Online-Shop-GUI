package userAuth;

public class Keyboard extends Product{
	private String type;
	private String layout;
	public Keyboard(int barcode, String brand, String type, String colour, ConnectivityType connectivity, int stockcount, double ogcost, double retailprice, String layout,ProductCategory category) {
		super(barcode, brand, colour, connectivity, stockcount, ogcost, retailprice, category);
		this.layout = layout;
		this.type = type;
	}
	public String toString(int authlevel) { //toString method based on user auth 
		if (authlevel == 1) {
			String output = ((getBarcode())+": "+(getBrand())+", "+getColor()+", "+(type)+", "+getConnectivity().toString().toLowerCase()+" "+(getCategory().toString().toLowerCase())+", with "+layout+" layout"+":   "+getQuantityInStock()+" in stock:"+"   bought for £"+getOriginalCost()+"   selling for £"+getRetailPrice());
			return output;
		}
		else if (authlevel == 0){
			String output = ((getBarcode())+": "+(getBrand())+", "+(getColor())+", "+(getConnectivity().toString().toLowerCase())+", "+(type)+" "+(getCategory().toString().toLowerCase())+" with; "+(layout)+" layout: £"+(getRetailPrice())+" - "+(getQuantityInStock())+" in stock");
			return output;
		}
		else {
			String output = ((getBarcode())+": "+(getBrand())+", "+(getColor())+", "+(getConnectivity().toString().toLowerCase())+", "+(type)+" "+(getCategory().toString().toLowerCase())+" with; "+(layout)+" layout: £"+(getRetailPrice()));
			return output;
		}
	}
	public String getlayout() { //getters
		return this.layout;
	}
	public String gettype() {
		String output = this.type;
		return output;
	}
}
