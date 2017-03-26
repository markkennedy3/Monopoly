
public class Property extends Square {

	private boolean isOwned;
	private boolean isHouse;
	private boolean isHotel;
	private int value;
	private int rent[];
	private Player owner;
	
	Property (String name, int value, int[] rent) {
		super(name);
		this.value = value;
		this.rent = rent;
		isOwned = false;
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
	
	public void setOwner (Player inPlayer) {
		owner = inPlayer;
		isOwned = true;
		return;
	}
	
	public Player getOwner () {
		return owner;
	}
	
	//Function which removes the current player as owner of a property
	public void removeOwner (Player inPlayer) {
		owner = inPlayer;
		isOwned = false;
		return;
	}
	
	//boolean expression to see if there a house present on the site
	public boolean isHouse (){
		isHouse = true;
		return isHouse;
	}
	
	//boolean expression to see if there a hotel present on the site
	public boolean isHotel (){
		isHotel = true;
		return isHotel;
	}
	
}
