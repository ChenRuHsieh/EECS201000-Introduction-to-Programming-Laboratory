package rational;

public class Rational {
	
	int numerator; //分子
	int denominator; //分母
	boolean denoIsZero;
	
	
	public Rational(int n, int d) {
		
		int gcd = 1;
		if(d == 0) {
			//System.out.println("分母為0沒有意義");
			denoIsZero = true;
			numerator = n;
			denominator = d;
		}
		else {
			denoIsZero = false;
			gcd = gcd(Math.abs(n), Math.abs(d));
			if(gcd != 0) {
				if(n * d >= 0) {
					numerator = Math.abs(n / gcd);
					denominator = Math.abs(d / gcd);
				}
				else {
					numerator = (n<0) ? n / gcd : -(n / gcd);
					denominator = Math.abs(d / gcd);
				}
				if(Math.abs(n) == Math.abs(d)) {
					numerator = n/d;
					denominator = 1;
				}
			}
			else {
				numerator = 0;
				denominator = 1;
			}
		}
	}
	
	public Rational() {
		numerator = 0;
		denominator = 1; 		
	}

	public Rational add(Rational adden) {
		
		if(denoIsZero || adden.denoIsZero) {
			System.out.println("分母為0無法計算");
			return null;
		}
		
		int lcm_deno = lcm(Math.abs(denominator), Math.abs(adden.denominator));
		//System.out.println("add_lcm = " + lcm_deno );
		
		int mul_origin = lcm_deno / denominator;
		int mul_adden = lcm_deno / adden.denominator;
		
		int n = numerator*Math.abs(mul_origin) + adden.numerator*Math.abs(mul_adden);
		int d = denominator*Math.abs(mul_origin);
		//System.out.println("n = " + n );
		//System.out.println("d = " + d );
		
		Rational result = new Rational(n, d);
		
		return result;
	}
	
	public Rational sub(Rational suber) {
		
		if(denoIsZero || suber.denoIsZero) {
			System.out.println("分母為0無法計算");
			return null;
		}
		
		int lcm_deno = lcm(Math.abs(denominator), Math.abs(suber.denominator));
		int mul_origin = lcm_deno / denominator;
		int mul_adden = lcm_deno / suber.denominator;
		
		int n = numerator*Math.abs(mul_origin) - suber.numerator*Math.abs(mul_adden);
		int d = denominator*Math.abs(mul_origin);
		
		Rational result = new Rational(n, d);
		
		return result;
		
	}
	
	public Rational mul(Rational muler) {
		
		if(denoIsZero || muler.denoIsZero) {
			System.out.println("分母為0無法計算");
			return null;
		}
		
		Rational result = new Rational(numerator * muler.numerator, denominator * muler.denominator);
		
		return result;
		
	}
	
	public Rational div(Rational diver) {
		
		if(denoIsZero || diver.denoIsZero) {
			System.out.println("分母為0無法計算");
			return null;
		}
		
		Rational result = new Rational(numerator * diver.denominator, denominator * diver.numerator);
		
		return result;
		
	}
	
	
	void printRational() {
		if(denoIsZero)
			System.out.println(numerator + "/" + denominator + " 分母為0沒有意義");
		else if(Math.abs(denominator) != 1)
			System.out.println(numerator + "/" + denominator);
		else
			System.out.println((int)numerator);
	}
	
	void printReal() {
		if(denoIsZero) {
			System.out.println("分母為0無法變成小數");
		}
		else{
			double result = (double)numerator / (double)denominator;
			System.out.println(result);
		}
	}


	
	public static int gcd(int x, int y){
		int gcd = 1;
		int i;
		int small;
		
		if(x >= y)
			small = y;
		else
			small = x;
		
		for(i = 2; i <= small; i++){
			while( ((x%i) == 0) && ((y%i) == 0)){
				gcd *= i;
				x /= i;
				y /= i;
				//System.out.println("i = " + i + " gcd = " + gcd);
			}
		}
		
		if(x == 0 || y == 0) {
			return 0;
		}
		
		return gcd;
	}
	
	public static int lcm(int x, int y) {
		
		int lcm;
		
		if(x == 0 || y == 0) {
			lcm = 0;
		}
		else{
			lcm = (x * y) / gcd(x, y);
		}
		
		return lcm;
	}
}
