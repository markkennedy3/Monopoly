import java.awt.Dimension;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class MainFrame {
	
	public static int result;
	public static int result2;
	
	public static void mainFrame() {//This function creates the JFrame and calls the other functions to commence the game
	
		
		 JFrame frame = new JFrame();//Creates and adjusts the JFrame
		 frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		 
		 frame.setDefaultCloseOperation
	         (JFrame.EXIT_ON_CLOSE);
			 
	    frame.setLayout(null);
		
	    frame.setVisible(true);
	      
	   	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	       double height = screenSize.getHeight();
	       double width = screenSize.getWidth();
	     
	       int h = (int)height;
	       int w = (int)width;
	 	
		JTextArea outputText = new JTextArea(30,20);
		String x = " ";
		
		JLayeredPane boardPanel = new JLayeredPane();
		boardPanel.setOpaque(true);
	    frame.add(boardPanel);
	  
	    boardPanel.setBounds(0,0,h,h);  
	   
	   
	    boardPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
	    //function calls below
	    
		Board.createBoard(frame,boardPanel,w,h);
		
		Dice.Dice(boardPanel);
		
		Dice.Dice2(boardPanel);
	
		
		Dice.Reroll(result, result2);
		
		
		
		CommandPanel.createCommandPanel(frame,w,h,outputText);
		
		Buttons.buttonsPanel(frame,w,h,outputText);
	  
	    InfoPanel.createInfoPanel(frame,w,h,outputText);
	    
	    
		monopoly.addText(outputText,x);
		
		
		
		monopoly.Questions();//Call the questions
		
		Properties.Props();//Fills/Creates the array of objects of properties
		
		tokens.tokenPanel(boardPanel ,w,h);
		
		Dice.Switch(tokens.labelNames[0], result, result2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		 
	    }

}
