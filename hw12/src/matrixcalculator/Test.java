package matrixcalculator;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		//Matrix.matrixSize = 4;
		//Matrix.isTest = true;
		Matrix M1 = new Matrix();
		Matrix M2 = new Matrix();
		MatrixCalculator c = new MatrixCalculator(M1, M2);
		
		/*
		System.out.println("M1 : ");
		M1.show();
		System.out.println("M2 : ");
		M2.show();
		*/
		long serialTime =  c.serialCalculate();
		long parallelTime = c.parallelCalculate();
		System.out.println("Serial Spent Time : " + serialTime + " ms");
		System.out.println("Parallel Spent Time : " + parallelTime + " ms");
		
		if(serialTime == parallelTime)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
