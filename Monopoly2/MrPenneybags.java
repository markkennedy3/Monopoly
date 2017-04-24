public class MrPenneybags implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects

	private BoardAPI board;
	private PlayerAPI player;
	private DiceAPI dice;
	private String x;
	
	MrPenneybags (BoardAPI board, PlayerAPI player, DiceAPI dice) {
		this.board = board;
		this.player = player;
		this.dice = dice;
		return;
	}
	
	public String getName () {
/*	Square position;
		position = board.getSquare(player.getPosition());
		int positions = 2;
		if(position instanceof Property){
			Property property = (Property) board.getSquare(player.getPosition());
			if(property.getOwner() != player){
				x = "Pay rent";
				return x;
			}
			else{
				x = "buy";
				return x;
			}
		}
		if(position instanceof Site){
			Site site = (Site) board.getSquare(player.getPosition());
			if(site.getOwner() != player){
				x = "Pay Rent";
				return x;
			}
			else{
				x = "buy";
				return x;
			}
		}
		if(position instanceof Station ){
			Site site = (Site) board.get
		}
		*/ x = "roll";
		
		return x;
	}
	
	
	
	
	
	
	public String getCommand () {
		
		
		
		
		
x = "roll";
		
		return x;
		
		
		
		
		
		// Add your code here
		
		
	}
	
	
	
	
	
	
	
	public String getDecision () {
		
		
		
		
		
		
		
		
x = "roll";
		
		return x;
	}
	
	
}