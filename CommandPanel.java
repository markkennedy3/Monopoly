
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class CommandPanel {
	
	static Dimension x = new Dimension(100,100);
	
	
	 public static void createCommandPanel(JFrame frame,int w,int h, JTextArea outputText) 
	 
	 {
			
		
	     
		 JPanel commandPanel = new JPanel();//Creates and sets the command panel
		 frame.add(commandPanel);
		 commandPanel.setBounds(h,1,((((w-h)/3)*2)),h/5);
		 commandPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

		 JLabel inputLabel = new JLabel(" Enter command:");
		 commandPanel.add(inputLabel);
		   
		 JTextField inputText = new JTextField(30);
		 commandPanel.add(inputText);
		 inputText.setEditable(true);



		 class AddInterestListener implements ActionListener{//Listener that listens to the command input
		 	public void actionPerformed(ActionEvent event){
		 		
		 		monopoly.commandInput = inputText.getText();//gets text from command text field
		 		
		 		if(monopoly.commandInput=="roll")
		 		
		 		{
		 			
		            System.out.println("true");
		              
		        }
		 		monopoly.addText(outputText,monopoly.commandInput);//Adds the text to the information panel
		 	}
		 }
		 		
}
}