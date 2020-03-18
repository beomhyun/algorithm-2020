package 프로그래머스.DP;

public class N으로표현 {
	public long solution(int N, int number) {
		long[] tile = new long[N];
		tile[0] = 1;
		tile[1] = 1;

		long[] round = new long[N];
		round[0] = 4;
		round[1] = 6;

		for (int i = 2; i < N; i++) {
			tile[i] = tile[i - 2] + tile[i - 1];
			round[i] = tile[i] * 4 + tile[i - 1] * 2;
		}
		return round[N - 1];
	}
}