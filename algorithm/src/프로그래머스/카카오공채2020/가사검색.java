package 프로그래머스.카카오공채2020;

import java.util.HashMap;

public class 가사검색 {
	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };

		solution(words, queries);
	}

	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		Trie root = new Trie('*');
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			Trie prev = root;
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				Trie curr = new Trie(c);
				prev = prev.putChild(curr, word.length());
			}
		}
		
		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];
			Trie trav = root;
			if(query.charAt(0) == '?') continue;
			for (int j = 0; j < query.length(); j++) {
				char c = query.charAt(j);
				if(c == '?') {
					answer[i] = trav.getNumChildrenWithLen(query.length());
					break;
				}
				trav = trav.getChild(c);
				if(trav == null) {
					answer[i] = 0;
					break;
				}
			}
		}
		Trie rootReverse = new Trie('*');
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			Trie prev = rootReverse;
			for (int j = word.length() - 1; j >= 0; j--) {
				char c = word.charAt(j);
				Trie curr = new Trie(c);
				prev = prev.putChild(curr, word.length());
			}
		}
		
		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];
			Trie trav = rootReverse;
			if( query.charAt(0) != '?') continue;
			for(int j = query.length() -1; j >= 0; j--) {
				char c = query.charAt(j);
				if( c == '?') {
					answer[i] = trav.getNumChildrenWithLen(query.length());
					break;
				}
				trav = trav.getChild(c);
				if(trav == null) {
					answer[i] = 0;
					break;
				}
			}
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		return answer;
	}

	
}
class Trie {
	char c;
	HashMap<Character, Trie> children;
	HashMap<Integer, Integer> numChildrenWithLen;

	Trie(char c) {
		this.c = c;
		children = new HashMap<Character, Trie>();
		numChildrenWithLen = new HashMap<Integer, Integer>();
	}

	Trie putChild(Trie t, int len) {
		if (!children.containsKey(t.c)) {
			children.put(t.c, t);
		}
		if (numChildrenWithLen.containsKey(len)) {
			numChildrenWithLen.put(len, numChildrenWithLen.get(len) + 1);
		} else {
			numChildrenWithLen.put(len, 1);
		}
		return children.get(t.c);
	}

	Trie getChild(char c) {
		return children.get(c);
	}

	int getNumChildrenWithLen(int len) {
		if (numChildrenWithLen.containsKey(len))
			return numChildrenWithLen.get(len);
		return 0;
	}
}