package ie.lyit.testers;

import ie.lyit.serialize.*;
import java.util.*;

public class CustomerSerializerTester {
	
	public static void main(String[]args)
	{
		CustomerSerializer custSerializer = new CustomerSerializer();
		
		// read array list that was already present in file
		custSerializer.readRecordsFromFile();
		
		//Build new console menu
		Menu custMenu = new Menu();
		
		// Use Option to decide what method to run
		do
		{
			try {
				custMenu.display();
				
				custMenu.readOption();
				
				switch(custMenu.getOption())
				{
				case 1: custSerializer.add();
				break;
				case 2: custSerializer.list();
				break;
				case 3: custSerializer.view();
				break;
				case 4: custSerializer.edit();
				break;
				case 5: custSerializer.delete();
				break;
				case 6: break;
				default: System.out.println("Invalid Option: Please try again");
				}
			}
			catch(InputMismatchException iME) {
				System.out.println("Incorrect input received: Please try again.");
			}
			}while(custMenu.getOption() != 6);
		
		
		//Write new array list to file
		custSerializer.writeRecordsToFile();
		
		custSerializer.readRecordsFromFile();
	}

}
