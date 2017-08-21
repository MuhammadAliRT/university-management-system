package Models;

public class DbVariables {
	
	private static String reg = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/UniversityDB";
	private static String user = "root";
	private static String pw = "123";
	
	public static String getUrl()
	{
		return url;
	}
	public static String getUser()
	{
		return user;
	}
	public static String getPassword()
	{
		return pw;
	}
	public static String getReg()
	{
		return reg;
	}
	
}
