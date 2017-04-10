import java.util.ArrayList;

public class Player {
	
	private String name;
	private int position;
	private int balance;
	private int amount;
	private String tokenName;
	private int tokenId;
	private boolean passedGo;
	boolean inJail;
	int posFromJail;
	int fine;
	int numOfStrikes;
	int numOfDoubles;
	boolean hasGetOutOfJailCard;
	private ArrayList<Property> properties = new ArrayList<Property>();
	
// CONSTRUCTORS
	
	Player (String name, String tokenName, int tokenId) {
		this.name = name;
		this.tokenName = tokenName;
		this.tokenId = tokenId;
		position = 0;
		balance = 0;
		passedGo = false;
		inJail = false;
		posFromJail = 0;
		fine = 50;
		hasGetOutOfJailCard = false;
		
		return;
	}
	
	Player (Player player) {   // copy constructor
		this(player.getName(), player.getTokenName(), player.getTokenId());
	}
	
// METHODS DEALING WITH PLAYER DATA
	
	public String getName () {
		return name;
	}
	
	public String getTokenName () {
		return tokenName;
	}
	
	public int getTokenId () {
		return tokenId;
	}
	
// METHODS DEALING WITH TOKEN POSITION
	
	public int getPosition () {
		return position;
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
	//Jail Methods
	public int getPositionsFromJail (){
		if(position >= 10){
			posFromJail = (Board.NUM_SQUARES - position) + 10;
		}
		else if(position < 10){
			posFromJail = 10 - position;
		}
		
		return posFromJail;
	}
	public void moveToJail (int posFromJail){
		position = position + posFromJail;
		if (position >= Board.NUM_SQUARES) {
			position = position - Board.NUM_SQUARES;
			passedGo = false;
		}
		else if(position < 0){
			position = position + Board.NUM_SQUARES;
			passedGo = false;
		} 
	}
	
	public int getFine() {
	return fine;
	}

	public void payFine(int amount) {
		balance = balance + amount;
		this.amount = amount;
		return;
		
	}
	
	//Card Methods to move//
	
	public int moveToGo (){
		position = 1;
		return position;
	}
	
	public int moveToBikeShop (){
		position = 2;
		return position;
	}
	
	public int moveToBelgrove (){
		position = 11;
		return position;
	}
	
	public int moveToClubhouse (){
		position = 24;
		return position;
	}
	
	public int moveToDrumcondra (){
		position = 15;
		return position;
	}
	
	public int moveToLaw (){
		position = 39;
		return position;
	}
	
	public boolean passedGo () {
		return passedGo;
	}
	
//  METHODS DEALING WITH MONEY
	
	public void doTransaction (int amount) {
		balance = balance + amount;
		this.amount = amount;
		return;
	}
		
	public int getTransaction () {
		return amount;
	}
	
	public int getBalance () {
		return balance;
	}
	
	public int getAssets () {
		int assets = balance;
		for (Property property: properties) {
			assets = assets + property.getPrice();
		}
		return assets;
	}
	
//  METHODS DEALING WITH PROPERTY
	
	public void addProperty (Property property) {
		property.setOwner(this);
		properties.add(property);
		return;
	}
	
	public Property getLatestProperty () {
		return properties.get(properties.size()-1);
	}
	
	public ArrayList<Property> getProperties () {
		return properties;
	}
	
	public boolean isGroupOwner (Site site) {
		boolean ownsAll = true;
		ColourGroup colourGroup = site.getColourGroup();
		for (Site s : colourGroup.getMembers()) {
			if (!s.isOwned() || (s.isOwned() && s.getOwner() != this))
				ownsAll = false;
		}
		return ownsAll;
	}
	public boolean isInJail(){
		return inJail;
	}
	public int getNumStationsOwned () {
		int numOwned = 0;
		for (Property p : properties) {
			if (p instanceof Station) {
				numOwned++;
			}
		}
		return numOwned;
	}
	
	public int getNumUtilitiesOwned () {
		int numOwned = 0;
		for (Property p : properties) {
			if (p instanceof Utility) {
				numOwned++;
			}
		}
		return numOwned;
	}
	
	
// COMMON JAVA METHODS	
	
	public boolean equals (String name) {
		return this.name.toLowerCase() == name;
	}
	
	public String toString () {
		return name + " (" + tokenName + ")";
	}

	public boolean hasGetOutOfJailCard() { 
		return hasGetOutOfJailCard;
	}
	
	

	
	

}
