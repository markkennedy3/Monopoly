import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JPanel;

public class tokens {
	
	//public int xcoordinate;
	//public int ycoordinate;
	public static final int MAX_PROPERTIES = 40;
	private static final Color[] PLAYER_COLORS = {Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN,Color.MAGENTA,Color.WHITE};
	public static JLabel[] labelNames = new JLabel[monopoly.MAX_PLAYERS];
	
	public static void tokenPanel(JLayeredPane boardPanel,int w,int h) {
		
		for(int r = 0; r < monopoly.numOfPlayers; r++){
			//JLabel tokenPanel = new JLabel("Player " + (r+1)); Not necessary 
			labelNames[r] = new JLabel(monopoly.namesArray[r].name);
			labelNames[r].setVisible(true);
	         
			labelNames[r].setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
			labelNames[r].setBackground(PLAYER_COLORS[r]);
			labelNames[r].setFont(new Font("Arial",Font.BOLD, 10));
		   
			labelNames[r].setBorder(new EtchedBorder(EtchedBorder.LOWERED));
			  
			  boardPanel.add(labelNames[r], new Integer(r+1));
		}
		  
		 

	}
	
	public static void moveToken(int squares, JLabel tokenPanel){
		//Get location of label? (Array Index)
		//Set new location ( + squares)
		//Refresh then?
		
		//tokenPanel.setBounds(Properties.propertiesArray[0 + squares].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);

		
}

		

	
}