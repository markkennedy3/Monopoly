public class Property extends Square {

	private boolean isOwned;
	private boolean isBuiltHouse;
	private boolean isBuiltHotel;
	private boolean isRedeemed;
	private boolean isMortgaged;
	private int value;
	private int rent[];
	private Player owner;
	
	Property (String name, int value, int[] rent) {
		super(name);
		this.value = value;
		this.rent = rent;
		isOwned = false;
		isBuiltHouse = false;
		isBuiltHotel = false;
		isRedeemed = false;
		isMortgaged = false;
		return;
	}
	
	public int getValue () {
		return value;
	}
	
	public int getRent () {
		return rent[0];
	}
	
	public boolean isOwned () {
		return isOwned;
	}
	
	public boolean isBuiltHouse (){
		return isBuiltHouse;
	}
	
	public boolean isBuiltHotel (){
		return isBuiltHotel;
	}
	
	public boolean isRedeemed (){
		return isRedeemed;
	}
	
	public boolean isMortgaged(){
		return isMortgaged;
	}

	
	public void setOwner (Player inPlayer) {
		owner = inPlayer;
		isOwned = true;
		return;
	}
	
	public Player getOwner () {
		return owner;
	}
}