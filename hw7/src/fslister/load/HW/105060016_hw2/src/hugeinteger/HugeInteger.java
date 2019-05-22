package hugeinteger;


public class HugeInteger {
	
	//String hugeint;
	char[] hugeint = new char[40];
	
	boolean isNegative;
	
	public HugeInteger(String h) {
		
		char[] ch = h.toCharArray();
		if(ch[0] == '-') {
			isNegative = true;
			//hugeint = "-";
			if(h.length() <= 40) {
				hugeint = h.substring(1).toCharArray();
			}
			else {
				hugeint = h.substring(h.length()-40).toCharArray(); 
			}
		}
		else {
			isNegative = false;
			if(h.length() <= 40)
				hugeint = h.toCharArray();
			else
				hugeint = h.substring(h.length()-40).toCharArray(); 
		}
		//String str_huge = new String(hugeint);
		//System.out.println("hugeint = " + str_huge);
	}
	
	public void input(String h) {
		//hugeint = h;
		String str_huge = new String(hugeint);
		System.out.println("將值從" + str_huge + "改成" + h);
		char[] ch = h.toCharArray();
		if(ch[0] == '-') {
			isNegative = true;
			//hugeint = "-";
			if(h.length() <= 40)
				hugeint = h.substring(1).toCharArray();
			else
				hugeint = h.substring(h.length()-40).toCharArray(); 
		}
		else {
			isNegative = false;
			if(h.length() <= 40)
				hugeint = h.toCharArray();
			else
				hugeint = h.substring(h.length()-40).toCharArray(); 
		}
		
	}
	
	public void output() {
		String str_huge = new String(hugeint);
		if(isNegative)
			System.out.println("-" + str_huge);
		else
			System.out.println(str_huge);
	}
	 
	public HugeInteger add(HugeInteger adder) {
		
		//為了都能從陣列的第0位開始算，反轉後最小那一位都在第0位

		char[] ch_adden;
		char[] ch_adder;
		boolean isNe;
		
		if(isNegative == false && adder.isNegative == true) {
			String str_er = new String(adder.hugeint);
			HugeInteger po_er = new HugeInteger(str_er);
			if(isGreaterThan(adder)) {
				return this.sub(po_er);
			}
			else if(isEqualTo(adder)) {
				StringBuilder sb_result = new StringBuilder();
				sb_result.append("0");
				return new HugeInteger(sb_result.toString());
			}
			else {
				return adder.sub(this); // 1 + -5 = - (5 - 1) = -4 但現在沒有負號
										// 1 + -5 = (5 - 1) = 4 到sub再處理
			}
		}
		else if(isNegative == true && adder.isNegative == false) {
			String str_en = new String(hugeint);
			HugeInteger po_en = new HugeInteger(str_en);
			if(this.isGreaterThan(adder)) {
				return this.sub(adder);// -5 + 1 = - (5 - 1) = -4 但現在沒有負號
										// -5 + 1 = (5 - 1) = 4 
			}
			else if(this.isEqualTo(adder)) {
				StringBuilder sb_result = new StringBuilder();
				sb_result.append("0");
				return new HugeInteger(sb_result.toString());
			}
			else {
				return adder.sub(po_en);
			}
		}
		else if(isNegative == true && adder.isNegative == true) {
			String str_adden = new String(hugeint);
			String str_adder = new String(adder.hugeint);
			ch_adden = new StringBuilder(str_adden).reverse().toString().toCharArray();
			ch_adder = new StringBuilder(str_adder).reverse().toString().toCharArray();
			
			isNe = true;
		}
		else {
			String str_adden = new String(hugeint);
			String str_adder = new String(adder.hugeint);
			ch_adden = new StringBuilder(str_adden).reverse().toString().toCharArray();
			ch_adder = new StringBuilder(str_adder).reverse().toString().toCharArray();
			isNe = false;
		}
		
		//System.out.println(ch_adden);
		//System.out.println(ch_adder);
		
		int i = 0;
		int len_adden = ch_adden.length;
		int len_adder = ch_adder.length;
		//取最長的的長度
		int maxlen;
		if(len_adden > len_adder)
			maxlen = len_adden;
		else
			maxlen = len_adder;
		
		int[] result = new int[maxlen+1];
		//相加
		for(i = 0; i <= maxlen; i++) {
			int int_adden, int_adder;
			
			if(i < len_adden)
				int_adden = ch_adden[i] - '0';
			else
				int_adden = 0;
			
			if(i < len_adder)
				int_adder = ch_adder[i] - '0';
			else
				int_adder = 0;
			
			result[i] = int_adden + int_adder;
			//System.out.println("i = " + i);
			//System.out.println("adden = " + int_adden + ", adder = " + int_adder + ", result = " + result[i]);
		}
		//進位
		for(i = 0; i <= maxlen; i++) {
			if(result[i] >= 10) {
				result[i+1] += result[i] / 10;
				result[i] %= 10;
			}
			//System.out.println("i = " + i + ", result = " + result[i]);
		}
		//反轉
		StringBuilder sb_result = new StringBuilder();
		//System.out.println(result); 為何會是亂碼???
		
		if(isNe) {
			sb_result.append("-");
		}
		
		for(i = maxlen; i>=0; i--) {
			if(i == maxlen) {
				if(result[i] != 0)
					sb_result.append(result[i]);
			}
			else {
				sb_result.append(result[i]);
				//System.out.println(sb_result);
			}
		}
		return new HugeInteger(sb_result.toString());
	}
	
