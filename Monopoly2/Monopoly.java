import java.util.ArrayList;



public class Monopoly {

	private static final int START_MONEY = 1500;
	private static final int GO_MONEY = 200;
	private static final int TAX_MONEY = 200;
	private static int randomNumber;
	private Players players = new Players();
	public Player currPlayer;
	private Dice dice = new Dice();
	private Board board = new Board(dice);
	private UI ui = new UI(players, board);
	private boolean gameOver = false;
	private boolean onlyOneNotBankrupt = false;
	private boolean turnFinished;
	private boolean rollDone;
	private boolean rentOwed;
	private boolean rentPaid;
	private int numOfDoubles;
	private int numOfStrikes;
	
	Monopoly () {
		ui.display();
		return;
	}
		
	public void inputNames () {
		int playerId = 0;
		do {
			ui.inputName(playerId);
			if (!ui.isDone()) {
				boolean duplicate = false;
				for (Player p : players.get()) {
					if (ui.getString().toLowerCase().equals(p.getName().toLowerCase())) {
						duplicate = true;
					}
				}
				if (!duplicate) {
					players.add(new Player(ui.getString(),ui.getTokenName(playerId),playerId));
					playerId++;
				} else {
					ui.displayError(UI.ERR_DUPLICATE);
				}
			}
		} while (!ui.isDone() && players.canAddPlayer());
		return;
	}
	
	public void giveStartMoney () {
		for (Player p : players.get()) {
			p.doTransaction (START_MONEY);
			ui.displayBankTransaction (p);
		}
		return;
	}
	
	public void decideStarter () {
		Players inPlayers = new Players(players), selectedPlayers = new Players();
		boolean tie = false;
		do {
			int highestTotal = 0;
			for (Player p : inPlayers.get()) {
				dice.roll();
				ui.displayDice(p,dice);
				if (dice.getTotal() > highestTotal) {
					tie = false;
					highestTotal = dice.getTotal();
					selectedPlayers.clear();
					selectedPlayers.add(p);
				} else if (dice.getTotal() == highestTotal) {
					tie = true;
					selectedPlayers.add(p);
				}
			}
			if (tie) {
				ui.displayRollDraw();
				inPlayers = new Players(selectedPlayers);
				selectedPlayers.clear();
			}
		} while (tie);
		currPlayer = selectedPlayers.get(0);
		ui.displayRollWinner(currPlayer);
		ui.display();
		return;
	}
	
