package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Sides;

import org.omg.PortableServer.AdapterActivator;

public class 이차원배열과연산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int N = 3;
		maxR = N;
		maxC = N;
		int[][] A = new int[100][100];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		solution(A, 0, k, r, c);
		System.out.println(answer);
	}

	static int answer;
	static int maxR;
	static int maxC;

	public static void solution(int[][] A, int turn, int k, int r, int c) {
		if (turn > 100) {
			answer = -1;
			return;
		}
		if (A[r - 1][c - 1] == k) {
			answer = turn;
			return;
		}
		if (maxR >= maxC) {
			A = rCal(A);
		} else {
			A = cCal(A);
		}
		solution(A, turn + 1, k, r, c);
	}

	public static int[][] rCal(int[][] A) {
		int[][] B = new int[100][100];
		int tmpMaxC = 0;
		for (int i = 0; i < maxR; i++) {
			List<Number> list = new ArrayList<>();
			int[] tmp = new int[101];
			for (int j = 0; j < maxR; j++) {
				tmp[A[i][j]]++;
			}
			for (int j = 1; j < tmp.length; j++) {
				if (tmp[j] == 0) {
					continue;
				}
				list.add(new Number(j, tmp[j]));
			}
			list.sort(new Comparator<Number>() {
				@Override
				public int compare(Number o1, Number o2) {
					if (o1.count == o2.count) {
						return o1.num - o2.num;
					}
					return o1.count - o2.count;
				}
			});
			int index = 0;
			for (int j = 0; j < list.size(); j++) {
				Number num = list.get(j);
				B[i][index++] = num.num;
				B[i][index++] = num.count;
				if (index == 100) {
					break;
				}
			}
			if (tmpMaxC < index) {
				tmpMaxC = index;
			}
		}
		maxC = tmpMaxC;
		return B;
	}

	public static int[][] cCal(int[][] A) {
		int[][] B = new int[100][100];
		int tmpMaxR = 0;
		for (int i = 0; i < maxC; i++) {
			List<Number> list = new ArrayList<>();
			int[] tmp = new int[101];
			for (int j = 0; j < maxC; j++) {
				tmp[A[j][i]]++;
			}
			for (int j = 1; j < tmp.length; j++) {
				if (tmp[j] == 0) {
					continue;
				}
				list.add(new Number(j, tmp[j]));
			}
			list.sort(new Comparator<Number>() {
				@Override
				public int compare(Number o1, Number o2) {
					if (o1.count == o2.count) {
						return o1.num - o2.num;
					}
					return o1.count - o2.count;
				}
			});
			int index = 0;
			for (int j = 0; j < list.size(); j++) {
				Number num = list.get(j);
				B[index++][i] = num.num;
				B[index++][i] = num.count;
				if (index == 100) {
					break;
				}
			}
			if (tmpMaxR < index) {
				tmpMaxR = index;
			}
		}
		maxR = tmpMaxR;
		return B;
	}

	public static class Number {
		int num;
		int count;

		public Number(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}
	}
}