	public HugeInteger sub(HugeInteger suber) {
		
		//為了都能從陣列的第0位開始算，反轉後最小那一位都在第0位
		char[] ch_suben;
		char[] ch_suber;
		boolean isNe;
		
		if(isNegative == false && suber.isNegative == true) {
			String str_er = new String(suber.hugeint);
			HugeInteger po_er = new HugeInteger(str_er);
			return this.add(po_er);
		}
		else if(isNegative == true && suber.isNegative == false) {
			//return adder.sub(this); 
			// 1 + -5 = - 5 + 1 = -4 但現在沒有負號
			// 1 + -5 = (5 - 1) = 4 到sub再處理*/
			String str_er = new String(suber.hugeint);
			String str_en = new String(suber.hugeint);
			
			HugeInteger po_en = new HugeInteger(str_en);
			if(po_en.isGreaterThan(suber)) {
				ch_suben = new StringBuilder(str_en).reverse().toString().toCharArray(); //5
				ch_suber = new StringBuilder(str_er).reverse().toString().toCharArray();
				isNe = true;
				//- ( 5 - 1 )
			}
			else {
				StringBuilder sb_ne_suber = new StringBuilder();
				sb_ne_suber.append("-");
				sb_ne_suber.append(suber.hugeint);
				HugeInteger ne_suber = new HugeInteger(sb_ne_suber.toString());
				//-3 - 7 = 
				return this.add(ne_suber);
			}
		}
		else if(isNegative == true && suber.isNegative == true) {
			//-5 - (-1) = -5 + 1 = - ( 5 - 1) = -4
			String str_en = new String(hugeint);
			String str_er = new String(suber.hugeint);
			HugeInteger po_en = new HugeInteger(str_en);
			HugeInteger po_er = new HugeInteger(str_er);
			if(po_en.isEqualTo(po_er)) {
				StringBuilder sb_result = new StringBuilder();
				sb_result.append("0");
				return new HugeInteger(sb_result.toString());
			}
			else {
				return this.add(po_er);
			}
			
			/*ch_suben = new StringBuilder(hugeint.substring(1)).reverse().toString().toCharArray();
			ch_suber = new StringBuilder(suber.hugeint.substring(1)).reverse().toString().toCharArray();
			isNe = true;*/
		}
		else {
			String str_en = new String(hugeint);
			String str_er = new String(suber.hugeint);
			ch_suben = new StringBuilder(str_en).reverse().toString().toCharArray();
			ch_suber = new StringBuilder(str_er).reverse().toString().toCharArray();
			isNe = false;
		}
		
		
		int i = 0;
		int len_suben = ch_suben.length;
		int len_suber = ch_suber.length;
		//反轉
		StringBuilder sb_result = new StringBuilder();
		
		if(isEqualTo(suber)) {
			sb_result.append("0");
			return new HugeInteger(sb_result.toString());
		}
		
		//取最長的的長度
		int maxlen, change = 1;
		HugeInteger compa_en, compa_er;
		compa_en = new HugeInteger(hugeint.toString());
		compa_er = new HugeInteger(suber.hugeint.toString());
	
		if(len_suben > len_suber) {
			maxlen = len_suben;
			//change = change;
			//-3 - -7 = - ( 3 - 7) = - ( -4 )
		}
		else {
			maxlen = len_suben;
			change = -change;
		}
		
		int[] result = new int[maxlen + 1];
		//相減
		for(i = 0; i <= maxlen; i++) {
			int int_suben, int_suber;
			
			if(i < len_suben)
				int_suben = ch_suben[i] - '0';
			else
				int_suben = 0;
			
			if(i < len_suber)
				int_suber = ch_suber[i] - '0';
			else
				int_suber = 0;
			
			if(change == 1)
				result[i] = int_suben - int_suber;
			else if(change == -1)
				result[i] = int_suber - int_suben;
			//System.out.println("i = " + i);
			//System.out.println("suben = " + int_suben + ", suber = " + int_suber + ", result = " + result[i]);
		}
		//借位
		//System.out.println("maxlen = " + maxlen + ", result len = " + result.length);
		
		for(i = 0; i <= maxlen; i++) {
			if(result[i] < 0) {
				result[i+1] -= 1;
				result[i] += 10;
			}
			//System.out.println("i = " + i + ", result = " + result[i]);
		}
		
		
		//System.out.println(result); 為何是亂碼?
		
		if(isNe)
			change = - change;
		
		if(change == -1)
			sb_result.append("-");
		
		for(i = maxlen; i>=0; i--) {
			if(i == maxlen) {
				if(result[i] != 0)
					sb_result.append(result[i]);
			}
			else {
				sb_result.append(result[i]);
				//System.out.println(sb_result);
			}
		}
		
		return new HugeInteger(sb_result.toString());
	}
	
