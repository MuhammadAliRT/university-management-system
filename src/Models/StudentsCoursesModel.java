package Models;

import java.sql.*;
import java.util.ArrayList;

public class StudentsCoursesModel extends StandardModel
{
	public StudentsCoursesModel()
	{

	}
	
	public int checkIfExists(Object n)
	{
		StudentsCourses sc = (StudentsCourses)n;
		connect();
		if(connected)
		{
			try
			{
				stmt = conn.createStatement();
				String sql = "SELECT * FROM Students_Courses WHERE student_id = "+sc.student_id+" AND course_id = "+sc.course_id+";";
				ResultSet i = stmt.executeQuery(sql);
				
				if(i.next())
				{
					return 1;
				}
				else
				{
					return 0;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return 0;
	}
	
	public ResultSet select(String tableName)
	{
		connect();
		if(connected)
		{
			try 
			{
				stmt = conn.createStatement();
				String sql = "SELECT Students.student_id, Students.f_name, Courses.course_id, Courses.course_name FROM Students_Courses JOIN Students ON ( Students_Courses.student_id = Students.student_id )  JOIN Courses ON ( Students_Courses.course_id = Courses.course_id ) ORDER BY Students.student_id; ";
				ResultSet result = stmt.executeQuery(sql);
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			close();
		}
		return null;
	}
	
	public ResultSet findRecord(ArrayList key, ArrayList columnNames, String tableName)
	{
		connect();
		if(connected)
		{
			try {
				
				stmt = conn.createStatement();
				String sql = "SELECT * FROM Students_Courses WHERE student_id = " +key.get(0)+" AND course_id = " +key.get(1)+";";
				ResultSet result = stmt.executeQuery(sql);

				if(result.next())
				{

					sql = "SELECT Students.student_id, Students.f_name, Courses.course_id, Courses.course_name FROM Students, Courses WHERE Students.student_id = "+key.get(0)+" AND Courses.course_id ="+key.get(1)+";";
					ResultSet r1 = stmt.executeQuery(sql);

					return r1;
				}
				else
				{
					System.out.println("Record not found");
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			close();
		}
		return null;
	}			
}
