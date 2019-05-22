package server;

public class Data {
	static int size = 3;
	static int intBlank = 0;
	static int intO = 1;
	static int intX = 2;
	static int step = 0;
	static int intOwin = 3;
	static int intXwin = -3;
	static int[][] map = {{0, 0, 0},
					  	  {0, 0, 0},
					  	  {0, 0, 0}};
	static String[][] strMap = {{"(0,0)", "(0,1)", "(0,2)"},
								{"(1,0)", "(1,1)", "(1,2)"},
								{"(2,0)", "(2,1)", "(2,2)"}};
	static boolean isOTurn = true;
	static boolean winnerExist = false;
	static boolean isRead = true;
	static boolean isWrite = false;
	static boolean isSetup = false;
	static String port = "2001";
	static String IP = "0.0.0.0";
	static String strSetup = "Setup";
	
	public static void show() {
		System.out.println("Step" + step + " : ");
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void changePlayer() {
		isOTurn = !isOTurn;
	}
	
	public Data(int[][] newMap) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				map[i][j] = newMap[i][j];
			}
		}
	}
	
	public static void put(String strNewClick) {
		int row = strNewClick.charAt(6) - '0';
		int col = strNewClick.charAt(14) - '0';
		if(map[row][col] == intBlank) {
			if(isOTurn)
				map[row][col] = intO;
			else
				map[row][col] = intX;
		}
		else {
			System.out.println("has been put");
		}
		show();
	}
	
	public static boolean CheckCircle() {
		int value = 0; //若為3 or -3 代表有人贏
		boolean circleWin = false;
		int row = 0, col = 0; 
		//計算橫向
		for(row = 0; row < Data.size; row++) {
			value = 0;
			for(col = 0; col < Data.size; col++) {
				if(Data.map[row][col] == Data.intO) {
					value++;
				}
			}
			if(value == intOwin)
				circleWin = true;
		}
		if(circleWin) {
			System.out.println("O 橫向");
			return circleWin;
		}
		//檢查直向
		for(col = 0; col < Data.size; col++) {
			value = 0;
			for(row = 0; row < Data.size; row++) {
				if(Data.map[row][col] == Data.intO) {
					value++;
				}
			}
			if(value == intOwin)
				circleWin = true;
		}
		if(circleWin) {
			System.out.println("O 直向");
			return circleWin;
		}
		//檢查左上->右下
		value = 0;
		for(row = 0; row < Data.size; row++) {
			if(Data.map[row][row] == Data.intO) {
				value++;
			}
			if(value == intOwin)
				circleWin = true;
		}
		if(circleWin) {
			System.out.println("O 左上右下");
			return circleWin;
		}
		//檢查右上->左下
		value = 0;
		for(row = 0; row < Data.size; row++) {
			if(Data.map[row][Data.size - row - 1] == Data.intO) {
				value++;
			}
			if(value == intOwin)
				circleWin = true;
		}
		if(circleWin) {
			System.out.println("O 右上左下");
			return circleWin;
		}
		
		return circleWin;
	}
	
	public static boolean CheckCross() {
		int value = 0; //若為3 or -3 代表有人贏
		boolean crossWin = false;
		int row = 0, col = 0; 
		//計算橫向
		for(row = 0; row < Data.size; row++) {
			value = 0;
			for(col = 0; col < Data.size; col++) {
				if(Data.map[row][col] == Data.intX) {
					value--;
				}
			}
			if(value == intXwin)
				crossWin = true;
		}
		if(crossWin)
			return crossWin;
		//檢查直向
		for(col = 0; col < Data.size; col++) {
			value = 0;
			for(row = 0; row < Data.size; row++) {
				if(Data.map[row][col] == Data.intX) {
					value--;
				}
			}
			if(value == intXwin)
				crossWin = true;
		}
		if(crossWin)
			return crossWin;
		//檢查左上->右下
		value = 0;
		for(row = 0; row < Data.size; row++) {
			if(Data.map[row][row] == Data.intX) {
				value--;
			}
			if(value == intXwin)
				crossWin = true;
		}
		if(crossWin)
			return crossWin;
		//檢查右上->左下
		value = 0;
		for(row = 0; row < Data.size; row++) {
			if(Data.map[row][Data.size - row - 1] == Data.intX) {
				value--;
			}
			if(value == intXwin)
				crossWin = true;
		}
		if(crossWin)
			return crossWin;
		
		return crossWin;
	}
}
