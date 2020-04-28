package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] A = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long answer = 0;

		for (int i = 0; i < A.length; i++) {
			A[i] -= B;
			answer += 1;
			if (A[i] <= 0) {
				continue;
			} else {
				if (A[i] % C == 0) {
					answer += A[i] / C;
				} else {
					answer += A[i] / C + 1;
				}
			}
		}
		System.out.println(answer);
	}
}
