package 伙己开抛;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 林荤困奔府扁 {

	public static int N, M, K, row, col;
	public static int[][] map;
	public static int[] dice = new int[6];
	public static int[] dirX = new int[] { 0, 0, -1, 1 };
	public static int[] dirY = new int[] { 1, -1, 0, 0 };
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			int dir = Integer.parseInt(st.nextToken());
			doDice(dir - 1);
		}
	}

	public static void doDice(int dir) {

		int nr = row + dirX[dir];
		int nc = col + dirY[dir];

		if (isBoundary(nr, nc)) {

			rollDice(dir);

			if (map[nr][nc] == 0) {
				map[nr][nc] = dice[5];
			} else {
				dice[5] = map[nr][nc];
				map[nr][nc] = 0;
			}
			System.out.println(dice[0]);
			row = nr;
			col = nc;
		}
	}

	public static void rollDice(int dir) {

		int[] temp = Arrays.copyOf(dice, dice.length);
		switch (dir) {
		case 0:
			dice[0] = temp[3];
			dice[2] = temp[0];
			dice[3] = temp[5];
			dice[5] = temp[2];
			break;
		case 1:
			dice[0] = temp[2];
			dice[2] = temp[5];
			dice[3] = temp[0];
			dice[5] = temp[3];
			break;
		case 2:
			dice[0] = temp[4];
			dice[1] = temp[0];
			dice[4] = temp[5];
			dice[5] = temp[1];
			break;
		case 3:
			dice[0] = temp[1];
			dice[1] = temp[5];
			dice[4] = temp[0];
			dice[5] = temp[4];
			break;
		}

	}

	public static boolean isBoundary(int row, int col) {
		return (row >= 0 && row < N) && (col >= 0 && col < M);
	}

}

class Node {
	int row;
	int col;

	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}

}