import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.swing.*;
import javax.swing.JLayeredPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
public class Board
{
	public static void board(JFrame frame,JLayeredPane boardPanel,int w,int h) {

  JPanel monopolyBoard = new JPanel();
  monopolyBoard.setOpaque(true);
  monopolyBoard.setBounds(1,1,h-1,h-1);
   
  monopolyBoard.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
 
  
  ImageIcon icon = new ImageIcon("monopoly.png");
  
  Image image = icon.getImage();
  
  
  BufferedImage bufferedImage2 = new BufferedImage((h),(h-50), BufferedImage.TYPE_INT_ARGB);
  Graphics g = bufferedImage2.createGraphics();
  g.drawImage(image,0,0,(h),(h-50),null);
  ImageIcon newIcon = new ImageIcon(bufferedImage2);
  JLabel label = new JLabel(newIcon);
  
  monopolyBoard.add(label);
   boardPanel.add(monopolyBoard, new Integer(0));


 }}