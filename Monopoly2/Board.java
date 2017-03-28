
public class Board {
	
	
	
	public static final int NUM_SQUARES = 40;
		
	private Square[] squares = new Square[NUM_SQUARES];
	//our own implemented property names with colour (or null) included for grouping.
	Board () {
		squares[0] = new Square("Go",null);
		squares[1] = new Property("UCD Bike Shop","Brown", 60, new int[] {2,10,30,90,160,250});
		squares[2] = new Square("Comminity Chest",null);
		squares[3] = new Property("AIB UCD","Brown", 60, new int[] {4,20,60,180,320,450});
		squares[4]  = new Square("Income Tax",null);
		squares[5] = new Property("Dublin Pearse",null, 200, new int[] {25,50,100,200,200,200});
		squares[6] = new Property("Centra UCD","Cyan", 100, new int[] {6,30,90,270,400,550});
		squares[7] = new Square("Chance",null);
		squares[8] = new Property("Glenomena Residences","Cyan", 100, new int[] {6,30,90,270,400,550});
		squares[9] = new Property("Merville Residences","Cyan", 120, new int[] {8,40,100,300,450,600});
		squares[10] = new Square("Jail",null);
		squares[11] = new Property("Belgrove Residences","Pink", 140, new int[] {10,50,150,450,625,750});
		squares[12] = new Property("Electric Company",null,150, new int[] {4,10,0,0,0,0});
		squares[13] = new Property("Ashfield Residences","Pink", 140, new int[] {10,50,150,450,625,750});
		squares[14] = new Property("Roebuck Residences","Pink", 160, new int[] {12,60,180,500,700,900});
		squares[15] = new Property("Drumcondra",null, 200, new int[] {25,50,100,200,200,200});
		squares[16] = new Property("Engineering Building","Orange", 180, new int[] {14,70,200,550,750,950});
		squares[17] = new Square("Community Chest",null);
		squares[18] = new Property("Newman Building","Orange",180, new int[] {14,70,200,550,750,950});
		squares[19] = new Property("James Joyce Library","Orange",200, new int[] {16,80,220,600,800,1000});
		squares[20] = new Square("Free Parking",null);
		squares[21] = new Property("UCD Gym","Red", 220, new int[] {18,90,250,700,875,1050});
		squares[22] = new Square("Chance",null);
		squares[23] = new Property("UCD Swimming Pool","Red", 220, new int[] {18,90,250,700,875,1050});
		squares[24]  = new Property("UCD Student Bar","Red", 240, new int[] {20,100,300,750,925,1100});
		squares[25] = new Property("Dublin Hueston",null, 200, new int[] {25,50,100,200,200,200});
		squares[26] = new Property("Health Science Building","Yellow", 260, new int[] {22,110,330,800,975,1150});
		squares[27] = new Property("Richview Building","Yellow",260, new int[] {22,110,330,800,975,1150});
		squares[28] = new Property("Water Works",null, 150, new int[] {4,10,0,0,0,0});
		squares[29] = new Property("UCD Students Union","Yellow",280, new int[] {22,120,360,850,1025,1200});
		squares[30] = new Square("Go To Jail",null);
		squares[31] = new Property("O'Brien Centre Of Science","Green",300, new int[] {26,130,390,900,1100,1275});
		squares[32] = new Property("Vetinary Building","Green",300, new int[] {26,130,390,900,1100,1275});
		squares[33] = new Square("Community Chest", null);
		squares[34] = new Property("Computer Science Building", "Green",320, new int[] {28,150,450,1000,1200,1400});
		squares[35] = new Property("Dublin Connolly",null, 200, new int[] {25,50,100,200,200,200});
		squares[36] = new Square("Chance",null);
		squares[37] = new Property("Quinn School of Business", "Blue",350, new int[] {35,175,500,1100,1300,1500});
		squares[38] = new Square("Super Tax",null);
		squares[39] = new Property("Sutherland School Of Law","Blue", 400, new int[] {50,200,600,1400,1700,2000});
		return;
	}
	
	public Square getSquare (int index) {
		return squares[index];
	}
	
	public Property getProperty (int index) {
		return (Property) squares[index];
	}
	
	public boolean isProperty (int index) {
		return squares[index] instanceof Property;
	}
	
}
  