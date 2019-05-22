package complex;

public class Test {
	
	public static void main(String[] args)
    {
        Complex A = new Complex(3, -6);
        Complex B = new Complex(1, 7);
        Complex C = A.add(B);
        Complex D = A.sub(B);
        
        System.out.printf("A = ");
        A.print();
        System.out.printf("B = ");
        B.print();
        System.out.printf("A + B = C = ");
        C.print();
        System.out.printf("A - B = D = ");
        D.print();
        
        /*
        System.out.println("A = " + A.realPart + "+" + A.imaginaryPart +"i");
        System.out.println("B = " + B.realPart + "+" + B.imaginaryPart +"i");
        System.out.println("A + B = C = " + C.realPart + "+" + C.imaginaryPart +"i");
        System.out.println("A - B = D = " + D.realPart + "+" + D.imaginaryPart +"i");
        */
    }

}
