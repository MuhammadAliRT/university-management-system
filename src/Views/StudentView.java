package Views;

import java.util.ArrayList;
import java.util.Scanner;
import Models.Student;

public class StudentView extends StandardView
{
	public StudentView()
	{

	}
	public ArrayList getRecordInput(ArrayList list)
	{
		System.out.println("Enter First Name: ");
		list.add(s.nextLine());
		System.out.println("Enter Last Name: ");
		list.add(s.nextLine());
		list.add(null);
		System.out.println("Enter Email: ");
		list.add(s.nextLine());
		System.out.println("Enter Contact Number: ");
		list.add(s.nextLine());
		System.out.println("Enter Address: ");
		list.add(s.nextLine());
		System.out.println("Enter Major: ");
		list.add(s.nextLine());
		
		return list;
	}
	
	public void displayRecords(Object n)
	{
		Student s = (Student)n;
	    System.out.print("FirstName: " + s.f_name);
	    System.out.print(", LastName: " + s.l_name);
	    System.out.print(", Email: " + s.email);
	    System.out.println(", ContactNumber: " + s.contact_number);
	    System.out.print(", Address: " + s.address);
	    System.out.println(", Major: " + s.major);
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
	
	public ArrayList askIntKey()
	{
		ArrayList key = new ArrayList();
		System.out.println("please enter Student Id");
		key.add(s.nextInt());
		s.nextLine();
		return key;
	}
	public ArrayList askStringKey()
	{
		ArrayList key = new ArrayList();
		System.out.println("please enter Student's First Name");
		key.add(s.nextLine());
		
		System.out.println("please enter Student's Last Name");
		key.add(s.nextLine());		
		return key;
	}
	public void printDeleteRecord1(ArrayList key)
	{
		System.out.println("The record with ID: "+key.get(0)+ " has been deleted");
	}
	public void printDeleteRecord2(ArrayList key)
	{
		System.out.println("The record with Student's Name: "+key.get(0)+ " " +key.get(1) + " has been deleted");
	}
	public int mainMenu()
	{
		System.out.println("STUDENTS PAGE \n\n"
				+ "Press a key to proceed \n"
				+ "1- Show all Student Records \n"
				+ "2- Insert a new Record \n"
				+ "3- Update a Record \n"
				+ "4- Delete a Record\n");
		int dec = s.nextInt();
		s.nextLine();
		return dec;
	}
}
