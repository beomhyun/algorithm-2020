package ���α׷��ӽ�.DP;

public class ������ {
	public static int solution(int[] price) {
		int answer = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < price.length; i++) {
			if (price[i] - min > answer) {
				answer = price[i] - min;
			}
			if (min > price[i]) {
				min = price[i];
			}
		}

		return answer;
	}
	public static void main(String[] args) {
		int[] price = {3,4,1,4,5};
		
		System.out.println(solution(price));
	}
}
