package Views;

import java.util.ArrayList;
import java.util.Scanner;
import Models.Course;

public class CourseView extends StandardView
{
	
	public CourseView()
	{
	}
	
	public ArrayList getRecordInput(ArrayList list)
	{
		System.out.println("Enter Course Name");
		list.add(s.nextLine());
		
		return list;
	}
	
	public void displayRecords(Object n)
	{
		Course c = (Course)n;
	//	System.out.print("Course ID = "+c.course_id);
		System.out.println("Course Name = "+c.course_name);
	}
	public ArrayList askIntKey()
	{
		ArrayList key = new ArrayList();
		System.out.println("please enter Course's Id");
		key.add(s.nextInt());
		s.nextLine();
		return key;
	}
	
	public ArrayList askStringKey()
	{
		ArrayList key = new ArrayList();
		System.out.println("please enter Course Name");
		key.add(s.nextLine());
		return key;
	}
	
	public void printDeleteRecord1(ArrayList key)
	{
		System.out.println("The record with ID: "+key.get(0)+ " has been deleted");
	}
	public void printDeleteRecord2(ArrayList key)
	{
		System.out.println("The record with Course Name: "+key.get(0)+ " has been deleted");
	}
	public int mainMenu()
	{
		System.out.println("COURSES PAGE \n\n"
				+ "Press a key to proceed \n"
				+ "1- Show all Courses Records \n"
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
		System.out.println("1- Delete by Course_ID");
		System.out.println("2- Delete by Course_Name");
		System.out.println("Any Key to Return");
		
		int dec;
		dec = s.nextInt();
		s.nextLine();
		
		return dec;
	}
}
