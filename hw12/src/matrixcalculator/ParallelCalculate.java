package matrixcalculator;

public class ParallelCalculate extends Thread{
	Matrix M1, M2, result;
	int startRow, endRow;
	public ParallelCalculate(Matrix M1, Matrix M2, Matrix result, int startRow, int endRow) {
		this.M1 = M1;
		this.M2 = M2;
		this.result = result;
		this.startRow = startRow;
		this.endRow = endRow;
	}
	
	public void run() {
		for(int i = startRow; i <= endRow; i++) {
			for(int j = 0; j < Matrix.matrixSize; j++) {
				for(int k = 0; k < Matrix.matrixSize; k++) {
					int row = startRow;
					int col = j;
					//System.out.println("Now Thread : " + this.currentThread() + ", Row : " + row + ", Col : " + col);
					result.matrixValue[row][col] += M1.matrixValue[row][k]*M2.matrixValue[k][col];
					
				}
			}
		}
	}
	
}
