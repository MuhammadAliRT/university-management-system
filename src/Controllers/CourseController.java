package Controllers;

import Models.CourseModel;
import Models.Student;
import Models.Course;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

import Views.CourseView;

public class CourseController extends StandardController
{
	public CourseController()
	{
		tableName = "Courses";
		model = new CourseModel();
		view = new CourseView();
	}
	
	public void displayRecords()
	{
	    
	    ResultSet result=  model.select("Courses");
	   Course c = new Course();
	    try 
	    {
			while(result.next())
			{
				c.course_name = result.getString("course_name");
				
				view.displayRecords(c);
			}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateRecord()
	{	
		Course c = new Course();
		int dec = view.updateRecordMenu();
		ResultSet result = null;
		ArrayList key = new ArrayList();
		ArrayList columnNames = new ArrayList();
		
		switch(dec)
		{
			case 1:
			{
				columnNames.add("course_id");
				key = view.askIntKey();
				result = model.findRecord(key, columnNames, tableName);
				break;
			}
			case 2:
			{
				columnNames.add("course_name");
				key= view.askStringKey();
				result = model.findRecord(key, columnNames, tableName);
				break;
			}
			case 3:
			{
				mainPage();
				return;
			}
		}
		
		try
		{
			if(result.next())
			{
				c.course_name = result.getString("course_name");
				System.out.println("This is the record about to be updated: ");
				view.displayRecords(c);
			}
			else
			{
				System.out.println("Record not found");
				return;
			}
			ArrayList dataList = new ArrayList();
			dataList = (ArrayList) view.getRecordInput(dataList);
			ArrayList attrList = new ArrayList();
			for(Field field : Course.class.getDeclaredFields())
			{
				String[] s = field.toString().split("Course.");
				attrList.add(s[1]);
			}
			model.update(tableName, dataList, attrList, columnNames, key );
		}
			catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void deleteRecord()
	{
		int dec = view.deleteRecordMenu();
		ArrayList key = new ArrayList();
		ArrayList compareFields = new ArrayList();	
		
		if(dec==1)
		{
			key  = view.askIntKey();
			compareFields.add("course_id");
			model.Delete(key, compareFields, tableName);
			view.printDeleteRecord1(key);
		}
		else if(dec==2)
		{
			key = view.askStringKey();
			compareFields.add("course_name");
			model.Delete(key, compareFields, tableName);
			view.printDeleteRecord2(key);
		}
		else
		{
			mainPage();
		}
		
	}
	
}
