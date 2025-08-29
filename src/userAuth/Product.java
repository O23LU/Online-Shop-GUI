package userAuth;

public abstract class Product{
	private int barcode;
	private String brand; 
	private String colour;
	private ConnectivityType connectivity;
	private int stockcount;
	private double ogcost;
	private double retailprice;
	private ProductCategory category;
	public Product (int barcode, String brand, String colour, ConnectivityType connectivity, int stockcount, double ogcost, double retailprice,ProductCategory category) {
		this.barcode = barcode;
		this.brand = brand;
		this.colour = colour;
		this.connectivity = connectivity;
		this.stockcount = stockcount;
		this.ogcost = ogcost;
		this.retailprice = retailprice;
		this.category = category;
	}
	//...................
	public int getBarcode() {  //getters and setters
		int output = this.barcode;
		return output;
	}
	public String getBrand() {
		String output = this.brand; 
		return output;
	}
	public String getColor() {
		String output = this.colour;
		return output;
	}
	public ConnectivityType getConnectivity() {
		ConnectivityType output = (this.connectivity);
		return output;
	}
	public int getQuantityInStock() {
		int output = this.stockcount;
		return output;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.stockcount = quantityInStock;
	}
	public double getOriginalCost() {
		double output = this.ogcost;
		return output;
	}
	public double getRetailPrice() {
		double output = this.retailprice;
		return output;
	}
	public ProductCategory getCategory() {
		ProductCategory output = this.category;
		return output;
	}
	public abstract String toString(int a);
}
