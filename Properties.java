import java.util.Arrays;

import javax.swing.JOptionPane;

public class Properties 

{	//Variables and array required to store content and constants etc.
	public int xcoordinate;
	public int ycoordinate;
	public String name;
	public int rent = 0;
	public String nameOfOwner = null;
	public int price;
	public static final int MAX_PROPERTIES = 41;
	public static Properties[] propertiesArray = new Properties[MAX_PROPERTIES];
	public static int [] priceArray = new int[MAX_PROPERTIES];
	public static int [] rentArray = new int[MAX_PROPERTIES];
	public static String [] namesArray = new String[MAX_PROPERTIES];
	//public static int [] propertiesArray = new int[MAX_PROPERTIES];
	public static int xCoordinate[] = new int[MAX_PROPERTIES];
	public static int yCoordinate[] = new int[MAX_PROPERTIES];
	
	public static Properties[] propertyNames = new Properties[MAX_PROPERTIES];
	
	
	
	
	public Properties(int x, int y, int cost, String propertyName){//Remember to include tax!!!
		 xcoordinate = x;
		 ycoordinate = y;
		 price = cost;
		// rent = tax;
		 name = propertyName;
	}
	
	public boolean isOccupied(){
		if(nameOfOwner != null){
			
			return true;
		}
		else{
			rent = 0;
			return false;
		}
		
	}
	
