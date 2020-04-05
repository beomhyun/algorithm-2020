package line;

import java.util.HashMap;
import java.util.Map;

public class test01 {
	public static int solution(String inputString) {
		int answer = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Character> matchingMap = new HashMap<Character, Character>();
		matchingMap.put(']', '[');
		matchingMap.put('}', '{');
		matchingMap.put(')', '(');
		matchingMap.put('>', '<');

		for (int i = 0; i < inputString.length(); i++) {
			char temp = inputString.charAt(i);
			if (temp == '[' || temp == '{' || temp == '(' || temp == '<') {
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
				} else {
					map.put(temp, 1);
				}
			} else if (temp == ']' || temp == '}' || temp == ')' || temp == '>') {
				char matching = matchingMap.get(temp);
				if (map.containsKey(matching)) {
					if (map.get(matching) == 0) {
						return -1;
					}
					map.put(matching, map.get(matching) - 1);
					answer++;
				} else {
					return -1;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("if (Count of eggs is 4.) {Buy milk.}"));
	}
}
