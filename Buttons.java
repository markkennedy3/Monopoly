import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.EtchedBorder;


public class Buttons {
	
	static Dimension x = new Dimension(100,100);
	
	
	
public static void buttonsPanel(JFrame frame,int w,int h,JTextArea outputText) 

{
	
		 JPanel buttonsPanel = new JPanel();
		 frame.add(buttonsPanel);
		 buttonsPanel.setBounds(w-((((w-h)/3)*1)),1,((((w-h)/3)*1)),h);
		 buttonsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
			 		
		 
		 JButton buyButton = new JButton("Buy Property");
		 buttonsPanel.add(buyButton);
		 buyButton.setPreferredSize(x);
		 
		 
		 
		 
		 JButton nextplayerButton = new JButton("Next Player");
		 buttonsPanel.add(nextplayerButton);
		 nextplayerButton.setPreferredSize(x);
		 
		 
		 
		 
		 
		 JButton balanceButton = new JButton("Current Balance");
		 buttonsPanel.add(balanceButton);
		 balanceButton.setPreferredSize(x);
		 balanceButton.setFont(new Font("Arial", Font.PLAIN, 12));
		 
		 balanceButton.addActionListener(new ActionListener() { 
			    public void actionPerformed(ActionEvent e) 
			    { 
			    	Players.getPosition();
			    	JOptionPane.showMessageDialog(null, Players.position);
			        Players.getBalance();
			        JOptionPane.showMessageDialog(null, Players.balance);
			    } 
			});
		 
		 
		 
		 
		 
		 JButton quitButton = new JButton("Quit");
		 buttonsPanel.add(quitButton);
		 quitButton.setPreferredSize(x);
		 
		 
		 
		 
		 
		 
		 
		 JButton helpButton = new JButton("Help");
		 buttonsPanel.add(helpButton);
		 helpButton.setPreferredSize(x);
		 
		 helpButton.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
		     
			 JOptionPane.showMessageDialog(null, 
					 " At the start of the game, players need to lay out the game board and place the Chance and Community Chest cards on the appropriate spots.\n "
			 		+ "Next, each player chooses a token from the available set and places it on the Go space.\n "
			 		+ "One player must act as the Banker, issuing each player $1,500 and placing the remaining money, along with the property deeds and property tokens, in the Bank area. Finally, play begins with the Banker rolling\n"
			 		+ " the dice and moving the token the appropriate number of spaces. Each subsequent player rolls the dice and moves their tokens, following the instructions of the spaces on which they land.\n"
			 		+ " Some may instruct a player to draw a card, while others may send the player to Jail. Each player that lands on a vacant property has the option to purchase the property.\n"
			 		+ " If a player lands on a property in the possession of another, that player must pay the owner rent. Each time another passes the Go square, that player collects $200.");
		     
		   }
		 });
		 
		 
		 
		 
		 
		 JButton endgameButton = new JButton("End Game");
		 buttonsPanel.add(endgameButton);
		 endgameButton.setPreferredSize(x);
		 
		 endgameButton.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   int quit = JOptionPane.showConfirmDialog(null,"Are you sure you wish to exit application?",null, JOptionPane.YES_NO_OPTION);
					if(quit == JOptionPane.YES_OPTION) 
						JOptionPane.showMessageDialog(null, "Goodbye"); 
					
					if(quit == JOptionPane.NO_OPTION)
						JOptionPane.showMessageDialog(null, "Thanks for staying");
					{
					    System.exit(0);
					} 
		     
		   }
		 });
		 
		 
		 
		 
		 
		 
		 
}}
	            
	   		 
		 