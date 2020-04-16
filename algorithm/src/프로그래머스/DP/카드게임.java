package 프로그래머스.DP;

import java.util.Arrays;

public class 카드게임 {
	static int[][] dp;

	public int solution(int[] left, int[] right) {
		int answer = 0;
		dp = new int[left.length][right.length];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		answer = recur(0, 0, left, right);
		return answer;
	}

	public int recur(int l, int r, int[] left, int[] right) {
		if (l == left.length || r == right.length) {
			return 0;
		}

		if (dp[l][r] != -1) {
			return dp[l][r];
		}
		dp[l][r] = Math.max(recur(l + 1, r, left, right), recur(l + 1, r + 1, left, right));

		if (left[l] > right[r]) {
			dp[l][r] = Math.max(dp[l][r], recur(l, r + 1, left, right) + right[r]);
		}

		return dp[l][r];
	}
}
