import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	import java.awt.Color;

	import javax.swing.JButton;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	import javax.swing.border.EtchedBorder;
	
	
public class Buy 
{
	

	
		
			public static void infoPanel(JFrame frame,int w,int h) {
			
				JButton BUY = new JButton();
				 BUY.setOpaque(true);
				 BUY.setBackground(Color.RED);
				 frame.add(BUY);
				 BUY.setBounds(w-100,0,100,100);
				 
			}
	

}
