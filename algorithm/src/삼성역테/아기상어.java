package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];

		XY shark = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j] = 0;
					shark = new XY(i, j, 2);
				}
			}
		}
		bfs(map, shark);
	}

	public static void print(int[][] map, XY shark, int answer) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == shark.x && j == shark.y) {
					System.out.print("9 ");
				} else {
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println(answer);
		System.out.println();
	}

	public static void bfs(int[][] map, XY shark) {
		int answer = 0;
		Queue<XY> que = new LinkedList<>();
		que.add(new XY(shark.x, shark.y));
		boolean[][] visit = new boolean[N][N];
		visit[shark.x][shark.y] = true;
		int distanceCount = 0;
		while (true) {
			List<XY> canEatFishes = new ArrayList<>();
			int queSize = que.size();
			Queue<XY> newQue = new LinkedList<>();
			distanceCount++;
			while (!que.isEmpty()) {
				XY temp = que.poll();
				newQue.add(temp);
				int x = temp.x;
				int y = temp.y;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (isCango(map, nx, ny, shark.size, visit)) {
						newQue.add(new XY(nx, ny));
						visit[nx][ny] = true;
						if (map[nx][ny] != 0 && map[nx][ny] < shark.size) {
							canEatFishes.add(new XY(nx, ny, map[nx][ny]));
						}
					}
				}
			}
			if (newQue.size() == queSize) {
				break;
			}
			if (canEatFishes.size() == 0) {
				que = newQue;
				continue;
			}

			canEatFishes.sort(new Comparator<XY>() {
				@Override
				public int compare(XY o1, XY o2) {

					if (o1.x != o2.x) {
						return o1.x - o2.x;
					} else {
						return o1.y - o2.y;
					}
				}
			});

			XY eatFish = canEatFishes.get(0);
			map[eatFish.x][eatFish.y] = 0;
			shark.eat++;
			if (shark.size == shark.eat) {
				shark.size++;
				shark.eat = 0;
			}
			shark.x = eatFish.x;
			shark.y = eatFish.y;
			visit = new boolean[N][N];
			visit[shark.x][shark.y] = true;
			que = new LinkedList<>();
			que.add(new XY(shark.x, shark.y));
			answer += distanceCount;
			distanceCount = 0;
		}
		System.out.println(answer);
	}

	public static boolean isCango(int[][] map, int x, int y, int size, boolean[][] visit) {
		return x >= 0 && y >= 0 && x < N && y < N && map[x][y] <= size && !visit[x][y];
	}

	public static class XY {
		int x;
		int y;
		int size;
		int eat;

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + ", size=" + size + "]";
		}

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public XY(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
}