	public static void Props(){
		
		namesArray[0]= "Go";
		namesArray[1]="UCD Bike Shop";
		namesArray[2]="Community Chest";
		namesArray[3]="AIB UCD";
		namesArray[4]="Income Tax";
		namesArray[5]="Dublin Pearse";
		namesArray[6]="Centra UCD";
		namesArray[7]="Chance";
		namesArray[8]="Glenomena Residences";
		namesArray[9]="Merville Residences";
		namesArray[10]="Just Visiting";
		namesArray[11]="Belgrove Residences";
		namesArray[12]="Electric Company";
		namesArray[13]="Ashfield Residences";
		namesArray[14]="Roebuck Residences";
		namesArray[15]="Drumcondra";
		namesArray[16]="Engineering Building";
		namesArray[17]="Community Chest";
		namesArray[18]="Newman Building";
		namesArray[19]="James Joyce Library";
		namesArray[20]="Free Parking";
		namesArray[21]="UCD Gym";
		namesArray[22]="Chance";
		namesArray[23]="UCD Swimming Pool";
		namesArray[24]="UCD Student Bar";
		namesArray[25]="Dublin Hueston";
		namesArray[26]="Health Science Building";
		namesArray[27]="Richview Building";
		namesArray[28]="Water Works";
		namesArray[29]="UCD Students Union";
		namesArray[30]="Go To Jail";
		namesArray[31]="O'Brien Centre Of Science";
		namesArray[32]="Vetinary Building";
		namesArray[33]="Community Chest";
		namesArray[34]="Computer Science Building";
		namesArray[35]="Dublin Connolly";
		namesArray[36]="Chance";
		namesArray[37]="Quinn School of Business";
		namesArray[38]="Super Tax";
		namesArray[39]="Sutherland School Of Law";
		namesArray[40]="Jail";
		
		
		priceArray[0]= 0;
		priceArray[1]= 60;
		priceArray[2]= 0;
		priceArray[3]= 60;
		priceArray[4]= 0;
		priceArray[5]= 200;
		priceArray[6]= 100;
		priceArray[7]= 0;
		priceArray[8]= 100;
		priceArray[9]= 120;
		priceArray[10]= 0;
		priceArray[11]= 140;
		priceArray[12]= 0;
		priceArray[13]= 140;
		priceArray[14]= 160;
		priceArray[15]= 200;
		priceArray[16]= 180;
		priceArray[17]= 0;
		priceArray[18]= 180;
		priceArray[19]= 200;
		priceArray[20]= 0;
		priceArray[21]= 220;
		priceArray[22]= 0;
		priceArray[23]= 220;
		priceArray[24]= 240;
		priceArray[25]= 200;
		priceArray[26]= 260;
		priceArray[27]= 260;
		priceArray[28]= 0;
		priceArray[29]= 180;
		priceArray[30]= 0;
		priceArray[31]= 300;
		priceArray[32]= 300;
		priceArray[33]= 0;
		priceArray[34]= 320;
		priceArray[35]= 200;
		priceArray[36]= 0;
		priceArray[37]= 350;
		priceArray[38]= 0;
		priceArray[39]= 400;
		priceArray[40]= 0;
		
		xCoordinate[0]= 710;
		xCoordinate[1]= 625;
		xCoordinate[2]= 560;
		xCoordinate[3]= 500;
		xCoordinate[4]= 440;
		xCoordinate[5]= 380;
		xCoordinate[6]= 315;
		xCoordinate[7]= 250;
		xCoordinate[8]= 190;
		xCoordinate[9]= 125;
		xCoordinate[10]= 30;
		xCoordinate[11]= 30;
		xCoordinate[12]= 30;
		xCoordinate[13]= 30;
		xCoordinate[14]= 30;
		xCoordinate[15]= 30;
		xCoordinate[16]= 30;
		xCoordinate[17]= 30;
		xCoordinate[18]= 30;
		xCoordinate[19]= 30;
		xCoordinate[20]= 50;
		xCoordinate[21]= 125;
		xCoordinate[22]= 190;
		xCoordinate[23]= 250;
		xCoordinate[24]= 315;
		xCoordinate[25]= 380;
		xCoordinate[26]= 440;
		xCoordinate[27]= 500;
		xCoordinate[28]= 560;
		xCoordinate[29]= 625;
		xCoordinate[30]= 710;
		xCoordinate[31]= 710;
		xCoordinate[32]= 710;
		xCoordinate[33]= 710;
		xCoordinate[34]= 710;
		xCoordinate[35]= 710;
		xCoordinate[36]= 710;
		xCoordinate[37]= 710;
		xCoordinate[38]= 710;
		xCoordinate[39]= 710;
		xCoordinate[40]= 60;
		
		yCoordinate[0] = 670;
		yCoordinate[1]= 670;
		yCoordinate[2]= 670;
		yCoordinate[3]= 670;
		yCoordinate[4]= 670;
		yCoordinate[5]= 670;
		yCoordinate[6]= 670;
		yCoordinate[7]= 670;
		yCoordinate[8]= 670;
		yCoordinate[9]= 670;
		yCoordinate[10]= 670;
		yCoordinate[11]= 595;
		yCoordinate[12]= 540;
		yCoordinate[13]= 480;
		yCoordinate[14]= 420;
		yCoordinate[15]= 360;
		yCoordinate[16]= 300;
		yCoordinate[17]= 240;
		yCoordinate[18]= 180;
		yCoordinate[19]= 120;
		yCoordinate[20]= 55;
		yCoordinate[21]= 30;
		yCoordinate[22]= 30;
		yCoordinate[23]= 30;
		yCoordinate[24]= 30;
		yCoordinate[25]= 30;
		yCoordinate[26]= 30;
		yCoordinate[27]= 30;
		yCoordinate[28]= 30;
		yCoordinate[29]= 30;
		yCoordinate[30]= 30;
		yCoordinate[31]= 125;
		yCoordinate[32]= 180;
		yCoordinate[33]= 240;
		yCoordinate[34]= 300;
		yCoordinate[35]= 360;
		yCoordinate[36]= 420;
		yCoordinate[37]= 480;
		yCoordinate[38]= 540;
		yCoordinate[39]= 595;
		yCoordinate[40]= 665;
		

		for(int s = 0;s < 40;s++){
			propertiesArray[s] = new Properties(xCoordinate[s], yCoordinate[s], priceArray[s], namesArray[s]);
			
		}	
	
	}
	
	public void buyProperty(){
		if(isOccupied() == true){
			
		}
		//balance goes down
		//Name of owner is assigned the name of whatever player(object) buys it
		
	}
	
	public int getxCoordinate(){
		return xcoordinate;
	}
	
	public int getYCoordinate(){
		return ycoordinate;
	}

}

