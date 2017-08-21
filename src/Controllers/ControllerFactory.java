package Controllers;

import Views.StartView;

public class ControllerFactory 
{
	public static StandardController getInstance()
	{
		String typeName = StartView.startMenu();
		System.out.println();
		if(typeName.equals("Student"))
		{
			return new StudentController(); 
		} 
		else if(typeName.equals("Teacher"))
		{
			return new TeacherController(); 
		}
		else if(typeName.equals("Courses"))
		{
			return new CourseController(); 
		}
		else if(typeName.equals("StudentsCourses"))
		{
			return new StudentsCoursesController(); 
		}
		else if(typeName.equals("TeachersCourses"))
		{
			return new TeachersCoursesController(); 
		}
		return null;
	}

}
