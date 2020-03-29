package EST;

import java.util.HashSet;
import java.util.Set;

public class example3 {
	public int solution(int[] A) {
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			int tmp = A[i];
			if (set.contains(tmp)) {
				set.remove(tmp);
			} else {
				set.add(tmp);
			}
		}
		int answer = 0;
		for (int tmp : set) {
			answer = tmp;
		}
		return answer;
	}
}