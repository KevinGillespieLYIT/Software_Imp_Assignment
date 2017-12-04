package ie.lyit.hotel;

import java.io.*;
import javax.swing.*;

public class Customer extends Person implements Serializable{//Must implement Serializable
// INHERITANCE - Customer IS-A Person
	// Customer has name, address, & phoneNumber from Person
	private String emailAddress;    // AND emailAddress
	private int number;			    // AND number

	private static int nextNumber=1;// static for unique number - starts off at 1
	
	// Default Constructor
	// Called when object is created like this ==> 
	//   Customer cObj = new Customer();	
	public Customer(){
		super();			// NOTE:Don't need to call super() explicitly.
		emailAddress=null;
		// Set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}
	
	// Initialization Constructor
	// Called when object is created like this ==>
	// Customer cObj = new Customer("Mr","Joe","Doe","12 Hi Rd,Letterkenny",
	//                              "0871234567","joe@hotmail.com");
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialise Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return number + ": " + super.toString() + "," + emailAddress;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(c1.equals(c2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Customer cObject;
		if (obj instanceof Customer)
		   cObject = (Customer)obj;
		else
		   return false;
		   
	    return(this.number==cObject.number);
	}

	// set() and get() methods
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	public String getEmailAddress(){
		return this.emailAddress;
	}	
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	// Providing next customer with highest value next requires setNumber() method!!
	
	
	//To increment customer number needed a setNumber() method
	public void setNumber(int lastValue) {
		number = lastValue;
	}
	public int getNumber(){
		return number;
	}	
	
	//read() method builds GUI to allow user to enter customer details
	public void read() 
	{
		JTextField txtCustNumber = new JTextField();
		txtCustNumber.setText("" + this.number);
		JTextField txtTitle = new JTextField();
		JTextField txtFName = new JTextField();
		JTextField txtSName = new JTextField();
		JTextField txtAddress = new JTextField();
		JTextField txtPNo = new JTextField();
		JTextField txtEmail = new JTextField();
		
		//should bring GUI to front (note: only works after 2nd method which generates GUI is called)
		txtTitle.requestFocus();

		
		Object[] message = { "Customer Number: ", txtCustNumber,
				"Title: ", txtTitle,
				"First Name: ", txtFName,
				"Surname: ", txtSName,
				"Address: " , txtAddress,
				"Phone Number: ", txtPNo,
				"Email Address: ", txtEmail };
		
		int option = JOptionPane.showConfirmDialog(null, message, "Enter Customer Details", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION)
		{
			//Builds name of customer here
			Name n = new Name(txtTitle.getText(), txtFName.getText(), txtSName.getText());
			this.name = n;
			this.address = txtAddress.getText();
			this.phoneNumber = txtPNo.getText();
			this.emailAddress = txtEmail.getText();
				
		}
	}
	
}

