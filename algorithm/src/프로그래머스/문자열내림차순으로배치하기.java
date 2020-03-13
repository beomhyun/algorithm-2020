package 프로그래머스;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 문자열내림차순으로배치하기 {
	public String solution(String s) {
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));

		}
		list.sort(Comparator.reverseOrder());
		String answer = "";
		for (char c : list) {
			answer += c;
		}
		return answer;
	}
}
