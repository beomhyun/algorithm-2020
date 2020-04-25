package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방향전환 {
	static int[] dx = {};
	static int[] dy = {};
	static int[][] map;

	public static void main(String[] args) throws IOException {
		map = new int[201][201];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int minX = Math.min(x1, x2);
			int maxX = Math.max(x1, x2);

			int minY = Math.min(y1, y2);
			int maxY = Math.max(y1, y2);

			int moveX = 0 + minX;
			int moveY = 0 + minY;

			maxX -= moveX;
			maxY -= moveY;
		}
	}

	public static void dfs(int x, int y, int findX, int findY) {
		
	}
}
