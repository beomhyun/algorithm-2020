package 프로그래머스.스킬체크;

public class 괄호쌍의개수 {
	static int answer;
	public static int solution(int n) {
		answer = 0;
		int[] map = new int[2*n];
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		map[0] = 1;
		dfs(n, 1, map, 1);

		return answer;
	}

	public static void dfs(int n, int open, int[] map, int d) {
		if (d == 2 * n) {
			for (int i = 0; i < map.length; i++) {
				System.out.print(map[i] + " ");
			}System.out.println();
			if (open == n) {
				boolean check = true;
				int sum = 1;
				for (int i = 1; i < map.length; i++) {
					sum += map[i];
					if (sum < 0) {
						check = false;
						break;
					}
				}
				if (check) {
					answer++;
					System.out.println("yes");
				}
			}
			return;
		}
		dfs(n, open, map, d + 1);
		map[d] = 1;
		dfs(n, open + 1, map, d + 1);
		map[d] = -1;
	}
	
	public static void main(String[] args) {
		solution(2);
	}
}
