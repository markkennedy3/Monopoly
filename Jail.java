
/*Not being used anymore*/



//New Class for Jail, might scrap or move some of these functions
public class Jail extends Square{

	boolean inJail;
	int posFromJail;
	
	Jail(String name, int price) {
		super(name);
		inJail = false;
		posFromJail = 0;
		
	}

	
	
	public boolean isInJail(){
		return inJail;
	}
	public void moveToJail(int posFromJail){//
		
	}
	public int positionsFromJail(){//Gets number of position from jail
		return posFromJail;
	}

}
