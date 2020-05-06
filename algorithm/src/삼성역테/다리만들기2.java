package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 다리만들기2 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, M;
	static int[][] map;
	static int islandSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Island> islandList = makeIslandList();
		map = new int[N][M];
		islandSize = islandList.size();

		for (int i = 0; i < islandList.size(); i++) {
			Island island = islandList.get(i);
			List<XY> list = island.XYs;
			int index = i + 1;

			for (int j = 0; j < list.size(); j++) {
				XY tempXY = list.get(j);
				map[tempXY.x][tempXY.y] = index;
			}
		}
		solution(islandList);

	}

	public static void solution(List<Island> islandList) {
		int answer = 0;
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);

		while (set.size() < islandSize) {
			int minIndex = -1;
			int minDistance = Integer.MAX_VALUE;
			for (int num : set) {
				int index = num - 1;
				Island island = islandList.get(index);
				List<XY> list = island.XYs;

				for (int i = 0; i < list.size(); i++) {
					XY xy = list.get(i);
					int x = xy.x;
					int y = xy.y;
					int nx, ny;

					for (int d = 0; d < 4; d++) {
						int tempDistance = -1;
						nx = x;
						ny = y;
						while (true) {
							nx += dx[d];
							ny += dy[d];
							tempDistance++;
							if (!isRange(nx, ny) || set.contains(map[nx][ny])) {
								break;
							}
							if (map[nx][ny] != 0 && !set.contains(map[nx][ny])) {
								if (tempDistance > 1 && minDistance > tempDistance) {
									minIndex = map[nx][ny];
									minDistance = tempDistance;
								}
								break;
							}
						}
					}
				}
			}
			if (minIndex == -1) {
				System.out.println(-1);
				return;
			} else {
				set.add(minIndex);
				answer += minDistance;
			}
		}
		System.out.println(answer);
	}

	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static List<Island> makeIslandList() {
		List<Island> list = new ArrayList<>();

		boolean[][] visit = new boolean[N][M];
		Queue<XY> que;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] || map[i][j] == 0) {
					continue;
				}
				Island tempIsland = new Island(new ArrayList<>());
				que = new LinkedList<>();
				que.add(new XY(i, j));
				tempIsland.add(i, j);
				visit[i][j] = true;

				while (!que.isEmpty()) {
					XY tempXY = que.poll();
					int x = tempXY.x;
					int y = tempXY.y;

					int nx, ny;
					for (int d = 0; d < 4; d++) {
						nx = x + dx[d];
						ny = y + dy[d];

						if (isRange(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
							tempIsland.add(nx, ny);
							visit[nx][ny] = true;
							que.add(new XY(nx, ny));
						}
					}

				}
				list.add(tempIsland);
			}
		}
		return list;
	}

	public static boolean isRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < M;
	}

	public static class Island {
		List<XY> XYs;

		public Island(List<XY> xYs) {
			super();
			XYs = xYs;
		}

		public void add(int x, int y) {
			XYs.add(new XY(x, y));
		}
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
