package EST;

import java.util.Map;
import java.util.TreeMap;

public class test01 {
	public int solution(int[] A) {
        // write your code in Java SE 8
    	Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    	for (int i = 0; i < A.length; i++) {
			if(map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i])+1);
			}else {
				map.put(A[i], 1);
			}
		}
    	int answer = 0;
    	for (int key : map.keySet()) {
			if(key == map.get(key)) {
				answer = key;
			}
		}
    	return answer;
    }
}
