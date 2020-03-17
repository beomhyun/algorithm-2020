package 프로그래머스.dfs;

public class 단어변환 {
	static int answer;
	static boolean[] visit;
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		solution(begin, target, words);
	}
	public static int solution(String begin, String target, String[] words) {
		boolean check = false;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target))
				check = true;
		}
		if (!check)
			return 0;
		answer = 0;
		visit = new boolean[words.length];
		dfs(begin, target, words, 0);
		return answer;
	}

	static void dfs(String begin, String target, String[] words, int d) {
		if (answer != 0 && d >= answer)
			return;
		if (begin.equals(target)) {
			if (answer == 0)
				answer = d;
			else {
				answer = answer > d ? d : answer;
			}
			return;
		}
		for (int i = 0; i < words.length; i++) {
			if (visit[i])
				continue;
			if (isCanChange(begin, words[i])) {
				visit[i] = true;
				dfs(words[i], target, words, d + 1);
				visit[i] = false;
			}
		}
	}

	static boolean isCanChange(String a, String b) {
		int differentCount = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				differentCount++;
			}
			if (differentCount == 2)
				return false;
		}
		if (differentCount == 1)
			return true;
		else
			return false;
	}
}