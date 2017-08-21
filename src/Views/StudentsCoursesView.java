package Views;

import java.util.ArrayList;
import java.util.Scanner;

import Models.StudentsCourses;

public class StudentsCoursesView extends StandardView
{
	
	public StudentsCoursesView()
	{
		
	}
	public ArrayList getRecordInput(ArrayList list)
	{
		System.out.println("Enter Student ID");
		list.add(s.nextInt());
		System.out.println("Enter Course ID");
		list.add(s.nextInt());
		s.nextLine();
		
		return list;
	}
	public int deleteRecordMenu()
	{
		return 0;
	}
	public void displayRecords(Object n)
	{
		StudentsCourses sc = (StudentsCourses)n;
		System.out.print("Student ID = "+sc.student_id);
		System.out.print(", Student Name = "+sc.student_name);
		System.out.print(", Course ID = "+sc.course_id);
		System.out.println(", Course Name = "+sc.course_name);
	}
	public ArrayList askIntKey()
	{
		ArrayList key = new ArrayList();
		System.out.println("please enter Student's Id");
		key.add(s.nextInt());
		System.out.println("please enter Course's Id");
		key.add(s.nextInt());
		s.nextLine();
		
		
		return key;
	}
	
	public ArrayList askStringKey()
	{
		return null;
	}
	public void printDeleteRecord1(ArrayList key)
	{
		System.out.println("The record with Student ID: "+key.get(0)+ " and Course ID: "+key.get(0)+"has been deleted");
	}
	public void printDeleteRecord2(ArrayList key)
	{
		
	}
	public int mainMenu()
	{
		System.out.println("STUDENTS_COURSES PAGE \n\n"
				+ "Press a key to proceed \n"
				+ "1- Show all Records \n"
				+ "2- Insert a new Record \n"
				+ "3- Update a Record \n"
				+ "4- Delete a Record\n");
		int dec = s.nextInt();
		s.nextLine();
		return dec;
	}
}
