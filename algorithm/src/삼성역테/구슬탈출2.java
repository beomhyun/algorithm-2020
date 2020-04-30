package »ï¼º¿ªÅ×;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ±¸½½Å»Ãâ2 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		XY red = null, blue = null;

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					red = new XY(i, j, 'R');
				} else if (map[i][j] == 'B') {
					blue = new XY(i, j, 'B');
				}
			}
		}
		answer = 11;
		dfs(map, -1, 1, red, blue);
		if (answer == 11) {
			answer = -1;
		}
		System.out.println(answer);
	}

	static int answer;

	public static void print(char[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void dfs(char[][] preMap, int dir, int turn, XY preRed, XY preBlue) {
		if (turn >= answer) {
			return;
		}
		for (int d = 0; d < 4; d++) {
			char[][] map = new char[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = preMap[i][j];
				}
			}
			XY red = new XY(preRed.x, preRed.y, preRed.color);
			XY blue = new XY(preBlue.x, preBlue.y, preBlue.color);

			if (d == dir) {
				continue;
			}
			if (d == 0) {
				if (red.x < blue.x) {
					red = go(map, d, red);
					blue = go(map, d, blue);
				} else {
					blue = go(map, d, blue);
					red = go(map, d, red);
				}
			} else if (d == 1) {
				if (red.y < blue.y) {
					blue = go(map, d, blue);
					red = go(map, d, red);
				} else {
					red = go(map, d, red);
					blue = go(map, d, blue);
				}
			} else if (d == 2) {
				if (red.x < blue.x) {
					blue = go(map, d, blue);
					red = go(map, d, red);
				} else {
					red = go(map, d, red);
					blue = go(map, d, blue);
				}
			} else if (d == 3) {
				if (red.y < blue.y) {
					red = go(map, d, red);
					blue = go(map, d, blue);
				} else {
					blue = go(map, d, blue);
					red = go(map, d, red);
				}
			}
			if (map[blue.x][blue.y] == 'O') {
				continue;
			} else if (map[red.x][red.y] == 'O') {
				answer = Math.min(answer, turn);
				return;
			}
			if (preRed.x == red.x && preRed.y == red.y && preBlue.x == blue.x && preBlue.y == blue.y) {
				continue;
			}
			dfs(map, dir, turn + 1, red, blue);
		}
	}

	public static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static boolean isClear(char[][] map, XY red, XY blue) {
		return map[blue.x][blue.y] != 'O' && map[red.x][red.y] == 'O';
	}

	public static XY go(char[][] map, int d, XY who) {
		int x = who.x;
		int y = who.y;
		while (true) {
			x += dx[d];
			y += dy[d];
			if (!isCango(map, x, y)) {
				x -= dx[d];
				y -= dy[d];
				break;
			}
		}
		if (isGole(map, x + dx[d], y + dy[d])) {
			map[who.x][who.y] = '.';
			return new XY(x + dx[d], y + dy[d], who.color);
		}
		map[who.x][who.y] = '.';
		map[x][y] = who.color;
		return new XY(x, y, who.color);
	}

	public static boolean isCango(char[][] map, int x, int y) {
		return isRange(x, y) && (map[x][y] == '.');
	}

	public static boolean isGole(char[][] map, int x, int y) {
		return isRange(x, y) && (map[x][y] == 'O');
	}

	public static class XY {
		int x;
		int y;
		char color;

		public XY(int x, int y, char color) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + ", color=" + color + "]";
		}
	}
}
