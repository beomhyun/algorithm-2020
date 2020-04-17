package 프로그래머스;

public class 종이접기 {
	public int[] solution(int n) {
		if (n == 1) {
			int[] answer = { 0 };
			return answer;
		}
		String result = "";
		for (int i = 1; i <= n; i++) {
			result = calc(i, result);
		}
		int[] answer = new int[result.length()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.charAt(i) - '0';
		}

		return answer;
	}

	public static String calc(int i, String s) {
		StringBuilder result = new StringBuilder(s);

		if (i == 1) {
			return "0";
		} else {
			result.append("0");

			String[] splits = s.split("");

			for (int j = splits.length - 1; j >= 0; j--) {
				String append = splits[j].equals("0") ? "1" : "0";
				result.append(append);
			}
		}
		return result.toString();
	}
}
