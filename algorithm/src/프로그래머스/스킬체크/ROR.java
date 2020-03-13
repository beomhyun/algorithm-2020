package 프로그래머스.스킬체크;

import java.util.LinkedList;
import java.util.Queue;

public class ROR {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		ROR ror = new ROR();
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
//		int[][] maps = { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };
		ror.solution(maps);
	}

	public int solution(int[][] maps) {
		int answer = -1;
		int n = maps.length;
		int m = maps[0].length;

		int[][] visit = new int[n][m];
		visit[0][0] = 1;
		Queue<xy> que = new LinkedList<xy>();
		que.add(new xy(0, 0));
		while (!que.isEmpty()) {
			xy xy = que.poll();
			int nowX = xy.getX();
			int nowY = xy.getY();
			if (nowX == n - 1 && nowY == m - 1) {
				answer = visit[nowX][nowY];
				break;
			}
			for (int i = 0; i < dx.length; i++) {
				int x = nowX + dx[i];
				int y = nowY + dy[i];
				if (x >= 0 && y >= 0 && x < n && y < m && maps[x][y] == 1 && visit[x][y] == 0) {
					visit[x][y] = visit[nowX][nowY] + 1;
					que.add(new xy(x, y));
				}
			}
		}
		return answer;
	}

	static class xy {
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

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			xy other = (xy) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}
}
