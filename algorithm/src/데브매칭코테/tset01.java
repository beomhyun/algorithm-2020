package 데브매칭코테;

public class tset01 {
	public int solution(String p, String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			int a = p.charAt(i) - s.charAt(i);
			int b = s.charAt(i) - p.charAt(i);
			if (a < 0) {
				a += 10;
			}
			if (b < 0) {
				b += 10;
			}
			answer += Math.min(a, b);

		}
		return answer;
	}
}
