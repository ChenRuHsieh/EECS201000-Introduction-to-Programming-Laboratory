package parallelsum;

public class Test {
	public static void main(String[] args) {
		Data d = new Data();
		//d.show();
		d.result();
		ParallelSum p0 = new ParallelSum(d, 0, 99);
		ParallelSum p1 = new ParallelSum(d, 100, 199);
		ParallelSum p2 = new ParallelSum(d, 200, 299);
		
		p0.start();
		p1.start();
		p2.start();
		
		synchronized(d) {
			if(d.count < 3) {
				try {
					d.wait();
				} catch (InterruptedException e) {
					System.out.println("Wait Failed");
					e.printStackTrace();
				}
			}
		}
		System.out.println("Parallel Result = " + d.result);
	}
}
