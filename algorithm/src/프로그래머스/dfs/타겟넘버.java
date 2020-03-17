package ���α׷��ӽ�.dfs;

public class Ÿ�ٳѹ� {
	static int answer;

	public int solution(int[] numbers, int target) {
		answer = 0;
		dfs(numbers, 0, 0, target);
		return answer;
	}

	static void dfs(int[] numbers, int sum, int index, int target) {
		if (index == numbers.length) {
			if (sum == target)
				answer++;
			return;
		}
		dfs(numbers, sum + numbers[index], index + 1, target);
		dfs(numbers, sum - numbers[index], index + 1, target);
	}
}
