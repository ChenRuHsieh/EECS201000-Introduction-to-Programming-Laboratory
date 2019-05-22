package chaoticsum;

public class ChaoticSum extends Thread{
	Data data;
	public ChaoticSum(Data d) {
		this.data = d;
	}
	
	public void run() {
		for(int i = 0; i < 20; i++) {
			int t = data.sum;
			t = t + 1;
			try {Thread.sleep(1);} catch (InterruptedException e) {}
			data.sum = t;
			System.out.println("Chaotic : " + data.sum);
		}
	}
}
