package userAuth;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainClass {
//.........................................................................................................................................	
	public static User[] getusers() throws FileNotFoundException  { //static class means no instantaion of that class is needed 
		//.......................reading file to authenticate users and get their info if they area a valid user
		File UserData = new File("UserAccounts.txt");
		Scanner readfile = new Scanner(UserData);
		int datalen = 0;
		while (readfile.hasNextLine()) {
			datalen++;
			readfile.nextLine();}  //gets the amount of lines in the text file, representing the amount of accounts 
		User[] Userinfo = new User[datalen]; //crates array of users to add to using the text file data of size of the amount of users found above
		readfile.close();
		//.........................
		Scanner readdata = new Scanner(UserData);
		int k = 0;
		while (readdata.hasNextLine()) {
			String temp = readdata.nextLine();
			String[] line = temp.split(", ",7);
			int userID = Integer.parseInt(line[0].trim());//trim removes the first space so it can be passed from a string to an integer
			String username = line[1];
			String name = line[2];
			int housenumber = Integer.parseInt(line[3]); //these lines just format the data from the file so can be used in the constructor for the user class
			String postcode = line[4];
			String city = line[5];
			if (line[6].equals("admin")) {
				Admin object = new Admin(userID,username,name,housenumber,postcode,city); //creates either an admin class or customer class based of info in the text file
				Userinfo[k] = object;
			}
			else if (line[6].equals("customer")) {
				Customer object = new Customer(userID,username,name,housenumber,postcode,city);
				Userinfo[k] = object;
			}
			k++;
		}
		readdata.close();
		return Userinfo;
	}
	//......................................
	public static Boolean authenticateusers(String userin, User[] Userinfo) {
		boolean bool = false;
		int enteredID;
		int datalen = Userinfo.length;    
		try {
			enteredID = Integer.parseInt(userin);  //makes sure that the userid is in the text file 
		} catch (NumberFormatException e) {
			enteredID = -1;
		}
		for (int i=0; i<datalen; i++) {
			if (Userinfo[i].getuserID() == enteredID) {
				bool =  true;
				break;
			}
			else {
				bool = false;
			}
		}
		return bool;
	}
	//.....................................
	public static int setcurrentuser(String userin, User[] Userinfo) {
		int enteredID;
		int datalen = Userinfo.length; //sets the current user based on there index to the array of users gathers from the info in the text file 
		int loggedin_user = 0;
		try {
			enteredID = Integer.parseInt(userin);
		} catch (NumberFormatException e) {
			enteredID = -1;
		}
		for (int i=0; i<datalen; i++) {
			if (Userinfo[i].getuserID() == enteredID) {
				loggedin_user = i;
			}
		}
		return loggedin_user;
	}
	//.....................................
	public static ArrayList<Product> getinventory() throws FileNotFoundException {
		File StockData = new File("Stock.txt");
		//.................
		ArrayList<Product> Stockinfo = new ArrayList<Product>();
		Scanner readdatastock = new Scanner(StockData);
		int j = 0;
		while (readdatastock.hasNextLine()) {
			String temp = readdatastock.nextLine();  //if the textfile has another line then makes a string of that line 
			String[] line = temp.split(", ",10); //formats this string by splitting where there is commas 
			int barcode = Integer.parseInt(line[0].trim());//trim removes the first space so it can be passed from a string to an integer
			ProductCategory category = ProductCategory.valueOf(line[1].toUpperCase());
			String type = line[2];
			String brand = line[3];
			String colour = line[4]; //format the variables to each part of the file 
			ConnectivityType connectivity = ConnectivityType.valueOf(line[5].toUpperCase()); //these lines just format the data from the file so can be used in the constructor for the user class
			int stockcount = Integer.parseInt(line[6]);
			double ogcost = Double.parseDouble(line[7]);
			double retailprice = Double.parseDouble(line[8]);
			if (category == ProductCategory.MOUSE){
				int buttons = Integer.parseInt(line[9]);
				Mouse object = new Mouse(barcode,brand,type,colour,connectivity,stockcount,ogcost,retailprice,buttons,category); //creates either a mouse of keyboard object based on the info of the line in the text file 
				Stockinfo.add(object);
			}
			else if (category == ProductCategory.KEYBOARD) {
				String layout = line[9];
				Keyboard object = new Keyboard(barcode,brand,type,colour,connectivity,stockcount,ogcost,retailprice,layout,category);
				Stockinfo.add(object);
			}
			j++;
		}
		readdatastock.close();
		Collections.sort(Stockinfo, new Comparator<Product>() {
			public int compare(Product o1, Product o2) {
				return Double.compare(o1.getRetailPrice(), o2.getRetailPrice());
			}
			//orders stock based on price (lowest to highest)
		});
		return Stockinfo;
	}
	//..............................................
	public static ArrayList<Product> filterstockbymousebutton(ArrayList<Product> stock, String numofbuttons){
		int buttons;
		ArrayList<Product> newstock = new ArrayList<Product>();
		try {
			buttons = Integer.parseInt(numofbuttons); //trys to make an int of the inputted textfield
		} catch (NumberFormatException e) {
			return stock;
		}
		for (int i = 0;i<stock.size();i++) {
			if (stock.get(i) instanceof Mouse) {
				Mouse temp = (Mouse)stock.get(i);
				if (temp.getbuttons() == buttons) {  //filters by mouse and then by buttons
					newstock.add(stock.get(i)); //returns the filtered results
				}
			}
		}
		return newstock;
	}
	//.......................................
	public static ArrayList<Product> filterbybarcode(ArrayList<Product> stock, String barcodenum){
		int barcode;
		ArrayList<Product> newstock = new ArrayList<Product>();
		try {
			barcode = Integer.parseInt(barcodenum);
			for (int i = 0;i<stock.size();i++) {
				if (stock.get(i).getBarcode() == barcode) { //checks through and sees if barcode is in the stock, breaks if found due to barcode being unique so only ever one product 
					newstock.add(stock.get(i));
					break;
				}
			}
			return newstock;
		} catch (NumberFormatException e) {
			return stock;
		}

	}
	//.............................................
	public static void writestocktofile(ArrayList<Product> stock) {
		String lineofstock;
		BufferedWriter writetofile = null;
		try { //adds info to the text file
			writetofile = new BufferedWriter(new FileWriter(new File("Stock.txt")));
			for (int i = 0;i<stock.size()-1;i++) {
				if (stock.get(i) instanceof Mouse) {
					Mouse tempobject = (Mouse)stock.get(i);     //creates string with info using info from the stock arraylist and writes back
					lineofstock = (" "+(tempobject.getBarcode())+", "+(tempobject.getCategory().toString().toLowerCase())+", "+(tempobject.gettype())+", "+(tempobject.getBrand())+", "+(tempobject.getColor())+", "+(tempobject.getConnectivity().toString().toLowerCase())+", "+(tempobject.getQuantityInStock())+", "+(tempobject.getOriginalCost())+", "+(tempobject.getRetailPrice())+", "+(tempobject.getbuttons())+"\n");
					writetofile.write(lineofstock);
				}
				else {
					Keyboard tempobject = (Keyboard)stock.get(i);
					lineofstock = (" "+(tempobject.getBarcode())+", "+(tempobject.getCategory().toString().toLowerCase())+", "+(tempobject.gettype())+", "+(tempobject.getBrand())+", "+(tempobject.getColor())+", "+(tempobject.getConnectivity().toString().toLowerCase())+", "+(tempobject.getQuantityInStock())+", "+(tempobject.getOriginalCost())+", "+(tempobject.getRetailPrice())+", "+(tempobject.getlayout())+"\n");
					writetofile.write(lineofstock);
				}
			}
			if (stock.get(stock.size()-1) instanceof Mouse) {
				Mouse tempobject = (Mouse)stock.get(stock.size()-1);     //creates string with info using info from the stock arraylist and writes back
				lineofstock = (" "+(tempobject.getBarcode())+", "+(tempobject.getCategory().toString().toLowerCase())+", "+(tempobject.gettype())+", "+(tempobject.getBrand())+", "+(tempobject.getColor())+", "+(tempobject.getConnectivity().toString().toLowerCase())+", "+(tempobject.getQuantityInStock())+", "+(tempobject.getOriginalCost())+", "+(tempobject.getRetailPrice())+", "+(tempobject.getbuttons()));
				writetofile.write(lineofstock);
			}
			else {
				Keyboard tempobject = (Keyboard)stock.get(stock.size()-1);
				lineofstock = (" "+(tempobject.getBarcode())+", "+(tempobject.getCategory().toString().toLowerCase())+", "+(tempobject.gettype())+", "+(tempobject.getBrand())+", "+(tempobject.getColor())+", "+(tempobject.getConnectivity().toString().toLowerCase())+", "+(tempobject.getQuantityInStock())+", "+(tempobject.getOriginalCost())+", "+(tempobject.getRetailPrice())+", "+(tempobject.getlayout()));
				writetofile.write(lineofstock);
			}
			writetofile.close(); 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
