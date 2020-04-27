package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][][] dir = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 2 }, { 1, 3 } },
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, { { 0, 1, 2 }, { 0, 1, 3 }, { 0, 2, 3 }, { 1, 2, 3 } },
			{ { 0, 1, 2, 3 } } };

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		List<Camera> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new Camera(i, j, map[i][j]));
				}
			}
		}
		answer = Integer.MAX_VALUE;
		dfs(new boolean[N][M], 0, list);
		System.out.println(answer);
	}

	static int answer;

	public static void printMap(boolean[][] watch) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && watch[i][j]) {
					System.out.print("# ");
				} else {
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void dfs(boolean[][] watch, int d, List<Camera> list) {
		if (d == list.size()) {
			int temp = calWatch(watch);
			answer = Math.min(answer, temp);
			return;
		}
		Camera camera = list.get(d);
		int cameraX = camera.x;
		int cameraY = camera.y;
		for (int i = 0; i < dir[camera.version].length; i++) {
			int x = cameraX;
			int y = cameraY;
			boolean[][] tempWatch = new boolean[N][M];
			for (int k = 0; k < N; k++) {
				for (int k2 = 0; k2 < M; k2++) {
					tempWatch[k][k2] = watch[k][k2];
				}
			}
			for (int j = 0; j < dir[camera.version][i].length; j++) {
				x = cameraX;
				y = cameraY;
				while (true) {
					x += dx[dir[camera.version][i][j]];
					y += dy[dir[camera.version][i][j]];
					if (isRange(x, y) && map[x][y] != 6) {
						tempWatch[x][y] = true;
					} else {
						break;
					}
				}
			}
			dfs(tempWatch, d + 1, list);
		}
	}

	public static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static int calWatch(boolean[][] watch) {
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !watch[i][j]) {
					answer++;
				}
			}
		}
		return answer;
	}

	public static class Camera {
		int x;
		int y;
		int version;

		public Camera(int x, int y, int version) {
			super();
			this.x = x;
			this.y = y;
			this.version = version;
		}

	}
}