	private void processRoll () {
		if(currPlayer.isInJail() == true && rollDone == true){
			ui.displayError(UI.ERR_TOO_MANY_ROLLS);
		}
		if(currPlayer.isInJail() == true){
			dice.roll();
			ui.displayDice(currPlayer, dice);
			if(dice.isDouble()){
				currPlayer.move(dice.getTotal());
				ui.displayGetOutOfJail(currPlayer);
				ui.displaySquare(currPlayer, board, dice);
				ui.display();
				rollDone = false;
				currPlayer.inJail = false;
				if(!rentOwed){
					if (board.getSquare(currPlayer.getPosition()) instanceof Property && 
							((Property) board.getSquare(currPlayer.getPosition())).isOwned() &&
							!((Property) board.getSquare(currPlayer.getPosition())).getOwner().equals(currPlayer) ) {
								rentOwed = true;
								rentPaid = false;
					} else {
						rentOwed = false;
					}
					
				
				}
				if (board.getSquare(currPlayer.getPosition()) instanceof Property) {
					Property property = (Property) board.getSquare(currPlayer.getPosition());
					if (property.isOwned()) {
						if (!property.getOwner().equals(currPlayer)) {
							if (!rentPaid) {
								    int rent = property.getRent();
									Player owner = property.getOwner();
									currPlayer.doTransaction(-rent);
									owner.doTransaction(+rent);
									ui.displayTransaction(currPlayer, owner);
									rentPaid = true;	
									rentOwed = false;
								
							} 
						} 
					} 
				} 
			}
			else{
				currPlayer.numOfStrikes += 1;
				ui.displayNotGetOutOfJail(currPlayer);//Different display for not getting out of jail
				rollDone = true;
				if(currPlayer.numOfStrikes == 3){//if the player has not rolled a double in 3 turns
					currPlayer.move(dice.getTotal());
					
					int fine = currPlayer.getFine();
					currPlayer.payFine(-fine);
					ui.displayFine(currPlayer);
					currPlayer.inJail = false;
					ui.displaySquare(currPlayer, board, dice);
					ui.display();
					
				}
			}
		}else{
		if (rollDone == false) {
			if (!rentOwed) {
				dice.roll();
				ui.displayDice(currPlayer, dice);
				currPlayer.move(2); //jail test
				//currPlayer.move(dice.getTotal());
				ui.display();
				
				if (currPlayer.passedGo()) {
					currPlayer.doTransaction(+GO_MONEY);
					ui.displayPassedGo(currPlayer);
					ui.displayBankTransaction(currPlayer);
				}
				ui.displaySquare(currPlayer, board, dice);
				
				
				if (board.getSquare(currPlayer.getPosition()) instanceof Property && 
						((Property) board.getSquare(currPlayer.getPosition())).isOwned() &&
						!((Property) board.getSquare(currPlayer.getPosition())).getOwner().equals(currPlayer) ) {
							rentOwed = true;
							rentPaid = false;
				} else {
					rentOwed = false;
				}
				if (!dice.isDouble()) {
					rollDone = true;
				}
			} else {
				ui.displayError(UI.ERR_RENT_OWED);	
			}
		} else {
			ui.displayError(UI.ERR_DOUBLE_ROLL);
			currPlayer.numOfDoubles += 1;
		}
		}
		
		if (board.getSquare(currPlayer.getPosition()) instanceof Property) {
			Property property = (Property) board.getSquare(currPlayer.getPosition());
			if (property.isOwned()) {
				if (!property.getOwner().equals(currPlayer)) {
					if (!rentPaid) {
						    int rent = property.getRent();
							Player owner = property.getOwner();
							currPlayer.doTransaction(-rent);
							owner.doTransaction(+rent);
							ui.displayTransaction(currPlayer, owner);
							rentPaid = true;	
							rentOwed = false;
						
					} else {
						ui.displayError(UI.ERR_RENT_ALREADY_PAID);									
					}
				} else {
					ui.displayError(UI.ERR_SELF_OWNED);								
				}
			} 
		} 
	
		
	
		if(currPlayer.getPosition() == 4 || currPlayer.getPosition() == 38){
			processPayTax();
		}
	
		
		if(currPlayer.getPosition() == 2 || currPlayer.getPosition() == 17 || currPlayer.getPosition() == 33){
			CommunityChest(currPlayer);
			ui.displayLandedOnCommunityChest(currPlayer);
			
     	}
		
		
	
		if(currPlayer.getPosition() == 7 || currPlayer.getPosition() == 22 || currPlayer.getPosition() == 36){
            Chance(currPlayer);
			ui.displayLandedOnChance(currPlayer);
			
			turnFinished = false;
		}
		
		
		if(currPlayer.numOfDoubles == 3){//If there are 3 doubles in a row
     		int positionFromJail = currPlayer.getPositionsFromJail();
			currPlayer.moveToJail(positionFromJail);
			currPlayer.inJail = true;
			rollDone = true;
		}
		
		if(board.getSquare(currPlayer.getPosition()) instanceof Square){
		if(currPlayer.getPosition() == 30){//if the person is on go to jail
			int positionFromJail = currPlayer.getPositionsFromJail();
			currPlayer.moveToJail(positionFromJail);
			ui.displayMovedToJail(currPlayer);
			currPlayer.inJail = true;
			rollDone = true;
			}
		}
		return;
	}
	

	private void processBuy () {
		if (board.getSquare(currPlayer.getPosition()) instanceof Property) {
			Property property = (Property) board.getSquare(currPlayer.getPosition());
			if (!property.isOwned()) {
				if (currPlayer.getBalance() >= property.getPrice()) {				
					currPlayer.doTransaction(-property.getPrice());
					ui.displayBankTransaction(currPlayer);
					currPlayer.addProperty(property);
					ui.displayLatestProperty(currPlayer);
				} else {
					ui.displayError(UI.ERR_INSUFFICIENT_FUNDS);
				}
			} else {
				ui.displayError(UI.ERR_IS_OWNED);
			}
		} else {
			ui.displayError(UI.ERR_NOT_A_PROPERTY);
		}
		return;
	}
	
