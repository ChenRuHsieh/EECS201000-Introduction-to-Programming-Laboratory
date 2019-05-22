package rational;

public class Test {
	public static void main(String[] args) {
		Rational A = new Rational(3, 4);
		Rational B = new Rational(-4, -3);
		Rational X = new Rational(-9, 12);
		Rational wrong = new Rational(100, 0);
		
		System.out.println("Wrong = ");
        wrong.printRational();
        wrong.printReal();
		
		System.out.println("A = ");
        A.printRational();
        A.printReal();
        
        System.out.println("B = ");
        B.printRational();
        B.printReal();
        
        System.out.println("X = ");
        X.printRational();
        X.printReal();
        
        System.out.println();
        
        Rational C = A.add(B);
        System.out.println("A + B = C =");
        C.printRational();
        C.printReal();
        
        Rational D = A.sub(B);
        System.out.println("A - B = D =");
        D.printRational();
        D.printReal();
        
        Rational E = A.mul(B);
        System.out.println("A * B = E =");
        E.printRational();
        E.printReal();
        
        Rational F = A.div(B);
        System.out.println("A / B = F =");
        F.printRational();
        F.printReal();
        
        System.out.println();
        
        Rational I = A.add(X);
        System.out.println("A + X = I =");
        I.printRational();
        I.printReal();
        
        Rational J = A.sub(X);
        System.out.println("A - X = J =");
        J.printRational();
        J.printReal();
        
        Rational K = A.mul(X);
        System.out.println("A * X = K =");
        K.printRational();
        K.printReal();
        
        Rational Q = A.div(X);
        System.out.println("A / X = Q =");
        Q.printRational();
        Q.printReal();
        
	}
}