	public boolean isGreaterThan(HugeInteger comparer) {
		int i = 0;
		int len_en = hugeint.length;
		int len_er = comparer.hugeint.length;
		//System.out.println("Enter > 比較");
		if(isNegative == false && comparer.isNegative == true ) {
			//System.out.println("前正後負");
			return true;
		}
		else if(isNegative == true && comparer.isNegative == false) {
			//System.out.println("前負後正");
			return false;
		}
		else if(isNegative == true && comparer.isNegative == true) {
			//System.out.println("2負");
			String str_en = new String(hugeint);
			String str_er = new String(comparer.hugeint);
			HugeInteger po_en = new HugeInteger(str_en);
			HugeInteger po_er = new HugeInteger(str_er);
			return po_er.isGreaterThan(po_en);
		}
		
		if(len_en > len_er)
			return true;
		else if(len_en < len_er)
			return false;
		else {
			for(i = 0; i < len_en; i++) {
				int int_en = hugeint[i] - '0';
				int int_er = comparer.hugeint[i] - '0';
				
				if(i == len_en - 1) {
					if(int_en <= int_er) {
						return false;
					}
					else
						return true;
				}
				else if(int_en < int_er) {
					return false;
				}
				else if(int_en > int_er) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isEqualTo(HugeInteger comparer) {
		int i = 0;
		int len_en = hugeint.length;
		int len_er = comparer.hugeint.length;
		
		boolean sameSign;
		if((isNegative && comparer.isNegative) || (isNegative==false && comparer.isNegative==false))
			sameSign = true;
		else
			sameSign = false;
			
			
		if((len_en == len_er) && sameSign) {
			for(i = 0; i < len_en; i++) {
				int int_en = hugeint[i] - '0';
				int int_er = comparer.hugeint[i] - '0';
				
				if(int_en != int_er)
					return false;
			}
		}
		else {
			return false;
		}
		
		return true;
	}
	
	public boolean isNotEqualTo(HugeInteger comparer) {
		
		if(isEqualTo(comparer))
			return false;
		else
			return true;
	}
	
	public boolean isLessThan(HugeInteger comparer) {
		int i = 0;
		int len_en = hugeint.length;
		int len_er = comparer.hugeint.length;
		
		if(isNegative == false && comparer.isNegative == true )
			return false;
		else if(isNegative == true && comparer.isNegative == false)
			return true;
		else if(isNegative == true && comparer.isNegative == true) {
			String str_en = new String(hugeint);
			String str_er = new String(comparer.hugeint);
			HugeInteger po_en = new HugeInteger(str_en);
			HugeInteger po_er = new HugeInteger(str_er);
			return po_er.isLessThan(po_en);
		}
		
		
		if(len_en > len_er) {
			return false;
		}
		else if(len_en < len_er) {
			return true;
		}
		else {
			for(i = 0; i < len_en; i++) {
				int int_en = hugeint[i] - '0';
				int int_er = comparer.hugeint[i] - '0';
				
				if(i == len_en - 1) {
					if(int_en >= int_er) {
						return false;
					}
					else
						return true;
				}
				else if(int_en > int_er) {
					return false;
				}
				else if(int_en < int_er) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isGreaterThanOrEqualTo(HugeInteger comparer) {
		if(isLessThan(comparer))
			return false;
		else
			return true;
	}
	
	public boolean isLessThanOrEqualTo(HugeInteger comparer) {
		if(isGreaterThan(comparer))
			return false;
		else
			return true;
	}
}