	private void PayFromJail(){
		if (board.getSquare(currPlayer.getPosition()) instanceof Property) {
			Property property = (Property) board.getSquare(currPlayer.getPosition());
			if (property.isJail() == true) {
				if (currPlayer.isInJail() == true && property.isFinePaid() == false) {
						int fine = property.getJailFine();
						Player jail = null;
						if (currPlayer.getBalance()>= fine) {
							currPlayer.doTransaction(-fine);
							ui.displayTransaction(currPlayer, jail);
					}
				}
			}
		}	
	}
	
	
	
	private void processPayTax(){
		if (currPlayer.getPosition() ==  4) {
						if (currPlayer.getBalance()>= 150) {
							currPlayer.doTransaction(-150);
							ui.displayBankTransaction(currPlayer);
							ui.displayString(currPlayer+" paid Income Tax");
							rollDone = true;
						}	
						else{
							ui.displayError(UI.ERR_INSUFFICIENT_FUNDS);
						}
			}
		if (currPlayer.getPosition() ==  38) {
			if (currPlayer.getBalance()>= 100) {
				currPlayer.doTransaction(-100);
				ui.displayBankTransaction(currPlayer);
				ui.displayString(currPlayer+" paid Super Tax");
				rollDone = true;
			}	
			else{
				ui.displayError(UI.ERR_INSUFFICIENT_FUNDS);
			}
}
	}		
	
	private void processBuild () {
		Property property = ui.getInputProperty();
		if (property.isOwned() && property.getOwner().equals(currPlayer)) {
			if (property instanceof Site) {
				Site site = (Site) property;
				if (currPlayer.isGroupOwner(site)) {
					if (!site.isMortgaged()) {
						int numBuildings = ui.getInputNumber();
						if (numBuildings>0) {
							if (site.canBuild(numBuildings)) {
								int debit = numBuildings*site.getBuildingPrice();
								if (currPlayer.getBalance()>debit) {
									site.build(numBuildings);
									currPlayer.doTransaction(-debit);
									ui.displayBuild(currPlayer,site,numBuildings);
								} else {
									ui.displayError(UI.ERR_INSUFFICIENT_FUNDS);
								}
							} else {
								ui.displayError(UI.ERR_TOO_MANY_BUILDINGS);
							}
						} else {
							ui.displayError(UI.ERR_TOO_FEW_BUILDINGS);
						}
					} else {
						ui.displayError(UI.SITE_IS_MORTGAGED);
					}
				} else {
					ui.displayError(UI.ERR_DOES_NOT_HAVE_GROUP);
				}
			} else {
				ui.displayError(UI.ERR_NOT_A_SITE);
			}
		} else {
			ui.displayError(UI.ERR_NOT_YOURS);
		}
		return;
	}
	
	private void processDemolish () {
		Property property = ui.getInputProperty();
		if (property.isOwned() && property.getOwner().equals(currPlayer)) {
			if (property instanceof Site) {
				Site site = (Site) property;
				int numBuildings = ui.getInputNumber();
				if (numBuildings>0) {
					if (site.canDemolish(numBuildings)) {
						site.demolish(numBuildings);
						int credit = numBuildings * site.getBuildingPrice()/2;
						currPlayer.doTransaction(+credit);
						ui.displayDemolish(currPlayer,site,numBuildings);
					} else {
						ui.displayError(UI.ERR_TOO_MANY_BUILDINGS);
					}
				} else {
					ui.displayError(UI.ERR_TOO_FEW_BUILDINGS);
				}
			} else {
				ui.displayError(UI.ERR_NOT_A_SITE);
			}
		} else {
			ui.displayError(UI.ERR_NOT_YOURS);
		}
		return;		
	}
	
	
	public void processBankrupt () {
		ui.displayBankrupt(currPlayer);
		Player tempPlayer = players.getNextPlayer(currPlayer);
		players.remove(currPlayer);
		currPlayer = tempPlayer;
		if (players.numPlayers()==1) {
			gameOver = true;
			onlyOneNotBankrupt = true;
		}
		ui.display();
		return;
	}
	

		
	public void processMortgage () {
		Property property = ui.getInputProperty();
		if (property.isOwned() && property.getOwner().equals(currPlayer)) {
			if ((property instanceof Site) && !((Site) property).hasBuildings() || (property instanceof Station) || (property instanceof Utility)) {
				if (!property.isMortgaged()) {
					property.setMortgaged();
					currPlayer.doTransaction(+property.getMortgageValue());
					ui.displayMortgage(currPlayer,property);
				} else {
					ui.displayError(UI.ERR_IS_MORTGAGED);
				}
			} else {
				ui.displayError(UI.ERR_HAS_BUILDINGS);
			}
		} else {
			ui.displayError(UI.ERR_NOT_YOURS);
		}
		return;		
	}
	
