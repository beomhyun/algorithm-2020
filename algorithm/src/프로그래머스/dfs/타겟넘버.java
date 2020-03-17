package 프로그래머스.dfs;

public class 타겟넘버 {
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
