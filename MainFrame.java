import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class MainFrame {
	
	public static int result;
	public static int result2;
	
	public static void mainFrame() {
		
		
		
		 JFrame frame = new JFrame();
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
		
	    
		Board.board(frame,boardPanel,w,h);
		
		Dice.Dice(boardPanel);
		
		Dice.Dice2(boardPanel);
	
		
		Dice.Reroll(result, result2);
		
		
		
		CommandPanel.commandPanel(frame,w,h,outputText);
		
		Buttons.buttonsPanel(frame,w,h,outputText);
	  
	    InfoPanel.infoPanel(frame,w,h,outputText);
	    
	    
		monopoly.addText(outputText,x);
		
		
		
		//monopoly.Questions();
		Properties.Props();
		
		
		
		
		tokens.tokenPanel(boardPanel,w,h);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		 
	    }

}
