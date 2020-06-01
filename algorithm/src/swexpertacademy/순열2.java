package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¼ø¿­2 {
	static int N, K;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			answer = 0;
			dfs(new boolean[N + 1], new boolean[N + 1], 0, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}

	public static void dfs(boolean[] A, boolean[] B, int d, int score) {
		if (score >= K) {
			answer += Math.pow(2, Math.max(N - d - 1, 0));
			return;
		}
//		if (d == N - 1) {
//			if (score >= K) {
//				answer++;
//			}
//			return;
//		}
		for (int i = 1; i <= N; i++) {
			if (A[i]) {
				continue;
			}
			A[i] = true;
			for (int j = 1; j <= N; j++) {
				if (B[j]) {
					continue;
				}
				B[j] = true;
				dfs(A, B, d + 1, score + Math.max(i, j));
				B[j] = false;
			}
			A[i] = false;
		}
	}
}
