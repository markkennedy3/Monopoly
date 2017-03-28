import java.util.ArrayList;

@SuppressWarnings("unused")
public class Player {
	
	private String name;
	private int position;
	private int balance;
	private int amount;
	private String token;
	private boolean passedGo;
	private ArrayList<Property> properties = new ArrayList<Property>();//Array list for propertys
	private ArrayList<Property> houses = new ArrayList<Property>();//array list for houses
	private ArrayList<Property> hotels = new ArrayList<Property>();//array list for hotels
	private ArrayList<Property> developedProperties = new ArrayList<Property>();//array list for propertys with houses
	private ArrayList<Property> developedProperties2 = new ArrayList<Property>();//array list for propertys with hotels
	private ArrayList<Property> mortgagedProperties = new ArrayList<Property>();//array list for mortgaged propertys
	
	
	Player (String name, String token) {
		this.name = name;
		this.token = token;
		position = 0;
		balance = 0;
		passedGo = false;
		return;
	}
	
	public void move (int squares) {
		position = position + squares;
		if (position >= Board.NUM_SQUARES) {
			position = position - Board.NUM_SQUARES;
			passedGo = true;
		} else {
			passedGo = false;
		}
		if (position < 0) {
			position = position + Board.NUM_SQUARES;
		} 
		return;
	}
	
	public void doTransaction (int amount) {
		balance = balance + amount;
		this.amount = amount;
		return;
	}
	
	public int getPosition () {
		return position;
	}
	
	public String getName () {
		return name;
	}
	
	public int getTransaction () {
		return amount;
	}
	
	public int getBalance () {
		return balance;
	}
	
	public boolean passedGo () {
		return passedGo;
	}
	
	public void boughtProperty (Property property) {
		property.setOwner(this);
		properties.add(property);
		return;
	}
	
	public void mortgagedProperty (Property MortgagedProperty) {
		MortgagedProperty.setOwner(this);
		mortgagedProperties.add(MortgagedProperty); //adds it to mortgage property list
		properties.remove(MortgagedProperty); //removes it from property list
		return;
	}
	
	public void redeemedProperty (Property RedeemedProperty) {
		RedeemedProperty.setOwner(this);
		mortgagedProperties.remove(RedeemedProperty); //removes from mortgaged property list
		properties.add(RedeemedProperty); //removes it from property list
		return;
	}
	
	public void buildHouse (Property DevelopedProperty){//Function to build houses
		DevelopedProperty.setOwner(this);//adds property with house to the developedProperty array list
		houses.add(DevelopedProperty);
		DevelopedProperty.isHouse();//sets boolean expression to true, to indicate that there is a house on this property
		return;
	}
	
	public void buildHotel (Property DevelopedProperty2){//Same but for hotels
		DevelopedProperty2.setOwner(this);
		hotels.add(DevelopedProperty2); //adds to hotels
		DevelopedProperty2.isHotel();
		return;
	}
	
	public ArrayList<Property> getMortgagedProperties () {
		return mortgagedProperties;
	}
	
	
	public Property getLatestProperty () {
		return properties.get(properties.size()-1);
	}
	
	public ArrayList<Property> getProperties () {
		return properties;
	}
	
	//Function which clears all properties owned by the bankrupt player
	public ArrayList<Property> clearProperties () {
		for (Property property: properties) {
			property.removeOwner(null);
		}
		return properties; 
	}
	
	//clears all houses
	public ArrayList<Property> clearHouses () {
	
		for (Property DevelopedProperty: houses) {
			DevelopedProperty.removeOwner(null);
		}
	return	houses;
	}
	
	//clears all hotels
	public ArrayList<Property> clearHotels () {
		
		for (Property DevelopedProperty2: hotels) {
			DevelopedProperty2.removeOwner(null);
		}
	return	hotels;
	}
	
	public int getAssets () {
		int assets = balance;
		for (Property property: properties) {
			assets = assets + property.getValue();
		}
		return assets;
	}
	
	public String toString () {
		return name + " (" + token + ")";
	}
	
	
}
