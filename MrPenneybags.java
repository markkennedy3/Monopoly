public class MrPenneybags implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects
	
	//Team name Mr Penneybags
	
	//Team Members
	//Michael Mallon
	//Mark Kennedy
	//Stephen Connolly

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
	
    
	public String getCommand () {//Returns our commands based on the state of play
		
		String command = "roll";//The default command
		
		if(rolldone==false){//If the roll command wasnt given or if we have an extra roll
			command="roll";
			rolldone = true;
			
		try {Thread.sleep(50);}//Controls the speed of the game 
			catch (InterruptedException e){
				e.printStackTrace();}
		}
		else {
			command="done";
			rolldone=false;}
		
		if(player.getBalance() < 0){//if your bankrupt youre gone
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
		
     	                 if(position instanceof Site){//If it is a site we are buying it
		                    Site site = (Site) board.getSquare(player.getPosition());
		                     if (!site.isOwned() && player.getBalance() >= site.getPrice() //If the site is not owned and the player can afford it
		                    		 &&!(site.getShortName() == "whitechapel") &&!(site.getShortName() == "strand")){//We dont want it to buy certain properties
			                     command = "buy";
			                     return command;
			                     }
     	                 }
     	               
		                    
     	                 
     	                
     	       	         if(position instanceof Station){//If it is a station we are buying it
     	       		       Station station = (Station) board.getSquare(player.getPosition());
     	       		           if (station.isOwned() && station.getOwner() == player && player.getBalance() >= 300){
     	       			          command = "buy";
     	       				      return command;
     	       				      }
     	       	         }
     	       	         
       Square buildhouse = board.getSquare(player.getPosition());//Name of square for building houses
     	         	
                    int numToBuild = 0;//Number of houses we want to build counter
     	    		
     	         	if(buildhouse instanceof Site){
     	    		 Site site = (Site) board.getSquare(player.getPosition());
     	    		
     	    		 if (site.isOwned() && site.getOwner() == player && player.getBalance() >= 750 && player.isGroupOwner(site)==true && site.getNumHouses()<3){
     	    			 String siteName =  site.getShortName();
     	    			
     	    			 command = "build";//build site that were on
     	    				
     	    				if(player.getBalance() >= 750){//If our balance is greater than 750 build 3 houses
     	    					numToBuild = 3;
     	    				}
     	    				
     	    				
     	    				String numberOfHouses = Integer.toString(numToBuild);//Convert from integer to string
     	    			
     	    				if(numToBuild != 0){
     	    					String appended = command + " " + siteName + " " + numberOfHouses;//Appended strings together to form the command
     	    					return appended;
     	    				}
     	    				
     	    				else if(numToBuild == 0){//If no more houses are to be built then end the turn
     	    					command = "roll";
     	    					if(rolldone==true)
     	    					{
     	    						command="done";
     	    											
     	    			      	}
     	    				}
     	    		     }
     	    		 }
     	         	
Square positionMortgage = board.getSquare(player.getPosition());//Just a name regarding mortgaging the sites
     	         	
     	         	
     	         	if(positionMortgage instanceof Site){//If its actually a site
     	         	Site sites = (Site) board.getSquare(player.getPosition());
     	         	ColourGroup group = sites.getColourGroup();//Get the colour group of the site
     	         	
     	         	if(sites.isOwned() && sites.getOwner() == player){//If the site is owned by the player
     	         	for (Site s : group.getMembers()) {
     	   			if (s.isOwned() && s.getOwner() != player){
     	   				if(numOfMortgageCommands == 1){//If the mortgage command was already used we want it to roll again or done depending on whether there is a roll available
 	   					command = "roll";
 	   						if(rolldone==true){
 	   						command="done";
 	   					}
 	   				
 	   			}else{
     	   				command = TellToMortgage(command, sites);//Calls the function that mortgages the property
     	   				numOfMortgageCommands += 1;//Increments the counter by 1
     	   				
 	   					}
     	   				
 	   		}else{//If its not owned keep going or end the turn
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
	
	public String TellToMortgage (String command, Site sites){//Tell to mortgage returns the command to mortgage
		String result = null;
		if(sites.isMortgaged() == true){//If it is already mortgaged then we will just do roll or done if we dont have a roll then done
      		command = "roll";
      		if(rolldone == true){
      			command = "done";
      			result = command;
      		}
      	}
      	else if(!player.isGroupOwner(sites)){//If it is not mortgaged then we want to mortgage it
      		  String siteName = sites.getShortName();
      		  String hold = "mortgage";
      		  command = hold + " " + siteName;//Appending the strings together
      		  result = command;
  			}
			return result;//The function returns a string called result
	}

	public String getDecision () {//Get decision function for the pay or take chance functionality
		
		 String result;
		 if (player.getBalance() >= 500 ) //If the balance is 500 or more we want the bot to pay
		 { result = "pay"; 
		 return result; 
		 } 
		 else{//Otherwise the bot takes the chance
			 result = "chance"; 
			 return result; 
			 } 
		 } 
	}