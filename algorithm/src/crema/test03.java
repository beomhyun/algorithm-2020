package crema;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test03 {
	static int answer;

	public static int longestChain(List<String> words) {
		answer = 0;
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < words.size(); i++) {
			set.add(words.get(i));
		}

		for (int i = 0; i < words.size(); i++) {
			StringBuilder str = new StringBuilder(words.get(i));
			dfs(str, set, 1);
		}

		return answer;
	}

	public static void dfs(StringBuilder str, Set<String> set, int count) {
		if ((str.length() + count - 1) <= answer) {
			return;
		}
		if (str.length() == 1) {
			if (answer < count) {
				answer = count;
			}
			return;
		}
		boolean check = false;
		for (int j = 0; j < str.length(); j++) {
			StringBuilder tmp = new StringBuilder();
			for (int k = 0; k < str.length(); k++) {
				if (j == k)
					continue;
				tmp.append(str.charAt(k));
			}
			if (set.contains(tmp.toString())) {
				str = tmp;
				check = true;
				dfs(str, set, count + 1);
			}
		}
		if (!check) {
			if (answer < count) {
				answer = count;
			}
		}
	}
}
