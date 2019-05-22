package chaoticsum;

public class Test {
	public static void main(String[] args) { 
		Data share = new Data(0);
		ChaoticSum c = new ChaoticSum(share);
		c.start();
		for(int i = 0; i < 20; i++) {
			share.sum++;
			System.out.println("Main : " + share.sum);
			try {Thread.sleep(1);} catch (InterruptedException e) {}
		}
		
		System.out.println("Final Value : " + share.sum);
	}
}
