package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개리맨더링2 {
	static int N;
	static int[][] A;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		A = new int[N][N];

		for (int i = 0; i < A.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < A.length; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if(x+d1+d2 < N && 0<= y-d1 && y+d2 < N) {
							makeMap(x, y, d1, d2);
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	public static void makeMap(int x, int y, int d1, int d2) {
		int[][] map = new int[N][N];
		int r = x;
		int c = y;
		for (int i = 0; i <= d1; i++) {
			if (r >= 0 && r < N && c >= 0 && c < N) {
				map[r][c] = 5;
				r++;
				c--;
			} else {
				break;
			}
		}
		r = x;
		c = y;
		for (int i = 0; i <= d2; i++) {
			if (r >= 0 && r < N && c >= 0 && c < N) {
				map[r][c] = 5;
				r++;
				c++;
			} else {
				break;
			}
		}
		r = x + d1 < N ? x + d1 : N - 1;
		c = y - d1 > 0 ? y - d1 : 0;
		for (int i = 0; i <= d2; i++) {
			if (r >= 0 && r < N && c >= 0 && c < N) {
				map[r][c] = 5;
				r++;
				c++;
			} else {
				break;
			}
		}
		r = x + d2 < N ? x + d2 : N - 1;
		c = y + d2 < N ? y + d2 : N - 1;
		for (int i = 0; i <= d1; i++) {
			if (r >= 0 && r < N && c >= 0 && c < N) {
				map[r][c] = 5;
				r++;
				c--;
			} else {
				break;
			}
		}
		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if(i < 0 || j < 0 || i >= N || j >= N) {
					break;
				}
				if (map[i][j] == 5) {
					break;
				}
				map[i][j] = 1;
			}
		}
		for (int i = 0; i <= x + d2; i++) {
			for (int j = N - 1; j >= y + 1; j--) {
				if(i < 0 || j < 0 || i >= N || j >= N) {
					break;
				}
				if (map[i][j] == 5) {
					break;
				}
				map[i][j] = 2;
			}
		}
		for (int i = x + d1; i < N; i++) {
			for (int j = 0; j <= y - d1 + d2; j++) {
				if(i < 0 || j < 0 || i >= N || j >= N) {
					break;
				}
				if (map[i][j] == 5) {
					break;
				}
				map[i][j] = 3;
			}
		}
		for (int i = x + d2 + 1; i < N; i++) {
			for (int j = N - 1; j >= y - d1 + d2; j--) {
				if(i < 0 || j < 0 || i >= N || j >= N) {
					break;
				}
				if (map[i][j] == 5) {
					break;
				}
				map[i][j] = 4;
			}
		}

		int[] count = new int[6];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				int tmp = map[i][j];
				if (tmp == 0)
					tmp = 5;
				count[tmp] += A[i][j];
			}
		}

		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < count.length; i++) {
			if (max < count[i]) {
				max = count[i];
			}
			if (min > count[i]) {
				min = count[i];
			}
		}
		if (answer > max - min) {
			answer = max - min;
		}
	}
}
