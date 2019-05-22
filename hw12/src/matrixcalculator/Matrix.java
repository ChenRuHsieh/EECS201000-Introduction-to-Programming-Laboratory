package matrixcalculator;

public class Matrix {
	static int matrixSize = 10000;
	static boolean isTest = false;
	int[][] matrixValue = new int[matrixSize][matrixSize];
	
	public Matrix() {
		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				matrixValue[i][j] = (isTest)? (i*matrixSize + j) : (int) (Math.random() * 100);
			}
		}
	}
	
	public void setZero() {
		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				matrixValue[i][j] = 0;
			}
		}
	}
	
	public void show() {
		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				System.out.print(matrixValue[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