	public void processRedeem () {
		Property property = ui.getInputProperty();
		if (property.isOwned() && property.getOwner().equals(currPlayer)) {
			if (property.isMortgaged()) {
				int price = property.getMortgageRemptionPrice();
				if (currPlayer.getBalance() >= price) {
					property.setNotMortgaged();
					currPlayer.doTransaction(-price);
					ui.displayMortgageRedemption(currPlayer,property);
				} else {
					ui.displayError(UI.ERR_INSUFFICIENT_FUNDS);
				}
			} else {
				ui.displayError(UI.ERR_IS_NOT_MORTGAGED);
			}
		} else {
			ui.displayError(UI.ERR_NOT_YOURS);
		}
		return;			
	}

	private void processDone () {
		if (rollDone) {
			if (!rentOwed || (rentOwed && rentPaid)) {
				turnFinished = true;
			} else {
				ui.displayError(UI.ERR_RENT_OWED);
			}
			if(currPlayer.getBalance() < 0){
				ui.displayError(UI.ERR_NEG_BALANCE);
			}
		} else {
			ui.displayError(UI.ERR_NO_ROLL);
		}
		return;
	}
	
	public void processTurn () {
		turnFinished = false;
		rollDone = false;
		rentOwed = false;
		rentPaid = false;
		do {
			ui.inputCommand(currPlayer);
			switch (ui.getCommandId()) {
				case UI.CMD_ROLL :
					processRoll();
					break;
				case UI.CMD_BUY :
					processBuy();
					break;
				case UI.CMD_BALANCE :
					ui.displayBalance(currPlayer);
					break;
				case UI.CMD_PROPERTY :
					ui.displayProperty(currPlayer);
					break;
				case UI.CMD_BANKRUPT :
					processBankrupt();
					turnFinished = true;
					break;
				case UI.CMD_BUILD :
					processBuild();
					break;
				case UI.CMD_DEMOLISH :
					processDemolish();
					break;
				case UI.CMD_REDEEM :
					processRedeem();
					break;
				case UI.CMD_MORTGAGE :
					processMortgage();
					break;
				case UI.CMD_HELP :
					ui.displayCommandHelp();
					break;
				case UI.CMD_DONE :
					processDone();
					break;
				case UI.CMD_PAY_10 : 
					currPlayer.doTransaction(-10);
					turnFinished = false;
					break;
				case UI.CMD_TAKE_CHANCE : 
					//Cards.Chance();
					turnFinished = false; 
					break;
			}
			if(board.getSquare(currPlayer.getPosition()) instanceof Property){
				Property property = (Property) board.getSquare(currPlayer.getPosition());
				if(property.isGoToJail()){
					//currPlayer.
				}
				
			}
		} while (!turnFinished);
		return;
	}
	
	
	
	public void nextPlayer () {
		currPlayer = players.getNextPlayer(currPlayer);
		return;
	}
	
	public void decideWinner () {
		if (onlyOneNotBankrupt) {
			ui.displayWinner(currPlayer);			
		} else {
			ArrayList<Player> playersWithMostAssets = new ArrayList<Player>();
			int mostAssets = players.get(0).getAssets();
			for (Player player : players.get()) {
				ui.displayAssets(player);
				if (player.getAssets() > mostAssets) {
					playersWithMostAssets.clear(); 
					playersWithMostAssets.add(player);
				} else if (player.getAssets() == mostAssets) {
					playersWithMostAssets.add(player);
				}
			}
			if (playersWithMostAssets.size() == 1) {
				ui.displayWinner(playersWithMostAssets.get(0));
			} else {
				ui.displayDraw(playersWithMostAssets);
			}
		}
		return;
	}
	
	
	
