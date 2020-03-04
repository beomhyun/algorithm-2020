package 프로그래머스.카카오공채2020;

import java.util.Stack;

public class 괄호변환 {
	public static void main(String[] args) {
		System.out.println(solution("))((()"));
	}
	public static String solution(String p) {
		if (p.length() == 0)
			return "";
		if (isCorrect(p))
			return p;

		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();

		int index = 0;
		int countOpen = 0;
		int countClose = 0;
		boolean check = true;
		while (index < p.length()) {
			if (countOpen != 0 && countOpen == countClose) {
				check = false;
			}
			if (check) {
				char tempChar = p.charAt(index);
				u.append(tempChar);
				if (tempChar == '(')
					countOpen++;
				else
					countClose++;
			} else {
				char tempChar = p.charAt(index);
				v.append(tempChar);
			}
			index++;
		}
		if (isCorrect(u.toString())) {
			u.append(solution(v.toString()));
			return u.toString();
		} else {
			StringBuilder tempString = new StringBuilder();
			tempString.append("(");
			tempString.append(solution(v.toString()));
			tempString.append(")");
			for (int i = 1; i < u.length() - 1; i++) {
				if (u.charAt(i) == '(')
					tempString.append(")");
				else
					tempString.append("(");
			}
			return tempString.toString();
		}
	}

	public static boolean isCorrect(String p) {
		boolean answer = true;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				stack.add('(');
			} else {
				if (stack.empty()) {
					answer = false;
					break;
				}
				stack.pop();
			}
		}
		return answer;
	}
}