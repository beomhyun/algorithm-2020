package 프로그래머스.DP;

public class 정수삼각형 {
	public static int solution(int[][] triangle) {
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0) {
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j];
				} else if (j == triangle[i].length - 1) {
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
				} else {
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1] > triangle[i][j] + triangle[i - 1][j]
							? triangle[i][j] + triangle[i - 1][j - 1]
							: triangle[i][j] + triangle[i - 1][j];
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
			answer = answer > triangle[triangle.length - 1][i] ? answer : triangle[triangle.length - 1][i];
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] triangle = { { 1 }, { 1, 2 }, { 1, 2, 3 } };
		solution(triangle);
	}
}