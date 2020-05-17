package 백준;

import java.util.Scanner;

public class 연속합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner s = new Scanner(System.in);
//		int N = s.nextInt();
//		int A[] = new int[N];
//		int preSum[] = new int[N];
//		for (int i = 0; i < N; i++) {
//			A[i] = s.nextInt();
//		}
//		preSum[0] = A[0];
//		for (int i = 1; i < N; i++) {
//			preSum[i] = Math.max(A[i], preSum[i - 1] + A[i]);
//		}
//
//		int res = Integer.MIN_VALUE;
//		for (int i = 0; i < N; i++) {
//			res = Math.max(res, preSum[i]);
//		}
//
//		System.out.println(res);
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		int preSum[] = new int[N + 1];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		int res = A[0];
		preSum[0] = A[0];
		
		for (int i = 1; i < N; i++) {
			preSum[i] = Math.max(A[i], preSum[i - 1] + A[i]);
			res = Math.max(preSum[i], res);
		}

		System.out.println(res);

		
		
	}

}