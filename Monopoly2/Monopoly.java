import java.util.ArrayList;

public class Monopoly {

	public static final int MAX_NUM_PLAYERS = 6;
	private static final int START_MONEY = 1500;
	private static final int GO_MONEY = 200;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player currPlayer;
	private UI ui = new UI(players);
	private int numPlayers;
	private Dice dice = new Dice();
	private boolean gameOver = false;
	private Board board = new Board();
	
	Monopoly () {
		numPlayers = 0;
		ui.display();
		return;
	}
	
	public void inputNames () {
		do {
			ui.inputName(numPlayers);
			if (!ui.isDone()) {
				players.add(new Player(ui.getString(),ui.getTokenName(numPlayers)));
				numPlayers++;
			}
		} while (!ui.isDone() && numPlayers!=MAX_NUM_PLAYERS);
		return;
	}
	
	
	public void giveStartMoney () {
		for (Player p : players) {
			p.doTransaction (START_MONEY);
			ui.displayBankTransaction (p);
		}
		return;
	}
	
	public void decideStarter () {
		ArrayList<Player> inPlayers = new ArrayList<Player>(players), 
				selectedPlayers = new ArrayList<Player>();
		boolean tie = false;
		do {
			int highestTotal = 0;
			for (Player p : inPlayers) {
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
				inPlayers = new ArrayList<Player>(selectedPlayers);
				selectedPlayers.clear();
			}
		} while (tie);
		currPlayer = selectedPlayers.get(0);
		ui.displayRollWinner(currPlayer);
		ui.display();
		return;
	}

	public void processTurn () {
		boolean turnFinished = false;
		boolean rollDone = false;
		boolean rentOwed = false;
		boolean rentPaid = false;
		do {
			ui.inputCommand(currPlayer);
			switch (ui.getCommandId()) {
				case UI.CMD_ROLL :
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
							ui.displaySquare(currPlayer, board);
							if (board.isProperty(currPlayer.getPosition()) && 
									board.getProperty(currPlayer.getPosition()).isOwned() &&
									!board.getProperty(currPlayer.getPosition()).getOwner().equals(currPlayer) ) {
										rentOwed = true;
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
					}
					break;
				case UI.CMD_PAY_RENT :
					if (board.isProperty(currPlayer.getPosition())) {
						Property property = board.getProperty(currPlayer.getPosition());
						if (property.isOwned()) {
							if (!property.getOwner().equals(currPlayer)) {
								if (!rentPaid) {
									if (currPlayer.getBalance()>=property.getRent()) {
										Player owner = property.getOwner();
										currPlayer.doTransaction(-property.getRent());
										owner.doTransaction(+property.getRent());
										ui.displayTransaction(currPlayer, owner);
										rentPaid = true;	
										rentOwed = false;
								      } else {
									 ui.displayError(UI.ERR_INSUFFICIENT_FUNDS);	
									 ui.displayError(UI.ERR_BANKRUPT);
								  }
								} else {
									ui.displayError(UI.ERR_RENT_ALREADY_PAID);									
								}
							} else {
								ui.displayError(UI.ERR_SELF_OWNED);								
							}
						} else {
							ui.displayError(UI.ERR_NOT_OWNED);							
						}
					} else {
						ui.displayError(UI.ERR_NOT_A_PROPERTY);
					}
					break;
				case UI.CMD_BUY :
					if (board.isProperty(currPlayer.getPosition())) {
						Property property = board.getProperty(currPlayer.getPosition());
						if (!property.isOwned()) {
							if (currPlayer.getBalance() >= property.getValue()) {				
								currPlayer.doTransaction(-property.getValue());
								ui.displayBankTransaction(currPlayer);
								currPlayer.boughtProperty(property);
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
					break;
				case UI.CMD_BALANCE :
					ui.displayBalance(currPlayer);
					break;
				case UI.CMD_PROPERTY :
					ui.displayProperty(currPlayer);
					break;
				case UI.CMD_HELP :
					ui.displayCommandHelp();
					break;
				case UI.CMD_DONE :
					if (rollDone) {
						if (!rentOwed || (rentOwed && rentPaid)) {
							turnFinished = true;
						} else {
							ui.displayError(UI.ERR_RENT_OWED);
						}
					} else {
						ui.displayError(UI.ERR_NO_ROLL);
					}
					break;
				case UI.CMD_QUIT : 
					turnFinished = true;
					gameOver = true;
					break;
				case UI.CMD_BANKRUPT : 
					players.remove(currPlayer);
					numPlayers -= 1;
					 if(numPlayers==1){
						 gameOver = true;
					 }
					turnFinished = true;
					break;	
				case UI.CMD_BUILD : 
					ui.displayError(UI.ERR_BUILD);
					break;	
				
			}
		} while (!turnFinished);
		return;
	}
	
	public void nextPlayer () {
			currPlayer = players.get((players.indexOf(currPlayer) + 1) % players.size());
		return;
	}
	
	public void decideWinner () {
		ArrayList<Player> playersWithMostAssets = new ArrayList<Player>();
		int mostAssets = players.get(0).getAssets();
		for (Player player : players) {
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