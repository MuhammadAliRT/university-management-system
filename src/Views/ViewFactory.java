package Views;

import Models.CourseModel;
import Models.StudentModel;
import Models.StudentsCoursesModel;
import Models.TeacherModel;
import Models.TeachersCoursesModel;

public class ViewFactory {
	
	public StandardView getInstance(String typeName)
	{
		if(typeName.equals("Student"))
		{
			return new StudentView(); 
		} 
		else if(typeName.equals("Teacher"))
		{
			return new TeacherView(); 
		}
		else if(typeName.equals("Courses"))
		{
			return new CourseView(); 
		}
		else if(typeName.equals("StudentsCourses"))
		{
			return new StudentsCoursesView(); 
		}
		else if(typeName.equals("TeachersCourses"))
		{
			return new TeachersCoursesView(); 
		}
		
		return null;	
	}
}
