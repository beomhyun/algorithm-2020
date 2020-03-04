package 프로그래머스.카카오공채2020;

public class 가사검색 {
	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };

		solution(words, queries);
	}

	public static int[] solution(String[] words, String[] queries) {
		
		int[] answer = new int[queries.length];
		for (int i = 0; i < answer.length; i++) {
			int count = 0;
			int length = queries[i].length();
			int frontIndex = 0;
			int rearIndex = 0;
			
			if (queries[i].charAt(0) == '?') {
				for (int j = 0; j < length; j++) {
					if (queries[i].charAt(j) != '?') {
						frontIndex = j;
						rearIndex =length;
						break;
					}
				}
			} else {
				for (int j = 0; j < length; j++) {
					if (queries[i].charAt(j) == '?') {
						frontIndex = 0;
						rearIndex = j;
						break;
					}
				}
			}
			String tempString = queries[i].substring(frontIndex, rearIndex);
			for (int j = 0; j < words.length; j++) {
				if(words[j].length() == length && words[j].substring(frontIndex, rearIndex).equals(tempString)) {
					count++;
				}
			}
			answer[i] = count;
		}

		return answer;
	}
}
