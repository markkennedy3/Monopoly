import java.awt.*;
import javax.swing.*;

import javax.swing.JOptionPane;
class monopoly {

	
	public static String commandInput = " ";
	public static final int NUM_OF_SQUARES = 40;
	public static final int MAX_PLAYERS = 6;
	public static Players[] namesArray = new Players[MAX_PLAYERS];
	public static int numOfPlayers = 0;
	
	
	    
 
 public static void addText(JTextArea outputText, String y){
	    	
	    outputText.append(y + "\n");
	    	
	  }


 public static void Questions(){
	 String y;
	 y = JOptionPane.showInputDialog("Enter the number of players");
	  numOfPlayers = Integer.parseInt(y);
	 
		 while(numOfPlayers > 6 || numOfPlayers < 2){
		 JOptionPane.showMessageDialog(null, "Incorrect number of players try again");
		 y = JOptionPane.showInputDialog("Enter the number of players");
		 numOfPlayers = Integer.parseInt(y);
		 if(numOfPlayers <= 6 && numOfPlayers >=2){
			 break;
		 }
		 }
	 
	 
	 String z = null;
	 for(int i = 1; i < numOfPlayers + 1;i++){
		 z = JOptionPane.showInputDialog("Please enter name number : " + i);
		 
		 namesArray[i-1] = new Players();
		 namesArray[i-1].name = z;
		 
		 }
	for(int i = 0; i < numOfPlayers; i++){
		
		JOptionPane.showMessageDialog(null, namesArray[i].name);
	}
	
	
	
	
}


	
public static void main(String args[]) {

MainFrame.mainFrame();
Questions();
 
}



}