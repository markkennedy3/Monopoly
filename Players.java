
public class Players {//Players class

	//Variables associated with players
public static int position;
public static int balance;
public String name;
public Properties[] propertyArray = new Properties[40];
	
	Players()
	{
		balance = 1500;//Assigning the balance to 1500 for each player
		
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
	
	
	public void move (int squares) {
		position = position + squares;
		if (position < 0) {
			position = position + monopoly.NUM_OF_SQUARES;
		} else if (position >= monopoly.NUM_OF_SQUARES) {
			position = position % monopoly.NUM_OF_SQUARES;
		}
		return;
	}
	
	public static int getPosition () {
		return position;
	}
	
}



