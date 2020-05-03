package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링 {
	static boolean[][] connect;
	static int N;
	static int[] map;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		connect = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());

			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken()) - 1;
				connect[i][temp] = true;
				connect[temp][i] = true;
			}
		}
		answer = Integer.MAX_VALUE;
		solution();
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	public static void solution() {
		int[] team = new int[N];
		dfs(team, 0);
	}

	public static void dfs(int[] team, int d) {
		if (d == N) {
			if (isCanTeam(team)) {
				cal(team);
			}
			return;
		}
		team[d] = 1;
		dfs(team, d + 1);
		team[d] = 2;
		dfs(team, d + 1);
	}

	public static void cal(int[] team) {
		int a = 0, b = 0;
		for (int i = 0; i < N; i++) {
			if (team[i] == 1) {
				a += map[i];
			} else {
				b += map[i];
			}
		}
		answer = Math.min(answer, Math.abs(a - b));
	}

	public static boolean isCanTeam(int[] team) {
		Queue<Integer> que;
		int[] teamCheck = new int[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (teamCheck[i] != 0) {
				continue;
			}
			count++;
			int teamTemp = team[i];
			que = new LinkedList<Integer>();
			que.add(i);
			while (!que.isEmpty()) {
				int temp = que.poll();
				for (int j = 0; j < N; j++) {
					if (connect[temp][j] && team[j] == teamTemp && teamCheck[j] == 0) {
						teamCheck[j] = teamTemp;
						que.add(j);
					}
				}
			}
		}
		if (count == 2) {
			return true;
		} else {
			return false;
		}
	}
}
