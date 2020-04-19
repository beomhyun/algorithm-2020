package 카카오2019겨울인턴;

public class 징검다리건너기 {
	public static int solution(int[] stones, int k) {
		int answer = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < stones.length; i++) {
			int tmp = stones[i];
			sum += tmp;
			boolean check = true;
			for (int j = 1; j < k; j++) {
				if (i + j < stones.length) {
					if (stones[i + j] <= tmp) {
						continue;
					} else {
						check = false;
						break;
					}
				} else {
					check = false;
					break;
				}
			}
			if (check) {
				answer = Math.min(answer, tmp);
			}
		}
		if (answer == Integer.MAX_VALUE) {
			return sum;
		} else {
			return answer;
		}
	}

	public static void main(String[] args) {
		int k = 20;
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };

		System.out.println(solution(stones, k));
	}
}
