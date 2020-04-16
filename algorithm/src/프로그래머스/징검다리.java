package 프로그래머스;

import java.util.Arrays;

public class 징검다리 {
	public static int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		return binarySearch(rocks, distance, n);
	}

	public static int binarySearch(int[] rocks, int distance, int n) {
		long answer = 0;
		long left = 1, right = distance, mid = 0;
		while (left <= right) {
			int count = 0;
			int prev = 0;
			mid = (left + right) / 2;
			for (int i = 0; i < rocks.length; i++) {
				if (rocks[i] - prev < mid) {
					count++;
				} else {
					prev = rocks[i];
				}
			}
			if (distance - rocks[rocks.length - 1] < mid)
				count++;
			if (count <= n) {
				answer = mid > answer ? mid : answer;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return (int) answer;
	}

	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = { 2, 14, 11, 21, 17 };
		int n = 2;
		
		System.out.println(solution(distance, rocks, n));
	}
}
