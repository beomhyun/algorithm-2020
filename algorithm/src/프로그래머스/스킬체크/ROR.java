package 프로그래머스.스킬체크;

public class ROR {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int answer;
	static xy destination;

	public static void main(String[] args) {
		ROR ror = new ROR();
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
//		int[][] maps = { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };
		ror.solution(maps);
	}

	public int solution(int[][] maps) {
		answer = -1;
		boolean[][] visit = new boolean[maps.length][maps[0].length];
		destination = new xy(0, 0);
		dfs(new xy(maps.length - 1, maps[0].length - 1), maps, visit, 1);
		return answer;
	}

	static void dfs(xy now, int[][] maps, boolean[][] visit, int count) {
		System.out.println(now + " " + count);
		if (answer != -1 && answer <= count)
			return;
		if (now.x == destination.x && now.y == destination.y) {
			System.out.println("!");
			if (answer == -1)
				answer = count;
			else
				answer = answer > count ? count : answer;
			return;
		}

		int x = now.getX();
		int y = now.getY();

		for (int i = 0; i < 4; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < maps.length && y + dy[i] >= 0 && y + dy[i] < maps[0].length
					&& maps[x + dx[i]][y + dy[i]] == 1 && !visit[x + dx[i]][y + dy[i]]) {
				visit[x][y] = true;
				dfs(new xy(x + dx[i], y + dy[i]), maps, visit, count + 1);
				visit[x][y] = false;
			}
		}
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
