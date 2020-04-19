package »ï¼º¿ªÅ×;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ¹Ì¼¼¸ÕÁö¾È³ç {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int R, C;
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int T = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];

		int[] air = { -1, -1 };

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (air[0] == -1) {
						air[0] = i;
					} else {
						air[1] = i;
					}
				}
			}
		}
		System.out.println(solution(map, air, T));
	}

	public static int solution(int[][] map, int[] air, int T) {
		if (T == 0) {
			return cal(map);
		}
		map = extendsAir(map);
		map = pureAir(map, air);
		return solution(map, air, T - 1);
	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int[][] pureAir(int[][] map, int[] air) {
		for (int a = 0; a < air.length; a++) {
			int d = RIGHT;
			int x = air[a];
			int y = 0;
			int nextX = air[a], nextY = 1;
			int pre = 0;
			while (!(nextX == air[a] && nextY == 0)) {
				nextX = x + dx[d];
				nextY = y + dy[d];
				if (isCango(map, nextX, nextY)) {
					int tmp = map[nextX][nextY];
					map[nextX][nextY] = pre;
					pre = tmp;
					x = nextX;
					y = nextY;
				} else {
					if (a == 0) {
						d--;
					} else {
						d++;
					}
					if (d == -1) {
						d = 3;
					}
					if (d == 4) {
						d = 0;
					}
				}
			}
		}
		return map;
	}

	public static int[][] extendsAir(int[][] map) {
		int[][] addMap = new int[R][C];
		List<XY> list;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				list = new ArrayList<>();
				for (int d = 0; d < 4; d++) {
					int x = i + dx[d];
					int y = j + dy[d];
					if (isCango(map, x, y)) {
						list.add(new XY(x, y));
					}
				}
				addMap[i][j] -= map[i][j] / 5 * list.size();
				for (XY tmp : list) {
					addMap[tmp.x][tmp.y] += map[i][j] / 5;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += addMap[i][j];
			}
		}
		return map;
	}

	public static boolean isCango(int[][] map, int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C && map[x][y] != -1;
	}

	public static int cal(int[][] map) {
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					continue;
				answer += map[i][j];
			}
		}
		return answer;
	}

	public static class XY {
		int x;
		int y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
