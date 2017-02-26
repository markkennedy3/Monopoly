
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class CommandPanel {
	
	static Dimension x = new Dimension(100,100);
	
	
	 public static void commandPanel(JFrame frame,int w,int h, JTextArea outputText) 
	 
	 {
			
		
	     
		 JPanel commandPanel = new JPanel();
		 frame.add(commandPanel);
		 commandPanel.setBounds(h,1,((((w-h)/3)*3)),h/5);
		 commandPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

		 JLabel inputLabel = new JLabel(" Enter command:");
		 commandPanel.add(inputLabel);
		   
		 JTextField inputText = new JTextField(30);
		 commandPanel.add(inputText);
		 inputText.setEditable(true);



		 class AddInterestListener implements ActionListener{
		 	public void actionPerformed(ActionEvent event){
		 		
		 		monopoly.commandInput = inputText.getText();
		 		
		 		if(monopoly.commandInput=="roll")
		 		
		 		{
		 			
		            System.out.println("true");
		              
		        }
		 		monopoly.addText(outputText,monopoly.commandInput);
		 	}
		 }
		 		
		 		
		 
		 
		 
		 

		 JButton inputButton = new JButton("Input");
		 commandPanel.add(inputButton);
		 ActionListener listener = new AddInterestListener();
		 inputButton.addActionListener(listener);
		 
		 
		 
		 
		 }
	 
	     
	 
	 
}