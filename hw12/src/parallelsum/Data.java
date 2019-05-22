package parallelsum;

public class Data {
	static int elementNum = 300;
	int count = 0;
	int[] elements = new int[elementNum]; // value is 1~100
	int result;
	public Data() {
		for(int i = 0; i < elements.length; i++) {
			elements[i] = (int) (Math.random() * 100);
			//elements[i] = 1;
		}
		result = 0;
	}
	
	public void show() {
		int colNum = 20;
		int rowNum = elementNum / colNum;
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				System.out.print(elements[i*colNum + j] + " ");
			}
			System.out.println();
		}
	}
	
	public void result() {
		int serialResult = 0;
		for(int i = 0; i < elementNum; i++) {
			serialResult += elements[i];
		}
		System.out.println("Serial Result : " + serialResult);
	}
}
