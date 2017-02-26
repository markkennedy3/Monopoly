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
	public static void tokenPanel(JLayeredPane boardPanel,int w,int h) {
		
		for(int r = 0; r < monopoly.numOfPlayers; r++){
			//JLabel tokenPanel = new JLabel("Player " + (r+1)); Not necessary 
			JLabel tokenPanel = new JLabel(monopoly.namesArray[r].name);
			  tokenPanel.setVisible(true);
	         
			  tokenPanel.setBounds(Properties.propertiesArray[r].xcoordinate, Properties.propertiesArray[r].ycoordinate ,30,30);
			  tokenPanel.setBackground(PLAYER_COLORS[r]);
			  tokenPanel.setFont(new Font("Arial",Font.BOLD, 10));
		   
		       tokenPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
			  
			  boardPanel.add(tokenPanel, new Integer(r+1));
		}
		  
		 

	}
	
	
	public static void moveToken(int squares, JLabel tokenPanel){
		int position;
		
		
		tokenPanel.setBounds(Properties.propertiesArray[1].xcoordinate, Properties.propertiesArray[1].ycoordinate ,40,40);
		
		

		
		
		
		
		
		
		
		
		
		
		
	/*	
		Properties a = new Properties(1,2,3,4);
		Properties b = new Properties(1,2,3,4);
		Properties c = new Properties(1,2,3,4);
		Properties d = new Properties(1,2,3,4);
		Properties e = new Properties(1,2,3,4);
		Properties f = new Properties(1,2,3,4);
		Properties g = new Properties(1,2,3,4);
		Properties h = new Properties(1,2,3,4);
		Properties i = new Properties(1,2,3,4);
		Properties j = new Properties(1,2,3,4);
		Properties k = new Properties(1,2,3,4);
		Properties l = new Properties(1,2,3,4);
		Properties m = new Properties(1,2,3,4);
		Properties n = new Properties(1,2,3,4);
		Properties o = new Properties(1,2,3,4);
		Properties p = new Properties(1,2,3,4);
		Properties q = new Properties(1,2,3,4);
		Properties r = new Properties(1,2,3,4);
		Properties s = new Properties(1,2,3,4);
		Properties t = new Properties(1,2,3,4);
		Properties u = new Properties(1,2,3,4);
		Properties v = new Properties(1,2,3,4);
		Properties w = new Properties(1,2,3,4);
		Properties x = new Properties(1,2,3,4);
		Properties y = new Properties(1,2,3,4);
		Properties z = new Properties(1,2,3,4);
		Properties aa = new Properties(1,2,3,4);
		Properties bb= new Properties(1,2,3,4);
		Properties cc= new Properties(1,2,3,4);
		Properties dd= new Properties(1,2,3,4);
		Properties ee= new Properties(1,2,3,4);
		Properties ff= new Properties(1,2,3,4);
		Properties gg = new Properties(1,2,3,4);
		Properties hh = new Properties(1,2,3,4);
		Properties ii = new Properties(1,2,3,4);
		Properties jj = new Properties(1,2,3,4);
		Properties kk = new Properties(1,2,3,4);
		Properties ll = new Properties(1,2,3,4);
		Properties mm = new Properties(1,2,3,4);
		Properties nn = new Properties(1,2,3,4);
		
		
		*/
		
		
		
		
		

	
}
	
	
}
