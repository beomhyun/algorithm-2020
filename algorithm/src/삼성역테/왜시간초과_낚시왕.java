package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 왜시간초과_낚시왕 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] change = { 1, 0, 3, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		Shark[] sharks = new Shark[10001];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			map[r][c] = z;
			sharks[z] = new Shark(r, c, s, d, z);
		}

		int answer = 0;
		for (int time = 0; time < C; time++) {
			// 상어를 잡는다.
			for (int i = 0; i < R; i++) {
				if (map[i][time] != 0) {
					answer += map[i][time];
					sharks[map[i][time]] = null;
					map[i][time] = 0;
					break;
				}
			}
			// 상어이동
			for (int i = 0; i < sharks.length; i++) {
				if (sharks[i] == null) {
					continue;
				}
				Shark curr = sharks[i];
				int nr = curr.r;
				int nc = curr.c;
				int move = curr.s;
				int d = curr.d;
				map[nr][nc] = 0;

				for (int j = 0; j < move; j++) {
					if (!isRange(nr + dx[d], nc + dy[d], R, C)) {
						d = change[d];
					}
					nr += dx[d];
					nc += dy[d];
				}
				sharks[i].r = nr;
				sharks[i].c = nc;
				sharks[i].d = d;

			}
			for (int i = sharks.length - 1; i > 0; i--) {
				if (sharks[i] == null) {
					continue;
				}
				Shark curr = sharks[i];
				if (map[curr.r][curr.c] < curr.z) {
					sharks[map[curr.r][curr.c]] = null;
					map[curr.r][curr.c] = curr.z;
				} else {
					sharks[i] = null;
				}
			}
		}
		System.out.println(answer);
	}

	public static boolean isRange(int r, int c, int R, int C) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	public static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
