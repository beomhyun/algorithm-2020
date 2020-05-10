package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스티커붙이기 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		boolean[][] visit;
		Queue<XY> que;

		for (int kk = 0; kk < K; kk++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[r][c];
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < c; k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			List<XY> stickerList = new ArrayList<>();
			visit = new boolean[r][c];
			for (int j = 0; j < r; j++) {
				boolean check = false;
				for (int k = 0; k < c; k++) {
					if (sticker[j][k] == 1 && !visit[j][k]) {
						que = new LinkedList<>();
						que.add(new XY(j, k));
						stickerList.add(new XY(j, k));
						visit[j][k] = true;
						while (!que.isEmpty()) {
							XY xy = que.poll();
							int x = xy.getX();
							int y = xy.getY();
							int nx, ny;

							for (int d = 0; d < 4; d++) {
								nx = x + dx[d];
								ny = y + dy[d];
								if (isRange(r, c, nx, ny) && !visit[nx][ny] && sticker[nx][ny] == 1) {
									stickerList.add(new XY(nx, ny));
									visit[nx][ny] = true;
									que.add(new XY(nx, ny));
								}
							}
						}
						check = true;
						break;
					}
					if (check) {
						break;
					}
				}
			}
			boolean checkBreak = false;
			for (int count = 0; count < 4; count++) {
				for (int i = 0; i < N; i++) {
					if (checkBreak) {
						break;
					}
					for (int j = 0; j < M; j++) {
						if (checkBreak) {
							break;
						}
						int x = i;
						int y = j;

						int nx, ny;
						boolean check = true;
						for (XY xy : stickerList) {
							nx = x + xy.getX();
							ny = y + xy.getY();

							if (isRange(N, M, nx, ny) && map[nx][ny] == 0) {
								continue;
							} else {
								check = false;
								break;
							}
						}
						if (check) {
							for (XY xy : stickerList) {
								nx = x + xy.getX();
								ny = y + xy.getY();

								map[nx][ny] = 1;
							}
							checkBreak = true;
							break;
						}
					}
				}
				if (checkBreak) {
					break;
				} else {
					int tmp = c;
					c = r;
					r = tmp;
					for (XY xy : stickerList) {
						int tmpX = xy.getX();
						int tmpY = xy.getY();
						xy.setX(tmpY);
						xy.setY(c - 1 - tmpX);
					}
				}
			}
		}
		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	public static boolean isRange(int r, int c, int x, int y) {
		return x >= 0 && y >= 0 && x < r && y < c;
	}

	public static class XY {
		private int x;
		private int y;

		public XY(int x, int y) {
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
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}

	}
}
