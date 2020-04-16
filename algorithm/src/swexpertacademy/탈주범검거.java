package swexpertacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Å»ÁÖ¹ü°Ë°Å {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] dir = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
	static int[][] canDir = { { 1, 2, 5, 6 }, { 1, 3, 6, 7 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N, M, R, C, L;
		int[][] map;

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();

			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			boolean[][] visit = new boolean[N][M];
			visit[R][C] = true;
			Queue<xy> que = new LinkedList<>();

			que.add(new xy(R, C));
			while (L > 1) {
				Queue<xy> tempQue = new LinkedList<>();
				while (!que.isEmpty()) {
					xy temp = que.poll();
					tempQue.add(temp);
					int x = temp.x;
					int y = temp.y;
					int turnel = map[x][y];
					for (int i = 0; i < dir[turnel].length; i++) {
						int d = dir[turnel][i];
						int nextX = x + dx[d];
						int nextY = y + dy[d];
						if (isCanGo(nextX, nextY, N, d, M, visit, map)) {
							tempQue.add(new xy(nextX, nextY));
							visit[nextX][nextY] = true;
						}
					}
				}
				que = tempQue;
				L--;
			}
			System.out.println("#" + tc + " " + que.size());
		}
	}

	public static boolean isCanGo(int x, int y, int N, int d, int M, boolean[][] visit, int[][] map) {
		boolean answer = x >= 0 && x < N && y >= 0 && y < M && !visit[x][y];
		if (answer) {
			answer = false;
			for (int i = 0; i < canDir[d].length; i++) {
				if (canDir[d][i] == map[x][y]) {
					answer = true;
					break;
				}
			}
		}
		return answer;
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
