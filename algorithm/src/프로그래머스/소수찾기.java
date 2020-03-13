package 프로그래머스;

public class 소수찾기 {
	public int solution(int n) {
		boolean[] isPrimeNumber = new boolean[n + 1];
		for (int i = 2; i < Math.sqrt(n); i++) {
			if(isPrimeNumber[i]) continue;
			int j = 2;
			while(i*j <= n) {
				isPrimeNumber[i*j] = true;
			}
		}
		int answer = 0;
		for (int i = 2; i <= n; i++) {
			if(!isPrimeNumber[i]) {
				answer++;
			}
		}
		return answer;
	}
}
