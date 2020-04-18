package 데브매칭코테;

import java.util.Arrays;

public class test03_dfs_닶없을때처리 {
	static int answer;

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
		answer = Integer.MAX_VALUE;
		dfs(numbers, K, 0);
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		return answer;
	}

	public static void dfs(int[] numbers, int K, int count) {
		if (answer <= count) {
			return;
		}
		if (clearCheck(numbers, K)) {
			answer = answer < count ? answer : count;
			return;
		}
		if (count == numbers.length * numbers.length) {
			return;
		}
		int[] tempNumbers = numbers.clone();
		for (int i = 0; i < tempNumbers.length; i++) {
			for (int j = i + 1; j < tempNumbers.length; j++) {
				int temp = tempNumbers[i];
				tempNumbers[i] = tempNumbers[j];
				tempNumbers[j] = temp;
				dfs(tempNumbers, K, count + 1);
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
