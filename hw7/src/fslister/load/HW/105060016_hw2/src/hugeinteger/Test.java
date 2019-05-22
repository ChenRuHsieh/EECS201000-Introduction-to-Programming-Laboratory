package hugeinteger;

public class Test {
	
	public static void main(String[] args) {
		HugeInteger A = new HugeInteger("-12345");
		HugeInteger B = new HugeInteger("12345");
		//HugeInteger X = new HugeInteger("-12345");
		
		System.out.print("A = ");
		A.output();
		
		System.out.print("B = ");
		B.output();
		/*
		System.out.print("X = ");
		X.output();
		*/
		System.out.println();
		
		HugeInteger C = A.add(B);
		System.out.print("A + B = C = ");
		C.output();
		
		HugeInteger D = A.sub(B);
		System.out.print("A - B = D = ");
		D.output();
		
		boolean AisEqualToB = A.isEqualTo(B);
		System.out.println("A = B is " + AisEqualToB);
		
		boolean AisNotEqualToB = A.isNotEqualTo(B);
		System.out.println("A != B is " + AisNotEqualToB);
		
		boolean AisGreaterThanB = A.isGreaterThan(B);
		System.out.println("A > B is " + AisGreaterThanB);
		
		boolean AisLessThanB = A.isLessThan(B);
		System.out.println("A < B is " + AisLessThanB);

		boolean AisGreaterThanOrEqualToB = A.isGreaterThanOrEqualTo(B);
		System.out.println("A >= B is " + AisGreaterThanOrEqualToB);
		
		boolean AisLessThanOrEqualToB = A.isLessThanOrEqualTo(B);
		System.out.println("A <= B is " + AisLessThanOrEqualToB);
		
		System.out.println();
		System.out.println("§ó§ïB");
		B.input("-12345");
		
		
		HugeInteger I = A.add(B);
		System.out.print("A + B = I = ");
		I.output();
		
		HugeInteger J = A.sub(B);
		System.out.print("A - B = J = ");
		J.output();
		
		boolean AisEqualToX = A.isEqualTo(B);
		System.out.println("A = X is " + AisEqualToX);
		
		boolean AisNotEqualToX = A.isNotEqualTo(B);
		System.out.println("A != X is " + AisNotEqualToX);
		
		boolean AisGreaterThanX = A.isGreaterThan(B);
		System.out.println("A > X is " + AisGreaterThanX);
		
		boolean AisLessThanX = A.isLessThan(B);
		System.out.println("A < X is " + AisLessThanX);

		boolean AisGreaterThanOrEqualToX = A.isGreaterThanOrEqualTo(B);
		System.out.println("A >= X is " + AisGreaterThanOrEqualToX);
		
		boolean AisLessThanOrEqualToX = A.isLessThanOrEqualTo(B);
		System.out.println("A <= X is " + AisLessThanOrEqualToX);
	
	}

}
