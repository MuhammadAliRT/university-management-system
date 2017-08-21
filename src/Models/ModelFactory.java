package Models;

public class ModelFactory {
	
	public StandardModel getInstance(String typeName)
	{
		if(typeName.equals("Student"))
		{
			return new StudentModel(); 
		} 
		else if(typeName.equals("Teacher"))
		{
			return new TeacherModel(); 
		}
		else if(typeName.equals("Courses"))
		{
			return new CourseModel(); 
		}
		else if(typeName.equals("StudentsCourses"))
		{
			return new StudentsCoursesModel(); 
		}
		else if(typeName.equals("TeachersCourses"))
		{
			return new TeachersCoursesModel(); 
		}
		
		return null;
	}

}
