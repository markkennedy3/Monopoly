import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

public class Dice {
	
	public static int totalresult;
	
	public static int Dice(JLayeredPane boardPanel){
		
		
		 MainFrame.result=(int)(Math.random()*6+1);
		 System.out.println(MainFrame.result);
		
		 JButton diceButton = new JButton();
		 diceButton.setOpaque(true);
	     diceButton.setBounds(450,200,60,60);
	    
	     if(MainFrame.result==1){
	     ImageIcon icon = new ImageIcon("res/images/1.png");
	     Image image = icon.getImage();
	     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
	     Graphics g = bufferedImage.createGraphics();
	     g.drawImage(image,0,0,60,60,null);
	     ImageIcon newIcon = new ImageIcon(bufferedImage);
	     JLabel label2 = new JLabel(newIcon);
	     diceButton.add(label2, BorderLayout.CENTER);
	     
	     boardPanel.add(diceButton);}
	    
	     else if(MainFrame.result==2){
	         ImageIcon icon = new ImageIcon("res/images/2.png");
	         Image image = icon.getImage();
	         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
	         Graphics g = bufferedImage.createGraphics();
	         g.drawImage(image,0,0,60,60,null);
	         ImageIcon newIcon = new ImageIcon(bufferedImage);
	         JLabel label3 = new JLabel(newIcon);
	         diceButton.add(label3, BorderLayout.CENTER);
	         
	         boardPanel.add(diceButton);}
	         
	     else if(MainFrame.result==3){
         ImageIcon icon = new ImageIcon("res/images/3.png");
         Image image = icon.getImage();
         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
         Graphics g = bufferedImage.createGraphics();
         g.drawImage(image,0,0,60,60,null);
         ImageIcon newIcon = new ImageIcon(bufferedImage);
         JLabel label4 = new JLabel(newIcon);
         diceButton.add(label4, BorderLayout.CENTER);
         
         boardPanel.add(diceButton);}
	     
	     else if(MainFrame.result==4){
         ImageIcon icon = new ImageIcon("res/images/4.png");
         Image image = icon.getImage();
         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
         Graphics g = bufferedImage.createGraphics();
         g.drawImage(image,0,0,60,60,null);
         ImageIcon newIcon = new ImageIcon(bufferedImage);
         JLabel label5 = new JLabel(newIcon);
         diceButton.add(label5, BorderLayout.CENTER);
         
         boardPanel.add(diceButton);}
	     
	     else if(MainFrame.result==5){
         ImageIcon icon = new ImageIcon("res/images/5.png");
         Image image = icon.getImage();
         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
         Graphics g = bufferedImage.createGraphics();
         g.drawImage(image,0,0,60,60,null);
         ImageIcon newIcon = new ImageIcon(bufferedImage);
         JLabel label6 = new JLabel(newIcon);
         diceButton.add(label6, BorderLayout.CENTER);
         
         boardPanel.add(diceButton);}
	     
	     else if(MainFrame.result==6){
         ImageIcon icon = new ImageIcon("res/images/6.png");
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
     ImageIcon icon = new ImageIcon("res/images/1.png");
     Image image = icon.getImage();
     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
     Graphics g = bufferedImage.createGraphics();
     g.drawImage(image,0,0,60,60,null);
     ImageIcon newIcon = new ImageIcon(bufferedImage);
     JLabel label2 = new JLabel(newIcon);
     diceButton.add(label2, BorderLayout.CENTER);
     
     boardPanel.add(diceButton);}
    
     else if(MainFrame.result2==2){
         ImageIcon icon = new ImageIcon("res/images/2.png");
         Image image = icon.getImage();
         BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
         Graphics g = bufferedImage.createGraphics();
         g.drawImage(image,0,0,60,60,null);
         ImageIcon newIcon = new ImageIcon(bufferedImage);
         JLabel label3 = new JLabel(newIcon);
         diceButton.add(label3, BorderLayout.CENTER);
         
         boardPanel.add(diceButton);}
         
     else if(MainFrame.result2==3){
     ImageIcon icon = new ImageIcon("res/images/3.png");
     Image image = icon.getImage();
     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
     Graphics g = bufferedImage.createGraphics();
     g.drawImage(image,0,0,60,60,null);
     ImageIcon newIcon = new ImageIcon(bufferedImage);
     JLabel label4 = new JLabel(newIcon);
     diceButton.add(label4, BorderLayout.CENTER);
     
     boardPanel.add(diceButton);}
     
     else if(MainFrame.result2==4){
     ImageIcon icon = new ImageIcon("res/images/4.png");
     Image image = icon.getImage();
     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
     Graphics g = bufferedImage.createGraphics();
     g.drawImage(image,0,0,60,60,null);
     ImageIcon newIcon = new ImageIcon(bufferedImage);
     JLabel label5 = new JLabel(newIcon);
     diceButton.add(label5, BorderLayout.CENTER);
     
     boardPanel.add(diceButton);}
     
     else if(MainFrame.result2==5){
     ImageIcon icon = new ImageIcon("res/images/5.png");
     Image image = icon.getImage();
     BufferedImage bufferedImage = new BufferedImage((60),(60), BufferedImage.TYPE_INT_ARGB);
     Graphics g = bufferedImage.createGraphics();
     g.drawImage(image,0,0,60,60,null);
     ImageIcon newIcon = new ImageIcon(bufferedImage);
     JLabel label6 = new JLabel(newIcon);
     diceButton.add(label6, BorderLayout.CENTER);
     
     boardPanel.add(diceButton);}
     
     else if(MainFrame.result2==6){
     ImageIcon icon = new ImageIcon("res/images/6.png");
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
	
	
public static void Switch(JLabel tokenPanel,int result,int result2) 

{
	
	totalresult = result+result2;

    switch(totalresult) 
    
    {
    
       case 1 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
    	  
          System.out.println("Output 1"); 
          break;
       case 2 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
          System.out.println("Output 2");
          break;
       case 3 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
          System.out.println("Output 3");
          break;
       case 4 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
          System.out.println("Output 4");
          break;
       case 5 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
           System.out.println("Output 5");
           break;
       case 6 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
           System.out.println("Output 6");
           break;
       case 7 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
           System.out.println("Output 7");
           break;
       case 8 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
           System.out.println("Output 8");
           break;
       case 9 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
           System.out.println("Output 9");
           break;
       case 10 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
           System.out.println("Output 10");
           break;
       case 11 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
           System.out.println("Output 11");
           break;
       case 12 :
    	   for(int r = 0; r < monopoly.numOfPlayers; r++){
    		   tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
    	   }
           System.out.println("Output 12");
           break;
       /*case 13 :
    	   if(result==result2)
    		{
    		    tokenPanel.setBounds(Properties.propertiesArray[12].xcoordinate, Properties.propertiesArray[12].ycoordinate ,30,30);
    			System.out.println("They are the same re-roll");
    		}
    	   
           System.out.println("Output 13");
           break;*/
           
       default :
          System.out.println("Invalid output");
    }
    System.out.println("the total rolled dice amount is " + totalresult);
}
}
	