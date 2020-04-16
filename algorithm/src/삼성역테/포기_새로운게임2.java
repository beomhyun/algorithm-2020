package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 포기_새로운게임2 {
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<horse> list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new horse(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		answer = 0;
		solution(0, list, map);
		System.out.println(answer);
	}

	static int answer;

	public static void solution(int turn, List<horse> list, int[][] map) {

		for (horse tmpH : list) {
			if (endCheck(tmpH)) {
				answer = turn;
				return;
			}
		}

		if (turn == 1001) {
			answer = -1;
			return;
		}
		for (horse h : list) {
			int x = h.x + dx[h.d];
			int y = h.y + dy[h.d];
			int d = h.d;
			if (x < 0 || x >= N || y < 0 || y >= N || map[x][y] == 2) {
				horse tmp = h;
				while (true) {
					if (d == 1) {
						tmp.d = 2;
					} else if (d == 2) {
						tmp.d = 1;
					} else if (d == 3) {
						tmp.d = 4;
					} else if (d == 4) {
						tmp.d = 3;
					}
					if (tmp.up == null) {
						break;
					} else {
						tmp = tmp.up;
					}
				}
			} else if (map[x][y] == 0) {
				horse tmp = h;
				while (true) {
					tmp.x = x;
					tmp.y = y;

					for (horse tmpH : list) {
						if (h.equals(tmpH)) {
							continue;
						} else if (tmpH.x == x && tmpH.y == y && tmpH.up == null) {
							tmpH.up = tmp;
							tmp.down = tmpH;
							break;
						}
					}
					if (tmp.up == null) {
						break;
					} else {
						tmp = tmp.up;
					}
				}
			} else if (map[x][y] == 1) {
				horse tmp = h;
				while (true) {
					tmp.x = x;
					tmp.y = y;

					boolean check = true;
					for (int i = list.size() - 1; i >= 0; i--) {
						horse tmpH = list.get(i);
						if (tmp.equals(tmpH)) {
							continue;
						} else if (tmpH.x == x && tmpH.y == y && tmpH.up == null) {
							tmpH.up = tmp;
							tmp.down = tmpH;
							check = false;
							break;
						}
					}
					if (check) {

					}

					if (tmp.up == null) {
						break;
					} else {
						tmp = tmp.up;
					}
				}
			}
		}
		solution(turn + 1, list, map);
	}

	public static boolean endCheck(horse h) {
		int cnt = 1;
		while (true) {
			if (h.up == null) {
				break;
			} else {
				h = h.up;
				cnt++;
				if (cnt == 4) {
					return true;
				}
			}
		}
		if (cnt < 4) {
			return false;
		} else {
			return true;
		}
	}

	public static class horse {
		int x;
		int y;
		int d;
		horse up;
		horse down;

		@Override
		public String toString() {
			return "horse [x=" + x + ", y=" + y + ", d=" + d + ", up=" + up + ", down=" + down + "]";
		}

		public horse(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.up = null;
			this.down = null;
		}
	}
}
