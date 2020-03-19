package ฤฺลื;

public class test01 {
	public int solution(int[] s1, int[] s2) {
		int answer = 0;
		for (int num : s1) {
			if (isInclusive(num, s2))
				continue;
			else {
				answer = num;
				break;
			}
		}
		return answer;
	}

	public static boolean isInclusive(int n, int[] array) {
		boolean answer = false;
		for (int num : array) {
			if (n == num) {
				answer = true;
				break;
			}
		}
		return answer;
	}
}
