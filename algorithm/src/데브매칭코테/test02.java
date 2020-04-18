package 데브매칭코테;

public class test02 {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static final String go = "go";
	static final String left = "left";
	static final String right = "right";

	public int solution(int[][] office, int r, int c, String[] move) {
		int answer = 0;

		int d = 0;
		answer = office[r][c];
		office[r][c] = 0;

		for (int i = 0; i < move.length; i++) {
			if (move[i].equals(go)) {
				if (isCango(office, r + dx[d], c + dy[d])) {
					r += dx[d];
					c += dy[d];
					answer += office[r][c];
					office[r][c] = 0;
				}
			} else if (move[i].equals(left)) {
				d--;
				if (d < 0) {
					d += 4;
				}
			} else if (move[i].equals(right)) {
				d++;
				if (d > 3) {
					d -= 4;
				}
			}
		}

		return answer;
	}

	public static boolean isCango(int[][] office, int r, int c) {
		return r >= 0 && c >= 0 && r < office.length && c < office[r].length && office[r][c] != -1;
	}
}
