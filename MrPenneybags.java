public class MrPenneybags implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects

	private BoardAPI board;
	private PlayerAPI player;
	private DiceAPI dice;
	private boolean rolldone = false;
	
	MrPenneybags (BoardAPI board, PlayerAPI player, DiceAPI dice) {
		this.board = board;
		this.player = player;
		this.dice = dice;
		return;
	}
	
	public String getName () {
		return "MrPenneybags";
	}
	
     public String getCommand () {
		
		String command = "roll";
		
		if(rolldone==false){
			command="roll";
			rolldone = true;
			
		try {Thread.sleep(0);}
			catch (InterruptedException e){
				e.printStackTrace();}
		}
		else {
			command="done";
			rolldone=false;}
		
		if(player.getBalance() < 0){
            command = "bankrupt";
            return command;
          }	
     
     
		
		//TACTICS
		
		Square position = board.getSquare(player.getPosition());
		
     	                 if(position instanceof Site){
		                    Site site = (Site) board.getSquare(player.getPosition());
		                     if (!site.isOwned() && player.getBalance() >= site.getPrice()){
			                     command = "buy";
			                     return command;}
     	                 }
		                    
     	                 
     	                
     	       	         if(position instanceof Station){
     	       		       Station station = (Station) board.getSquare(player.getPosition());
     	       		           if (station.isOwned() && station.getOwner() == player && player.getBalance() >= 300){
     	       			          command = "buy";
     	       				      return command;}
     	       	         }
     	       	         
       Square buildhouse = board.getSquare(player.getPosition());
     	         	
                    int numToBuild = 0;
     	    		
     	         	if(buildhouse instanceof Site){
     	    		 Site site = (Site) board.getSquare(player.getPosition());
     	    		
     	    		 if (site.isOwned() && site.getOwner() == player && player.getBalance() >= 750 && player.isGroupOwner(site)==true && site.getNumHouses()<3){
     	    			 String siteName =  site.getShortName();
     	    				command = "build ";//build site that were on
     	    				
     	    				if(player.getBalance() >= 750 ){
     	    					numToBuild = 1;
     	    				}
     	    				
     	    				String numberOfHouses = Integer.toString(numToBuild);
     	    				if(numToBuild == 3){
     	    					command = "done";
     	    					return command;
     	    				}
     	    				
     	    				if(numToBuild != 0){
     	    					String appended = command + siteName + " " + numberOfHouses;
     	    					return appended;
     	    				}
     	    				
     	    				else if(numToBuild == 0){
     	    					command = "roll";
     	    					if(rolldone==true)
     	    					{
     	    						command="done";
     	    											
     	    			      	}
     	    				}
     	    		     }
     	    		 }
     	         	
		return command;
     	       	        
	}
	
	public String getDecision () {
		return " ";
	}
}