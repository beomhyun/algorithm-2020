package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작 {
	static int N, M, H;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][H];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = 1;
		}
		answer = 4;
		solution(map);
		if (answer == 4) {
			answer = -1;
		}
		System.out.println(answer);
	}

	public static void solution(int[][] map) {
		for (int i = 0; i < 4; i++) {
			dfs(map, 0, i);
			if (answer != 4) {
				return;
			}
		}
	}

	public static void dfs(int[][] map, int d, int D) {
		if (d == D) {
			if (clearCheck(map)) {
				answer = d;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < H; j++) {
				if (map[i][j] == 1 || (isCan(i - 1, j) && map[i - 1][j] == 1)
						|| (isCan(i + 1, j) && map[i + 1][j] == 1))
					continue;
				map[i][j] = 1;
				dfs(map, d + 1, D);
				map[i][j] = 0;
			}
		}

	}

	public static boolean clearCheck(int[][] map) {
		for (int i = 0; i < N; i++) {
			int x = i;
			int y = 0;

			while (y < H) {
				if (isCan(x, y) && map[x][y] == 1) {
					x++;
				} else if (isCan(x - 1, y) && map[x - 1][y] == 1) {
					x--;
				}
				y++;
			}
			if (i != x) {
				return false;
			}
		}
		return true;
	}

	public static boolean isCan(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < H;
	}
}