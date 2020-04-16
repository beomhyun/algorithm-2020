package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;

		for (int i = 0; i < N; i++) {
			boolean check = true;
			boolean[] used = new boolean[N];

			for (int j = 1; j < N; j++) {
				if (Math.abs(map[i][j] - map[i][j - 1]) > 1) {
					check = false;
					break;
				} else if (map[i][j] - map[i][j - 1] == 1) {
					int tmp = map[i][j - 1];
					if (j - L < 0) {
						check = false;
						break;
					}
					for (int k = j - 1; k >= j - L; k--) {
						if (used[k] || map[i][k] != tmp) {
							check = false;
							break;
						}
					}
					if (!check) {
						break;
					} else {
						for (int k = j - 1; k >= j - L; k--) {
							used[k] = true;
						}
					}
				} else if (map[i][j] - map[i][j - 1] == -1) {
					int tmp = map[i][j];
					if (j + L - 1 >= N) {
						check = false;
						break;
					}
					for (int k = j; k < j + L; k++) {
						if (used[k] || map[i][k] != tmp) {
							check = false;
							break;
						}
					}
					if (!check) {
						break;
					} else {
						for (int k = j; k < j + L; k++) {
							used[k] = true;
						}

					}
				}
			}
			if (check) {
				answer++;
			}
			check = true;
			used = new boolean[N];
			for (int j = 1; j < N; j++) {
				if (Math.abs(map[j][i] - map[j - 1][i]) > 1) {
					check = false;
					break;
				} else if (map[j][i] - map[j - 1][i] == 1) {
					int tmp = map[j - 1][i];
					if (j - L < 0) {
						check = false;
						break;
					}
					for (int k = j - 1; k >= j - L; k--) {
						if (used[k] || map[k][i] != tmp) {
							check = false;
							break;
						}
					}
					if (!check) {
						break;
					} else {
						for (int k = j - 1; k >= j - L; k--) {
							used[k] = true;
						}
					}
				} else if (map[j][i] - map[j - 1][i] == -1) {
					int tmp = map[j][i];
					if (j + L - 1 >= N) {
						check = false;
						break;
					}
					for (int k = j; k < j + L; k++) {
						if (used[k] || map[k][i] != tmp) {
							check = false;
							break;
						}
					}
					if (!check) {
						break;
					} else {
						for (int k = j; k < j + L; k++) {
							used[k] = true;
						}

					}
				}
			}
			if (check) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}