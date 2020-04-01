package 백준;

import java.util.Scanner;

public class 숨박꼭질6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int S = sc.nextInt();

		int[] A = new int[N];

		int[] distance = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			distance[i] = Math.abs(S - A[i]);
		}

		int gcd = distance[0];

		for (int i = 1; i < distance.length; i++) {
			gcd = GCD(gcd,distance[i]);
		}
		
		System.out.println(gcd);
	}

	public static int GCD(int n1, int n2) {
		if (n2 == 0)
			return n1;
		else
			return GCD(n2, n1 % n2);
	}
}
