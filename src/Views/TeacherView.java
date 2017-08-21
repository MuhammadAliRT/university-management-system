package Views;

import java.util.ArrayList;

import Models.Teacher;

public class TeacherView extends StandardView
{
	
	public TeacherView()
	{
	}
	
	public ArrayList getRecordInput(ArrayList list)
	{
		System.out.println("Enter First Name: ");
		list.add(s.nextLine());
		System.out.println("Enter Last Name: ");
		list.add(s.nextLine());
		System.out.println("Enter Email: ");
		list.add(s.nextLine());
		list.add(null);
		System.out.println("Enter Contact Number: ");
		list.add(s.nextLine());
		System.out.println("Enter Address: ");
		list.add(s.nextLine());
		
		
		return list;
	}
	
	public void displayRecords(Object n)
	{
		Teacher t = (Teacher)n;
	    System.out.print("FirstName: " + t.f_name);
	    System.out.print(", LastName: " + t.l_name);
	    System.out.print(", Email: " + t.email);
	    System.out.print(", ContactNumber: " + t.contact_number);
	    System.out.println(", Address: " + t.address);
	}
	public ArrayList askIntKey()
	{
		ArrayList key = new ArrayList();
		System.out.println("please enter Teacher's Id");
		key.add(s.nextInt());
		s.nextLine();
		return key;
	}
	public ArrayList askStringKey()
	{
		ArrayList key = new ArrayList();
		System.out.println("please enter Teacher's First Name");
		key.add(s.nextLine());
		
		System.out.println("please enter Teacher's Last Name");
		key.add(s.nextLine());
		return key;
	}
	public void printDeleteRecord1(ArrayList key)
	{
		System.out.println("The record with ID: "+key.get(0)+ " has been deleted");
	}
	public void printDeleteRecord2(ArrayList key)
	{
		System.out.println("The record with Teacher's Name: "+key.get(0)+ " " + key.get(1) + " has been deleted");
	}
	public int mainMenu()
	{
		System.out.println("TEACHERS PAGE \n\n"
				+ "Press a key to proceed \n"
				+ "1- Show all Teachers Records \n"
				+ "2- Insert a new Record \n"
				+ "3- Update a Record \n"
				+ "4- Delete a Record\n");
		int dec = s.nextInt();
		s.nextLine();
		return dec;
	}
	public int deleteRecordMenu()
	{
		System.out.println("DELETE RECORD");
		System.out.println("Please select from the menu");
		System.out.println("1- Delete by ID");
		System.out.println("2- Delete by Name");
		System.out.println("Any Key to Return");

		
		int dec;
		dec = s.nextInt();
		s.nextLine();
		
		return dec;
	}
	
}
