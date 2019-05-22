package matrixcalculator;

public class MatrixCalculator {
	//new(1,2) = m1(1,k)*m2(k,2)
	//new(i,j) = m1(i,k)*m2(k,j)
	Matrix M1, M2;
	
	public MatrixCalculator(Matrix m1, Matrix m2) {
		M1 = m1;
		M2 = m2;
	}
	
	public long serialCalculate() {
		long time1, time2;
        time1 = System.currentTimeMillis();
		
		int i, j, k;
		Matrix result = new Matrix();
		result.setZero();
		for(i = 0; i < Matrix.matrixSize; i++) {
			for(j = 0; j < Matrix.matrixSize; j++) {
				for(k = 0; k < Matrix.matrixSize; k++) {
					result.matrixValue[i][j] += M1.matrixValue[i][k] * M2.matrixValue[k][j];
				}
			}
		}
		//System.out.println("Serial Matrix Result : ");
		//result.show();
		
		time2 = System.currentTimeMillis();
		return time2 - time1;
	}
	
	public long parallelCalculate() throws InterruptedException {
		long time1, time2;
        time1 = System.currentTimeMillis();
		
		Matrix result = new Matrix();
		result.setZero();
		
		ParallelCalculate p0 = new ParallelCalculate(M1, M2, result, 0, Matrix.matrixSize/4 - 1);
		ParallelCalculate p1 = new ParallelCalculate(M1, M2, result, Matrix.matrixSize/4, Matrix.matrixSize/2 - 1);
		ParallelCalculate p2 = new ParallelCalculate(M1, M2, result, Matrix.matrixSize/2, Matrix.matrixSize/4*3 - 1);
		ParallelCalculate p3 = new ParallelCalculate(M1, M2, result, Matrix.matrixSize/4*3, Matrix.matrixSize - 1);
		
		p0.start();
		p1.start();
		p2.start();
		p3.start();
		
		p0.join();
		p1.join();
		p2.join();
		p3.join();
		
		//System.out.println("Parallel Matrix Result : ");
		//result.show();
		time2 = System.currentTimeMillis();
		return time2 - time1;
	}
}


