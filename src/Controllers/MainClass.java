package Controllers;

public class MainClass {
	
	public static StandardController obj;
	public static void main(String [] args)
	{
		obj = ControllerFactory.getInstance();
		obj.mainPage();
	}
}


