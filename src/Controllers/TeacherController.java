package Controllers;

import Models.TeacherModel;
import Models.Student;
import Models.Teacher;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Views.TeacherView;

public class TeacherController extends StandardController{
	
	public TeacherController()
	{
		tableName= "Teachers";
		model = new TeacherModel();
		view = new TeacherView();
	}
	
	public void displayRecords()
	{
	    Teacher t = new Teacher();
	    ResultSet result=  model.select("Teachers");
	   
	    try {
			while(result.next())
			{
				t.f_name = result.getString("f_name");
				t.l_name = result.getString("l_name");
				t.email = result.getString("email");
				t.contact_number = result.getString("contact_number");
				t.address = result.getString("address");

			    view.displayRecords(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateRecord()
	{	
		Teacher t = new Teacher();
		int dec = view.updateRecordMenu();
		ResultSet result = null;
		ArrayList key = new ArrayList();
		ArrayList columnNames = new ArrayList();
		
		switch(dec)
		{
			case 1:
			{
				columnNames.add("teacher_id");
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
		try 
		{
			if(result.next())
			{
				t.f_name = result.getString("f_name");
				t.l_name = result.getString("l_name");
				t.email = result.getString("email");
			    t.contact_number = result.getString("contact_number");
			    t.address = result.getString("address");
			    System.out.println("This is the Record about to be modified");
			    view.displayRecords(t);
			}
			else
			{
				System.out.println("Record not found");
				return;
			}
		ArrayList dataList = new ArrayList();
		dataList = (ArrayList)view.getRecordInput(dataList);
		ArrayList attrList = new ArrayList();
		for(Field field : Teacher.class.getDeclaredFields())
		{
			String[] s = field.toString().split("Teacher.");
			attrList.add(s[1]);
		}
		model.update(tableName, dataList, attrList, columnNames, key );
		} catch (SQLException e) {;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void deleteRecord()
	{
		int dec = view.deleteRecordMenu();
		ArrayList key = new ArrayList();
		ArrayList compareFields = new ArrayList();		if(dec==1)
		{
			key  = view.askIntKey();
			compareFields.add("teacher_id");
			model.Delete(key, compareFields, tableName);
			view.printDeleteRecord1(key);
		}
		else if(dec==2)
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
