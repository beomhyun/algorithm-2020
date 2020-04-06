package 伙己开抛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 楷备家 {
	static final int chooseWallSize = 3;
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static int M;
	static int answer;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder(br.readLine());
		StringTokenizer st = new StringTokenizer(sb.toString());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		List<xy> list = new ArrayList<>();
		answer = 0;
		for (int i = 0; i < N; i++) {
			sb = new StringBuilder(br.readLine());
			st = new StringTokenizer(sb.toString());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new xy(i, j));
				}
			}
		}
		solution(list, new ArrayList<>(), 0);

		System.out.println(answer);
	}

	public static void solution(List<xy> list, List<xy> choose, int d) {
		if (choose.size() == chooseWallSize) {
			visit = new boolean[N][M];
			Queue<xy> birus = new LinkedList<>();

			int[][] newMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newMap[i][j] = map[i][j];
					if (newMap[i][j] == 2) {
						birus.add(new xy(i, j));
					}
				}
			}
			for (int i = 0; i < choose.size(); i++) {
				xy tmp = choose.get(i);
				newMap[tmp.x][tmp.y] = 1;
			}
			while (!birus.isEmpty()) {
				xy tmp = birus.poll();
				int x = tmp.x;
				int y = tmp.y;
				for (int i = 0; i < 4; i++) {
					int xx = x + dx[i];
					int yy = y + dy[i];
					if (xx >= 0 && yy >= 0 && xx < N && yy < M && newMap[xx][yy] == 0) {
						newMap[xx][yy] = 2;
						birus.add(new xy(xx, yy));
					}
				}
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (newMap[i][j] == 0) {
						count++;
					}
				}
			}
			if (answer < count) {
				answer = count;
			}
			return;
		}
		if (d == list.size())
			return;
		choose.add(list.get(d));
		solution(list, choose, d + 1);
		choose.remove(choose.size() - 1);
		solution(list, choose, d + 1);
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
