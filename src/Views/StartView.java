package Views;
import java.util.Scanner;
public class StartView {
	public static String startMenu()
	{
		System.out.println("Main Menu \n\n Please Select from the menu:" );
		System.out.println("1 for Students Page");
		System.out.println("2 for Teachers Page");
		System.out.println("3 for Courses Page");
		System.out.println("4 for Students-Courses Page");
		System.out.println("5 for Teachers-Courses Page");

		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		
		switch(input)
		{
			case 1:
			{
				return "Controllers.StudentController";
			}
			case 2:
			{
				return "Controllers.TeacherController";
			}
			case 3:
			{
				return "Controllers.CourseController";
			}
			case 4:
			{
				return "Controllers.StudentsCoursesController";
			}
			case 5:
			{
				return "Controllers.TeachersCoursesController";
			}
		}
		return "";
	}
}
