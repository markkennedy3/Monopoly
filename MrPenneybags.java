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
/*	
		*/
		
		return "Mr Penneybags";
	}
	
	
	
	
	
	
	public String getCommand () {
		
		
		/*
		Square position;
		position = board.getSquare(player.getPosition());
		
		if(player.isInJail() == true){
			x = "roll";
			return x;
		
		}else{
			x = "roll";
		}
		
		
		
		if(position instanceof Property){
			Property property = (Property) board.getSquare(player.getPosition());
			if(property.getOwner() != player){
				x = "pay rent";
				return x;
			}
			else{
				x = "buy";
				return x;
			}
		}
		if(position instanceof Site){
			Site site = (Site) board.getSquare(player.getPosition());
			if(player.isGroupOwner(site)){
				x = "mortgage" + site;//Not sure if correct practice
			}
			if(site.getOwner() != player){
				x = "pay rent";
				return x;
			}
			else{
				x = "buy";
				return x;
			}
			
		}
		if(position instanceof Station ){
			Site site = (Site) board.getSquare(player.getPosition());
			if(site.getOwner() != player){
				x = "pay rent";
			}
			else{
				x = "buy";
			}
			
		}
		if(position instanceof Station ){
			Site site = (Site) board.getSquare(player.getPosition());
			if(site.getOwner() != player){
				x = "pay rent";
			}
			else{
				x = "buy";
			}
			
		}
		*/
		x = "roll";
		
		
		
		

		
		return x;
		
		
		
		
		
		// Add your code here
		
		
	}
	
	
	
	
	
	
	
	public String getDecision () {
		
	return " ";
	}
}