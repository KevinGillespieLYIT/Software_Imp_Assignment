package ie.lyit.serialize;

import java.util.Scanner;

public class Menu {
	
	public int option;
	
	//Will display a console menu for selecting function and displaying customers array
	public void display()
	{
		System.out.println("\t1. Add");
		System.out.println("\t2. List");
		System.out.println("\t3. View");
		System.out.println("\t4. Edit");
		System.out.println("\t5. Delete");
		System.out.println("\t6. Quit");
		
	}
	
	//read user keyboard input
	public void readOption()
	{
		Scanner kbInt = new Scanner(System.in);
		System.out.println("\n\tEnter Option {1|2|3|4|5|6}");
		option = kbInt.nextInt();
	}
	
	public int getOption()
	{
		return option;
	}

}