	//All Of Cards//
	
	public void CommunityChest(Player currPlayer) 

	{
		randomNumber =  (int)(Math.random()*16+1);

	    switch(randomNumber) 
	    
	    {
	    
	    
	    case 1 :
	    	//Advance to Go//
	    	//just needs linked in right//
	    	ui.displayString(currPlayer+" must advance to go");
	    	currPlayer.moveToGo();
	    	ui.displayMovedToGo(currPlayer);
	    	
	    	break;
	    
	    case 2 :
	    	//Go Back to UCD Bike Shop//
	    	ui.displayString(currPlayer+" has to move to ucd bikeshop");
	    	currPlayer.moveToBikeShop();
	    	ui.displayMovedToBikeShop(currPlayer);
	    	
	    	break;
	    	
	    case 3 :
	    	//Go To Jail//
	    	
	    	int positionFromJail = currPlayer.getPositionsFromJail();
			currPlayer.moveToJail(positionFromJail);//Moves the token positionFromJail spaces
			ui.displayString(currPlayer + " must go to jail ");
			currPlayer.inJail = true;//Player is now in jail
	    	
	    	break;
	    
	    case 4 :
	    	//Pay 100 to hospital//
	    	currPlayer.doTransaction(-100);
	    	ui.displayString(currPlayer+" visited the hospital");
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    	
	    case 5 :
	    	//Pay 50 to doctor//
	    	currPlayer.doTransaction(-50);
	    	ui.displayString(currPlayer+" visited the doctor");
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    
	    case 6 :
	    	//Pay 50 insureance
	    	currPlayer.doTransaction(-50);
	    	ui.displayString(currPlayer+" has to pay for insurance");
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    	
	    case 7 :
	    	//Bank error +200
	    	currPlayer.doTransaction(+200);
	    	ui.displayString(currPlayer+" has profited from a bank error");
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    
	    case 8 :
	    	//Annuity matures + 100
	    	currPlayer.doTransaction(+100);
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    	
	    case 9 :
	    	//Inherit 100
	    	currPlayer.doTransaction(+100);
	    	ui.displayString(currPlayer+" has inherited 100 euro");
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    
	    case 10 :
	    	//stock sale +50
	    	currPlayer.doTransaction(+50);
	    	ui.displayString(currPlayer+" has sold some stock");
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    	
	    case 11 :
	    	//shares +25
	    	currPlayer.doTransaction(+25);
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    
	    case 12 :
	    	//income tax refund +20
	    	currPlayer.doTransaction(+20);
	    	ui.displayString(currPlayer+" got a tax refund of 20 euro");
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    	
	    case 13 :
	    	//beauty contest +10
	    	currPlayer.doTransaction(+10);
	    	ui.displayString(currPlayer+" won a beauty contest");
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    
	    case 14 :
	    	//birthday 10 from each player
	    	ui.displayString("Happy Birthday "+currPlayer+" collect 10 euro from each player");
	    	for (Player p : players.get()) {
	    		if( p != currPlayer){
	    		currPlayer.doTransaction(+10);
	    		currPlayer.doTransaction(-10);
	    		ui.displayTransaction(currPlayer, p);
	    		}
	    		else{
	    			return;
	    		}
			}
	    	break;
	    	
	    case 15 :
	    	//get out of jail free
	    	break;
	    
	    case 16 :
	    	//pay 10 or take chance
	    	ui.displayString("Pay 10 or Take Chance");
	    	
	    	break;
	    	
	    default :
	        System.out.println("Invalid output");
	  }
	  return;
	}


	public void Chance(Player currPlayer) 

