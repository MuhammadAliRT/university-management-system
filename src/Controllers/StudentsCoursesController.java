package Controllers;

import Models.StudentsCourses; 
import Models.StudentsCoursesModel;
import Models.TeachersCourses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.reflect.Field;
import java.sql.*;
import Views.StudentsCoursesView;

public class StudentsCoursesController extends StandardController
{	
	public StudentsCoursesController()
	{
		tableName = "Students_Courses";
		model = new StudentsCoursesModel();
		view = new StudentsCoursesView();
	}

	
	public void displayRecords()
	{
		ResultSet result = model.select("Students_Courses");
		StudentsCourses sc = new StudentsCourses();
		try
		{
			while(result.next())
			{
				sc.student_id = result.getInt("student_id");
				sc.student_name= result.getString("f_name");
				sc.course_id =  result.getInt("course_id");
				sc.course_name = result.getString("course_name");
				
				view.displayRecords(sc);
			}
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void updateRecord()
	{
		StudentsCourses sc = new StudentsCourses();
		ArrayList columnNames = new ArrayList();
		columnNames.add("student_id");
		columnNames.add("course_id");
		ArrayList key = new ArrayList();

		key = view.askIntKey();
		ResultSet result = model.findRecord(key, columnNames, tableName);
		
		if(result!=null)
		{
			try
			{
				while(result.next())
				{
					sc.student_id = result.getInt("student_id");
					sc.student_name = result.getString("f_name");
					sc.course_id = result.getInt("course_id");
					sc.course_name = result.getString("course_name");
					System.out.println("This record is about to be modified: ");
					view.displayRecords(sc);
				}
				ArrayList dataList = new ArrayList();
				dataList = (ArrayList) view.getRecordInput(dataList);
				ArrayList attrList = new ArrayList();
				attrList.add("student_id");
				attrList.add("course_id");
//				for(Field field : StudentsCourses.class.getDeclaredFields())
//				{
//					String[] s = field.toString().split("StudentsCourses.");
//					attrList.add(s[1]);
//				}
				model.update(tableName, dataList, attrList, columnNames, key );
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Record Not Found");
		}
	}
	public void deleteRecord()
	{
		ArrayList key = new ArrayList();
		ArrayList compareFields = new ArrayList();	
		
		key = view.askIntKey();
		compareFields.add("student_id");
		compareFields.add("course_id");
		int isDeleted = model.Delete(key, compareFields, tableName);
		if(isDeleted==1)
		{
			view.printDeleteRecord1(key);
		}
		else
		{
			System.out.println("Record Not Found");
		}	
	}
}
