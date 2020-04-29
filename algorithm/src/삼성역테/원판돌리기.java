package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 원판돌리기 {
	static int N, M;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			lotation(map, x, d, k);
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer += map[i][j];
			}
		}
		System.out.println(answer);
	}

	public static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void lotation(int[][] map, int x, int dd, int k) {
		for (int i = 0; i < map.length; i++) {
			int d = dd;
			if ((i + 1) % x == 0) {
				int[] A = map[i];
				if (d == 0) {
					d = 1;
				} else if (d == 1) {
					d = -1;
				}
				k %= A.length;
				d *= k;
				int[] temp = new int[A.length];

				for (int j = 0; j < A.length; j++) {
					int index = j + d;
					if (index < 0) {
						index += A.length;
					} else if (index >= A.length) {
						index -= A.length;
					}
					temp[index] = A[j];
				}
				map[i] = temp;
			}
		}
		Queue<XY> que;
		boolean check = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				que = new LinkedList<>();
				que.add(new XY(i, j));
				int v = map[i][j];
				boolean c = false;
				while (!que.isEmpty()) {
					XY xy = que.poll();
					int xx = xy.x;
					int yy = xy.y;
					for (int dir = 0; dir < 4; dir++) {
						int nx = xx + dx[dir];
						int ny = yy + dy[dir];

						if (ny < 0) {
							ny += M;
						} else if (ny >= M) {
							ny -= M;
						}

						if (isRange(nx, ny) && map[nx][ny] == v) {
							if (c) {
								map[nx][ny] = 0;
								que.add(new XY(nx, ny));
							} else {
								map[xx][yy] = 0;
								map[nx][ny] = 0;
								que.add(new XY(nx, ny));
								c = true;
								check = false;
							}
						}
					}
				}

			}
		}
		if (check) {
			float sum = 0;
			int count = 0;
			for (int l = 0; l < N; l++) {
				for (int m = 0; m < M; m++) {
					if (map[l][m] != 0) {
						sum += map[l][m];
						count++;
					}
				}
			}
			if (count == 0) {
				return;
			}
			float avg = sum / count;
			for (int l = 0; l < N; l++) {
				for (int m = 0; m < M; m++) {
					if (map[l][m] == 0)
						continue;
					if (map[l][m] < avg) {
						map[l][m]++;
					} else if (map[l][m] > avg) {
						map[l][m]--;
					}
				}
			}
		}
	}

	public static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static class XY {
		int x;
		int y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
