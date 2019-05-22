package numarraylist;

import java.util.*;

public class NumArrayList {
	ArrayList<Integer> intList = new ArrayList<Integer>();
	
	public NumArrayList() {
		int num = 0;
		while(num != 20) {
			int tmp = (int) (Math.random() * 1000);
			//System.out.println(tmp);
			intList.add(tmp);
			num++;
		}
	}
	
	public void show() {
		Iterator<Integer> it = intList.iterator();
		int num = 0;
		while(it.hasNext()) {
			System.out.println("No." + num + " : " + it.next());
			num++;
		}
	}
	
	public void delete(int bound) {
		/*for(Object value: intList) {
			if((Integer)value < 500) {
				System.out.println(value + " be removed!");
				intList.remove(value);
			}
		}
		*/
		Iterator<Integer> it = intList.iterator();
		while(it.hasNext()) {
			int tmp = it.next();
			if(tmp < 500) {
				System.out.println(tmp + " be removed!");
				it.remove();
			}
		}
	}
}
