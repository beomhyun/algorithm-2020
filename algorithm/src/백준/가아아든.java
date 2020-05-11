package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 가아아든 {
	static int N, M;
	static int[][] map;
	static List<XY> canGround;
	static int G, R;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static final int RED = 3;
	static final int GREEN = 4;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		canGround = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					canGround.add(new XY(i, j));
				} else if (map[i][j] == 0) {
					map[i][j] = -1;
				}
			}
		}
		List<XY> red = new ArrayList<>();
		List<XY> green = new ArrayList<>();
		answer = 0;
		dfs(red, green, 0);
		System.out.println(answer);
	}

	public static void solution(List<XY> red, List<XY> green) {
		Queue<XY> que = new LinkedList<>();

		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			copyMap[i] = Arrays.copyOf(map[i], M);
		}
		for (XY temp : red) {
			que.add(temp);
			copyMap[temp.getX()][temp.getY()] = RED;
		}
		for (XY temp : green) {
			que.add(temp);
			copyMap[temp.getX()][temp.getY()] = GREEN;
		}

		int count = 0;
		while (true) {
			boolean endCheck = true;
			while (!que.isEmpty()) {
				XY temp = que.poll();

				int x = temp.getX();
				int y = temp.getY();
				int color = temp.getColor();

				int nx, ny;
				for (int d = 0; d < 4; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (color == RED) {
						if (isRange(nx, ny) && (copyMap[nx][ny] == 1 || copyMap[nx][ny] == 2)) {
							copyMap[nx][ny] = RED;
							endCheck = false;
						} else if (isRange(nx, ny) && copyMap[nx][ny] == GREEN) {
							copyMap[nx][ny] = -1;
							count++;
						}
					} else {
						if (isRange(nx, ny) && (copyMap[nx][ny] == 1 || copyMap[nx][ny] == 2)) {
							copyMap[nx][ny] = GREEN;
							endCheck = false;
						} else if (isRange(nx, ny) && copyMap[nx][ny] == RED) {
							copyMap[nx][ny] = -1;
							count++;
						}
					}
				}
			}

			if (endCheck) {
				break;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copyMap[i][j] != 0) {
						copyMap[i][j] = copyMap[i][j];
						if (copyMap[i][j] == RED) {
							que.add(new XY(i, j, 'R'));
						} else if (copyMap[i][j] == GREEN) {
							que.add(new XY(i, j, 'G'));
						}
					}
				}
			}
		}
		answer = Math.max(answer, count);
	}

	public static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static void printMap(int[][] copyMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(copyMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void dfs(List<XY> red, List<XY> green, int d) {
		if (red.size() == R && green.size() == G) {
			solution(red, green);
			return;
		}
		if (d == canGround.size() || red.size() > R || green.size() > G) {
			return;
		}
		XY temp = canGround.get(d);
		XY r = new XY(temp.getX(), temp.getY(), RED);
		XY g = new XY(temp.getX(), temp.getY(), GREEN);

		red.add(r);
		dfs(red, green, d + 1);
		red.remove(r);

		green.add(g);
		dfs(red, green, d + 1);
		green.remove(g);

		dfs(red, green, d + 1);
	}

	public static class XY {
		private int x;
		private int y;
		private int color;

		public XY(int x, int y, int color) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
		}

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

		public int getColor() {
			return color;
		}

		public void setColor(int color) {
			this.color = color;
		}

	}
}
