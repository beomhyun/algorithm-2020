package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		xy pipe = new xy(0, 1);

		answer = 0;
		move(pipe, 0, map, N);
		System.out.println(answer);
	}

	static int answer;

	public static void move(xy pipe, int d, int[][] map, int N) {
		int x = pipe.x;
		int y = pipe.y;
		if (x == N - 1 && y == N - 1) {
			answer++;
			return;
		}

		if (d == 0) {
			if (isCanGoRight(x, y, N, map)) {
				move(new xy(x, y + 1), 0, map, N);
			}
			if (isCanGoRightDown(x, y, N, map)) {
				move(new xy(x + 1, y + 1), 2, map, N);
			}
		} else if (d == 1) {
			if (isCanGoDown(x, y, N, map)) {
				move(new xy(x + 1, y), 1, map, N);
			}
			if (isCanGoRightDown(x, y, N, map)) {
				move(new xy(x + 1, y + 1), 2, map, N);
			}
		} else {
			if (isCanGoDown(x, y, N, map)) {
				move(new xy(x + 1, y), 1, map, N);
			}
			if (isCanGoRight(x, y, N, map)) {
				move(new xy(x, y + 1), 0, map, N);
			}
			if (isCanGoRightDown(x, y, N, map)) {
				move(new xy(x + 1, y + 1), 2, map, N);
			}
		}
	}

	public static boolean isCanGoRight(int x, int y, int N, int[][] map) {
		y = y + 1;
		return x >= 0 && x < N && y >= 0 && y < N && map[x][y] == 0;
	}

	public static boolean isCanGoDown(int x, int y, int N, int[][] map) {
		x = x + 1;
		return x >= 0 && x < N && y >= 0 && y < N && map[x][y] == 0;
	}

	public static boolean isCanGoRightDown(int x, int y, int N, int[][] map) {
		return x + 1 >= 0 && x + 1 < N && y + 1 >= 0 && y + 1 < N && map[x + 1][y] == 0 && map[x][y + 1] == 0
				&& map[x + 1][y + 1] == 0;
	}

	public static class xy {
		int x;
		int y;

		@Override
		public String toString() {
			return "xy [x=" + x + ", y=" + y + "]";
		}

		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
