
public class Cards {
	
	private static int randomNumber;
	private static Players players = new Players();
	public static Player currPlayer;
	private static Dice dice = new Dice();
	private static Board board = new Board(dice);
	private static UI ui = new UI(players, board);
	
	
public static void CommunityChest() 

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
    	
    	//Leaving to stephen who is working on jail//
    	
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


public static void Chance() 

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
    	
    	//stephen for you//
    	
    	break;
    	
    case 3 :
    	//Go To pal mall(belgrove) if you pass go collect 200//
    	
    	
    	
    	break;
    
    case 4 :
    	//Take a trip to Marylebone Station(drumcondra) and if you pass Go collect £200.//
    	break;
    	
    case 5 :
    	//Advance to Trafalgar Square(student bar). If you pass Go collect £200.//
    	break;
    
    case 6 :
    	//Advance to Mayfair(sutherland)
    	break;
    	
    case 7 :
    	//go back 3 spaces
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
  
}
}