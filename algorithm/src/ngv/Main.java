package ngv;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		StringBuilder str = new StringBuilder(sc.next());

		long answer = 0;

		for (int i = 0; i <= N - K; i++) {
			StringBuilder s = new StringBuilder(str.substring(i, i + K));
			long tmp = Integer.parseInt(s.toString());
			if (tmp > answer) {
				answer = tmp;
			}
		}

		System.out.println(answer);
	}
}
