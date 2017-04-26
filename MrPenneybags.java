public class MrPenneybags implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects

	private BoardAPI board;
	private PlayerAPI player;
	private DiceAPI dice;
	private boolean rolldone = false;
	private int numOfMortgageCommands = 0;
	
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
			
		try {Thread.sleep(50);}
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
     
     
		//PAY OR CHANCE IN COMMUNITY CHEST
		/*
		String decision = null;
		Square payorchance; 
		payorchance = board.getSquare(player.getPosition());
		Card chest = null;
		if(payorchance instanceof CommunityChest){
			if(chest.getAction()==8) 
				decision = getDecision();
			if (decision == "pay") {
				command = "pay";
				return command; }
			else{ 
				command = "chance"; 
				return command;
			}
		}*/
		//TACTICS
		
		Square position = board.getSquare(player.getPosition());
		
     	                 if(position instanceof Site){
		                    Site site = (Site) board.getSquare(player.getPosition());
		                     if (!site.isOwned() && player.getBalance() >= site.getPrice() 
		                    		 &&!(site.getShortName() == "whitechapel") &&!(site.getShortName() == "strand")){
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
     	    			
     	    			 command = "build";//build site that were on
     	    				
     	    				if(player.getBalance() >= 750){
     	    					numToBuild = 3;
     	    				}
     	    				
     	    				
     	    				String numberOfHouses = Integer.toString(numToBuild);
     	    			
     	    				if(numToBuild != 0){
     	    					String appended = command + " " + siteName + " " + numberOfHouses;
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
     	         	
Square positionMortgage = board.getSquare(player.getPosition());
     	         	
     	         	
     	         	if(positionMortgage instanceof Site){
     	         	Site sites = (Site) board.getSquare(player.getPosition());
     	         	ColourGroup group = sites.getColourGroup();
     	         	
     	         	if(sites.isOwned() && sites.getOwner() == player){
     	         	for (Site s : group.getMembers()) {
     	   			if (s.isOwned() && s.getOwner() != player){
     	   				if(numOfMortgageCommands == 1){
 	   					command = "roll";
 	   						if(rolldone==true){
 	   						command="done";
 	   					}
 	   				
 	   			}else{
     	   				command = TellToMortgage(command, sites);
     	   				numOfMortgageCommands += 1;
     	   				
 	   					}
     	   				
 	   		}else{
 	   			command = "roll";
				if(rolldone==true){
				command="done";
					}
				}
         	}
 	    }
 	}
     	         	
		return command;
     	       	        
	}
	
	public String TellToMortgage (String command, Site sites){
		String result = null;
		if(sites.isMortgaged() == true){
      		command = "roll";
      		if(rolldone == true){
      			command = "done";
      			result = command;
      		}
      	}
      	else if(!player.isGroupOwner(sites)){
      		  String siteName = sites.getShortName();
      		  String hold = "mortgage";
      		  command = hold + " " + siteName;
      		  result = command;
  			}
			return result;
	}

	public String getDecision () {
		
		 String result;
		 if (player.getBalance() >= 500 ) 
		 { result = "pay"; 
		 return result; 
		 } 
		 else{
			 result = "chance"; 
			 return result; } 
		 } 
	}

		