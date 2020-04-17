package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, L, R;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		bfs(map, 0);
		System.out.println(answer);
	}

	static int answer;

	public static void bfs(int[][] map, int turn) {
		visit = new boolean[N][N];
		List<List<xy>> list = new ArrayList<List<xy>>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) {
					continue;
				}
				Queue<xy> que = new LinkedList<>();
				que.add(new xy(i, j));
				visit[i][j] = true;
				while (true) {
					int tempSize = que.size();
					Queue<xy> newQue = new LinkedList<>();
					while (!que.isEmpty()) {
						xy xy = que.poll();
						newQue.add(xy);
						for (int d = 0; d < 4; d++) {
							int x = xy.x + dx[d];
							int y = xy.y + dy[d];
							if (isCan(map, visit, x, y, xy)) {
								newQue.add(new xy(x, y));
								visit[x][y] = true;
							}
						}
					}
					que = newQue;
					if (que.size() == tempSize) {
						List<xy> tempList = new ArrayList<>();
						while (!que.isEmpty()) {
							tempList.add(que.poll());
						}
						list.add(tempList);
						break;
					}
				}
			}
		}
		boolean check = false;

		for (List<xy> tempList : list) {
			int sum = 0;
			for (xy tempXY : tempList) {
				sum += map[tempXY.x][tempXY.y];
			}
			sum /= tempList.size();
			for (xy tempXY : tempList) {
				if (!check && map[tempXY.x][tempXY.y] != sum) {
					check = true;
				}
				map[tempXY.x][tempXY.y] = sum;
			}
		}
		if (check) {
			bfs(map, turn + 1);
		} else {
			answer = turn;
		}
	}

	public static boolean isCan(int[][] map, boolean[][] visit, int x, int y, xy xy) {
		boolean c = x >= 0 && x < N && y >= 0 && y < N && !visit[x][y];
		if (c) {
			int tmp = Math.abs(map[xy.x][xy.y] - map[x][y]);
			if (tmp < L || tmp > R) {
				c = false;
			}
		}
		return c;
	}

	public static class xy {
		int x;
		int y;

		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
