package userAuth;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import userAuth.User;
import userAuth.MainClass;
//import userAuth.P
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserIN;
	private JTextField enterbarcode;
	private JTextField entermousebuttons;
	private JTextField newbarcode;
	private JTextField newbrand;
	private JTextField newcolour;
	private JTextField newstockcount;
	private JTextField newogprice;
	private JTextField newretailprice;
	private JTextField cardnumber;
	private JTextField cvv;
	private JTextField paypalemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//..............................................
	/**
	 * Create the frame.
	 */
	public GUI() throws FileNotFoundException { 
		//............... runs method to create array of users
		User[] userinfo;
		userinfo = MainClass.getusers(); //uses methods from mainclass to create a array of the users from the text file
		ArrayList<Product> stock;
		stock = MainClass.getinventory();	//uses methods from mainclass to create a arraylist of the stock from the text file
		ArrayList<Product> basket = new ArrayList<Product>();
		ArrayList<String> displaybasket = new ArrayList<String>();
		ArrayList<Product> ogstock = MainClass.getinventory();
		//...............
		setBackground(new Color(240, 240, 240));
		setTitle("GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 565);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 181, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//............................................................... panels/cards that are shown
		
		JPanel UserLogin = new JPanel();
		UserLogin.setBackground(new Color(252, 160, 163));
		contentPane.add(UserLogin, "name_3380744537790900");
		UserLogin.setLayout(null);
		
		JPanel MainMenu_customer = new JPanel();
		MainMenu_customer.setBackground(new Color(252, 160, 163));
		contentPane.add(MainMenu_customer, "name_3380782637501400");
		MainMenu_customer.setLayout(null);
		
		JPanel MainMenu_admin = new JPanel();
		MainMenu_admin.setBackground(new Color(252, 160, 163));
		contentPane.add(MainMenu_admin, "name_3391932182988700");
		MainMenu_admin.setLayout(null);
		
		JPanel Checkout = new JPanel();
		Checkout.setBackground(new Color(252, 160, 163));
		contentPane.add(Checkout, "name_3752854164003200");
		Checkout.setLayout(null);
		
		//...............................................................
		
		contentPane.add(UserLogin,"User Login");
		contentPane.add(MainMenu_customer,"Main Menu (Customer)");
		contentPane.add(MainMenu_admin,"Main Menu (Admin)");
		contentPane.add(Checkout,"Checkout");
		CardLayout cardlayout = (CardLayout) contentPane.getLayout();
		
		JLabel currentusershows1 = new JLabel("");
		currentusershows1.setFont(new Font("Sitka Small", Font.BOLD, 10));
		currentusershows1.setBounds(418, 10, 296, 14);
		MainMenu_admin.add(currentusershows1);
		
		JLabel showcurrentuser = new JLabel("");
		showcurrentuser.setFont(new Font("Sitka Small", Font.BOLD, 10));
		showcurrentuser.setBounds(418, 10, 296, 14);
		MainMenu_customer.add(showcurrentuser);
		
		JScrollPane customerstock = new JScrollPane();
		customerstock.setBounds(10, 90, 520, 200);
		MainMenu_customer.add(customerstock);
		
		JList stocklist = new JList();
		stocklist.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		customerstock.setViewportView(stocklist);
		
		JScrollPane basketscroll = new JScrollPane();
		basketscroll.setBounds(10, 365, 491, 98);
		MainMenu_customer.add(basketscroll);
		
		JList Basket = new JList();
		basketscroll.setViewportView(Basket);
		
		JSpinner quantityofitem = new JSpinner();
		quantityofitem.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		quantityofitem.setBounds(224, 301, 39, 24);
		MainMenu_customer.add(quantityofitem);
		quantityofitem.setEditor(new JSpinner.DefaultEditor(quantityofitem));
		
		JScrollPane adminstockview = new JScrollPane();
		adminstockview.setBounds(10, 74, 704, 213);
		MainMenu_admin.add(adminstockview);
		
		JList adminstock = new JList();
		adminstockview.setViewportView(adminstock);
		
		JComboBox userIN = new JComboBox();
		userIN.setBounds(348, 153, 102, 22);
		UserLogin.add(userIN);
		String[] users = {"101","102","103","104"};
		for (int i = 0;i<users.length;i++) {
			userIN.addItem(users[i]);
		}
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userin = (String)userIN.getSelectedItem();
				if (MainClass.authenticateusers(userin,userinfo)==true){//checks to see if is in database
					UserIN.setText((String)userIN.getSelectedItem());
					User currentuser = userinfo[MainClass.setcurrentuser(userin, userinfo)]; //sets current user as the one inputed
					currentusershows1.setText(String.valueOf(currentuser));
					showcurrentuser.setText(String.valueOf(currentuser));
					if (currentuser instanceof Admin) { //sends to different screens depending on if user is admin or customer
						cardlayout.show(contentPane,"Main Menu (Admin)");
						DefaultListModel listmodel = new DefaultListModel();
						for (int j=0;j<stock.size();j++) {
							listmodel.addElement(stock.get(j).toString(currentuser.authlevel())); //sets the stock display of the jlist dependent on the users level (admin or customer)
						}
						adminstock.setModel(listmodel);
					}
					else {
						cardlayout.show(contentPane,"Main Menu (Customer)"); //sets the stock display of the jlist dependent on the users level (admin or customer)
						DefaultListModel listmodel = new DefaultListModel();
						for (int j=0;j<stock.size();j++) {
							listmodel.addElement(stock.get(j).toString(currentuser.authlevel()));
							}
						stocklist.setModel(listmodel);
					}
				}
				else {
					currentusershows1.setText(String.valueOf("User not in database"));
					showcurrentuser.setText(String.valueOf("User not in database"));
				}
			}
		});
		btnNewButton.setBounds(311, 205, 89, 23);
		UserLogin.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(311, 103, 102, 23);
		UserLogin.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Enter User ID: ");
		lblNewLabel_2.setBounds(262, 157, 92, 14);
		UserLogin.add(lblNewLabel_2);
		
		UserIN = new JTextField();
		UserIN.setBounds(430, 269, 86, 20);
		UserLogin.add(UserIN);
		UserIN.setColumns(10);
		UserIN.setVisible(false);
		
		JLabel mainmenu_label = new JLabel("Main Menu");
		mainmenu_label.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		mainmenu_label.setBounds(10, 10, 117, 14);
		MainMenu_customer.add(mainmenu_label);
		
		JLabel currentlogin1 = new JLabel("Currently logged in as:");
		currentlogin1.setFont(new Font("Sitka Small", Font.BOLD, 10));
		currentlogin1.setBounds(286, 10, 162, 14);
		MainMenu_admin.add(currentlogin1);
		
		JButton changeuser_button = new JButton("Change User");
		changeuser_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(contentPane,"User Login");
				basket.clear();
				displaybasket.clear();
				DefaultListModel listmodel = new DefaultListModel(); //resets back to the login panel 
				Basket.setModel(listmodel);
				for (int i = 0;i<ogstock.size();i++) {
					(stock.get(i)).setQuantityInStock(ogstock.get(i).getQuantityInStock()); //resets the stock quantity's
				}
			}
		});
		changeuser_button.setBounds(10, 482, 117, 23);
		MainMenu_customer.add(changeuser_button);
		
		JLabel currentuser_label = new JLabel("Currently Logged in as;");
		currentuser_label.setFont(new Font("Sitka Small", Font.BOLD, 10));
		currentuser_label.setBounds(286, 10, 278, 14);
		MainMenu_customer.add(currentuser_label);
		
		JLabel basketsum = new JLabel("");
		basketsum.setFont(new Font("Gadugi", Font.BOLD, 12));
		basketsum.setBounds(10, 86, 300, 23);
		Checkout.add(basketsum);
		
		JButton checkout_button = new JButton("Checkout");
		checkout_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (User.basketsum(basket) == 0) {
					JOptionPane.showMessageDialog(MainMenu_customer, "You cannot go to checkout as nothing in basket"); //doesn't let you if basket empty 
				}
				else {
					cvv.setText(null);
					cardnumber.setText(null);
					paypalemail.setText(null);
					cardlayout.show(contentPane,"Checkout");
					basketsum.setText("The Total of your Basket comes to £"+String.format("%.2f", (User.basketsum(basket)))); //goes to checkout panel and shows amount
				}
			}
		});
		checkout_button.setBounds(597, 482, 117, 23);
		MainMenu_customer.add(checkout_button);
		
		JButton addtobasket_button = new JButton("Add to basket");
		addtobasket_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User currentuse = userinfo[MainClass.setcurrentuser(UserIN.getText(), userinfo)];
				if (stocklist.getSelectedValue() == null) { //deals with if no value in list has been selected
					JOptionPane.showMessageDialog(MainMenu_customer, "No item selected \n(click item to select)"); //gives error message if there isnt enough stock
				}
				else {
					int index = 0;
					for (int i=0;i<stock.size();i++) {
						if (((String)stocklist.getSelectedValue()).substring(0,5).equals((String)stock.get(i).toString(currentuse.authlevel()).substring(0,5))) {
							index = i;
							break;
							}
						}
					if (stock.get(index).getQuantityInStock() < (int)quantityofitem.getValue()) {
						JOptionPane.showMessageDialog(MainMenu_customer, "You cannot add this many items (insufficient stock levels)"); //gives error message if there isnt enough stock
					}
					else {
						for (int k = 0;k<((int)quantityofitem.getValue());k++) { //if it can be added to basket adds to the basket array list
							basket.add(stock.get(index));
						}
						displaybasket.add(quantityofitem.getValue()+"x "+stock.get(index).toString(2));
						DefaultListModel listmodel = new DefaultListModel();  //then updates the basket list shown 
						for (int j=0;j<displaybasket.size();j++) {
							listmodel.addElement(displaybasket.get(j)); //adds to basket with altered view that doesn't show stock count
						}
						Basket.setModel(listmodel);
						
						int newamount = stock.get(index).getQuantityInStock() - (int)quantityofitem.getValue();
						stock.get(index).setQuantityInStock(newamount);
						//.....
						DefaultListModel currentstocklist = new DefaultListModel();
						for (int j=0;j<stock.size();j++) {
							currentstocklist.addElement(stock.get(j).toString(currentuse.authlevel())); //then updates the stock list with this updated stock value
							}
						stocklist.setModel(currentstocklist);
						}
					}
				}
			});
		addtobasket_button.setBounds(10, 302, 117, 23);
		MainMenu_customer.add(addtobasket_button);
		
		JLabel stock_label = new JLabel("Avaliable Stock; (Click on item to select )");
		stock_label.setFont(new Font("Gadugi", Font.BOLD, 12));
		stock_label.setBounds(10, 68, 520, 14);
		MainMenu_customer.add(stock_label);
		
		JLabel filter_label = new JLabel("Filter by #mouse buttons;");
		filter_label.setBounds(540, 211, 184, 14);
		MainMenu_customer.add(filter_label);
		
		JButton applyfilter_button = new JButton("Apply Filter");
		applyfilter_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User current = userinfo[MainClass.setcurrentuser(UserIN.getText(), userinfo)]; //sets current users 
				ArrayList<Product> itemstock = new ArrayList<Product>();
				for (int i = 0;i<stock.size();i++) {
					itemstock.add(stock.get(i));
				}
				itemstock = MainClass.filterstockbymousebutton(itemstock, entermousebuttons.getText()); //filters using method so will return a filtered array list
				if (itemstock.size()>0) {
					DefaultListModel listmodel = new DefaultListModel();
					for (int j=0;j<itemstock.size();j++) {
						listmodel.addElement(itemstock.get(j).toString(current.authlevel())); //sets the j list to using this filtered array list 
						}
					stocklist.setModel(listmodel);
				}
				else {
					DefaultListModel listmodel = new DefaultListModel();
					for (int j=0;j<stock.size();j++) {
						listmodel.addElement(stock.get(j).toString(current.authlevel())); //sets the j list back to original if the filtered array list comes back empty 
					}
					stocklist.setModel(listmodel);
					JOptionPane.showMessageDialog(MainMenu_customer, "No results found");
				}
			}
		});
		applyfilter_button.setBounds(540, 267, 156, 23);
		MainMenu_customer.add(applyfilter_button);
		
		enterbarcode = new JTextField();
		enterbarcode.setBounds(540, 117, 156, 20);
		MainMenu_customer.add(enterbarcode);
		enterbarcode.setColumns(10);
		
		JLabel filterbarcode_button = new JLabel("Look up product barcode");
		filterbarcode_button.setBounds(540, 92, 156, 14);
		MainMenu_customer.add(filterbarcode_button);
		
		entermousebuttons = new JTextField();
		entermousebuttons.setBounds(540, 236, 156, 20);
		MainMenu_customer.add(entermousebuttons);
		entermousebuttons.setColumns(10);
		
		JButton searchbarcode = new JButton("Search");
		searchbarcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User current = userinfo[MainClass.setcurrentuser(UserIN.getText(), userinfo)];  // sets current user 
				ArrayList<Product> itemstock1 = new ArrayList<Product>();
				for (int i = 0;i<stock.size();i++) {    //makes a array list of the stock, with the current stock levels (accounting for basket)
					itemstock1.add(stock.get(i));
				}
				itemstock1 = MainClass.filterbybarcode(itemstock1, enterbarcode.getText()); //uses the filter method in the MainClass
				if (itemstock1.size()>0) {
					DefaultListModel listmodel = new DefaultListModel();
					for (int j=0;j<itemstock1.size();j++) {
						listmodel.addElement(itemstock1.get(j).toString(current.authlevel())); //adds all the info to the list model 
						}
					stocklist.setModel(listmodel); //sets the list model so the j list displays the filtered stock 
				}
				else {
					DefaultListModel listmodel = new DefaultListModel();
					for (int j=0;j<stock.size();j++) {
						listmodel.addElement(stock.get(j).toString(current.authlevel())); //if the filtered list is empty it just shows the normal list 
						}
					stocklist.setModel(listmodel);
					JOptionPane.showMessageDialog(MainMenu_customer, "No results found");
				}
			}
		});
		searchbarcode.setBounds(540, 148, 156, 23);
		MainMenu_customer.add(searchbarcode);
		
		JLabel basket_label = new JLabel("Basket:");
		basket_label.setFont(new Font("Gadugi", Font.BOLD, 12));
		basket_label.setBounds(10, 348, 46, 14);
		MainMenu_customer.add(basket_label);
		
		JLabel quantity_label = new JLabel("Quantity");
		quantity_label.setFont(new Font("Arial Black", Font.BOLD, 11));
		quantity_label.setBounds(159, 301, 69, 24);
		MainMenu_customer.add(quantity_label);
		
		JButton emptybasket_button = new JButton("Empty Basket");
		emptybasket_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basket.clear();
				displaybasket.clear();  //clears the array lists of basket and the basket display
				DefaultListModel listmodel = new DefaultListModel();
				Basket.setModel(listmodel);  //resets the j list model as empty to reflect the fact that the lists have changed 
				for (int i = 0;i<ogstock.size();i++) {
					(stock.get(i)).setQuantityInStock(ogstock.get(i).getQuantityInStock());
				}
				DefaultListModel listmodel2 = new DefaultListModel(); //resets stock count then updates the j list to show this
				for (int j=0;j<stock.size();j++) {
					listmodel2.addElement(stock.get(j).toString(0));
					}
				stocklist.setModel(listmodel2);
			}
		});
		emptybasket_button.setBounds(507, 363, 122, 41);
		MainMenu_customer.add(emptybasket_button);
		
		JButton resetstockview = new JButton("Show all Stock (reset filter)");
		resetstockview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel listmodel = new DefaultListModel();
				for (int j=0;j<stock.size();j++) {
					listmodel.addElement(stock.get(j).toString(0)); //resets the j list using the stock array list
					}
				stocklist.setModel(listmodel);
			}
		});
		resetstockview.setBounds(310, 301, 220, 23);
		MainMenu_customer.add(resetstockview);
		
		JLabel mainmenuA_label = new JLabel("Main Menu (Admin)");
		mainmenuA_label.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		mainmenuA_label.setBounds(10, 11, 170, 14);
		MainMenu_admin.add(mainmenuA_label);
		
		JLabel adminstock_label = new JLabel("Stock;");
		adminstock_label.setFont(new Font("Gadugi", Font.BOLD, 12));
		adminstock_label.setBounds(10, 55, 76, 14);
		MainMenu_admin.add(adminstock_label);
		
		JLabel addnewproduct_label = new JLabel("Add new product to stock:");
		addnewproduct_label.setFont(new Font("Gadugi", Font.BOLD, 12));
		addnewproduct_label.setBounds(10, 315, 162, 14);
		MainMenu_admin.add(addnewproduct_label);
		
		newbarcode = new JTextField();
		newbarcode.setBounds(10, 358, 86, 20);
		MainMenu_admin.add(newbarcode);
		newbarcode.setColumns(10);
		
		newbrand = new JTextField();
		newbrand.setBounds(106, 358, 86, 20);
		MainMenu_admin.add(newbrand);
		newbrand.setColumns(10);
		
		newcolour = new JTextField();
		newcolour.setBounds(413, 358, 96, 20);
		MainMenu_admin.add(newcolour);
		newcolour.setColumns(10);
		
		JComboBox newconnectivitytype = new JComboBox();
		newconnectivitytype.setModel(new DefaultComboBoxModel(ConnectivityType.values()));
		newconnectivitytype.setBounds(200, 407, 106, 22);
		MainMenu_admin.add(newconnectivitytype);
		newconnectivitytype.setSelectedItem(ConnectivityType.WIRED);
		
		newstockcount = new JTextField();
		newstockcount.setBounds(628, 358, 86, 20);
		MainMenu_admin.add(newstockcount);
		newstockcount.setColumns(10);
		
		newogprice = new JTextField();
		newogprice.setBounds(519, 358, 104, 20);
		MainMenu_admin.add(newogprice);
		newogprice.setColumns(10);
		
		newretailprice = new JTextField();
		newretailprice.setBounds(519, 408, 104, 20);
		MainMenu_admin.add(newretailprice);
		newretailprice.setColumns(10);
		
		JLabel producttype_label = new JLabel("Product");
		producttype_label.setBounds(202, 339, 46, 14);
		MainMenu_admin.add(producttype_label);
		
		JLabel connectivity_label = new JLabel("Connectivity");
		connectivity_label.setBounds(200, 390, 76, 14);
		MainMenu_admin.add(connectivity_label);
		
		JLabel barcode_label = new JLabel("Barcode");
		barcode_label.setBounds(10, 339, 76, 14);
		MainMenu_admin.add(barcode_label);
		
		JLabel brand_label = new JLabel("Brand");
		brand_label.setBounds(106, 339, 74, 14);
		MainMenu_admin.add(brand_label);
		
		JLabel colour_label = new JLabel("Colour");
		colour_label.setBounds(413, 339, 46, 14);
		MainMenu_admin.add(colour_label);
		
		JLabel stockcount_label = new JLabel("Stock Count");
		stockcount_label.setBounds(628, 339, 76, 14);
		MainMenu_admin.add(stockcount_label);
		
		JLabel lblNewLabel_6 = new JLabel("Origional Price (\u00A3)");
		lblNewLabel_6.setBounds(519, 339, 104, 14);
		MainMenu_admin.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Retail Price (\u00A3)");
		lblNewLabel_7.setBounds(519, 390, 104, 14);
		MainMenu_admin.add(lblNewLabel_7);
		
		JLabel typenew = new JLabel("Type");
		typenew.setBounds(316, 339, 46, 14);
		MainMenu_admin.add(typenew);
		
		String[] inital1 = {"Standard","Flexible","Gaming"};
		JComboBox typebox = new JComboBox(inital1);
		typebox.setBounds(316, 357, 87, 22);
		MainMenu_admin.add(typebox);
		typebox.setSelectedItem("Standard");
		
		JLabel newadditionalinfo = new JLabel("Keyboard Layout");
		newadditionalinfo.setBounds(316, 390, 114, 14);
		MainMenu_admin.add(newadditionalinfo);
		
		String[] inital = {"UK","US"};
		JComboBox additionalinformationbox = new JComboBox(inital);
		additionalinformationbox.setMaximumRowCount(4);
		additionalinformationbox.setBounds(316, 407, 87, 22);
		MainMenu_admin.add(additionalinformationbox);
		additionalinformationbox.setSelectedItem("UK");
		
		JLabel lblNewLabel_1 = new JLabel("Checkout");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 11, 101, 26);
		Checkout.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Back to Basket");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(contentPane, "Main Menu (Customer)");
			}
		});
		btnNewButton_2.setBounds(10, 482, 120, 23);
		Checkout.add(btnNewButton_2);
		
		JLabel paymentmethod = new JLabel("Credit Card:");
		paymentmethod.setFont(new Font("Gadugi", Font.BOLD, 13));
		paymentmethod.setBounds(10, 120, 134, 14);
		Checkout.add(paymentmethod);
		
		cardnumber = new JTextField();
		cardnumber.setBounds(10, 164, 101, 20);
		Checkout.add(cardnumber);
		cardnumber.setColumns(10);
		
		cvv = new JTextField();
		cvv.setBounds(10, 217, 86, 20);
		Checkout.add(cvv);
		cvv.setColumns(10);
		
		JLabel cardnumber_label = new JLabel("Card Number (6 digits)");
		cardnumber_label.setBounds(10, 145, 160, 14);
		Checkout.add(cardnumber_label);
		
		JLabel cvv_label = new JLabel("CVV (3 digits)");
		cvv_label.setBounds(10, 198, 86, 14);
		Checkout.add(cvv_label);
		
		JLabel paypalemail_label = new JLabel("PayPal Email");
		paypalemail_label.setBounds(10, 145, 134, 14);
		Checkout.add(paypalemail_label);
		paypalemail_label.setVisible(false);
		
		paypalemail = new JTextField();
		paypalemail.setBounds(10, 164, 160, 20);
		Checkout.add(paypalemail);
		paypalemail.setColumns(10);
		paypalemail.setVisible(false);
		
		JToggleButton changepaymethod = new JToggleButton("Change Payment Method");
		changepaymethod.setBounds(10, 48, 200, 23);
		Checkout.add(changepaymethod);
		changepaymethod.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					paymentmethod.setText("Paypal:");
					paypalemail_label.setVisible(true);
					paypalemail.setVisible(true);
					cardnumber_label.setVisible(false); //sets all the related text fields and labels invisible for a credit card payment 
					cardnumber.setVisible(false);
					cardnumber.setText(null);
					cvv_label.setVisible(false);
					cvv.setVisible(false);
					cvv.setText(null);
				}
				else {
					paymentmethod.setText("Credit Card:");
					cardnumber_label.setVisible(true); //sets all the related text fields and labels visible for a credit card payment 
					cardnumber.setVisible(true);
					cvv_label.setVisible(true);
					cvv.setVisible(true);
					paypalemail_label.setVisible(false);
					paypalemail.setVisible(false);
					paypalemail.setText(null);
				}
			}
		});
		
		JButton completecheckout = new JButton("Complete Checkout");
		completecheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User Currentuser = userinfo[MainClass.setcurrentuser(UserIN.getText(), userinfo)];
				double amount = User.basketsum(basket);
				Address useraddress = new Address(Currentuser.getHousenumber(),Currentuser.getPostcode(),Currentuser.getCity());
				if (paymentmethod.getText().equals("Paypal:")) {
					if (paypalemail.getText().contains("@") && paypalemail.getText().indexOf("@") != (0) && paypalemail.getText().indexOf("@") != (paypalemail.getText().length()-1)) {
						Paypal userpaydetails = new Paypal(paypalemail.getText());
						Receipt usersreceipt = userpaydetails.processPayment(amount, useraddress);
						JOptionPane.showMessageDialog(Checkout, usersreceipt);
						//once processed and text file changed then need to update the stock and og stock array lists
						MainClass.writestocktofile(stock);
						ArrayList<Product> temporary; //updates the admin stock view and stock array lists
						ArrayList<Product> temporary2;
						try {
							temporary = MainClass.getinventory();
							temporary2 = MainClass.getinventory(); 
							stock.clear();
							ogstock.clear();
							for (int i = 0;i<temporary.size();i++) {
								stock.add(temporary.get(i));  //resetting the stock and original stock array lists using temporary array lists 
								ogstock.add(temporary2.get(i));
							}
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} 
						basket.clear(); //clears the user basket
						displaybasket.clear();
						DefaultListModel listmodel = new DefaultListModel();  //then updates the basket list shown on the gui
						Basket.setModel(listmodel); 
						cardlayout.show(contentPane,"User Login");
					}
					else {
						JOptionPane.showMessageDialog(Checkout, "Insuffiencet details;\nNeeds to contain and '@' and have at least 1 letter either side");
					}
				}
				else if (paymentmethod.getText().equals("Credit Card:")){
					if (cardnumber.getText().length() == 6 && cvv.getText().length() == 3) {
						try {
							int cardnum = Integer.parseInt(cardnumber.getText());
							int usercvv = Integer.parseInt(cvv.getText());
							Creditcard userpaydetails = new Creditcard(cardnum,usercvv);
							Receipt usersreceipt = userpaydetails.processPayment(amount, useraddress);
							JOptionPane.showMessageDialog(Checkout, usersreceipt);
							//once processed and text file changed then need to update the stock and og stock array lists
							MainClass.writestocktofile(stock);
							ArrayList<Product> temporary; //updates the admin stock view and stock array lists
							ArrayList<Product> temporary2;
							try {
								temporary = MainClass.getinventory();
								temporary2 = MainClass.getinventory(); //resetting the stock and original stock array lists using temporary array lists 
								stock.clear();
								ogstock.clear();
								for (int i = 0;i<temporary.size();i++) {
									stock.add(temporary.get(i));
									ogstock.add(temporary2.get(i));
								}
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} 
							basket.clear(); //clears the user basket 
							displaybasket.clear();
							DefaultListModel listmodel = new DefaultListModel();  //then updates the basket list shown on the gui
							Basket.setModel(listmodel); 
							cardlayout.show(contentPane,"User Login");
							//reset user to either login or customer page, resetting checkout input fields
						} catch (NumberFormatException e1) { //catches error that is given when a user puts in a non integer character (a letter)
							JOptionPane.showMessageDialog(Checkout, "Insuffiencet details;\nCard Number needs to be a 6 digits number\nCVV needs to be a 3 digit number");
						}
					}
					else {
						JOptionPane.showMessageDialog(Checkout, "Insuffiencet details;\nCard Number needs to be a 6 digits number\nCVV needs to be a 3 digit number");
					}
				}
			}
		});
		completecheckout.setBounds(10, 264, 160, 23);
		Checkout.add(completecheckout);
		
		JComboBox newproducttype = new JComboBox();
		newproducttype.setModel(new DefaultComboBoxModel(ProductCategory.values()));
		newproducttype.setBounds(200, 357, 106, 22);
		MainMenu_admin.add(newproducttype);
		newproducttype.setSelectedItem(ProductCategory.KEYBOARD);
		newproducttype.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					if (e.getItem() == ProductCategory.KEYBOARD) {
						newadditionalinfo.setText("Keyboard Layout");
						String[] additionalinfo = {"UK","US"};     //sets the combo boxes based on the type of product (mouse or keyboard)
						additionalinformationbox.removeAllItems();
						for (int i = 0;i<additionalinfo.length;i++) {
							additionalinformationbox.addItem(additionalinfo[i]);
						}
						String[] types = {"Standard","Flexible","Gaming"};
						typebox.removeAllItems();
						for (int i = 0;i<types.length;i++) {
							typebox.addItem(types[i]);
						}
					}
					else if (e.getItem() == ProductCategory.MOUSE) {
						newadditionalinfo.setText("# of Mouse Buttons"); //sets the combo boxes based on the type of product (mouse or keyboard)
						int[] additionalinfo = {1,2,3,4,5,6,7,8,9,10};
						additionalinformationbox.removeAllItems();
						for (int i = 0;i<additionalinfo.length;i++) {
							additionalinformationbox.addItem(additionalinfo[i]);
						}
						String[] types = {"Standard","Gaming"};
						typebox.removeAllItems();
						for (int i = 0;i<types.length;i++) {
							typebox.addItem(types[i]);
						}
					}
				}
				
			}
		});
		
		JButton changeuserA_button = new JButton("Change User");
		changeuserA_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(contentPane,"User Login");
				newbarcode.setText(null);  //resets all add to basket info text fields and combo boxes 
				newbrand.setText(null);
				newcolour.setText(null);
				newstockcount.setText(null);
				newogprice.setText(null);
				newretailprice.setText(null);
				newconnectivitytype.setSelectedItem(ConnectivityType.WIRED);
				additionalinformationbox.setSelectedItem("UK");
				typebox.setSelectedItem("Standard");
				newproducttype.setSelectedItem(ProductCategory.KEYBOARD);
			}
		});
		changeuserA_button.setBounds(10, 482, 120, 23);
		MainMenu_admin.add(changeuserA_button);
		
		
		JButton ADDTOSTOCK = new JButton("Add to Stock");
		ADDTOSTOCK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int barcode = 0;
				int stockcount = 0;
				double ogcost = 0;           //0's and null values just to ensure the variables are initialised
				double retailprice = 0;
				String brand = null;
				String colour = null;
				ProductCategory TypeOfProduct = null;
				ConnectivityType connectivity = null;
				String additionalinfo = null;
				String type = null;
				String infotoadd;
				//..........
				BigDecimal ogprice = null;
				BigDecimal retail = null;
				/*requirements 
				 * BARCODE IT HAS TO BE A 6 DIGIT INTEGER
				 * both prices have to be doubles (in form of currency so max of 2 dp)
				 * stock has to be an integer
				*/
				try {
					ogprice = new BigDecimal (newogprice.getText());
					retail = new BigDecimal (newretailprice.getText()); 
					stockcount = Integer.parseInt(newstockcount.getText());
					//creates variable of big decimals data type so can check that they only have a max of 2dp so that way the prices are in the standard form that all currencies are in
					if (newbarcode.getText().length() == 6 && ogprice.scale() < 3 && retail.scale() < 3 && stockcount>=0) {
						try {
							barcode = Integer.parseInt(newbarcode.getText());
							stockcount = Integer.parseInt(newstockcount.getText());
							ogcost = Double.parseDouble(newogprice.getText());
							retailprice = Double.parseDouble(newretailprice.getText()); //try's to convert all user inputs to their correct data type 
							brand = newbrand.getText();
							colour = newcolour.getText();
							TypeOfProduct = (ProductCategory)(newproducttype.getSelectedItem());
							connectivity = (ConnectivityType)(newconnectivitytype.getSelectedItem());
							additionalinfo = String.valueOf(additionalinformationbox.getSelectedItem());
							type = (String)typebox.getSelectedItem();
							//if statement to check that the barcode isn't already in use as has to be different 
							int barcodeused = 0;
							for (int i = 0;i<stock.size();i++)
								if (barcode == stock.get(i).getBarcode()) { //checks if barcode is in use 
									barcodeused = 1;
									break;
								}
							if (barcodeused == 1){
								JOptionPane.showMessageDialog(MainMenu_admin, "Cannot use this barcode; already assigned to another product");
							}
							else {
								//string below formats the info the the correct way, same as in the stock text file, ready for it to be added 
								infotoadd = ("\n "+(barcode)+", "+(TypeOfProduct.toString().toLowerCase())+", "+(type)+", "+(brand)+", "+(colour)+", "+(connectivity.toString().toLowerCase())+", "+(stockcount)+", "+(ogcost)+", "+(retailprice)+", "+(additionalinfo));
								//the code below adds to the stock text file
								BufferedWriter writetofile = null;
								try {
									writetofile = new BufferedWriter(new FileWriter(new File("Stock.txt"),true)); //adds info to the text file
									writetofile.write(infotoadd);
									writetofile.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								try {
									ArrayList<Product> temporary = MainClass.getinventory(); //updates the admin stock view and stock array lists
									ArrayList<Product> temporary2 = MainClass.getinventory();
									stock.clear();
									ogstock.clear();
									for (int i = 0;i<temporary.size();i++) {
										stock.add(temporary.get(i));
										ogstock.add(temporary2.get(i));
									}
									DefaultListModel listmodel = new DefaultListModel(); //need to reset all fields and auto select the combo boxes once added a new product
									for (int j=0;j<stock.size();j++) {
										listmodel.addElement(stock.get(j).toString(1)); //adds the admin view of stock to the admin stock j-list
									}
									adminstock.setModel(listmodel);
									newconnectivitytype.setSelectedItem(ConnectivityType.WIRED);
									newproducttype.setSelectedItem(ProductCategory.KEYBOARD); //resets the selected values of the combo boxes in case user wants to add another keyboard and doesnt select it
									additionalinformationbox.setSelectedItem("UK");
									typebox.setSelectedItem("Standard");
									newbarcode.setText(null);  //resets all add to basket info text fields and combo boxes 
									newbrand.setText(null);
									newcolour.setText(null);
									newstockcount.setText(null);
									newogprice.setText(null);
									newretailprice.setText(null);
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
							}
						} catch (NumberFormatException e2){
							JOptionPane.showMessageDialog(MainMenu_admin, "Incorrect Product Information;\nBarcode has to be a 6 digit integer\nOrigional Cost and Retail Price must be doubles (maximum of 2 decimal places)\nStock Count must be a positive Integer");
						}
					}
					else {
						JOptionPane.showMessageDialog(MainMenu_admin, "Incorrect Product Information;\nBarcode has to be a 6 digit integer\nOrigional Cost and Retail Price must be doubles (maximum of 2 decimal places)\nStock Count must be a positive Integer");
					}
				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(MainMenu_admin, "Incorrect Product Information;\nBarcode has to be a 6 digit integer\nOrigional Cost and Retail Price must be doubles (maximum of 2 decimal places)\nStock Count must be a positive Integer");
				}
			}
		});
		ADDTOSTOCK.setBounds(575, 484, 139, 23);
		MainMenu_admin.add(ADDTOSTOCK);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, UserLogin, lblNewLabel, lblNewLabel_2, UserIN, btnNewButton, MainMenu_customer, mainmenu_label, changeuser_button, currentuser_label, showcurrentuser, MainMenu_admin, mainmenuA_label, changeuserA_button, currentlogin1, currentusershows1, checkout_button, stocklist, customerstock, addtobasket_button, stock_label, filter_label, applyfilter_button, enterbarcode, filterbarcode_button, entermousebuttons, searchbarcode, basket_label, basketscroll, quantityofitem, quantity_label, Basket, emptybasket_button, adminstock, adminstockview, adminstock_label, addnewproduct_label, newbarcode, newbrand, newproducttype, newcolour, newconnectivitytype, newstockcount, newogprice, newretailprice, producttype_label, connectivity_label, barcode_label, brand_label, colour_label, stockcount_label, lblNewLabel_6, lblNewLabel_7, ADDTOSTOCK, Checkout, lblNewLabel_1, btnNewButton_2, changepaymethod, paymentmethod, cardnumber, cvv, cardnumber_label, cvv_label, paypalemail_label, paypalemail, completecheckout, basketsum, typenew, typebox, newadditionalinfo, additionalinformationbox, userIN, resetstockview}));
	}
}
