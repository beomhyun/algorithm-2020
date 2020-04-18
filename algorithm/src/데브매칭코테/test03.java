package 데브매칭코테;

import java.util.Arrays;

public class test03 {
	public int solution(int[] numbers, int K) {
		int[] tmp = numbers.clone();
		Arrays.sort(tmp);
		int max = 0;
		for (int i = 1; i < tmp.length - 1; i++) {
			if (max < Math.abs(tmp[i] - tmp[i - 1])) {
				max = Math.abs(tmp[i] - tmp[i - 1]);
			}
			if (max < Math.abs(tmp[i] - tmp[i + 1])) {
				max = Math.abs(tmp[i] - tmp[i + 1]);
			}
		}
		if (max > K) {
			return -1;
		}
		int answer = binarySearch(numbers, K);
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		return answer;
	}

	public static int binarySearch(int[] numbers, int K) {
		int answer = Integer.MAX_VALUE;

		int left = 0;
		int right = numbers.length * numbers.length;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			changeCheck = false;
			dfs(numbers, K, mid);
			if (changeCheck) {
				answer = answer > mid ? mid : answer;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}

	static boolean changeCheck;

	public static void dfs(int[] numbers, int K, int count) {
		if (changeCheck) {
			return;
		}
		if (count == 0) {
			if (clearCheck(numbers, K)) {
				changeCheck = true;
			}
			return;
		}
		int[] tempNumbers = numbers.clone();
		for (int i = 0; i < tempNumbers.length; i++) {
			for (int j = i + 1; j < tempNumbers.length; j++) {
				int temp = tempNumbers[i];
				tempNumbers[i] = tempNumbers[j];
				tempNumbers[j] = temp;

				dfs(tempNumbers, K, count - 1);
				tempNumbers[j] = tempNumbers[i];
				tempNumbers[i] = temp;
			}
		}
	}

	public static boolean clearCheck(int[] numbers, int K) {
		boolean check = true;
		for (int i = 1; i < numbers.length - 1; i++) {
			if (Math.abs(numbers[i] - numbers[i - 1]) > K || Math.abs(numbers[i] - numbers[i + 1]) > K) {
				check = false;
				break;
			}
		}
		return check;
	}
}
