import java.util.ArrayList;


public class Monopoly {

	private static final int START_MONEY = 1500;
	private static final int GO_MONEY = 200;
	private static final int TAX_MONEY = 200;
	
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
		if(currPlayer.isInJail() == true){
			dice.roll();
			ui.displayDice(currPlayer, dice);
			if(dice.isDouble()){
				currPlayer.move(dice.getTotal());
				ui.displayGetOutOfJail(currPlayer);
			}
			else{
				numOfStrikes += 1;
				ui.displayNotGetOutOfJail(currPlayer);//Different display for not getting out of jail
				if(numOfStrikes == 3){
					currPlayer.move(dice.getTotal());
					
					int fine = currPlayer.getFine();
					currPlayer.payFine(-fine);
					ui.displayFine(currPlayer);
					currPlayer.inJail = false;
					
				}
			}
		}else{
		if (!rollDone) {
			if (!rentOwed) {
				dice.roll();
				ui.displayDice(currPlayer, dice);
				currPlayer.move(dice.getTotal());
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
			numOfDoubles += 1;
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
			} else {
				ui.displayError(UI.ERR_NOT_OWNED);							
			}
		} 
	
		
	
		if(currPlayer.getPosition() == 4 || currPlayer.getPosition() == 38){
			processPayTax();
		}
	
		
		if(currPlayer.getPosition() == 2 || currPlayer.getPosition() == 17 || currPlayer.getPosition() == 33){
			Cards.CommunityChest();
			ui.displayLandedOnCommunityChest(currPlayer);
			ui.displaySquare(currPlayer, board, dice);
     	}
		
		
	
		if(currPlayer.getPosition() == 7 || currPlayer.getPosition() == 22 || currPlayer.getPosition() == 36){
            Cards.Chance();
			ui.displayLandedOnChance(currPlayer);
			ui.displaySquare(currPlayer, board, dice);
			turnFinished = false;
		}
		
		
		if(numOfDoubles == 3){//If there are 3 doubles in a row
     		int positionFromJail = currPlayer.getPositionsFromJail();
			currPlayer.moveToJail(positionFromJail);
			currPlayer.inJail = true;
			rollDone = true;
		}
		
		if(board.getSquare(currPlayer.getPosition()) instanceof Square){
		if(currPlayer.getPosition() == 30){
			int positionFromJail = currPlayer.getPositionsFromJail();
			currPlayer.moveToJail(positionFromJail);
			ui.displayRolledToJail(currPlayer);
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
					Cards.Chance();
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
	
	public void displayGameOver () {
		ui.displayGameOver ();
		return;
	}
	
	public boolean isGameOver () {
		return gameOver;
	}
}