package numtreeset;

import java.util.*;

public class NumTreeSet {
	Set<Integer> intTree = new TreeSet<Integer>();

	public NumTreeSet() {
		int num = 0;
		while(num != 80) {
			int tmp = (int) (Math.random() * 100);
			intTree.add(tmp);
			num++;
		}
	}
	
	public void show() {
		//Iterator<Integer> it = intList.iterator();
		System.out.println("共生成" + intTree.size() + "個不同的數字，如下 : ");
		int num = 0;
		for(Integer value : intTree) {
			System.out.println("No." + num + " : " + value);
			num++;
		}
	}
}

