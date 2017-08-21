package Controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import Views.StartView;

public class ControllerFactory 
{
	private interface Factory
	{
		StandardController create();
	}
	
	private static final Map<String, Factory> factoryMap =Collections.unmodifiableMap(new HashMap<String, Factory>()
	{{
		put("Student", new Factory(){ public StandardController create() { return new StudentController();}});
		put("Teacher", new Factory(){ public StandardController create() { return new TeacherController();}});
		put("Courses", new Factory(){ public StandardController create() { return new CourseController();}});
		put("StudentsCourses", new Factory(){ public StandardController create() { return new StudentsCoursesController();}});
		put("TeachersCourses", new Factory(){ public StandardController create() { return new TeachersCoursesController();}});

	}});
	
	public static StandardController getInstance()
	{
		String typeName = StartView.startMenu();
		System.out.println();

		Factory fact = factoryMap.get(typeName);
		
		if(fact!=null)
		{
			return fact.create();
		}
		
		return null;
	}

}

