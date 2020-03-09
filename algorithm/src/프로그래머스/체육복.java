package 프로그래머스;

public class 체육복 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2,4,5 };
		int[] reserve = { 1,4 };

		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int[] map = new int[n + 1];
		for (int i = 1; i < map.length; i++) {
			map[i] = 1;
		}

		for (int i = 0; i < lost.length; i++) {
			map[lost[i]] = 0;
		}

		for (int i = 0; i < reserve.length; i++) {
			map[reserve[i]]++;
		}

		for (int i = 0; i < lost.length; i++) {
			int index = lost[i];
			if (index - 1 > 0 && map[index - 1] == 2) {
				map[index - 1] = 1;
				map[index] = 1;
			} else if (index + 1 <= n && map[index + 1] == 2) {
				map[index + 1] = 1;
				map[index] = 1;
			}
		}

		int answer = 0;
		for (int i = 1; i < map.length; i++) {
			if (map[i] > 0) {
				answer++;
			}
		}

		return answer;
	}
}
