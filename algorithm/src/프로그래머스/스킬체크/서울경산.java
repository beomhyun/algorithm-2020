package 프로그래머스.스킬체크;

public class 서울경산 {

//	dfs
//	static int answer;
//
//	public int solution(int K, int[][] travel) {
//		answer = 0;
//		dfs(0, 0, K, travel, 0);
//		return answer;
//	}
//
//	public void dfs(int sumTime, int sumMoney, int K, int[][] travel, int d) {
//		if (sumTime > K)
//			return;
//		if (d == travel.length) {
//			answer = answer > sumMoney ? answer : sumMoney;
//			return;
//		}
//		dfs(sumTime + travel[d][0], sumMoney + travel[d][1], K, travel, d + 1);
//		dfs(sumTime + travel[d][2], sumMoney + travel[d][3], K, travel, d + 1);
//		
//	}

	public int solution(int K, int[][] travel) {
		int answer = 0;
		int[][] dp = new int[travel.length + 1][K + 1];
		int money;
		int wT, wM, bT, bM;

		for (int i = 1; i < travel.length + 1; i++) {
			for (int j = 0; j < K + 1; j++) {
				money = -1;
				wT = travel[i - 1][0];
				wM = travel[i - 1][1];
				bT = travel[i - 1][2];
				bM = travel[i - 1][3];
				if (j - wT >= 0 && wM + dp[i - 1][j - wT] > money) {
					money = wM + dp[i - 1][j - wT];
				}
				if (j - bT >= 0 && bM + dp[i - 1][j - bT] > money) {
					money = bM + dp[i - 1][j - bT];
				}
				dp[i][j] = money == -1 ? Integer.MIN_VALUE : money;
			}
		}
		answer = dp[travel.length][K];
		return answer;
	}
}
