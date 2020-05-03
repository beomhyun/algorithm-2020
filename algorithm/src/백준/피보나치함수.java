package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 피보나치함수 {
	static int[][] dp = new int[41][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		init();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int[] answer = fibonacci(n);

			System.out.println(answer[0] + " " + answer[1]);
		}
	}

	public static void init() {
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
	}

	public static int[] fibonacci(int n) {
		if (dp[n][0] != -1 || dp[n][1] != -1) {
			return dp[n];
		} else {
			int[] tmp1 = fibonacci(n - 1);
			int[] tmp2 = fibonacci(n - 2);
			dp[n][0] = tmp1[0] + tmp2[0];
			dp[n][1] = tmp1[1] + tmp2[1];
			return dp[n];
		}
	}
}
