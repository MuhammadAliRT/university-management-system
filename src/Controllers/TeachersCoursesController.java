package Controllers;

import Models.Student;
import Models.StudentsCourses;
import Models.TeachersCourses;
import Models.TeachersCoursesModel;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

import Views.TeachersCoursesView;

public class TeachersCoursesController extends StandardController
{
	public TeachersCoursesController()
	{
		tableName = "Teachers_Courses";
		model = new TeachersCoursesModel();
		view = new TeachersCoursesView();
	}
	
	
	public void displayRecords()
	{
		ResultSet result = model.select("Teachers_Courses");
		TeachersCourses tc = new TeachersCourses();
		try
		{
			while(result.next())
			{
				tc.teacher_id = result.getInt("teacher_id");
				tc.teacher_name= result.getString("f_name");
				tc.course_id =  result.getInt("course_id");
				tc.course_name = result.getString("course_name");
				
				view.displayRecords(tc);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateRecord()
	{				
		TeachersCourses tc = new TeachersCourses();
		ArrayList columnNames = new ArrayList();
		columnNames.add("teacher_id");
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
					tc.teacher_id = result.getInt("teacher_id");
					tc.teacher_name = result.getString("f_name");
					tc.course_id = result.getInt("course_id");
					tc.course_name = result.getString("course_name");
					System.out.println("This record is about to be modified: ");
					view.displayRecords(tc);
				}
				ArrayList dataList = new ArrayList();
				dataList = (ArrayList) view.getRecordInput(dataList);
				ArrayList attrList = new ArrayList();
				attrList.add("teacher_id");
				attrList.add("course_id");
				
				//				for(Field field : TeachersCourses.class.getDeclaredFields())
//				{
//					String[] s = field.toString().split("TeachersCourses.");
//					attrList.add(s[1]);
//				}
				model.update(tableName, dataList, attrList, columnNames, key );
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteRecord()
	{
		ArrayList key = new ArrayList();
		ArrayList compareFields = new ArrayList();	
		key = view.askIntKey();
		compareFields.add("teacher_id");
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
