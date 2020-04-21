package ���α׷��ӽ�;

public class ī�� {
	public int[] solution(int brown, int red) {
		dfs(brown, red, 1);
		int[] answer = { (brown + red) / result, result };

		return answer;
	}

	static int result;

	public static void dfs(int brown, int red, int a) {
		if (a >= (brown + red) / 2) {
			return;
		}
		if (clearCheck(brown, red, a)) {
			result = a;
		} else {
			dfs(brown, red, a + 1);
		}

	}

	public static boolean clearCheck(int brown, int red, int a) {
		int area = brown + red;
		int b = area / a;
		if (a * b != area) {
			return false;
		}
		if ((a - 2) * (b - 2) == red) {
			return true;
		} else {
			return false;
		}
	}
}
