
public class Players {

private static int position;
public static int balance;
public String name;
public Properties[] propertyArray = new Properties[40];
	
	Players()
	{
		balance = 1500;
		
	}

	public static int getBalance()
	
	{
		System.out.println(balance);
		return balance;
	}
	
	/*public static String getName()
	{
	return name;
	}*/
	
	public void getProperties()
	{
		
	}
}

