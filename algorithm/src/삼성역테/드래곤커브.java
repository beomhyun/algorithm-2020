package »ï¼º¿ªÅ×;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class µå·¡°ïÄ¿ºê {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int d = Integer.parseInt(st.nextToken());

			int g = Integer.parseInt(st.nextToken());

			List<Integer> list = new ArrayList<>();
			list.add(d);
			for (int j = 0; j < g; j++) {
				List<Integer> newList = new ArrayList<>();
				for (int k = 0; k < list.size(); k++) {
					newList.add(list.get(k));
				}
				for (int k = list.size() - 1; k >= 0; k--) {
					int tmpD = list.get(k) + 1;
					tmpD %= 4;
					newList.add(tmpD);
				}
				list = newList;
			}
			map[x][y] = true;
			for (int j = 0; j < list.size(); j++) {
				x += dx[list.get(j)];
				y += dy[list.get(j)];
				if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
					map[x][y] = true;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < map.length - 1; i++) {
			for (int j = 0; j < map.length - 1; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	public static class xy {
		int x;
		int y;
		int d;

		@Override
		public String toString() {
			return "xy [x=" + x + ", y=" + y + ", d=" + d + "]";
		}

		public xy(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}
}
