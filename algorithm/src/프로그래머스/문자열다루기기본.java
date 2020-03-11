package 프로그래머스;

public class 문자열다루기기본 {
	public boolean solution(String s) {
		if (s.length() == 4 || s.length() == 6) {
			boolean answer = true;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) < '0' || s.charAt(i) > '9') {
					answer = false;
					break;
				}
			}
			
			return answer;
		} else {
			return false;
		}
	}
}