	{
		randomNumber =  (int)(Math.random()*16+1);

	    switch(randomNumber) 
	    
	    {
	    
	    
	    case 1 :
	    	//Advance to Go//
	    	//just needs linked in right//
	    	ui.displayString(currPlayer+" must advance to go");
	    	currPlayer.moveToGo();
	    	ui.displayMovedToGo(currPlayer);
	    	break;
	    
	    case 2 :
	    	//Go to jail//
	    	int positionFromJail = currPlayer.getPositionsFromJail();
			currPlayer.moveToJail(positionFromJail);//Moves the token positionFromJail spaces
			ui.displayString(currPlayer + " must go to jail ");
			currPlayer.inJail = true;//Player is now in jail
	    	
	    	
	    	break;
	    	
	    case 3 :
	    	//Go To pal mall(belgrove) if you pass go collect 200//
	    	
	    	
	    	if(currPlayer.getPosition() > 11){
	    		currPlayer.doTransaction(+200);
	    		currPlayer.moveToBelgrove();
	    		ui.displayString(currPlayer+" has been moved to Belgrove and has passed go and" + currPlayer + "has collected 200 euro");
	    	}
	    	else if(currPlayer.getPosition() < 11){
	    		currPlayer.moveToBelgrove();
	    		ui.displayString(currPlayer+" has been moved to Belgrove");
	    	}
	    	else if(currPlayer.getPosition() == 11){
	    		
	    	}
	    	
	    	
	    	
	    	break;
	    
	    case 4 :
	    	//Take a trip to Marylebone Station(drumcondra) and if you pass Go collect £200.//
	    	if(currPlayer.getPosition() > 15){
	    		currPlayer.doTransaction(+200);
	    		currPlayer.moveToDrumcondra();
	    		ui.displayString(currPlayer+" has been moved to Drumcondra and has passed go and" + currPlayer + "has collected 200 euro");
	    	}
	    	else if(currPlayer.getPosition() < 15){
	    		currPlayer.moveToDrumcondra();
	    	}
	    	else if(currPlayer.moveToDrumcondra() == 15){
	    		
	    	}
	    	break;
	    	
	    case 5 :
	    	//Advance to Trafalgar Square(student bar). If you pass Go collect £200.//
	    	if(currPlayer.getPosition() > 24){
	    		currPlayer.doTransaction(+200);
	    		currPlayer.moveToClubhouse();
	    		ui.displayString(currPlayer+" has been moved to the Clubhouse and has passed go and" + currPlayer + "has collected 200 euro");
	    	}
	    	else if(currPlayer.getPosition() < 24){
	    		currPlayer.moveToClubhouse();
	    	}
	    	else if(currPlayer.getPosition() == 24){
	    		
	    	}
	    	break;
	    
	    case 6 :
	    	//Advance to Mayfair(sutherland)
	    	if(currPlayer.getPosition() > 39){
	    		currPlayer.doTransaction(+200);
	    		currPlayer.moveToLaw();
	    		ui.displayString(currPlayer+" has been moved to Sutherland and has passed go and" + currPlayer + "has collected 200 euro");
	    	}
	    	else if(currPlayer.getPosition() < 24){
	    		currPlayer.moveToLaw();
	    	}
	    	else if(currPlayer.getPosition() == 24){
	    		
	    	}
	    	break;
	    	
	    case 7 :
	    	//go back 3 spaces
	    	currPlayer.move(-3);
	    	break;
	    
	    case 8 :
	    	//Make general repairs on all of your houses. For each house pay £25. For each hotel pay £100.
	    	break;
	    	
	    case 9 :
	    	//You are assessed for street repairs: £40 per house, £115 per hotel.
	    	break;
	    
	    case 10 :
	    	//Pay school fees of £150
	    	currPlayer.doTransaction(-150);
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    	
	    case 11 :
	    	//Drunk in charge fine £20.
	    	currPlayer.doTransaction(-20);
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    
	    case 12 :
	    	//Speeding fine £15.
	    	currPlayer.doTransaction(-15);
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    	
	    case 13 :
	    	//Your building loan matures. Receive £150.
	    	currPlayer.doTransaction(+150);
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    
	    case 14 :
	    	//You have won a crossword competition. Collect £100.
	    	currPlayer.doTransaction(+100);
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    	
	    case 15 :
	    	//Bank pays you dividend of £50.
	    	currPlayer.doTransaction(+50);
	    	ui.displayBankTransaction(currPlayer);
	    	break;
	    
	    case 16 :
	    	//Get out of jail free. This card may be kept until needed or sold.
	    	break;
	    	
	    default :
	        System.out.println("Invalid output");
	  }
	  return;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void displayGameOver () {
		ui.displayGameOver ();
		return;
	}
	
	public boolean isGameOver () {
		return gameOver;
	}
}