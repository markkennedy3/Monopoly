import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.util.Random;
import java.awt.BorderLayout;


public class Dice {
	
	
	public static int Dice(JLayeredPane boardPanel){
		
		
		 MainFrame.result=(int)(Math.random()*6+1);
		 System.out.println(MainFrame.result);
		
		 JButton diceButton = new JButton();
		 diceButton.setOpaque(true);
	     diceButton.setBounds(450,200,60,60);
	    
	     if(MainFrame.result==1){
	     ImageIcon icon = new ImageIcon("1.png");
	     Image image = icon.getImage();
	     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
	     Graphics g = bufferedImage.createGraphics();
	     g.drawImage(image,0,0,60,60,null);
	     ImageIcon newIcon = new ImageIcon(bufferedImage);
	     JLabel label2 = new JLabel(newIcon);
	     diceButton.add(label2, BorderLayout.CENTER);
	     
	     boardPanel.add(diceButton);}
	    
	     else if(MainFrame.result==2){
	         ImageIcon icon = new ImageIcon("2.png");
	         Image image = icon.getImage();
	         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
	         Graphics g = bufferedImage.createGraphics();
	         g.drawImage(image,0,0,60,60,null);
	         ImageIcon newIcon = new ImageIcon(bufferedImage);
	         JLabel label3 = new JLabel(newIcon);
	         diceButton.add(label3, BorderLayout.CENTER);
	         
	         boardPanel.add(diceButton);}
	         
	     else if(MainFrame.result==3){
         ImageIcon icon = new ImageIcon("3.png");
         Image image = icon.getImage();
         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
         Graphics g = bufferedImage.createGraphics();
         g.drawImage(image,0,0,60,60,null);
         ImageIcon newIcon = new ImageIcon(bufferedImage);
         JLabel label4 = new JLabel(newIcon);
         diceButton.add(label4, BorderLayout.CENTER);
         
         boardPanel.add(diceButton);}
	     
	     else if(MainFrame.result==4){
         ImageIcon icon = new ImageIcon("4.png");
         Image image = icon.getImage();
         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
         Graphics g = bufferedImage.createGraphics();
         g.drawImage(image,0,0,60,60,null);
         ImageIcon newIcon = new ImageIcon(bufferedImage);
         JLabel label5 = new JLabel(newIcon);
         diceButton.add(label5, BorderLayout.CENTER);
         
         boardPanel.add(diceButton);}
	     
	     else if(MainFrame.result==5){
         ImageIcon icon = new ImageIcon("5.png");
         Image image = icon.getImage();
         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
         Graphics g = bufferedImage.createGraphics();
         g.drawImage(image,0,0,60,60,null);
         ImageIcon newIcon = new ImageIcon(bufferedImage);
         JLabel label6 = new JLabel(newIcon);
         diceButton.add(label6, BorderLayout.CENTER);
         
         boardPanel.add(diceButton);}
	     
	     else if(MainFrame.result==6){
         ImageIcon icon = new ImageIcon("6.png");
         Image image = icon.getImage();
         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
         Graphics g = bufferedImage.createGraphics();
         g.drawImage(image,0,0,60,60,null);
         ImageIcon newIcon = new ImageIcon(bufferedImage);
         JLabel label7 = new JLabel(newIcon);
         diceButton.add(label7, BorderLayout.CENTER);
         
         boardPanel.add(diceButton);}
	     return MainFrame.result;
	}
		

public static int Dice2(JLayeredPane boardPanel){
	
	
	MainFrame.result2=(int)(Math.random()*6+1);
	System.out.println(MainFrame.result2);
	
	 JButton diceButton = new JButton();
	 diceButton.setOpaque(true);
     diceButton.setBounds(550,200,60,60);
   
     if(MainFrame.result2==1){
     ImageIcon icon = new ImageIcon("1.png");
     Image image = icon.getImage();
     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
     Graphics g = bufferedImage.createGraphics();
     g.drawImage(image,0,0,60,60,null);
     ImageIcon newIcon = new ImageIcon(bufferedImage);
     JLabel label2 = new JLabel(newIcon);
     diceButton.add(label2, BorderLayout.CENTER);
     
     boardPanel.add(diceButton);}
    
     else if(MainFrame.result2==2){
         ImageIcon icon = new ImageIcon("2.png");
         Image image = icon.getImage();
         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
         Graphics g = bufferedImage.createGraphics();
         g.drawImage(image,0,0,60,60,null);
         ImageIcon newIcon = new ImageIcon(bufferedImage);
         JLabel label3 = new JLabel(newIcon);
         diceButton.add(label3, BorderLayout.CENTER);
         
         boardPanel.add(diceButton);}
         
     else if(MainFrame.result2==3){
     ImageIcon icon = new ImageIcon("3.png");
     Image image = icon.getImage();
     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
     Graphics g = bufferedImage.createGraphics();
     g.drawImage(image,0,0,60,60,null);
     ImageIcon newIcon = new ImageIcon(bufferedImage);
     JLabel label4 = new JLabel(newIcon);
     diceButton.add(label4, BorderLayout.CENTER);
     
     boardPanel.add(diceButton);}
     
     else if(MainFrame.result2==4){
     ImageIcon icon = new ImageIcon("4.png");
     Image image = icon.getImage();
     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
     Graphics g = bufferedImage.createGraphics();
     g.drawImage(image,0,0,60,60,null);
     ImageIcon newIcon = new ImageIcon(bufferedImage);
     JLabel label5 = new JLabel(newIcon);
     diceButton.add(label5, BorderLayout.CENTER);
     
     boardPanel.add(diceButton);}
     
     else if(MainFrame.result2==5){
     ImageIcon icon = new ImageIcon("5.png");
     Image image = icon.getImage();
     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
     Graphics g = bufferedImage.createGraphics();
     g.drawImage(image,0,0,60,60,null);
     ImageIcon newIcon = new ImageIcon(bufferedImage);
     JLabel label6 = new JLabel(newIcon);
     diceButton.add(label6, BorderLayout.CENTER);
     
     boardPanel.add(diceButton);}
     
     else if(MainFrame.result2==6){
     ImageIcon icon = new ImageIcon("6.png");
     Image image = icon.getImage();
     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
     Graphics g = bufferedImage.createGraphics();
     g.drawImage(image,0,0,60,60,null);
     ImageIcon newIcon = new ImageIcon(bufferedImage);
     JLabel label7 = new JLabel(newIcon);
     diceButton.add(label7, BorderLayout.CENTER);
     
     boardPanel.add(diceButton);
     

}
	return MainFrame.result2;
	
}

public static boolean Reroll(int result, int result2){
	
	result=MainFrame.result;
	result2=MainFrame.result2;
	
	
	
	
	
	if(result==result2)
	{
		
		System.out.println("They are the same re-roll");
		return true;
		
	}
	
	else{
		
		System.out.println("They are not the same continue");
		return false;
		
		
		}
	}
	
	

	
	
	
}