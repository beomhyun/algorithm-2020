package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ÇÏ³ª·Î {
	static int N;
	static int[] X, Y;
	static double E;
	static int testCase;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			testCase = tc;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			X = new int[N];
			Y = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			E = Double.parseDouble(st.nextToken());

			solution();
		}
	}

	public static void printDistance(double[][] distance) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solution() {
		double[][] distance = new double[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (distance[i][j] != 0) {
					continue;
				}
				distance[i][j] = calDistance(X[i], X[j], Y[i], Y[j]);
				distance[j][i] = distance[i][j];
			}
		}

		boolean[] visit = new boolean[N];

		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		visit[0] = true;

		double answer = 0;
		while (list.size() < N) {
			int minIndex = -1;
			double minDistance = Double.MAX_VALUE;

			for (int i = 0; i < list.size(); i++) {
				int index = list.get(i);
				for (int j = 0; j < N; j++) {
					if (visit[j] || index == j) {
						continue;
					}
					double tempDistance = distance[index][j];
					if (tempDistance == 0) {
						continue;
					}
					if (minDistance > tempDistance) {
						minIndex = j;
						minDistance = tempDistance;
					}
				}
			}

			list.add(minIndex);
			answer += minDistance;
			visit[minIndex] = true;

		}

		System.out.println("#" + testCase + " " + Math.round(answer));
	}

	public static double calDistance(int x1, int x2, int y1, int y2) {
		return E * Math.pow(Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2)), 2);
	}
}
