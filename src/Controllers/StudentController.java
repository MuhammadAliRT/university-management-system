package Controllers;

import Models.*;
import Models.Student;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Views.StudentView;

public class StudentController extends StandardController
{

	
	public StudentController()
	{
		tableName = "Students";
		model = new StudentModel();
		view = new StudentView();
	}
	
	public void insert()
	{  
		ArrayList list = new ArrayList(); 
		list = (ArrayList)view.getRecordInput(list);
		model.insertRecord(list, "Students");
	}
	
	public void displayRecords()
	{
	    Student s = new Student();
	    ResultSet result=  model.select("Students");
	   
	    try {
			while(result.next())
			{
				s.f_name = result.getString("f_name");
				s.l_name = result.getString("l_name");
				s.email = result.getString("email");
				s.contact_number = result.getString("contact_number");
				s.address = result.getString("address");
				s.major = result.getString("major");

			    view.displayRecords(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateRecord()
	{
		Student st = new Student();
		int dec = view.updateRecordMenu();
		ResultSet result = null;
		ArrayList key = new ArrayList();
		ArrayList columnNames = new ArrayList();

		switch(dec)
		{
			case 1:
			{
				columnNames.add("student_id");
				key = view.askIntKey();
				result = model.findRecord(key, columnNames, tableName);
				break;

			}
			case 2:
			{
				columnNames.add("f_name");
				columnNames.add("l_name");
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
		
		try {

			if(result.next())
			{
				st.f_name = result.getString("f_name");
				st.l_name = result.getString("l_name");
			    st.email = result.getString("email");
			    st.contact_number = result.getString("contact_number");
			    st.address = result.getString("address");
			    st.major = result.getString("major");
			    
			    System.out.println("This is the Record about to be modified");
			    view.displayRecords(st);
			}
			else
			{
				System.out.println("Record not found");
				return;
			}
			ArrayList dataList = new ArrayList();
			dataList = (ArrayList) view.getRecordInput(dataList);
			ArrayList attrList = new ArrayList();
			for(Field field : Student.class.getDeclaredFields())
			{
				String[] s = field.toString().split("Student.");
				attrList.add(s[1]);
			}
	
			
			model.update(tableName, dataList, attrList, columnNames, key );
			
		} 	catch (SQLException e) {
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
			compareFields.add("student_id");
			model.Delete(key, compareFields, tableName);
			view.printDeleteRecord1(key);
		}
		else if(dec == 2)
		{
			key = view.askStringKey();
			compareFields.add("f_name");
			compareFields.add("l_name");
			model.Delete(key, compareFields, tableName);
			view.printDeleteRecord2(key);
		}
		else
		{
			mainPage();
		}
	}
}
