package ���α׷��ӽ�;

public class �ֽİ��� {
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
		�ֽİ��� test = new �ֽİ���();

		int[] answer = test.solution(prices);

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
