package Controllers;
import Models.*;
import Views.*;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class StandardController 
{
	public String tableName;
	Scanner s;
	public StandardModel model;
	public StandardView view;
	
	public StandardController()
	{
		s = new Scanner ( System.in ); 
	}
	
	public void mainPage()
	{
		int dec = view.mainMenu();
		switch(dec)
		{
			case 1:
			{
				displayRecords();
				break;
			}
			case 2:
			{
				insert(tableName);
				break;
			}
			case 3:
			{
				updateRecord();
				break;
			}
			case 4:
			{
				deleteRecord();
				break;
			}

		}
		mainPage();
	}
	
	public void insert(String tableName)
	{  
		ArrayList list = new ArrayList(); 
		if((tableName.equals("Students"))||(tableName.equals("Teachers"))||(tableName.equals("Courses")))
			list.add(0);
		list = (ArrayList)view.getRecordInput(list);
		model.insertRecord(list, tableName);
	}
	
	public abstract void displayRecords();
	public abstract void updateRecord();
	public abstract void deleteRecord();
		
}
