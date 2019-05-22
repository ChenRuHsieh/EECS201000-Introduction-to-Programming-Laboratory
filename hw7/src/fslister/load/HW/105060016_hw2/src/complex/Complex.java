package complex;

public class Complex {
	
	double realPart;
	double imaginaryPart;
	
	public Complex(double r, double i) {
		realPart = r;
		imaginaryPart = i;
	}
	
	public Complex add(Complex adden) {
		
		Complex result = new Complex(realPart + adden.realPart, imaginaryPart+adden.imaginaryPart);
		
		return result;
	}
	
	public Complex sub(Complex sub) {
		
		Complex result = new Complex(realPart - sub.realPart, imaginaryPart - sub.imaginaryPart);
		
		return result;
	}
	
	public void print() {
		if(imaginaryPart >= 0)
			System.out.println(" " + realPart + "+" + imaginaryPart +"i");
		else 
			System.out.println(" " + realPart + "-" + Math.abs(imaginaryPart) +"i");
	}

}
