import javax.swing.*;
import javax.swing.border.EtchedBorder;


public class InfoPanel {
public static void createInfoPanel(JFrame frame,int w,int h,JTextArea outputText) {//creates the info panel
	

		 JLabel outputLable = new JLabel(" Information Panel:");//creates and sets position of the panel
		 JPanel infoPanel = new JPanel();
		 frame.add(infoPanel);
		 infoPanel.setBounds(h,h/5,((((w-h)/3)*2)),((h/5)*4));
		 infoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		 infoPanel.add(outputLable);

		 outputText.setEditable(false);
		 infoPanel.add(outputText);
		 outputText.append(monopoly.commandInput + "\n");

		 
		 JScrollPane scrollPane = new JScrollPane(outputText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 frame.add(scrollPane);
		 infoPanel.add(scrollPane);
		 frame.setVisible(true);


		 } 
}