package 프로그래머스;

public class 문자열내p와y의개수 {
	boolean solution(String s) {
		boolean answer = true;
		int p = 0;
		int y = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
				p++;
			} else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
				y++;
			}
		}
		if(p != y) answer = false;
		return answer;
	}
}
