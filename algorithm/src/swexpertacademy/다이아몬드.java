package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 다이아몬드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] diamond = new int[N];

			for (int i = 0; i < diamond.length; i++) {
				diamond[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(diamond);
			System.out.println("#" + tc + " " + cntDiamond(K, diamond));
		}

	}

	public static int cntDiamond(int k, int[] diamond) {
		int start = 0;
		int end = 1;
		int answer = 0;
		while (end < diamond.length && start <= end) {
			if (diamond[end] - diamond[start] > k) {
				start++;
			} else {
				answer = Math.max(end - start + 1, answer);
				end++;
			}
		}
		return answer;
	}
}
