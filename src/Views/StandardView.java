package Views;

import java.util.ArrayList;
import java.util.Scanner;
import Models.*;
public abstract class StandardView {

	Scanner s;
	
	public StandardView()
	{
		s = new Scanner ( System.in ); 
	}
	
	public int updateRecordMenu()
	{
		System.out.println("UPDATE RECORD MENU\n "
				+ "Please select from the menu \n"
				+ "1- Update by ID \n"
				+ "2- Update by Name \n" 
				+ "3- Go back");
		
		int dec;
		dec = s.nextInt();
		s.nextLine();
		
		return dec;
	}
	
	public abstract Object getRecordInput(ArrayList list);
	public abstract int deleteRecordMenu();
	public abstract void displayRecords(Object n);
	public abstract ArrayList askIntKey();
	public abstract ArrayList askStringKey();
	public abstract void printDeleteRecord1(ArrayList key);
	public abstract void printDeleteRecord2(ArrayList key);
	public abstract int mainMenu();
}
