package EST;

import java.util.HashMap;
import java.util.Map;

public class test02 {
	public int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int answer = -1;
		for (int i = 0; i < A.length; i++) {
			int sumDigit = sumDigit(A[i]);
			if (map.containsKey(sumDigit)) {
				answer = answer > map.get(sumDigit) + A[i] ? answer : map.get(sumDigit) + A[i];
				if (map.get(sumDigit) < A[i]) {
					map.put(sumDigit, A[i]);
				}
			} else {
				map.put(sumDigit, A[i]);
			}
		}

		return answer;
	}

	public static int sumDigit(int N) {
		int answer = 0;
		String str = "" + N;
		for (int i = 0; i < str.length(); i++) {
			answer += str.charAt(i) - '0';
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] A = { 12, 21, 34, 999999991, 199999999 };
		test02 test = new test02();
		System.out.println(test.solution(A));
	}
}
