package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ���ڿ������������ι�ġ�ϱ� {
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
