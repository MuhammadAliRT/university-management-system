package Models;
import java.sql.*;
import java.util.ArrayList;
public class TeachersCoursesModel extends StandardModel{
	
	public TeachersCoursesModel()
	{

	}
	public int checkIfExists(Object n)
	{
		TeachersCourses tc = (TeachersCourses)n;
		connect();
		if(connected)
		{
			try
			{
				stmt = conn.createStatement();
				String sql = "SELECT * FROM Teachers_Courses WHERE teacher_id = "+tc.teacher_id+" AND course_id = "+tc.course_id+";";
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
				String sql = "SELECT Teachers.teacher_id, Teachers.f_name, Courses.course_id, Courses.course_name FROM Teachers_Courses JOIN Teachers ON ( Teachers_Courses.teacher_id = Teachers.teacher_id )  JOIN Courses ON ( Teachers_Courses.course_id = Courses.course_id ) ORDER BY Teachers.teacher_id; ";
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
				String sql = "SELECT * FROM Teachers_Courses WHERE teacher_id = " +key.get(0)+" AND course_id = " +key.get(1)+";";
				ResultSet result = stmt.executeQuery(sql);

				if(result.next())
				{

					sql = "SELECT Teachers.teacher_id, Teachers.f_name, Courses.course_id, Courses.course_name FROM Teachers, Courses WHERE Teachers.teacher_id = "+key.get(0)+" AND Courses.course_id ="+key.get(1)+";";
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
	
	public ResultSet findRecord(String[] key)
	{
		return null;
	}
}
