package Controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import Views.StartView;

public class ControllerFactory 
{
	public static StandardController getInstance()
	{
		String typeName = StartView.startMenu();
		System.out.println();

		Class<?> classType;
		try {
			classType = Class.forName(typeName);
			Object obj = classType.newInstance();
			StandardController controllerObj = (StandardController)obj;
			return controllerObj;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}


