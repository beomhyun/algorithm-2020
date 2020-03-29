package crema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class test01 {
	public static int numofPrizes(int k, List<Integer> marks) {
		// Write your code here
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		for (int mark : marks) {
			if (map.containsKey(mark)) {
				int tmp = map.get(mark);
				map.put(mark, tmp + 1);
			} else {
				map.put(mark, 1);
			}
		}
		int answer = 0;
		int index = 0;
		for (int key : map.keySet()) {
			if (index >= k || key == 0) {
				break;
			}
			int count = map.get(key);
			answer += count;
			index += count;
		}

		return answer;

	}
	public static void main(String[] args) {
		test01 test = new test01();
		int k = 1;
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(10);
		marks.add(50);
		marks.add(50);
		marks.add(0);
		marks.add(0);
		
		System.out.println(test.numofPrizes(k, marks));
	}
}
