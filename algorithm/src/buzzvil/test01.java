package buzzvil;

import java.util.Stack;

public class test01 {
	static String[] braces(String[] values) {
		final String yes = "YES";
		final String no = "NO";

		String[] answer = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			String value = values[i];

			if (value.length() % 2 != 0 || value.length() == 0) {
				answer[i] = no;
				continue;
			}
			Stack<Character> stack = new Stack<Character>();
			boolean check = true;

			for (int j = 0; j < value.length(); j++) {
				char c = value.charAt(j);
				if (c == '(' || c == '{' || c == '[') {
					stack.push(c);
				} else {
					if (stack.isEmpty()) {
						check = false;
						break;
					} else {
						char tmp = stack.pop();
						if (c == ')') {
							if (tmp == '(') {
								continue;
							} else {
								check = false;
								break;
							}
						} else if (c == '}') {
							if (tmp == '{') {
								continue;
							} else {
								check = false;
								break;
							}
						} else if (c == ']') {
							if (tmp == '[') {
								continue;
							} else {
								check = false;
								break;
							}
						}
					}
				}
			}
			if (!stack.isEmpty()) {
				check = false;
			}
			answer[i] = check ? yes : no;
		}

		return answer;
	}
}
