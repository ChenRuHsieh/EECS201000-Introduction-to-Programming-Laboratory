package date;

public class Date {
	
	String date;
	int day;
	int month;
	int year;
	boolean isValid;
	//boolean isLeapYear;
	
	public Date(String M, String D, String Y) {
		
		isValid = dateIsValid(Integer.parseInt(Y), Integer.parseInt(M), Integer.parseInt(D));
		
		date = M + "/" + D + "/" + Y;	
		day = Integer.parseInt(D);
		month = Integer.parseInt(M);
		year = Integer.parseInt(Y);
	}
	
	public Date(String m, int D, int Y) {
		
		int mToInt = 0;
		
		if(m.equals("January")) {
			mToInt = 1;
		}
		else if(m.equals("February")) {
			mToInt = 2;
		}
		else if(m.equals("March")) {
			mToInt = 3;
		}
		else if(m.equals("April")) {
			mToInt = 4;
		}
		else if(m.equals("May")) {
			mToInt = 5;
		}
		else if(m.equals("June")) {
			mToInt = 6;
		}
		else if(m.equals("July")) {
			mToInt = 7;
		}
		else if(m.equals("August")) {
			mToInt = 8;
		}
		else if(m.equals("September")) {
			mToInt = 9;
		}
		else if(m.equals("October")) {
			mToInt = 10;
		}
		else if(m.equals("November")) {
			mToInt = 11;
		}
		else if(m.equals("December")) {
			mToInt = 12;
		}
		else {
			mToInt = 0;
		}
		
		isValid = dateIsValid(Y,mToInt, D);
		
		date = m + " " + D + ", " + Y;	
		day = D;
		month = mToInt;
		year = Y;
		
		
	}
	
	public Date(int Y, int M, int D) {
		
		isValid = dateIsValid(Y, M, D);
		
	
		date = Y + "" + M + "る" + D + "ら";
		day = D;
		month = M;
		year = Y;
	
	}
	
	public void print() {
		if(isValid)
			System.out.println(date);
		else
			System.out.println(date + "琌ぃ猭ら戳");
	}
	
	public int dateDistance(Date d) {
		int dis = 0;
		//int i = 0, j = 0;
		//int bigY, bigM, bigD;
		//int smallY, smallM, smallD;
		Date bigDate;
		Date smallDate;
		boolean isNe;
		
		if(isValid == false || d.isValid == false) {
			System.out.println("ら戳ぃ猭");
			return 0;
		}
		else if(isEqualTo(d)){
			return 0;
		}
		else if(isBiggerThan(d)) {
			bigDate = this;
			smallDate = d;
			isNe = false;
		}
		else {
			bigDate = d;
			smallDate = this;
			isNe = true;
		}
		/*
		System.out.print("BigDate is ");
		bigDate.print();
		System.out.print("SmallDate is ");
		smallDate.print();
		*/
		for(int y = smallDate.year; y <= bigDate.year; y++) {
			boolean firstYear = (y == smallDate.year) ? true : false;
			boolean finalYear = (y == bigDate.year) ? true : false;
			
			if(firstYear) {
				boolean equalYear = (smallDate.year == bigDate.year) ? true : false;
				boolean equalMonth = (smallDate.month == bigDate.month) ? true : false;
				int finalMonth = (equalYear) ? bigDate.month : 12; 
				
				for(int m = smallDate.month; m <= finalMonth; m++) {
					
					boolean firstMonth;
					if(m == smallDate.month) firstMonth = true;
					else firstMonth = false;
					
					int howManyday = 0;
					if(m == 2)
						howManyday = (isLeapY(y)) ? 29 : 28;
					else if(isBigM(m))
						howManyday = 31;
					else
						howManyday = 30;
					
					int finalDay = ((equalYear && equalMonth) || m==bigDate.month) ? bigDate.day : howManyday;
					
					if(firstMonth)	{
						for(int i = smallDate.day; i <= finalDay; i++) {
							dis++;
							//System.out.println("Y = " + y + ", M = " + m + ", D = " + i );
						}
					}
					else {
						for(int i = 1; i <= finalDay; i++) {
							dis++;
							//System.out.println("Y = " + y + ", M = " + m + ", D = " + i );
						}
					}
						
				}
			}
			else if(finalYear){
				for(int m = 1; m <= bigDate.month; m++) {
					int howManyday = 0;
					if(m == 2)
						howManyday = (isLeapY(y)) ? 29 : 28;
					else if(isBigM(m))
						howManyday = 31;
					else
						howManyday = 30;
					
					int finalDay = (m == bigDate.month) ? bigDate.day : howManyday;
					
					for(int i = 1; i <= finalDay; i++) {
						dis++;
						//System.out.println("Y = " + y + ", M = " + m + ", D = " + i );
					}
				}
			}
			else {
				if(isLeapY(y)) {
					dis += 366;
					//System.out.println("Y = " + y );
				}
				else {
					dis += 365;
					//System.out.println("Y = " + y );
				}
			}
		}
		
		dis--; //衡ぱ
		if(isNe)
			dis = -dis;
		
		return dis;
		
	}
	
