package 프로그래머스.DP;

public class dp {
	public static int solution(int a, int b, int budget) {
		int endIndex;
		int minPrice;
		int maxPrice;

		if (a > b) {
			endIndex = budget / a;
			minPrice = b;
			maxPrice = a;
		} else {
			endIndex = budget / b;
			minPrice = a;
			maxPrice = b;
		}
		int temp = 0;
		for (int i = 1; i <= endIndex; i++) {
			int remainBudget = budget - maxPrice * i;
			if (remainBudget >= minPrice && remainBudget % minPrice == 0) {
				temp = i * maxPrice;
			}
		}
		int lcm = lcm(minPrice, maxPrice);
		int answer = 0;
		while(temp > 0) {
			temp -= lcm;
			answer++;
		}
			
		return answer;
	}

	public static int lcm(int n, int m) {
		int min = n > m ? m : n;
		int lcm = 1;
		for (int i = min; i > -1; i--) {
			if (n % i == 0 && m % i == 0) {
				lcm = n * m / i;
				break;
			}
		}
		return lcm;

	}

	public static void main(String[] args) {
		System.out.println(solution(3, 5, 1000000000));
	}
}
