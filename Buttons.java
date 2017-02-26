import java.awt.*;
import java.applet.Applet;
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
		 buttonsPanel.setBounds(h+358,h/5,((((w-h)/3)*1)),((h/5)*4));
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
			        Players.getBalance();
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
		     
			 JOptionPane.showMessageDialog(null, "Test");
		     
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
					{
					    System.exit(0);
					} 
					
					if(quit == JOptionPane.NO_OPTION)
						JOptionPane.showMessageDialog(null, "Thanks for staying");
		     
		   }
		 });
		 
		 
		 
		 
		 
		 
		 
}}
	            
	   		 
		 