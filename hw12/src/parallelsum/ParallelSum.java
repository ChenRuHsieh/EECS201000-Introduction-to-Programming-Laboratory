package parallelsum;

public class ParallelSum extends Thread{
	Data d;
	private int start, end;
	
	public ParallelSum(Data d, int start, int end) {
		this.d = d;
		this.start = start;
		this.end = end;
	}
	
	public void run() {
		synchronized(d) {
			for(int i = start; i <= end; i++) {
				d.result += d.elements[i];
				//System.out.println("Adder is No." + (i));
			}
			d.count++;
			if(d.count == 3) {
				d.notify();
			}
		}
	}
}
