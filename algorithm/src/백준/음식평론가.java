package 백준;

import java.util.Scanner;

public class 음식평론가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		System.out.println(M - gcd(N, M));
	}
	public static int gcd(int x , int y) {
		while(y != 0) {
			int tmp = y;
			y = x % y;
			x = tmp;
		}
		return x;
	}
}