	public boolean isBiggerThan(Date d) {
		
		if(year < d.year) {
			return false;
		}
		else if(year > d.year) {
			return true;
		}
		else {
			if(month < d.month) {
				return false;
			}
			else if(month > d.month) {
				return true;
			}
			else {
				if(day < d.day) {
					return false;
				}
				else if(day > d.day) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		
	}
	
	public boolean isSmallerThan(Date d) {
		
		if(year < d.year) {
			return true;
		}
		else if(year > d.year) {
			return false;
		}
		else {
			if(month < d.month) {
				return true;
			}
			else if(month > d.month) {
				return false;
			}
			else {
				if(day < d.day) {
					return true;
				}
				else if(day > d.day) {
					return false;
				}
				else {
					return false;
				}
			}
		}
	}
	
	public boolean isEqualTo(Date d) {
		if(year == d.year && month == d.month && day == d.day) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isLeapY(int Y) {
		if(Y % 400 == 0) {
			return true;
		}
		else if(Y % 100 == 0) {
			return false;
		}
		else if(Y % 4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isBigM(int M) {
		switch(M) {
		case 1 :
			return true;
		case 2 :
			return false;
		case 3 :
			return true;
		case 4 :
			return false;
		case 5 :
			return true;
		case 6 :
			return false;
		case 7 :
			return true;
		case 8 :
			return true;
		case 9 :
			return false;
		case 10 :
			return true;
		case 11 :
			return false;
		case 12 :
			return true;
		default :
			//System.out.println("ぃ猭る");
			return false;
		}
	}
	
	public boolean dateIsValid(int Y, int M, int D) {
		
		//System.out.println("Y = " + Y + ", M = " + M + ", D = " + D);
		
		boolean isLeapYear = isLeapY(Y);
		boolean bigM = isBigM(M);
		
		
		
		if(M > 12 || M < 1) {
			return false;
		}
		else if(isLeapYear) {
			if(M == 2) {
				if(D <= 29) 
					return true;
				else {
					//System.out.println("ぃ猭2るぱ计");
					return false;
				}
			}
			else if(bigM) {
				if(D <= 31) {
					return true;
				}
				else {
					//System.out.println("ぃ猭るぱ计");
					return false;
				}
			}
			else {
				if(D <= 30) {
					return true;
				}
				else {
					//System.out.println("ぃ猭るぱ计");
					return false;
				}
			}
		}
		else {
			if(M == 2) {
				if(D <= 28) 
					return true;
				else {
					//System.out.println("ぃ猭2るぱ计");
					return false;
				}
			}
			else if(bigM) {
				if(D <= 31) {
					return true;
				}
				else {
					//System.out.println("ぃ猭るぱ计");
					return false;
				}
			}
			else {
				if(D <= 30) {
					return true;
				}
				else {
					//System.out.println("ぃ猭るぱ计");
					return false;
				}
			}
		}
		
		
	}
}
