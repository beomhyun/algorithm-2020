package 伙己开抛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 肺嚎没家扁 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder(br.readLine());

		StringTokenizer st = new StringTokenizer(sb.toString());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		sb = new StringBuilder(br.readLine());
		st = new StringTokenizer(sb.toString());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			sb = new StringBuilder(br.readLine());
			st = new StringTokenizer(sb.toString());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		while (true) {
			if (map[r][c] == 0) {
				map[r][c] = 2;
				answer++;
			}
			boolean check = false;
			int tmpD = d;
			for (int i = 0; i < 4; i++) {
				tmpD -= 1;
				if (tmpD == -1) {
					tmpD = 3;
				}
				int x = r + dx[tmpD];
				int y = c + dy[tmpD];
				if (x >= 0 && y >= 0 && x < N && y < N && map[x][y] == 0) {
					r = x;
					c = y;
					check = true;
					d = tmpD;
					break;
				}
			}
			if (check) {
				continue;
			}
			tmpD = d - 2;
			if (tmpD < 0) {
				tmpD += 4;
			}
			int x = r + dx[tmpD];
			int y = c + dy[tmpD];

			if (x >= 0 && y >= 0 && x < N && y < M) {
				if (map[x][y] == 1) {
					break;
				} else {
					r = x;
					c = y;
				}
			} else {
				break;
			}
		}
		System.out.println(answer);
	}
}
