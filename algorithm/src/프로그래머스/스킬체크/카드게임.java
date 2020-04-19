package 프로그래머스.스킬체크;

public class 카드게임 {
	public int solution(int[] left, int[] right) {
		int answer = 0;
		int leftIndex = 0;
		int rightIndex = 0;

		int leftMax = 0;
		for (int i = 0; i < left.length; i++) {
			leftMax = Math.max(leftMax, left[i]);
		}
		boolean[] check = new boolean[right.length];
		boolean c = true;
		for (int i = 0; i < check.length; i++) {
			if (right[i] >= leftMax) {
				check[i] = true;
				c = false;
			}
		}
		if (c) {
			for (int i = 0; i < right.length; i++) {
				answer += right[i];
			}
			return answer;
		}
		return answer;
	}
}