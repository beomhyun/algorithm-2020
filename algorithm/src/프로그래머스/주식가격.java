package 프로그래머스;

public class 주식가격 {
	public int[] solution(int[] prices) {
		int size = prices.length;
		int[] answer = new int[size];

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (prices[i] > prices[j]) {
					answer[i] = j - i;
					break;
				}
				if (j == size - 1) {
					answer[i] = j - i;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		주식가격 test = new 주식가격();

		int[] answer = test.solution(prices);

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
