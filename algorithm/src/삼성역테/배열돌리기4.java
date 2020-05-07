package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 배열돌리기4 {
	static int N, M, K;
	static List<RotateInfo> rotateInfoList;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rotateInfoList = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rotateInfoList.add(new RotateInfo(Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}
		answer = Integer.MAX_VALUE;
		boolean[] used = new boolean[K];

		dfs(used, 0, map);

		System.out.println(answer);
	}

	public static void dfs(boolean[] used, int k, int[][] map) {
		if (k == K) {
			for (int i = 0; i < N; i++) {
				int tempSum = 0;
				for (int j = 0; j < M; j++) {
					tempSum += map[i][j];
				}
				answer = Math.min(answer, tempSum);
			}

			return;
		}

		int[][] copyMap = new int[N][M];
		for (int index = 0; index < used.length; index++) {
			if (!used[index]) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						copyMap[i][j] = map[i][j];
					}
				}
				copyMap = rotate(index, copyMap);
				used[index] = true;
				dfs(used, k + 1, copyMap);
				used[index] = false;
			}
		}
	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int[][] rotate(int index, int[][] map) {
		RotateInfo rotateInfo = rotateInfoList.get(index);
		int r = rotateInfo.r;
		int c = rotateInfo.c;
		int s = rotateInfo.s;

		int x, y, d;
		int nx, ny;
		while (s > 0) {
			x = r - s;
			y = c - s;
			int tempVal = map[x][y];
			d = 0;
			nx = x + dx[d];
			ny = y + dy[d];
			while (x != nx || y != ny) {
				int temp = map[nx][ny];
				map[nx][ny] = tempVal;
				tempVal = temp;
				nx += dx[d];
				ny += dy[d];
				if (!isRange(r, c, s, nx + dx[d], ny + dy[d])) {
					d++;
				}
			}
			map[x][y] = tempVal;
			s--;
		}
		return map;
	}

	public static boolean isRange(int r, int c, int s, int x, int y) {
		// r-s ~ r+s, c-s ~ c+s
		return x >= r - s && x <= r + s && y >= c - s && y <= c + s;
	}

	public static class RotateInfo {
		int r;
		int c;
		int s;

		public RotateInfo(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}

	}
}
