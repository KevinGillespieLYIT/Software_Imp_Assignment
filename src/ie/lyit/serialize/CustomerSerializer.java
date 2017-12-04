package ie.lyit.serialize;
import java.io.*;
import ie.lyit.hotel.*;
import java.util.*;

public class CustomerSerializer implements CustomerDao {
	
	final String FILENAME = "customers.bin";
	
	ArrayList<Customer> customers;
	
	public CustomerSerializer() {
		customers = new ArrayList<Customer>();
	}
	
	@Override
	public void add() {
		Customer customer = new Customer();
		
		//Set customer number to last number found in ArrayList
		if(customers.size() > 0) {
			customer.setNumber(customers.get(customers.size()).getNumber());
		}
		customer.read();
		
		customers.add(customer);
	
	}
	
	@Override
	public Customer view() {

			Scanner keyboard = new Scanner(System.in);
			System.out.println("ENTER CUSTOMER NUMBER: ");
			int customerToView = keyboard.nextInt();
			
			for (Customer tmpCust:customers) {
				if(tmpCust.getNumber()==customerToView) {
					System.out.println(tmpCust);
					return tmpCust;
				}
				

			}
			return null;
	}
	
	@Override
	public void list() {
		for(Customer tmpCust:customers)
			System.out.println(tmpCust);
	}
	
	@Override
	public void edit() {
		Customer tmpCust = view();
		
		if(tmpCust != null) {
			int index=customers.indexOf(tmpCust);
			tmpCust.read();
			customers.set(index, tmpCust);
			}
		
	}
	
	@Override
	public void delete() {
		Customer tmpCust = view();
		
		if (tmpCust != null)
			customers.remove(tmpCust);
		
	}
	
	public void writeRecordsToFile(){
			try{
				FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
				ObjectOutputStream os = new ObjectOutputStream(fileStream);
		
				os.writeObject(customers);
				
				os.close();
				fileStream.close();

					}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store customers.");
			}
			catch(IOException ioe){
				System.out.println(ioe.getMessage());
			}
		
	}
	
	
	public void readRecordsFromFile(){
		try{
			FileInputStream fis = new FileInputStream(FILENAME);
			
			ObjectInputStream os = new ObjectInputStream(fis);
				
			customers = (ArrayList<Customer>)os.readObject();
						
			os.close();
			fis.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot find customers file. Will attempt to write file once user has completed input.");
		}
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}	

}
