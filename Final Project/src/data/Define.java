package data;

import java.awt.*;

public class Define {
	
	
	
	
	public static int scorewidth = 0;
	public static Color colorBackground = Color.GRAY;
	public static Color colorHeadP1 = Color.RED;
	public static Color colorHeadP2 = Color.GREEN;
	public static Color colorBody = new Color(0 , 255, 255); //藍綠
	public static Color colorWall = new Color(8*16+4 , 4*16+2, 0); //咖啡
	public static Color colorFood = Color.ORANGE;
	public static Color colorCave = Color.DARK_GRAY;
	
	
	public static int P1StartX = 10;
	public static int P1StartY = 10;
	public static int P2StartX = 10;
	public static int P2StartY = 480;
	public static int CaveEntry1X = 120;
	public static int CaveEntry1Y = 120;
	public static int CaveExit1X = 380;
	public static int CaveExit1Y = 380;
	public static int CaveEntry2X = 380;
	public static int CaveEntry2Y = 120;
	public static int CaveExit2X = 120;
	public static int CaveExit2Y = 380;
	
	public static int amountWall = 10;
	public static int unit = 10;
	public static int FormNum = 10;
	public static int width = 500;
	public static int heighth = 500;
	public static int RAND_POS = 49;
	public static int slowRepaint = 100;
	public static int fastRepaint = 50;
	public static int needInCaveTime = 1000;
	
	public static int menuState = 0;
	public static int gameState = 1;
	public static int gamePauseState = 2;
	public static int gameOverState = 3;
	public static int ruleState = 4;
	public static int nobody = 0;
	public static int singleMode = 1;
	public static int mutiMode = 2;
	
	public static int BTWidth = 100;
	public static int BTHeighth = 50;
	public static int BTdis = 30;
	public static int BTX = 200;
	public static int BTY = 150;
	
	public static int TitleWidth = 300;
	public static int TitleHeighth = 70;
	public static int TitleX = 135;
	public static int TitleY = 50;
	
	public static int stop = 0;
	public static int up = 1;
	public static int down = -1;
	public static int right = 2;
	public static int left = -2;
	
	public static String strStartTwo = "StartTwo";
	public static String strStartOne = "StartOne";
	public static String strReturnMenu = "RetunrMenu";
	public static String strTimer = "Timer";
	public static String strExit = "Exit";
	
	
	
}
